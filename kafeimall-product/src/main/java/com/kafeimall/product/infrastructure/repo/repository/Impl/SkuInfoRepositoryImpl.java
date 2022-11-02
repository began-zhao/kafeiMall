package com.kafeimall.product.infrastructure.repo.repository.Impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.kafeimall.product.domain.aggregate.SkuAggregate;
import com.kafeimall.product.infrastructure.repo.dao.SkuImagesDao;
import com.kafeimall.product.infrastructure.repo.dao.SkuInfoDao;
import com.kafeimall.product.infrastructure.repo.dao.po.SkuImagesPO;
import com.kafeimall.product.infrastructure.repo.dao.po.SkuInfoPO;
import com.kafeimall.product.infrastructure.repo.repository.SkuInfoRepository;
import com.kafeimall.product.infrastructure.repo.repository.converter.SkuInfoRepositoryConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @author: zzg
 * @date: 8/31/22
 * @Description: Sku资源层
 */
@Service("SkuInfoRepository")
public class SkuInfoRepositoryImpl implements SkuInfoRepository {

    @Autowired
    SkuInfoDao skuInfoDao;

    @Autowired
    SkuInfoRepositoryConverter skuInfoRepositoryConverter;

    @Autowired
    SkuImagesDao skuImagesDao;

    @Autowired
    ThreadPoolExecutor executor;

    @Override
    public SkuAggregate getById(Long skuId) throws ExecutionException, InterruptedException {

        //sku基本信息获取
        CompletableFuture<SkuInfoPO> infoFuture = CompletableFuture.supplyAsync(() -> {
            SkuInfoPO skuInfoPO = skuInfoDao.selectById(skuId);
           return skuInfoPO;
        }, executor);

        //sku的图片信息获取
        CompletableFuture<List<SkuImagesPO>> imageFuture = CompletableFuture.supplyAsync(() -> {
            List<SkuImagesPO> skuImagesPOS = skuImagesDao.selectList(new QueryWrapper<SkuImagesPO>().eq("sku_id", skuId));
           return skuImagesPOS;
        }, executor);
        //查询当前sku是否参与秒杀优惠（需要调用到秒杀服务，转移到领域服务调用防腐层执行。）

        //等待所有任务都完成
        CompletableFuture.allOf(infoFuture, imageFuture).get();

        SkuAggregate skuAggregate = skuInfoRepositoryConverter.toSkuInfoDO(infoFuture.get(), imageFuture.get());

        return skuAggregate;
    }

}
