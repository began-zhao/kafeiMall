package com.kafeimall.product.infrastructure.repo.repository.Impl;

import com.kafeimall.product.domain.aggregate.SpuAggregate;
import com.kafeimall.product.domain.valobj.SkuItemSaleAttr;
import com.kafeimall.product.domain.valobj.SpuInfoDesc;
import com.kafeimall.product.domain.valobj.SpuItemAttrGroup;
import com.kafeimall.product.infrastructure.repo.dao.AttrGroupDao;
import com.kafeimall.product.infrastructure.repo.dao.SkuSaleAttrValueDao;
import com.kafeimall.product.infrastructure.repo.dao.SpuInfoDao;
import com.kafeimall.product.infrastructure.repo.dao.SpuInfoDescDao;
import com.kafeimall.product.infrastructure.repo.dao.po.SpuInfoDescPO;
import com.kafeimall.product.infrastructure.repo.dao.po.SpuInfoPO;
import com.kafeimall.product.infrastructure.repo.repository.SpuInfoRepository;
import com.kafeimall.product.infrastructure.repo.repository.converter.SpuInfoRepositoryConverter;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @author: zzg
 * @date: 9/2/22
 * @Description: zzg
 */
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

    @Override
    public SpuAggregate getBySpuId(Long spuId) {
        SpuInfoPO spuInfoPO = spuInfoDao.selectById(spuId);
        SpuAggregate spuAggregate = converter.toSpuAggregateDO(spuInfoPO);
        return spuAggregate;
    }

    @Override
    public List<SkuItemSaleAttr> getSaleAttrsBySpuId(Long spuId) {
        List<SkuItemSaleAttr> saleAttrsBySpuId = skuSaleAttrValueDao.getSaleAttrsBySpuId(spuId);
        return saleAttrsBySpuId;
    }

    @Override
    public SpuInfoDesc getSpuDescById(Long spuId) {
        SpuInfoDescPO spuInfoDescPO = spuInfoDescDao.selectById(spuId);
        SpuInfoDesc spuInfoDesc = converter.toSpuDescInfoDO(spuInfoDescPO);
        return spuInfoDesc;
    }

    @Override
    public List<SpuItemAttrGroup> getAttrGroupWithAttrsBySpuId(Long spuId, Long cataLogId) {
        List<SpuItemAttrGroup> attrGroupWithAttrsBySpuId = attrGroupDao.getAttrGroupWithAttrsBySpuId(spuId, cataLogId);
        return attrGroupWithAttrsBySpuId;
    }
}
