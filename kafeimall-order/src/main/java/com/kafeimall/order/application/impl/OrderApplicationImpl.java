package com.kafeimall.order.application.impl;

import com.kafeimall.order.application.OrderApplication;
import com.kafeimall.order.application.dto.OrderConfirmDto;
import com.kafeimall.order.application.dto.OrderSubmitDto;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.concurrent.ExecutionException;

/**
 * @author: zzg
 * @date: 10/20/22
 * @Description: 订单应用服务实现
 */
@Service
public class OrderApplicationImpl implements OrderApplication {

    @Override
    public OrderConfirmDto confirmOrder() throws ExecutionException, InterruptedException {
        return null;
    }

    @Override
    public Map<String, Object> submitOrder(OrderSubmitDto vo) {
        return null;
    }
}
