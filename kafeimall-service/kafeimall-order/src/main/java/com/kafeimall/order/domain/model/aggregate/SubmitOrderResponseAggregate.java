package com.kafeimall.order.domain.model.aggregate;

import lombok.Data;

/**
 * @author: zzg
 * @date: 2022/11/19
 * @Description: zzg
 */
@Data
public class SubmitOrderResponseAggregate {
    private OrderAggregate order;
    private Integer code;//0成功 ，错误状态码
}
