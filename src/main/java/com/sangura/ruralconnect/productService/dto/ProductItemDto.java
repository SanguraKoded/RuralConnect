package com.sangura.ruralconnect.productService.dto;

import com.sangura.ruralconnect.productService.Category;
import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Setter
@Getter
public class ProductItemDto {

    private String name;

    private String description;

    private BigDecimal price;

    @Enumerated(value = EnumType.STRING)
    private Category category;

    private String region;
}
