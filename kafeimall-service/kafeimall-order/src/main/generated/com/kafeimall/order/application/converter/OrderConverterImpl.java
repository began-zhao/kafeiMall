package com.kafeimall.order.application.converter;

import com.kafeimall.order.application.dto.OrderDto;
import com.kafeimall.order.application.dto.OrderSubmitRequestDto;
import com.kafeimall.order.application.dto.SubmitOrderResponseDto;
import com.kafeimall.order.domain.model.OrderDO;
import com.kafeimall.order.domain.model.OrderSubmitRequestAggregate;

import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-03-01T00:22:49+0800",
    comments = "version: 1.5.2.Final, compiler: javac, environment: Java 11.0.2 (Oracle Corporation)"
)
@Component
public class OrderConverterImpl implements OrderConverter {

    @Override
    public OrderDO toOrderAggregate(OrderDto orderDto) {
        if ( orderDto == null ) {
            return null;
        }

        OrderDO orderDO = new OrderDO();

        return orderDO;
    }

    @Override
    public OrderDto toOrderDto(OrderDO orderDO) {
        if ( orderDO == null ) {
            return null;
        }

        OrderDto orderDto = new OrderDto();

        return orderDto;
    }
}
