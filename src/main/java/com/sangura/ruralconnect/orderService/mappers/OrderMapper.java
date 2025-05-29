package com.sangura.ruralconnect.orderService.mappers;

import com.sangura.ruralconnect.orderService.dto.OrderDto;
import com.sangura.ruralconnect.orderService.entities.Order;
import com.sangura.ruralconnect.orderService.entities.enums.OrderStatus;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import java.time.LocalDate;

@Mapper(componentModel = "spring")
public interface OrderMapper {

    default OrderDto toDTO(Order order){
        if(order==null){
            return null;
        }

        OrderDto orderDto = new OrderDto();
        orderDto.setItems(order.getItems());
        orderDto.setCustomerId(order.getCustomerId());
        orderDto.setTotalAmount(order.getTotalAmount());
        orderDto.setAgentId(order.getAgentId());

        return orderDto;
    };
    default Order toEntity(OrderDto orderDto){
        if(orderDto==null){
            return null;
        }
        Order order = new Order();
        order.setOrderDate(LocalDate.now());
        order.setOrderStatus(OrderStatus.PAID);
        order.setAgentId(orderDto.getAgentId());
        order.setItems(orderDto.getItems());
        return order;
    };

    @Mapping(target = "orderId", ignore = true)
    Order updateOrder(OrderDto orderDto, @MappingTarget Order order );
}
