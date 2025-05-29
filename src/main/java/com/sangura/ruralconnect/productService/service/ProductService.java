package com.sangura.ruralconnect.productService.service;

import com.sangura.ruralconnect.productService.dto.ProductDto;
import com.sangura.ruralconnect.productService.entities.Product;
import com.sangura.ruralconnect.productService.entities.ProductItem;

import java.util.List;

public interface ProductService {

    Product createProduct(ProductDto productDto);

    Product updateProduct(Long id, ProductDto productDto);

    List<Product> getAllProduct();

    Product findProduct(Long id);

    String deleteProductById(Long id);
}
