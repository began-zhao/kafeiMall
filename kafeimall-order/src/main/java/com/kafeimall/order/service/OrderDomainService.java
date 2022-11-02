package com.kafeimall.order.service;

import com.kafeimall.order.domain.aggregate.OrderAggregate;
import com.kafeimall.order.domain.aggregate.OrderConfirmAggregate;

import java.util.List;

/**
 * @author: zzg
 * @date: 9/16/22
 * @Description: 订单领域服务
 */
public interface OrderDomainService {

    /**
     * 根据购物车ID新增订单
     * @param cartIds 购物车ID选中的集合
     * @return OrderAggregate 订单聚合根
     */
    OrderConfirmAggregate generateConfirmOrder(List<Long> cartIds);

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
