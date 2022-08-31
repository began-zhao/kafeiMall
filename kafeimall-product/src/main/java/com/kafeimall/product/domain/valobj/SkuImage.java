package com.kafeimall.product.domain.valobj;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author: zzg
 * @date: 8/31/22
 * @Description: zzg
 */
@Data
@NoArgsConstructor
public class SkuImage {
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
