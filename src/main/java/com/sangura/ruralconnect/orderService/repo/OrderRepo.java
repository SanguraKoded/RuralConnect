package com.sangura.ruralconnect.orderService.repo;

import com.sangura.ruralconnect.orderService.entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepo extends JpaRepository<Order, Long> {
    Order findOrderById(Long id);
}
