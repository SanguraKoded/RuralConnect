package com.sangura.ruralconnect.productService.mappers;

import com.sangura.ruralconnect.productService.dto.ProductDto;
import com.sangura.ruralconnect.productService.entities.Product;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface ProductMapper {

    default ProductDto toDto(Product product){
        if(product==null){
            return null;
        }

        ProductDto productDto = new ProductDto();
        productDto.setProductItem(product.getProductItem());
        productDto.setName(productDto.getName());
        productDto.setCategory(product.getCategory());
        productDto.setPrice(product.getPrice());
        productDto.setDescription(productDto.getDescription());
        productDto.setImageUrl(product.getImageUrl());
        productDto.setRegion(product.getRegion());
        return productDto;

    };
    default Product toEntity(ProductDto productDto){

        if(productDto==null){
            return null;
        }

        Product product = new Product();
        product.setDescription(productDto.getDescription());
        product.setName(productDto.getName());
        product.setCategory(productDto.getCategory());
        product.setPrice(productDto.getPrice());
        product.setImageUrl(productDto.getImageUrl());
        product.setRegion(productDto.getRegion());
        product.setProductItem(productDto.getProductItem());
        return product;
    };

    @Mapping(target = "id", ignore = true)
    Product updateProduct(ProductDto productDto, @MappingTarget Product product);
}
