package com.kafeimall.order.application.impl;

import com.kafeimall.common.to.mq.OrderTo;
import com.kafeimall.common.util.service.RedisService;
import com.kafeimall.order.application.OrderApplication;
import com.kafeimall.order.application.converter.OrderConverter;
import com.kafeimall.order.application.dto.OrderConfirmDto;
import com.kafeimall.order.application.dto.OrderDto;
import com.kafeimall.order.application.dto.OrderSubmitRequestDto;
import com.kafeimall.order.application.dto.SubmitOrderResponseDto;
import com.kafeimall.order.domain.model.OrderDO;
import com.kafeimall.order.domain.repository.OrderRepository;
import com.kafeimall.order.domain.service.OrderDomainService;
import com.kafeimall.order.infrastructure.common.enums.OrderStatusEnum;
import com.kafeimall.order.infrastructure.facade.MemberAdaptor;
import org.springframework.amqp.AmqpException;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ThreadPoolExecutor;

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

    @Resource
    ThreadPoolExecutor executor;

    @Resource
    RedisService redisUtil;

    @Resource
    MemberAdaptor memberAdaptor;

    /**
     * 生成订单确认页信息
     *
     * @param cartIds 购物陈Ids
     * @return 订单确认页信息
     * @throws ExecutionException
     * @throws InterruptedException
     */
    @Override
    public OrderConfirmDto generateConfirmOrder(List<Long> cartIds) throws ExecutionException, InterruptedException {
//        OrderConfirmAggregate orderConfirmAggregate = orderDomainService.generateConfirmOrder(cartIds);
//        OrderConfirmDto orderConfirmDto = orderConverter.toOrderConfirmDto(orderConfirmAggregate);
//        return orderConfirmDto;

//        OrderConfirmDto confirm = new OrderConfirmDto();
//        UserDto userDto = LoginUserInterceptor.LoginUser.get();
//
//        CompletableFuture<Void> getAddressFuture = CompletableFuture.runAsync(() -> {
//            //1、远程查询所有的收货地址列表
//            List<MemberAddressResponse> address = memberAdaptor.getAddress(userDto.getId());
//            confirm.setAddress(orderConverter.toOrderAddressDto(address));
//        }, executor);
//
//
//        CompletableFuture<Void> cartFuture = CompletableFuture.runAsync(() -> {
//            //2、远程查询购物车所有选中的购物项
//            List<CurrentUserCartItems> items = cartFeignAdaptor.getCurrentUserCartItems();
//            confirm.setItems(items);
//        }, executor).thenRunAsync(() -> {
//            List<CurrentUserCartItems> items = confirm.getItems();
//            List<Long> collect = items.stream().map(item -> item.getSkuId()).collect(Collectors.toList());
//            //远程查询库存
//            Map<Long, Boolean> skusHasStock = wmsFeignAdaptor.getSkusHasStock(collect);
//            confirm.setStocks(skusHasStock);
//        }, executor);
//
//        //todo 3、获取用户积分
////        Integer integration = userDto.getIntegration();
////        confirm.setIntegration(integration);
//
//        //4、订单总额\应付价格
//        //自动计算
//
//        //TODO 5、防重令牌
//        String token = UUID.randomUUID().toString().replace("-", "");
//        redisUtil.sAdd(OrderConstant.USER_TOKEN_ORDER_PREFIX + userDto.getId(), token, 30L, TimeUnit.MINUTES);
//        confirm.setOrderToken(token);
//
//        CompletableFuture.allOf(getAddressFuture, cartFuture).get();
//
//        return confirm;
        return null;
    }

    /**
     //     * 根据购物车ID新增订单
     //     * @param cartIds 购物车ID选中的集合
     //     * @return OrderAggregate 订单聚合根
     //     */
//    @Override
//    public OrderConfirmAggregate generateConfirmOrder(List<Long> cartIds) throws ExecutionException, InterruptedException {
//
//    }

    /**
     * 提交订单
     *
     * @param requestDto 订单提交信息
     * @return
     */
    @Override
    public SubmitOrderResponseDto submitOrder(OrderSubmitRequestDto requestDto) {
//        OrderSubmitRequestAggregate orderSubmitRequestAggregate = orderConverter.toOrderSubmitRequestAggregate(requestDto);
//        SubmitOrderResponseAggregate submitOrderResponseAggregate = orderDomainService.submitOrder(orderSubmitRequestAggregate);
//        return orderConverter.toSubmitOrderResponseDto(submitOrderResponseAggregate);
        return null;
    }

    /**
     * 根据订单号获取订单
     *
     * @param OrderSn 订单号
     * @return 订单信息
     */
    @Override
    public OrderDto getOrderBuOrderSn(String OrderSn) {
        OrderDO orderBuOrderSn = orderDomainService.getOrderBuOrderSn(OrderSn);
        return orderConverter.toOrderDto(orderBuOrderSn);
    }

    /**
     * 关闭过期订单
     *
     * @param OrderId 需要关闭的订单参数
     */
    @Override
    public void closeOrder(Long OrderId) {
        //查询当前这个订单的最新状态
        OrderDO orderEntity = orderRepository.getOrderDOById(OrderId);
        //关单
        if (orderEntity.getStatus() == OrderStatusEnum.CRETAE_NEW.getCode()) {
            OrderDO entity1 = new OrderDO();
            entity1.setStatus(OrderStatusEnum.CANCLED.getCode());
            entity1.setId(OrderId);
            orderRepository.saveAndFlush(entity1);
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
