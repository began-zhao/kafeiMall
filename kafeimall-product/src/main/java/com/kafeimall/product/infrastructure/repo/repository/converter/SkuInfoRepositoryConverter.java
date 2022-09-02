package com.kafeimall.product.infrastructure.repo.repository.converter;

import com.kafeimall.product.domain.aggregate.SkuAggregate;
import com.kafeimall.product.domain.valobj.SkuImage;
import com.kafeimall.product.infrastructure.repo.dao.po.SkuImagesPO;
import com.kafeimall.product.infrastructure.repo.dao.po.SkuInfoPO;
import org.mapstruct.Mapper;

/**
 * @author: zzg
 * @date: 8/31/22
 * @Description: zzg
 */
@Mapper(componentModel = "spring")
public interface SkuInfoRepositoryConverter {
    SkuAggregate toSkuInfoDO(SkuInfoPO categoryPO);

    SkuInfoPO toSkuInfoPO(SkuAggregate categoryDO);

    SkuImage toSkuImageDO(SkuImagesPO skuImagesPO);
}
