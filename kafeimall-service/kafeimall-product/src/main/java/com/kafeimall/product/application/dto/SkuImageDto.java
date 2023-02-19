package com.kafeimall.product.application.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author: zzg
 * @date: 9/1/22
 * @Description: sku的图片信息
 */
@Data
@NoArgsConstructor
public class SkuImageDto {
    /**
     * id
     */
    private Long id;
    /**
     * sku_id
     */
    private Long skuId;
    /**
     * 图片地址
     */
    private String imgUrl;
    /**
     * 排序
     */
    private Integer imgSort;
    /**
     * 默认图[0 - 不是默认图，1 - 是默认图]
     */
    private Integer defaultImg;
}
