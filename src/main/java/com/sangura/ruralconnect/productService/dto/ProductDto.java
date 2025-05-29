package com.sangura.ruralconnect.productService.dto;

import com.sangura.ruralconnect.productService.Category;
import com.sangura.ruralconnect.productService.entities.ProductItem;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
@Getter
@Setter
public class ProductDto {
    private String imageUrl;

    private String name;

    private String description;

    private Integer quantityAvailable;

    private BigDecimal price;

    @Enumerated(value = EnumType.STRING)
    private Category category;

    @Column(nullable = false)
    private String region;

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL, orphanRemoval = true)
    private ProductItem productItem;
}
