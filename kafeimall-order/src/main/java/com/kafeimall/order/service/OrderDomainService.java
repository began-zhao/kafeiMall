package com.kafeimall.order.service;

import com.kafeimall.order.domain.aggregate.OrderAggregate;

/**
 * @author: zzg
 * @date: 9/16/22
 * @Description: 订单领域服务
 */
public interface OrderDomainService {
    void CreateOrder(OrderAggregate orderAggregate);
    void  UpdateOrder(OrderAggregate orderAggregate);
}
