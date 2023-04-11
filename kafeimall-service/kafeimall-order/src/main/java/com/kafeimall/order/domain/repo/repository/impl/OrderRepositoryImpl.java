package com.kafeimall.order.domain.repo.repository.impl;

import com.kafeimall.order.domain.aggregate.OrderAggregate;
import com.kafeimall.order.domain.repo.repository.converter.OrderRepositoryConverter;
import com.kafeimall.order.domain.repo.dao.OrderDao;
import com.kafeimall.order.domain.repo.dao.OrderItemDao;
import com.kafeimall.order.domain.repo.dao.po.OrderItemPO;
import com.kafeimall.order.domain.repo.dao.po.OrderPO;
import com.kafeimall.order.domain.repo.repository.OrderRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author: zzg
 * @date: 10/18/22
 * @Description: 订单管理资源层
 */
@Service("OrderRepository")
public class OrderRepositoryImpl implements OrderRepository {

    @Resource
    OrderDao orderDao;

    @Resource
    OrderItemDao orderItemDao;

    @Resource
    OrderRepositoryConverter orderRepositoryConverter;


    @Override
    public OrderAggregate getOrderById(Long id) {
        OrderPO orderPO = orderDao.selectById(id);
        List<OrderItemPO> orderItemPOS = orderItemDao.selectByOrderId(orderPO.getId());
        OrderAggregate orderAggregate = orderRepositoryConverter.toOrderDo(orderPO, orderItemPOS);
        return orderAggregate;
    }

    @Override
    public List<OrderAggregate> getOrderByUserId(Long uId) {
        List<OrderPO> orderPOs = orderDao.selectByUId(uId);
        List<Long> orderIds = orderPOs.stream().map(OrderPO::getId).collect(Collectors.toList());
        List<OrderItemPO> orderItemPOS = orderItemDao.selectByOrderIdList(orderIds);
        List<OrderAggregate> orderAggregate = orderRepositoryConverter.toOrderListDo(orderPOs, orderItemPOS);
        return orderAggregate;
    }

    @Override
    public OrderAggregate getByOrderNo(String orderNo) {
        OrderPO orderPO = orderDao.selectByOrderNo(orderNo);
        List<OrderItemPO> orderItemPOS = orderItemDao.selectByOrderId(orderPO.getId());
        OrderAggregate orderAggregate = orderRepositoryConverter.toOrderDo(orderPO, orderItemPOS);
        return orderAggregate;
    }

    @Override
    public void insertOrder(OrderAggregate orderAggregate) {
        OrderPO orderPO = new OrderPO();
        BeanUtils.copyProperties(orderAggregate,orderPO);
        List<OrderItemPO> orderItemPOList = orderAggregate.getItemEntities().stream().map(e -> {
            OrderItemPO orderItemPO = new OrderItemPO();
            BeanUtils.copyProperties(e, orderItemPO);
            return orderItemPO;
        }).collect(Collectors.toList());
        orderDao.insert(orderPO);
        //TODO:可批量添加
        orderItemPOList.stream().forEach(e->{
            orderItemDao.insert(e);
        });
    }

    @Override
    public void updateOrder(OrderAggregate orderAggregate) {
        OrderPO orderPO = new OrderPO();
        BeanUtils.copyProperties(orderAggregate,orderPO);
        List<OrderItemPO> orderItemPOList = orderAggregate.getItemEntities().stream().map(e -> {
            OrderItemPO orderItemPO = new OrderItemPO();
            BeanUtils.copyProperties(e, orderItemPO);
            return orderItemPO;
        }).collect(Collectors.toList());
        orderDao.updateById(orderPO);
        //TODO:可批量修改
        orderItemPOList.stream().forEach(e->{
            orderItemDao.updateById(e);
        });
    }
}
