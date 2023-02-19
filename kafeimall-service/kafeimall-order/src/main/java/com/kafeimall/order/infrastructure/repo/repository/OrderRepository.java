package com.kafeimall.order.infrastructure.repo.repository;

import com.kafeimall.common.repository.IRepository;
import com.kafeimall.order.domain.aggregate.OrderAggregate;

import java.util.List;

/**
 * @author: zzg
 * @date: 9/16/22
 * @Description: 订单服务资源层
 */
public interface OrderRepository extends IRepository<OrderAggregate> {

    /**
     * 获取ID对应订单
     */
    OrderAggregate getOrderById(Long id);

    /**
     * 获取用户对应订单
     */
    List<OrderAggregate> getOrderByUserId(Long uId);

    /**
     * 根据订单号获取订单
     */
    OrderAggregate getByOrderNo(String orderNo);

    /**
     * 新增订单
     */
    void insertOrder(OrderAggregate orderAggregate);

    /**
     * 修改订单
     */
    void updateOrder(OrderAggregate orderAggregate);



}
