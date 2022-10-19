package com.kafeimall.order.service.impl;

import com.kafeimall.order.domain.aggregate.OrderAggregate;
import com.kafeimall.order.infrastructure.repo.repository.OrderRepository;
import com.kafeimall.order.service.OrderDomainService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author: zzg
 * @date: 10/19/22
 * @Description: 订单领域服务实现
 */
@Service
public class OrderDomainServiceImpl implements OrderDomainService {

    @Resource
    OrderRepository orderRepository;

    @Override
    public void CreateOrder(OrderAggregate orderAggregate) {
        orderRepository.insertOrder(orderAggregate);
    }

    @Override
    public void UpdateOrder(OrderAggregate orderAggregate) {
        orderRepository.updateOrder(orderAggregate);
    }
}
