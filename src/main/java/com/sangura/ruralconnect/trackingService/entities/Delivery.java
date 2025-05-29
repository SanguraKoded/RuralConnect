package com.sangura.ruralconnect.trackingService.entities;

import com.sangura.ruralconnect.trackingService.entities.enums.DeliveryStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Delivery {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    private Long orderId;

    @Column(nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String trackingNumber;

    @Column(nullable = false)
    @Enumerated(value = EnumType.STRING)
    private DeliveryStatus deliverStatus;

    @Column(nullable = false)
    private LocalDateTime expectedDeliveryTime;

    @Column(nullable = false)
    private String deliveryLocation;

    @Column(nullable = false)
    private String deliveryLocationPin;
}
