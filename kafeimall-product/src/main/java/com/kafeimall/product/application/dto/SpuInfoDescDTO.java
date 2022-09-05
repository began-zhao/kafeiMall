package com.kafeimall.product.application.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author: zzg
 * @date: 9/1/22
 * @Description: 获取spu介绍
 */
@Data
@NoArgsConstructor
public class SpuInfoDescDTO {
    /**
     * 商品id
     */
    private Long spuId;
    /**
     * 商品介绍
     */
    private String decript;
}
