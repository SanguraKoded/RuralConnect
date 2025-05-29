package com.sangura.ruralconnect.orderService.mappers;

import com.sangura.ruralconnect.orderService.dto.OrderItemDto;
import com.sangura.ruralconnect.orderService.entities.OrderItem;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface OrderItemMapper {

    default OrderItem toEntity(OrderItemDto orderItemDto){
        if(orderItemDto==null){
            return null;
        }
        OrderItem orderItem = new OrderItem();
        orderItem.setQuantity(orderItemDto.getQuantity());
        orderItem.setProductId(orderItemDto.getProductId());
        orderItem.setTotalPrice(orderItemDto.getTotalPrice());
        return orderItem;
    };
    default OrderItemDto toDto(OrderItem orderItem){
        if(orderItem==null){
            return null;
        }
        OrderItemDto orderItemDto = new OrderItemDto();
        orderItemDto.setProductId(orderItem.getProductId());
        orderItemDto.setTotalPrice(orderItem.getTotalPrice());
        orderItemDto.setQuantity(orderItem.getQuantity());
        return orderItemDto;
    };

    @Mapping(target = "orderItemId", ignore = true)
    OrderItem updateOrderItem(OrderItemDto orderItemDto, @MappingTarget OrderItem orderItem);
}
