package com.kafeimall.order.application.converter;

import com.kafeimall.order.application.dto.MemberAddressDto;
import com.kafeimall.order.application.dto.OrderConfirmDto;
import com.kafeimall.order.application.dto.OrderItemDto;
import com.kafeimall.order.domain.aggregate.OrderConfirmAggregate;
import org.mapstruct.Mapper;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author: zzg
 * @date: 11/4/22
 * @Description: 订单确认信息DO-DTO转换
 */
@Mapper(componentModel = "spring")
public interface OrderConfirmConverter {

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
}
