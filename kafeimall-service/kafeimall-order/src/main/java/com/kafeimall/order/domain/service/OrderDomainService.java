package com.kafeimall.order.domain.service;

import com.kafeimall.order.domain.model.OrderDO;

/**
 * @author: zzg
 * @date: 9/16/22
 * @Description: 订单领域服务
 */
public interface OrderDomainService {

//    /**
//     * 根据购物车ID新增订单
//     * @param cartIds 购物车ID选中的集合
//     * @return OrderAggregate 订单聚合根
//     */
//    @Transactional
//    OrderConfirmAggregate generateConfirmOrder(List<Long> cartIds) throws ExecutionException, InterruptedException;
//
//    /**
//     * 下单
//     * @param orderSubmitRequestAggregate 下单信息
//     * @return 下单成功返回订单具体信息
//     */
//    @Transactional
//    SubmitOrderResponseAggregate submitOrder(OrderSubmitRequestAggregate orderSubmitRequestAggregate);
//
    /**
     * 新增订单
     * @param orderDO 订单聚合
     */
    void createOrder(OrderDO orderDO);

    /**
     * 修改订单
     * @param orderDO 订单聚合
     */
    void  updateOrder(OrderDO orderDO);

    /**
     * 根据订单号获取订单信息
     * @param orderSn
     * @return
     */
    OrderDO getOrderBuOrderSn(String orderSn);
}
