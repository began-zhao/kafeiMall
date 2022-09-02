package com.kafeimall.product.infrastructure.repo.repository.Impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.kafeimall.product.domain.aggregate.SkuAggregate;
import com.kafeimall.product.domain.valobj.SkuImage;
import com.kafeimall.product.infrastructure.repo.dao.SkuImagesDao;
import com.kafeimall.product.infrastructure.repo.dao.SkuInfoDao;
import com.kafeimall.product.infrastructure.repo.dao.po.SkuImagesPO;
import com.kafeimall.product.infrastructure.repo.dao.po.SkuInfoPO;
import com.kafeimall.product.infrastructure.repo.repository.SkuInfoRepository;
import com.kafeimall.product.infrastructure.repo.repository.converter.SkuInfoRepositoryConverter;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.stream.Collectors;

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
    @Autowired
    SkuImagesDao skuImagesDao;

    @Override
    public SkuAggregate getById(Long Id) {
        SkuInfoPO skuInfoPo = skuInfoDao.selectById(Id);
        SkuAggregate skuAggregate = skuInfoRepositoryConverter.toSkuInfoDO(skuInfoPo);
        return skuAggregate;
    }

    @Override
    public List<SkuImage> getImagesBySkuId(Long skuId) {
        List<SkuImagesPO> skuImagesPOS = skuImagesDao.selectList(new QueryWrapper<SkuImagesPO>().eq("sku_id", skuId));
        List<SkuImage> skuImageList = skuImagesPOS.stream().map(e -> {
            return skuInfoRepositoryConverter.toSkuImageDO(e);
        }).collect(Collectors.toList());
        return skuImageList;
    }
}
