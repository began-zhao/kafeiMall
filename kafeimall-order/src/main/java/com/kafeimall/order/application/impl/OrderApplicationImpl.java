package com.kafeimall.order.application.impl;

import com.kafeimall.order.application.OrderApplication;
import com.kafeimall.order.application.dto.OrderConfirmDto;
import com.kafeimall.order.application.dto.OrderSubmitDto;
import com.kafeimall.order.domain.aggregate.OrderAggregate;
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

    @Override
    public OrderConfirmDto confirmOrder(List<Long> cartIds) throws ExecutionException, InterruptedException {
        OrderAggregate order = orderDomainService.createOrder(cartIds);


        return null;
    }

    @Override
    public Map<String, Object> submitOrder(OrderSubmitDto vo) {
        return null;
    }
}
