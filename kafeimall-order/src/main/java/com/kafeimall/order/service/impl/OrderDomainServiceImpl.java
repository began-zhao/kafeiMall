package com.kafeimall.order.service.impl;

import cn.hutool.core.lang.UUID;
import com.kafeimall.common.auth.UserDto;
import com.kafeimall.common.util.service.RedisService;
import com.kafeimall.order.common.OrderConstant;
import com.kafeimall.order.domain.aggregate.OrderAggregate;
import com.kafeimall.order.domain.aggregate.OrderConfirmAggregate;
import com.kafeimall.order.domain.entity.CurrentUserCartItems;
import com.kafeimall.order.domain.entity.MemberAddress;
import com.kafeimall.order.infrastructure.facade.CartFeignAdaptor;
import com.kafeimall.order.infrastructure.facade.MemberAdaptor;
import com.kafeimall.order.infrastructure.facade.WmsFeignAdaptor;
import com.kafeimall.order.infrastructure.repo.repository.OrderRepository;
import com.kafeimall.order.interceptor.LoginUserInterceptor;
import com.kafeimall.order.service.OrderDomainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

/**
 * @author: zzg
 * @date: 10/19/22
 * @Description: 订单领域服务实现
 */
@Service
public class OrderDomainServiceImpl implements OrderDomainService {

    @Resource
    OrderRepository orderRepository;

    @Resource
    MemberAdaptor memberAdaptor;

    @Resource
    CartFeignAdaptor cartFeignAdaptor;

    @Resource
    WmsFeignAdaptor wmsFeignAdaptor;

    @Autowired
    ThreadPoolExecutor executor;

    @Autowired
    RedisService redisUtil;


    @Override
    public OrderConfirmAggregate generateConfirmOrder(List<Long> cartIds) throws ExecutionException, InterruptedException {
        OrderConfirmAggregate confirm = new OrderConfirmAggregate();
        UserDto userDto = LoginUserInterceptor.LoginUser.get();

        CompletableFuture<Void> getAddressFuture = CompletableFuture.runAsync(() -> {
            //1、远程查询所有的收货地址列表
            List<MemberAddress> address = memberAdaptor.getAddress(userDto.getId());
            confirm.setAddress(address);
        }, executor);


        CompletableFuture<Void> cartFuture = CompletableFuture.runAsync(() -> {
            //2、远程查询购物车所有选中的购物项
            List<CurrentUserCartItems> items = cartFeignAdaptor.getCurrentUserCartItems();
            confirm.setItems(items);
        }, executor).thenRunAsync(() -> {
            List<CurrentUserCartItems> items = confirm.getItems();
            List<Long> collect = items.stream().map(item -> item.getSkuId()).collect(Collectors.toList());
            //远程查询库存
            Map<Long, Boolean> skusHasStock = wmsFeignAdaptor.getSkusHasStock(collect);
            confirm.setStocks(skusHasStock);
        }, executor);

        //todo 3、获取用户积分
//        Integer integration = userDto.getIntegration();
//        confirm.setIntegration(integration);

        //4、订单总额\应付价格
        //自动计算

        //TODO 5、防重令牌
        String token = UUID.randomUUID().toString().replace("-", "");
        redisUtil.sAdd(OrderConstant.USER_TOKEN_ORDER_PREFIX + userDto.getId(), token, 30L, TimeUnit.MINUTES);
        confirm.setOrderToken(token);

        CompletableFuture.allOf(getAddressFuture, cartFuture).get();

        return confirm;
    }

    @Override
    public void createOrder(OrderAggregate orderAggregate) {
        orderRepository.insertOrder(orderAggregate);
    }

    @Override
    public void updateOrder(OrderAggregate orderAggregate) {
        orderRepository.updateOrder(orderAggregate);
    }
}
