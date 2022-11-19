package com.kafeimall.order.httpapi.model.response;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

/**
 * @author: zzg
 * @date: 10/20/22
 * @Description: 订单确认页需要的数据
 */
public class OrderConfirmResponse {
    //收货地址
    @Setter
    @Getter
    List<MemberAddressResponse> address;

    //所有选中的购物车项
    @Setter
    @Getter
    List<OrderItemResponse> items;

    //发票信息。。
    //..
    //..

    //订单防重令牌，防止多次点击提交订单的重复下单
    @Setter
    @Getter
    String orderToken;

    @Setter
    @Getter
    Map<Long,Boolean> stocks;

    //商品数量
    public Integer getCount() {
        Integer i = 0;
        if (items != null) {
            for (OrderItemResponse item : items
            ) {
                i += item.getCount();
            }
        }
        return i;
    }

    //会员积分信息
    @Setter
    @Getter
    Integer integration;

    //订单总额
//    BigDecimal total;

    public BigDecimal getTotal() {
        BigDecimal sum = new BigDecimal("0");
        if (items != null) {
            for (OrderItemResponse item : items
            ) {
                //当前项的价格
                BigDecimal multiply = item.getPrice().multiply(new BigDecimal((item.getCount().toString())));
                //累加
                sum = sum.add(multiply);
            }
        }
        return sum;
    }

    //应付价格
//    BigDecimal payPrice;

    public BigDecimal getPayPrice() {
        return getTotal();
    }
}
