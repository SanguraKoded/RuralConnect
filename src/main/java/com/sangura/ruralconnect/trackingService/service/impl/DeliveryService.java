package com.sangura.ruralconnect.trackingService.service.impl;

import com.sangura.ruralconnect.trackingService.dto.DeliveryDto;
import com.sangura.ruralconnect.trackingService.entities.Delivery;

import java.util.List;

public interface DeliveryService {

    Delivery createDelivery(DeliveryDto deliveryDto);

    Delivery updateDelivery(Long id, DeliveryDto deliveryDto);

    List<Delivery> getAllDeliveries();

    String deleteDelivery(Long id);

    Delivery findByDeliveryById(Long id);
}
