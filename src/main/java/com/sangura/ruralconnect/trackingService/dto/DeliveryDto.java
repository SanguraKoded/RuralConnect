package com.sangura.ruralconnect.trackingService.dto;

import com.sangura.ruralconnect.trackingService.entities.enums.DeliveryStatus;
import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class DeliveryDto {

    private Long orderId;

    private String trackingNumber;

    @Enumerated(value = EnumType.STRING)
    private DeliveryStatus deliverStatus;

    private LocalDateTime expectedDeliveryTime;

    private String deliveryLocation;

}
