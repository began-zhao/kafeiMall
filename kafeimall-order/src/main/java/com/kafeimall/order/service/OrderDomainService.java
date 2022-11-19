package com.kafeimall.order.service;

import com.kafeimall.order.domain.aggregate.OrderAggregate;
import com.kafeimall.order.domain.aggregate.OrderConfirmAggregate;
import com.kafeimall.order.domain.aggregate.OrderSubmitRequestAggregate;
import com.kafeimall.order.domain.aggregate.SubmitOrderResponseAggregate;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.concurrent.ExecutionException;

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
    @Transactional
    OrderConfirmAggregate generateConfirmOrder(List<Long> cartIds) throws ExecutionException, InterruptedException;

    /**
     * 下单
     * @param orderSubmitRequestAggregate 下单信息
     * @return 下单成功返回订单具体信息
     */
    @Transactional
    SubmitOrderResponseAggregate submitOrder(OrderSubmitRequestAggregate orderSubmitRequestAggregate);

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
