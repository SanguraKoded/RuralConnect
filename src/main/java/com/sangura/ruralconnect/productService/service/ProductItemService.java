package com.sangura.ruralconnect.productService.service;

import com.sangura.ruralconnect.productService.dto.ProductDto;
import com.sangura.ruralconnect.productService.dto.ProductItemDto;
import com.sangura.ruralconnect.productService.entities.Product;
import com.sangura.ruralconnect.productService.entities.ProductItem;

import java.util.List;

public interface ProductItemService {

    ProductItem createProductItem(ProductItemDto productItemDto);

    ProductItem updateProductItem(Long id, ProductItemDto productDto);

    List<ProductItem> getAllProductItem();

    ProductItem findProductItemById(Long id);

    String deleteProductItemById(Long id);

}
