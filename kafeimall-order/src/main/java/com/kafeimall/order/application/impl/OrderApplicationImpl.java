package com.kafeimall.order.application.impl;

import com.kafeimall.order.application.OrderApplication;
import com.kafeimall.order.application.converter.OrderConfirmConverter;
import com.kafeimall.order.application.dto.OrderConfirmDto;
import com.kafeimall.order.application.dto.OrderSubmitDto;
import com.kafeimall.order.domain.aggregate.OrderConfirmAggregate;
import com.kafeimall.order.service.OrderDomainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
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
    OrderConfirmConverter orderConfirmConverter;

    @Override
    public OrderConfirmDto generateConfirmOrder(List<Long> cartIds) throws ExecutionException, InterruptedException {
        OrderConfirmAggregate orderConfirmAggregate = orderDomainService.generateConfirmOrder(cartIds);
        OrderConfirmDto orderConfirmDto = orderConfirmConverter.toOrderConfirmDto(orderConfirmAggregate);
        return orderConfirmDto;
    }

    @Override
    public Map<String, Object> submitOrder(OrderSubmitDto vo) {
        return null;
    }
}
