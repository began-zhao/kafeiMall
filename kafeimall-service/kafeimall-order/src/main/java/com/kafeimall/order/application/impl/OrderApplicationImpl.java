package com.kafeimall.order.application.impl;

import com.kafeimall.common.to.mq.OrderTo;
import com.kafeimall.order.application.OrderApplication;
import com.kafeimall.order.application.converter.OrderConverter;
import com.kafeimall.order.application.dto.OrderConfirmDto;
import com.kafeimall.order.application.dto.OrderDto;
import com.kafeimall.order.application.dto.OrderSubmitRequestDto;
import com.kafeimall.order.application.dto.SubmitOrderResponseDto;
import com.kafeimall.order.infrastructure.common.enums.OrderStatusEnum;
import com.kafeimall.order.domain.model.aggregate.OrderAggregate;
import com.kafeimall.order.domain.model.aggregate.OrderConfirmAggregate;
import com.kafeimall.order.domain.model.aggregate.OrderSubmitRequestAggregate;
import com.kafeimall.order.domain.model.aggregate.SubmitOrderResponseAggregate;
import com.kafeimall.order.domain.repository.OrderRepository;
import com.kafeimall.order.domain.service.OrderDomainService;
import org.springframework.amqp.AmqpException;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.BeanUtils;
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

    @Autowired
    OrderRepository orderRepository;

    @Autowired
    RabbitTemplate rabbitTemplate;

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

    /**
     * 关闭过期订单
     * @param OrderId 需要关闭的订单参数
     */
    @Override
    public void closeOrder(Long OrderId){
        //查询当前这个订单的最新状态
        OrderAggregate orderEntity = orderRepository.getOrderById(OrderId);
        //关单
        if (orderEntity.getStatus() == OrderStatusEnum.CRETAE_NEW.getCode()) {
            OrderAggregate entity1 = new OrderAggregate();
            entity1.setStatus(OrderStatusEnum.CANCLED.getCode());
            entity1.setId(OrderId);
            orderRepository.updateOrder(entity1);
            OrderTo orderTo = new OrderTo();
            BeanUtils.copyProperties(orderEntity, orderTo);
            //发给MQ一个，防止因为网络问题导致库存解锁失败
            try {
                //TODO 保证消息一定会发送出去，每一个消息都做好日志记录（给数据库保存每一个消息的详细信息）。
                //TODO 定期扫描数据库，将失败的消息重新发送
                rabbitTemplate.convertAndSend("order-event-exchange", "order.release.other", orderTo);
            } catch (AmqpException e) {
                //TODO 将没发送成功的消息进行重试发送

            }
        }
    }

}
