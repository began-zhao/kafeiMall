package com.kafeimall.product.infrastructure.repo.repository.Impl;

import com.kafeimall.product.domain.aggregate.SkuAggregate;
import com.kafeimall.product.infrastructure.repo.dao.SkuInfoDao;
import com.kafeimall.product.infrastructure.repo.dao.po.SkuInfoPO;
import com.kafeimall.product.infrastructure.repo.repository.SkuInfoRepository;
import com.kafeimall.product.infrastructure.repo.repository.converter.SkuInfoRepositoryConverter;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author: zzg
 * @date: 8/31/22
 * @Description: zzg
 */
public class SkuInfoRepositoryImpl implements SkuInfoRepository {

    @Autowired
    SkuInfoDao skuInfoDao;

    @Autowired
    SkuInfoRepositoryConverter skuInfoRepositoryConverter;

    @Override
    public SkuAggregate getById(Long Id) {
        SkuInfoPO skuInfoPo = skuInfoDao.selectById(Id);
        SkuAggregate skuAggregate = skuInfoRepositoryConverter.toSkuInfoDO(skuInfoPo);
        return skuAggregate;
    }
}
