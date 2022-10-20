package com.kafeimall.order.service;

import com.kafeimall.order.domain.aggregate.OrderAggregate;

/**
 * @author: zzg
 * @date: 9/16/22
 * @Description: 订单领域服务
 */
public interface OrderDomainService {
    /**
     * 新增订单
     * @param orderAggregate 订单聚合
     */
    void createOrder(OrderAggregate orderAggregate);

    /**
     * 修改订单
     * @param orderAggregate 订单聚合
     */
    void  updateOrder(OrderAggregate orderAggregate);
}
