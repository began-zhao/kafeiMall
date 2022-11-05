package com.kafeimall.product.infrastructure.repo.repository.converter;

import com.kafeimall.product.domain.aggregate.SpuAggregate;
import com.kafeimall.product.domain.entity.SkuItemSaleAttr;
import com.kafeimall.product.domain.entity.SpuInfoDesc;
import com.kafeimall.product.domain.entity.SpuItemAttrGroup;
import com.kafeimall.product.infrastructure.repo.dao.po.SpuInfoDescPO;
import com.kafeimall.product.infrastructure.repo.dao.po.SpuInfoPO;
import org.mapstruct.Mapper;

import java.util.List;

/**
 * @author: zzg
 * @date: 9/2/22
 * @Description: zzg
 */
@Mapper(componentModel = "spring")
public interface SpuInfoRepositoryConverter {
    SpuInfoDesc toSpuDescInfoDO(SpuInfoDescPO spuInfoDescPO);

    //添加默认转换处理
    default SpuAggregate toSpuAggregateDO(SpuInfoPO spuInfoFuture, List<SkuItemSaleAttr> saleAttrFuture, SpuInfoDescPO spuInfoDesc, List<SpuItemAttrGroup> baseAttrFuture) {
        SpuAggregate spuAggregate = new SpuAggregate();
        spuAggregate.setId(spuInfoFuture.getId());
        spuAggregate.setSpuName(spuInfoFuture.getSpuName());
        spuAggregate.setSpuDescription(spuInfoFuture.getSpuDescription());
        spuAggregate.setCatalogId(spuInfoFuture.getCatalogId());
        spuAggregate.setBrandId(spuInfoFuture.getBrandId());
        spuAggregate.setWeight(spuInfoFuture.getWeight());
        spuAggregate.setPublishStatus(spuInfoFuture.getPublishStatus());
        //
        spuAggregate.setSkuItemSaleAttrs(saleAttrFuture);
        SpuInfoDesc infoDesc = new SpuInfoDesc();
        infoDesc.setSpuId(spuInfoDesc.getSpuId());
        infoDesc.setDecript(spuInfoDesc.getDecript());
        spuAggregate.setSpuInfoDesc(infoDesc);
        //
        spuAggregate.setSpuItemAttrGroups(baseAttrFuture);
        return spuAggregate;
    };
}
