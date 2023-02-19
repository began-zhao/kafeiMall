package com.kafeimall.product.domain.eventHandles.model;

import lombok.Data;

/**
 * @author: zzg
 * @date: 2022/11/26
 * @Description: zzg
 */
@Data
public class ProductEventEto {
    /**
     * skuId
     */
    private String skuId;
    /**
     * 状态
     */
    private Integer productStatus;
    /**
     * 用户ID
     */
    private String userId;
    //……
}
