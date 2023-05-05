package com.kafeimall.order.httpapi.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: zzg
 * @date: 9/16/22
 * @Description: 订单
 */
@RestController
@RequestMapping("order")
public class OrderController {

//    @Resource
//    OrderApplication orderApplication;
//
//
//    /**
//     * 生成确认订单项
//     * @param cartIds 购物车ID
//     * @return OrderConfirmVo 确认订单项信息
//     * @throws ExecutionException
//     * @throws InterruptedException
//     */
//    @PostMapping("/generateConfirmOrder")
//    public Result<OrderConfirmDto> generateConfirmOrder(@RequestBody @Valid List<Long> cartIds) throws ExecutionException, InterruptedException {
//        OrderConfirmDto orderConfirmDto = orderApplication.generateConfirmOrder(cartIds);
//        return  Result.success(orderConfirmDto);
//    }
//
//    /**
//     * 提交订单
//     * @param request
//     * @return
//     */
//    @PostMapping("/submitOrder")
//    public Result<SubmitOrderResponseDto> submitOrder(@RequestBody @Valid OrderSubmitRequestDto request){
//        return Result.success(orderApplication.submitOrder(request)) ;
//    };
//
//    /**
//     * 根据订单号获取订单信息
//     * @param orderSn 订单号
//     * @return 订单信息
//     */
//    @GetMapping("/getOrderBuOrderSn")
//    public Result<OrderDto> getOrderBuOrderSn(@PathVariable("orderSn") String orderSn){
//        return Result.success(orderApplication.getOrderBuOrderSn(orderSn)) ;
//    };
//
//    /**
//     *关闭过期订单
//     * @param orderId 订单Id
//     * @return 订单信息
//     */
//    @GetMapping("/closeOrder")
//    public Result<Object> closeOrder(@PathVariable("orderId") Long orderId){
//        orderApplication.closeOrder(orderId);
//        return Result.ok();
//    };
//
//    /**
//     * 支付成功回调
//     * @param
//     * @return
//     */
//    public void handlePayResult(HttpServletRequest request, HttpServletResponse response) throws IOException {
//
//        String result="success";
////        response.setContentType("text/html;charset=" + alipayConfig.getCharset());
////        response.setCharacterEncoding(alipayConfig.getCharset());
//        response.getWriter().write(result);// 直接将完整的表单html输出到页面
//        response.getWriter().flush();
//        response.getWriter().close();
//    };

}
