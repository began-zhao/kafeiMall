package com.kafeimall.order.infrastructure.repo.repository.impl;

import com.kafeimall.order.domain.aggregate.OrderAggregate;
import com.kafeimall.order.infrastructure.repo.dao.OrderDao;
import com.kafeimall.order.infrastructure.repo.dao.OrderItemDao;
import com.kafeimall.order.infrastructure.repo.dao.po.OrderItemPO;
import com.kafeimall.order.infrastructure.repo.dao.po.OrderPO;
import com.kafeimall.order.infrastructure.repo.repository.OrderRepository;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author: zzg
 * @date: 10/18/22
 * @Description: 订单管理资源层
 */
public class OrderRepositoryImpl implements OrderRepository {

    @Resource
    OrderDao orderDao;

    @Resource
    OrderItemDao orderItemDao;


    @Override
    public OrderAggregate getOrderById(String Id) {
        OrderPO orderPO = orderDao.selectById(Id);
        List<OrderItemPO> orderItemPOS = orderItemDao.selectByOrderId(Id);

        return null;
    }

    @Override
    public List<OrderAggregate> getOrderByUserId(String UId) {
        return null;
    }

    @Override
    public OrderAggregate getByOrderNo(String OrderNo) {
        return null;
    }

    @Override
    public void insertOrder(OrderAggregate Order) {

    }

    @Override
    public void updateOrder(OrderAggregate Order) {

    }
}
