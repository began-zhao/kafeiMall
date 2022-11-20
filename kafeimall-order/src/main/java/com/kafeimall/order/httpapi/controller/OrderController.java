package com.kafeimall.order.httpapi.controller;

import com.kafeimall.common.result.Result;
import com.kafeimall.order.application.OrderApplication;
import com.kafeimall.order.application.dto.OrderConfirmDto;
import com.kafeimall.order.application.dto.OrderDto;
import com.kafeimall.order.application.dto.OrderSubmitRequestDto;
import com.kafeimall.order.application.dto.SubmitOrderResponseDto;
import org.springframework.web.bind.annotation.*;

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


    /**
     * 生成确认订单项
     * @param cartIds 购物车ID
     * @return OrderConfirmVo 确认订单项信息
     * @throws ExecutionException
     * @throws InterruptedException
     */
    @PostMapping("/generateConfirmOrder")
    public Result<OrderConfirmDto> generateConfirmOrder(@RequestBody @Valid List<Long> cartIds) throws ExecutionException, InterruptedException {
        OrderConfirmDto orderConfirmDto = orderApplication.generateConfirmOrder(cartIds);
        return  Result.success(orderConfirmDto);
    }

    /**
     * 提交订单
     * @param request
     * @return
     */
    @PostMapping("/submitOrder")
    public Result<SubmitOrderResponseDto> submitOrder(@RequestBody @Valid OrderSubmitRequestDto request){
        return Result.success(orderApplication.submitOrder(request)) ;
    };

    /**
     * 根据订单号获取订单信息
     * @param orderSn 订单号
     * @return 订单信息
     */
    @GetMapping("/getOrderBuOrderSn")
    public Result<OrderDto> getOrderBuOrderSn(@PathVariable("orderSn") String orderSn){
        return Result.success(orderApplication.getOrderBuOrderSn(orderSn)) ;
    };


}
