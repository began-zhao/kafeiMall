package com.kafeimall.order.httpapi;

import com.kafeimall.common.result.Result;
import com.kafeimall.order.application.OrderApplication;
import com.kafeimall.order.application.dto.OrderConfirmDto;
import com.kafeimall.order.httpapi.converter.OrderApiConverter;
import com.kafeimall.order.httpapi.model.vo.OrderConfirmVo;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.List;
import java.util.concurrent.ExecutionException;

/**
 * @author: zzg
 * @date: 9/16/22
 * @Description: 订单
 */
@RestController
@RequestMapping("order")
public class OrderController {

    @Resource
    OrderApplication orderApplication;

    @Resource
    OrderApiConverter orderApiConverter;

    /**
     * 生成确认订单项
     * @param cartIds 购物车ID
     * @return OrderConfirmVo 确认订单项信息
     * @throws ExecutionException
     * @throws InterruptedException
     */
    @PostMapping("/generateConfirmOrder")
    public Result<OrderConfirmVo> generateConfirmOrder(@RequestBody @Valid List<Long> cartIds) throws ExecutionException, InterruptedException {
        OrderConfirmDto orderConfirmDto = orderApplication.generateConfirmOrder(cartIds);
        OrderConfirmVo orderConfirmVo = orderApiConverter.toOrderConfirmVo(orderConfirmDto);
        return  Result.success(orderConfirmVo);
    }
}
