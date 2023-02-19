package com.kafeimall.order.application.dto;

import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author: zzg
 * @date: 10/20/22
 * @Description: 下单的订单项
 */
@Data
public class OrderItemDto {
    private Long skuId;
    private Boolean check;
    private String title;
    private String image;
    private List<String> skuAttr;
    private BigDecimal price;
    private Integer count;
    private BigDecimal totalPrice;

    //TODO 查询商品重量
    private BigDecimal weight;
}
