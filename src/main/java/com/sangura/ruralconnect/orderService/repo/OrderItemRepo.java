package com.sangura.ruralconnect.orderService.repo;

import com.sangura.ruralconnect.orderService.entities.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItemRepo extends JpaRepository<OrderItem, Long> {
}
