package com.kafeimall.product.domain.valobj;

import com.kafeimall.common.domain.ValueObject;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author: zzg
 * @date: 9/1/22
 * @Description: zzg
 */
@Data
@NoArgsConstructor
public class SpuInfoDesc extends ValueObject {
    /**
     * 商品id
     */
    private Long spuId;
    /**
     * 商品介绍
     */
    private String decript;
}
