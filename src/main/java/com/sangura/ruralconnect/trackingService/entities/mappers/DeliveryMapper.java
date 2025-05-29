package com.sangura.ruralconnect.trackingService.entities.mappers;

import com.sangura.ruralconnect.trackingService.dto.DeliveryDto;
import com.sangura.ruralconnect.trackingService.entities.Delivery;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface DeliveryMapper {

    default Delivery toEntity(DeliveryDto deliveryDto){
        if(deliveryDto==null){
            return null;
        }
        Delivery delivery = new Delivery();
        delivery.setDeliveryLocation(deliveryDto.getDeliveryLocation());
        delivery.setExpectedDeliveryTime(deliveryDto.getExpectedDeliveryTime());
        delivery.setOrderId(deliveryDto.getOrderId());
        delivery.setDeliverStatus(deliveryDto.getDeliverStatus());
        return delivery;
    };

    default DeliveryDto toDto(Delivery delivery){
        if(delivery==null){
            return null;
        }
        DeliveryDto deliveryDto = new DeliveryDto();
        deliveryDto.setDeliveryLocation(delivery.getDeliveryLocation());
        deliveryDto.setExpectedDeliveryTime(delivery.getExpectedDeliveryTime());
        deliveryDto.setOrderId(delivery.getOrderId());
        deliveryDto.setDeliverStatus(delivery.getDeliverStatus());
        deliveryDto.setTrackingNumber(delivery.getTrackingNumber());
        return deliveryDto;
    };
    @Mapping(target="id", ignore = true)
    @Mapping(target = "trackingNumber", ignore = true)
    Delivery updateDeliveryFromDto(DeliveryDto deliveryDto, Delivery delivery);
}
