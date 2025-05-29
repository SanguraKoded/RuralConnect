package com.sangura.ruralconnect.productService.repo;

import com.sangura.ruralconnect.productService.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepo extends JpaRepository<Product, Long> {
    Product findProductById(Long id);
}
