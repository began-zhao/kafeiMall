package com.kafeimall.order.service.impl;

import com.kafeimall.common.auth.UserDto;
import com.kafeimall.order.application.dto.OrderConfirmDto;
import com.kafeimall.order.common.OrderConstant;
import com.kafeimall.order.domain.aggregate.OrderAggregate;
import com.kafeimall.order.domain.aggregate.OrderConfirmAggregate;
import com.kafeimall.order.domain.entity.CurrentUserCartItems;
import com.kafeimall.order.domain.entity.MemberAddress;
import com.kafeimall.order.infrastructure.facade.CartFeignAdaptor;
import com.kafeimall.order.infrastructure.facade.MemberAdaptor;
import com.kafeimall.order.infrastructure.repo.repository.OrderRepository;
import com.kafeimall.order.interceptor.LoginUserInterceptor;
import com.kafeimall.order.service.OrderDomainService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
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

    @Override
    public OrderConfirmAggregate generateConfirmOrder(List<Long> cartIds) {
        OrderConfirmDto confirmVo = new OrderConfirmDto();
        UserDto userDto = LoginUserInterceptor.LoginUser.get();

        CompletableFuture<Void> getAddressFuture = CompletableFuture.runAsync(() -> {
            //1、远程查询所有的收货地址列表
            List<MemberAddress> address = memberAdaptor.getAddress(userDto.getId());
            confirmVo.setAddress(address);
        }, executor);


        CompletableFuture<Void> cartFuture = CompletableFuture.runAsync(() -> {
            //2、远程查询购物车所有选中的购物项
            List<CurrentUserCartItems> items = cartFeignAdaptor.getCurrentUserCartItems();
            confirmVo.setItems(items);
        }, executor).thenRunAsync(() -> {
            List<OrderItemVo> items = confirmVo.getItems();
            List<Long> collect = items.stream().map(item -> item.getSkuId()).collect(Collectors.toList());
            //远程查询库存
            R hasStock = wmsFeignService.getSkusHasStock(collect);
            List<SkuStockVo> data = hasStock.getData(new TypeReference<List<SkuStockVo>>() {
            });
            if (data != null) {
                Map<Long, Boolean> booleanMap = data.stream().collect(Collectors.toMap(SkuStockVo::getSkuId, SkuStockVo::getHasStock));
                confirmVo.setStocks(booleanMap);
            }
        }, executor);


        //3、获取用户积分
        Integer integration = memberRespVo.getIntegration();
        confirmVo.setIntegration(integration);

        //4、订单总额\应付价格
        //自动计算

        //TODO 5、防重令牌
        String token = UUID.randomUUID().toString().replace("-", "");
        redisTemplate.opsForValue().set(OrderConstant.USER_TOKEN_ORDER_PREFIX + memberRespVo.getId(), token, 30L, TimeUnit.MINUTES);
        confirmVo.setOrderToken(token);

        CompletableFuture.allOf(getAddressFuture, cartFuture).get();

        return confirmVo;

        return null;
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
