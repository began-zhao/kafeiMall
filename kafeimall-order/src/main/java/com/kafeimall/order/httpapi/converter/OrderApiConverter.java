package com.kafeimall.order.httpapi.converter;

import com.kafeimall.order.application.dto.OrderConfirmDto;
import com.kafeimall.order.httpapi.model.vo.OrderConfirmVo;
import org.mapstruct.Mapper;

/**
 * @author: zzg
 * @date: 2022/11/12
 * @Description: 订单VO-DTO转换
 */
@Mapper(componentModel = "spring")
public interface OrderApiConverter {

    OrderConfirmVo toOrderConfirmVo (OrderConfirmDto orderConfirmDto);
}
