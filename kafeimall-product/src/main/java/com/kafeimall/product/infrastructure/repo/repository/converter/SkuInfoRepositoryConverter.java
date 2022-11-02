package com.kafeimall.product.infrastructure.repo.repository.converter;

import com.kafeimall.product.domain.aggregate.SkuAggregate;
import com.kafeimall.product.domain.valobj.SkuImage;
import com.kafeimall.product.domain.valobj.skuAggregate;
import com.kafeimall.product.infrastructure.repo.dao.po.SkuImagesPO;
import com.kafeimall.product.infrastructure.repo.dao.po.SkuInfoPO;
import org.mapstruct.Mapper;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author: zzg
 * @date: 8/31/22
 * @Description: zzg
 */
@Mapper(componentModel = "spring")
public interface SkuInfoRepositoryConverter {
    skuAggregate toSkuInfoDO(SkuInfoPO categoryPO);

    //默认转换处理
    default SkuAggregate toSkuInfoDO(SkuInfoPO infoFuture, List<SkuImagesPO> imageFuture){
        SkuAggregate skuAggregate = new SkuAggregate();
        skuAggregate.setSkuId(infoFuture.getSkuId());
        skuAggregate.setSpuId(infoFuture.getSpuId());
        skuAggregate.setSkuName(infoFuture.getSkuName());
        skuAggregate.setSkuDesc(infoFuture.getSkuDesc());
        skuAggregate.setCatalogId(infoFuture.getCatalogId());
        skuAggregate.setBrandId(infoFuture.getBrandId());
        skuAggregate.setSkuDefaultImg(infoFuture.getSkuDefaultImg());
        skuAggregate.setSkuTitle(infoFuture.getSkuTitle());
        skuAggregate.setSkuSubtitle(infoFuture.getSkuSubtitle());
        skuAggregate.setPrice(infoFuture.getPrice());
        skuAggregate.setSaleCount(infoFuture.getSaleCount());
//
        List<SkuImage> skuImages = imageFuture.stream().map(e -> {
            SkuImage skuImage = new SkuImage();
            skuImage.setSkuId(e.getSkuId());
            skuImage.setId(e.getId());
            skuImage.setDefaultImg(e.getDefaultImg());
            skuImage.setImgUrl(e.getImgUrl());
            skuImage.setImgSort(e.getImgSort());
            return skuImage;
        }).collect(Collectors.toList());
        skuAggregate.setSkuImages(skuImages);
        //
//        SeckillInfo seckillInfo = new SeckillInfo();
//        seckillInfo.setId(secKillFuture.getId());
//        seckillInfo.setSkuId(secKillFuture.getSkuId());
//        seckillInfo.setSeckillCount(secKillFuture.getSeckillCount());
//        seckillInfo.setPromotionId(secKillFuture.getPromotionId());
//        seckillInfo.setPromotionSessionId(secKillFuture.getPromotionSessionId());
//        seckillInfo.setRandomCode(secKillFuture.getRandomCode());
//        seckillInfo.setSeckillPrice(secKillFuture.getSeckillPrice());
//        seckillInfo.setSeckillCount(secKillFuture.getSeckillCount());
//        seckillInfo.setSeckillLimit(secKillFuture.getSeckillLimit());
//        seckillInfo.setSeckillSort(secKillFuture.getSeckillSort());
//        skuAggregate.setSeckillInfo(seckillInfo);
        return skuAggregate;
    };
}
