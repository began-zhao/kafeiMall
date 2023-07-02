package com.kafeimall.order.domain.repository;

import com.kafeimall.common.repository.IRepository;
import com.kafeimall.order.domain.model.OrderDO;

import java.util.List;

/**
 * @author: zzg
 * @date: 9/16/22
 * @Description: 订单服务资源层
 */
public interface OrderRepository extends IRepository<OrderDO> {

    /**
     * 获取ID对应订单
     */
    OrderDO getOrderById(Long id);

    /**
     * 获取用户对应订单
     */
    List<OrderDO> getOrderByUserId(Long uId);

    /**
     * 根据订单号获取订单
     */
    OrderDO getByOrderNo(String orderNo);

    /**
     * 新增订单
     */
    void insertOrder(OrderDO orderDO);

    /**
     * 修改订单
     */
    void updateOrder(OrderDO orderDO);



}
