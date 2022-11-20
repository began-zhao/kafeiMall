package com.kafeimall.order.application.impl;

import com.kafeimall.order.application.OrderApplication;
import com.kafeimall.order.application.converter.OrderConverter;
import com.kafeimall.order.application.dto.OrderConfirmDto;
import com.kafeimall.order.application.dto.OrderDto;
import com.kafeimall.order.application.dto.OrderSubmitRequestDto;
import com.kafeimall.order.application.dto.SubmitOrderResponseDto;
import com.kafeimall.order.domain.aggregate.OrderAggregate;
import com.kafeimall.order.domain.aggregate.OrderConfirmAggregate;
import com.kafeimall.order.domain.aggregate.OrderSubmitRequestAggregate;
import com.kafeimall.order.domain.aggregate.SubmitOrderResponseAggregate;
import com.kafeimall.order.service.OrderDomainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.ExecutionException;

/**
 * @author: zzg
 * @date: 10/20/22
 * @Description: 订单应用服务实现
 */
@Service
public class OrderApplicationImpl implements OrderApplication {
    @Autowired
    OrderDomainService orderDomainService;

    @Autowired
    OrderConverter orderConverter;

    /**
     * 生成订单确认页信息
     * @param cartIds 购物陈Ids
     * @return 订单确认页信息
     * @throws ExecutionException
     * @throws InterruptedException
     */
    @Override
    public OrderConfirmDto generateConfirmOrder(List<Long> cartIds) throws ExecutionException, InterruptedException {
        OrderConfirmAggregate orderConfirmAggregate = orderDomainService.generateConfirmOrder(cartIds);
        OrderConfirmDto orderConfirmDto = orderConverter.toOrderConfirmDto(orderConfirmAggregate);
        return orderConfirmDto;
    }

    /**
     * 提交订单
     * @param requestDto 订单提交信息
     * @return
     */
    @Override
    public SubmitOrderResponseDto submitOrder(OrderSubmitRequestDto requestDto) {
        OrderSubmitRequestAggregate orderSubmitRequestAggregate = orderConverter.toOrderSubmitRequestAggregate(requestDto);
        SubmitOrderResponseAggregate submitOrderResponseAggregate = orderDomainService.submitOrder(orderSubmitRequestAggregate);
        return orderConverter.toSubmitOrderResponseDto(submitOrderResponseAggregate);
    }
    /**
     * 根据订单号获取订单
     * @param OrderSn 订单号
     * @return 订单信息
     */
    @Override
    public OrderDto getOrderBuOrderSn(String OrderSn){
        OrderAggregate orderBuOrderSn = orderDomainService.getOrderBuOrderSn(OrderSn);
        return orderConverter.toOrderDto(orderBuOrderSn);
    }

}
