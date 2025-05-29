package com.sangura.ruralconnect.orderService.dto;

import jakarta.persistence.Column;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class OrderItemDto {
    private Long productId;

    private Long quantity;

    private BigDecimal totalPrice;
}
