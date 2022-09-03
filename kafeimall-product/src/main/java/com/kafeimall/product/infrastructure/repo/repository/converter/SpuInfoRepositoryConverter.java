package com.kafeimall.product.infrastructure.repo.repository.converter;

import com.kafeimall.product.domain.aggregate.SpuAggregate;
import com.kafeimall.product.domain.valobj.SkuItemSaleAttr;
import com.kafeimall.product.domain.valobj.SpuInfoDesc;
import com.kafeimall.product.domain.valobj.SpuItemAttrGroup;
import com.kafeimall.product.infrastructure.repo.dao.po.SpuInfoDescPO;
import com.kafeimall.product.infrastructure.repo.dao.po.SpuInfoPO;
import org.mapstruct.Mapper;

import java.util.List;
import java.util.concurrent.CompletableFuture;

/**
 * @author: zzg
 * @date: 9/2/22
 * @Description: zzg
 */
@Mapper(componentModel = "spring")
public interface SpuInfoRepositoryConverter {
    SpuInfoDesc toSpuDescInfoDO(SpuInfoDescPO spuInfoDescPO);

    //TODO：添加默认转换处理
    SpuAggregate toSpuAggregateDO(CompletableFuture<SpuInfoPO> spuInfoFuture, CompletableFuture<List<SkuItemSaleAttr>> saleAttrFuture, CompletableFuture<SpuInfoDescPO> spuInfoDesc, CompletableFuture<List<SpuItemAttrGroup>> baseAttrFuture);
}
