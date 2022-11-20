package com.kafeimall.product.application.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author: zzg
 * @date: 9/1/22
 * @Description: SKU详情
 */
@Data
@NoArgsConstructor
public class SkuItemDto {
    //1、sku基本信息获取 pms_sku_info
    SkuInfoDto skuInfo;

    //是否有货
    boolean hasStock = true;

    //2、sku的图片信息获取 pms_sku_images
    List<SkuImageDto> images;

    //3、spu销售属性组合
    List<SkuItemSaleAttrDto> saleAttr;

    //4、获取spu介绍
    SpuInfoDescDto desp;

    //5、获取spu规格参数信息
    List<SpuItemAttrGroupDto> groupAttrs;

    //6、当亲商品秒杀优惠信息
    SeckillInfoDto seckillInfo;
}
