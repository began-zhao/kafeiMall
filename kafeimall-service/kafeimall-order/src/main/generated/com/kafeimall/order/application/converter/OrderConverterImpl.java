package com.kafeimall.order.application.converter;

import com.kafeimall.order.application.dto.OrderDto;
import com.kafeimall.order.application.dto.OrderSubmitRequestDto;
import com.kafeimall.order.application.dto.SubmitOrderResponseDto;
import com.kafeimall.order.domain.aggregate.OrderAggregate;
import com.kafeimall.order.domain.aggregate.OrderSubmitRequestAggregate;
import com.kafeimall.order.domain.aggregate.SubmitOrderResponseAggregate;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-02-20T22:36:39+0800",
    comments = "version: 1.5.2.Final, compiler: javac, environment: Java 11.0.2 (Oracle Corporation)"
)
@Component
public class OrderConverterImpl implements OrderConverter {

    @Override
    public OrderSubmitRequestAggregate toOrderSubmitRequestAggregate(OrderSubmitRequestDto orderSubmitRequestDto) {
        if ( orderSubmitRequestDto == null ) {
            return null;
        }

        OrderSubmitRequestAggregate orderSubmitRequestAggregate = new OrderSubmitRequestAggregate();

        return orderSubmitRequestAggregate;
    }

    @Override
    public SubmitOrderResponseDto toSubmitOrderResponseDto(SubmitOrderResponseAggregate submitOrderResponseAggregate) {
        if ( submitOrderResponseAggregate == null ) {
            return null;
        }

        SubmitOrderResponseDto submitOrderResponseDto = new SubmitOrderResponseDto();

        return submitOrderResponseDto;
    }

    @Override
    public OrderAggregate toOrderAggregate(OrderDto orderDto) {
        if ( orderDto == null ) {
            return null;
        }

        OrderAggregate orderAggregate = new OrderAggregate();

        return orderAggregate;
    }

    @Override
    public OrderDto toOrderDto(OrderAggregate orderAggregate) {
        if ( orderAggregate == null ) {
            return null;
        }

        OrderDto orderDto = new OrderDto();

        return orderDto;
    }
}
