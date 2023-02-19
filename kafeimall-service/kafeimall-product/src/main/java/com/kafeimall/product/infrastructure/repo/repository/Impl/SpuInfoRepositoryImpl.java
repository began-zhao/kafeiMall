package com.kafeimall.product.infrastructure.repo.repository.Impl;

import com.kafeimall.product.domain.aggregate.SpuAggregate;
import com.kafeimall.product.domain.entity.SkuItemSaleAttr;
import com.kafeimall.product.domain.entity.SpuItemAttrGroup;
import com.kafeimall.product.infrastructure.repo.dao.AttrGroupDao;
import com.kafeimall.product.infrastructure.repo.dao.SkuSaleAttrValueDao;
import com.kafeimall.product.infrastructure.repo.dao.SpuInfoDao;
import com.kafeimall.product.infrastructure.repo.dao.SpuInfoDescDao;
import com.kafeimall.product.infrastructure.repo.dao.po.SpuInfoDescPO;
import com.kafeimall.product.infrastructure.repo.dao.po.SpuInfoPO;
import com.kafeimall.product.infrastructure.repo.repository.SpuInfoRepository;
import com.kafeimall.product.infrastructure.repo.repository.converter.SpuInfoRepositoryConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @author: zzg
 * @date: 9/2/22
 * @Description: Spu资源层
 */
@Service("SpuInfoRepository")
public class SpuInfoRepositoryImpl implements SpuInfoRepository {
    @Autowired
    private SkuSaleAttrValueDao skuSaleAttrValueDao;
    @Autowired
    private SpuInfoDescDao spuInfoDescDao;
    @Autowired
    private SpuInfoRepositoryConverter converter;
    @Autowired
    private AttrGroupDao attrGroupDao;

    @Autowired
    private SpuInfoDao spuInfoDao;
    @Autowired
    ThreadPoolExecutor executor;

    @Override
    public SpuAggregate getBySpuId(Long spuId) throws ExecutionException, InterruptedException {
        //获取spu信息
        CompletableFuture<SpuInfoPO> spuInfoFuture = CompletableFuture.supplyAsync(() -> {
            SpuInfoPO spuInfoPO = spuInfoDao.selectById(spuId);
            return spuInfoPO;
        }, executor);

        //获取spu对应销售属性
        CompletableFuture<List<SkuItemSaleAttr>> saleAttrFuture = CompletableFuture.supplyAsync(() -> {
            List<SkuItemSaleAttr> saleAttrsBySpuId = skuSaleAttrValueDao.getSaleAttrsBySpuId(spuId);
            return saleAttrsBySpuId;
        }, executor);
        //获取spu介绍
        CompletableFuture<SpuInfoDescPO> spuInfoDesc = CompletableFuture.supplyAsync(() -> {
            SpuInfoDescPO spuInfoDescPO = spuInfoDescDao.selectById(spuId);
            return spuInfoDescPO;
        }, executor);
        //获取spu规格参数信息
        CompletableFuture<List<SpuItemAttrGroup>> baseAttrFuture = spuInfoFuture.thenApplyAsync((res) -> {
            List<SpuItemAttrGroup> attrGroupWithAttrsBySpuId = attrGroupDao.getAttrGroupWithAttrsBySpuId(spuId, res.getCatalogId());
            return attrGroupWithAttrsBySpuId;
        }, executor);

        //等待所有任务都完成
        CompletableFuture.allOf(saleAttrFuture, spuInfoDesc, baseAttrFuture, spuInfoFuture).get();

        SpuAggregate spuAggregate = converter.toSpuAggregateDO(spuInfoFuture.get(), saleAttrFuture.get(), spuInfoDesc.get(), baseAttrFuture.get());

        return spuAggregate;
    }

}
