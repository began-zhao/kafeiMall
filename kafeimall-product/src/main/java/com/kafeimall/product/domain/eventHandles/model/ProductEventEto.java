package com.kafeimall.product.domain.eventHandles.model;

import com.kafeimall.common.event.BaseDomainEvent;

/**
 * @author: zzg
 * @date: 2022/11/26
 * @Description: zzg
 */
public class ProductEventEto extends BaseDomainEvent<ProductEventEto> {
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
