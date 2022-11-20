package com.kafeimall.order.application;

import com.kafeimall.order.application.dto.OrderConfirmDto;
import com.kafeimall.order.application.dto.OrderDto;
import com.kafeimall.order.application.dto.OrderSubmitRequestDto;
import com.kafeimall.order.application.dto.SubmitOrderResponseDto;

import java.util.List;
import java.util.concurrent.ExecutionException;

/**
 * @author: zzg
 * @date: 9/16/22
 * @Description: 订单应用程序接口
 */
public interface OrderApplication {
    /**
     * 给订单确认页返回需要的数据
     * @return
     */
    OrderConfirmDto generateConfirmOrder(List<Long> cartId) throws ExecutionException, InterruptedException;

    /**
     * 下单方法
     * @param orderSubmitRequestDto 下单入参
     * @return
     */
   SubmitOrderResponseDto submitOrder(OrderSubmitRequestDto orderSubmitRequestDto);

    /**
     * 根据订单号获取订单
     * @param OrderSn 订单号
     * @return 订单信息
     */
    OrderDto getOrderBuOrderSn(String OrderSn);

    /**
     * 关闭过期订单
     * @param OrderId
     */
    void closeOrder(Long OrderId);

//    /**
//     * 获取当前订单支付信息
//     * @param orderSn
//     * @return
//     */
//    PayVo getOrderPay(String orderSn);
//
//    PageUtils queryPageWithItem(Map<String, Object> params);
//
//    /**
//     * 处理支付宝支付返回数据
//     * @param vo
//     * @return
//     */
//    String handlePayResult(PayAsyncVo vo);
//
//    /**
//     * 准备创建秒杀单的详细信息
//     * @param entity
//     */
//    void createSeckillOrder(SeckillOrderTo entity);


}
