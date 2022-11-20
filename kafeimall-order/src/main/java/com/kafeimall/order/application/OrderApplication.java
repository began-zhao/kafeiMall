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

    //TODO:


}
