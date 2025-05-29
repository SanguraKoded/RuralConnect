package com.sangura.ruralconnect.orderService.dto;

import com.sangura.ruralconnect.orderService.entities.OrderItem;
import com.sangura.ruralconnect.orderService.entities.enums.OrderStatus;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
public class OrderDto {

    private Long agentId;

    private Long customerId;

    private List<OrderItem> items;

    private BigDecimal totalAmount;

}
