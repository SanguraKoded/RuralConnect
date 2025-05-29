package com.sangura.ruralconnect.orderService.services;

import com.sangura.ruralconnect.orderService.dto.OrderDto;
import com.sangura.ruralconnect.orderService.dto.OrderItemDto;
import com.sangura.ruralconnect.orderService.entities.Order;
import com.sangura.ruralconnect.orderService.entities.OrderItem;
import com.sangura.ruralconnect.orderService.entities.enums.OrderStatus;

import java.time.LocalDate;
import java.util.List;

public interface OrderService {

    Order createOrder (OrderDto orderDto);
    Order updateOrder(Long id, OrderDto orderDto);

    String deleteOrder(Long id);

    List<Order> getAllOrder();
    OrderItem createOrderItem (OrderItemDto orderItemDto);
    OrderItem updateOrderItem(Long id, OrderItemDto orderItemDto);

    String deleteOrderItem(Long id);

    List<OrderItem> getAllOrderItem();



}
