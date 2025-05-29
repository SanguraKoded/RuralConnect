package com.sangura.ruralconnect.productService.repo;

import com.sangura.ruralconnect.productService.entities.ProductItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductItemRepo extends JpaRepository<ProductItem, Long> {
}
