package com.sangura.ruralconnect.productService.mappers;

import com.sangura.ruralconnect.productService.dto.ProductDto;
import com.sangura.ruralconnect.productService.dto.ProductItemDto;
import com.sangura.ruralconnect.productService.entities.ProductItem;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface ProductItemMapper {

    default ProductItem toEntity(ProductItemDto productItemDto){
        if(productItemDto==null){
            return null;
        }

        ProductItem productItem = new ProductItem();
        productItem.setName(productItemDto.getName());
        productItem.setCategory(productItemDto.getCategory());
        productItem.setRegion(productItemDto.getRegion());
        productItem.setPrice(productItemDto.getPrice());
        productItem.setDescription(productItemDto.getDescription());
        return productItem;
    }

    default ProductItemDto toDto(ProductItem productItem){
        if(productItem == null){
            return null;
        }
        ProductItemDto productItemDto = new ProductItemDto();
        productItemDto.setName(productItem.getName());
        productItemDto.setCategory(productItem.getCategory());
        productItemDto.setRegion(productItem.getRegion());
        productItemDto.setPrice(productItem.getPrice());
        productItemDto.setDescription(productItem.getDescription());
        return  productItemDto;
    }

    @Mapping(target = "id", ignore = true)
    ProductItem updateProductItemFromDto(ProductItemDto productItemDto, @MappingTarget ProductItem productItem);
}
