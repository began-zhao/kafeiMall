package com.kafeimall.product.infrastructure.repo.repository.converter;

import com.kafeimall.product.domain.aggregate.SkuAggregate;
import com.kafeimall.product.domain.valobj.SeckillInfo;
import com.kafeimall.product.domain.valobj.SkuInfo;
import com.kafeimall.product.infrastructure.repo.dao.po.SkuImagesPO;
import com.kafeimall.product.infrastructure.repo.dao.po.SkuInfoPO;
import org.mapstruct.Mapper;

import java.util.List;
import java.util.concurrent.CompletableFuture;

/**
 * @author: zzg
 * @date: 8/31/22
 * @Description: zzg
 */
@Mapper(componentModel = "spring")
public interface SkuInfoRepositoryConverter {
    SkuInfo toSkuInfoDO(SkuInfoPO categoryPO);

    //TODO:添加默认转换处理
    SkuAggregate toSkuInfoDO(CompletableFuture<SkuInfoPO> infoFuture, CompletableFuture<List<SkuImagesPO>> imageFuture, CompletableFuture<SeckillInfo> secKillFuture);
}
