package com.kafeimall.order.infrastructure.repo.repository.converter;

import com.kafeimall.order.domain.aggregate.OrderAggregate;
import com.kafeimall.order.infrastructure.repo.dao.po.OrderItemPO;
import com.kafeimall.order.infrastructure.repo.dao.po.OrderPO;
import org.mapstruct.Mapper;

import java.util.List;

/**
 * @author: zzg
 * @date: 10/18/22
 * @Description: 订单DO-PO转换器
 */
@Mapper(componentModel = "spring")
public interface OrderRepositoryConverter {
    default OrderAggregate toOrderDo(OrderPO orderPO, List<OrderItemPO> orderItemPOS){
        OrderAggregate orderAggregate = new OrderAggregate();
        //TODO： 具体转化内容
        return orderAggregate;

    }
}
