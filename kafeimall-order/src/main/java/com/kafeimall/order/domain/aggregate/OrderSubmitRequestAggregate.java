package com.kafeimall.order.domain.aggregate;

import lombok.Data;

import java.math.BigDecimal;

/**
 * @author: zzg
 * @date: 10/20/22
 * @Description: 封装订单提交的数据
 */
@Data
public class OrderSubmitRequestAggregate {
    private Long addrId;//收货地址Id
    private Integer payType;//支付方式
    //送货清单....
    //无需提交购买的商品，去购物车再获取一次
    //优惠、发票....

    private String orderToken;//防重令牌
    private BigDecimal payPrice;//应付价格，验价
    private String note;//订单备注
    //用户相关信息，直接可以在session中取
}
