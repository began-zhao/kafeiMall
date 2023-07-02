package com.kafeimall.order.application.converter;

import com.kafeimall.order.application.dto.*;
import com.kafeimall.order.domain.model.OrderDO;
import com.kafeimall.order.domain.model.OrderSubmitRequestAggregate;
import org.mapstruct.Mapper;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author: zzg
 * @date: 11/4/22
 * @Description: 订单确认信息DO-DTO转换
 */
@Mapper(componentModel = "spring")
public interface OrderConverter {

    default OrderConfirmDto toOrderConfirmDto(OrderConfirmAggregate orderConfirmAggregate){
        OrderConfirmDto orderConfirmDto = new OrderConfirmDto();
        orderConfirmDto.setOrderToken(orderConfirmAggregate.getOrderToken());
        orderConfirmDto.setStocks(orderConfirmAggregate.getStocks());

        List<OrderItemDto> orderItemDtos = orderConfirmAggregate.getItems().stream().map(item -> {
            OrderItemDto orderItemDto = new OrderItemDto();
            orderItemDto.setSkuId(item.getSkuId());
            orderItemDto.setCheck(item.getCheck());
            orderItemDto.setTitle(item.getTitle());
            orderItemDto.setImage(item.getImage());
            orderItemDto.setSkuAttr(item.getSkuAttr());
            orderItemDto.setPrice(item.getPrice());
            orderItemDto.setCount(item.getCount());
            orderItemDto.setTotalPrice(item.getTotalPrice());
            orderItemDto.setWeight(item.getWeight());
            return orderItemDto;
        }).collect(Collectors.toList());
        List<MemberAddressDto> addressDtoList = orderConfirmAggregate.getAddress().stream().map(address -> {
            MemberAddressDto memberAddressDto = new MemberAddressDto();
            memberAddressDto.setId(address.getId());
            memberAddressDto.setMemberId(address.getMemberId());
            memberAddressDto.setName(address.getName());
            memberAddressDto.setPhone(address.getPhone());
            memberAddressDto.setPostCode(address.getPostCode());
            memberAddressDto.setProvince(address.getProvince());
            memberAddressDto.setCity(address.getCity());
            memberAddressDto.setRegion(address.getRegion());
            memberAddressDto.setDetailAddress(address.getDetailAddress());
            memberAddressDto.setAreacode(address.getAreacode());
            memberAddressDto.setDefaultStatus(address.getDefaultStatus());
            return memberAddressDto;
        }).collect(Collectors.toList());
        orderConfirmDto.setItems(orderItemDtos);
        orderConfirmDto.setAddress(addressDtoList);
        orderConfirmDto.setIntegration(orderConfirmAggregate.getIntegration());
        return orderConfirmDto;
    }

    /**
     * 订单提交信息 DTO-DO
     * @param orderSubmitRequestDto 订单提交信息DTO
     * @return 订单提交信息聚合
     */
    OrderSubmitRequestAggregate toOrderSubmitRequestAggregate(OrderSubmitRequestDto orderSubmitRequestDto);

    SubmitOrderResponseDto toSubmitOrderResponseDto(SubmitOrderResponseAggregate submitOrderResponseAggregate);

    /**
     * 订单信息 DTO-DO
     */
    OrderDO toOrderAggregate(OrderDto orderDto);
    OrderDto toOrderDto(OrderDO orderDO);
}
