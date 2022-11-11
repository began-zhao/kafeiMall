package com.kafeimall.order.httpapi.model.vo;

import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author: zzg
 * @date: 10/20/22
 * @Description: zzg
 */
@Data
public class OrderItemVo {
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
