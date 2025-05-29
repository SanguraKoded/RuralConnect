package com.sangura.ruralconnect.trackingService.repo;

import com.sangura.ruralconnect.productService.entities.Product;
import com.sangura.ruralconnect.trackingService.entities.Delivery;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DeliveryRepo extends JpaRepository<Delivery, Long> {
    Delivery findDeliveryById(Long id);
}
