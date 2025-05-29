package com.sangura.ruralconnect.productService.service.impl;

import com.sangura.ruralconnect.productService.dto.ProductDto;
import com.sangura.ruralconnect.productService.dto.ProductItemDto;
import com.sangura.ruralconnect.productService.entities.Product;
import com.sangura.ruralconnect.productService.entities.ProductItem;
import com.sangura.ruralconnect.productService.mappers.ProductItemMapper;
import com.sangura.ruralconnect.productService.repo.ProductItemRepo;
import com.sangura.ruralconnect.productService.service.ProductItemService;
import com.sangura.ruralconnect.productService.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductItemServiceImpl implements ProductItemService {

    private final ProductItemRepo productItemRepo;

    private final ProductItemMapper productItemMapper;

    @Override
    @Transactional
    public ProductItem createProductItem(ProductItemDto productItemDto) {
        try{
            ProductItem productItem = productItemMapper.toEntity(productItemDto);
            return productItemRepo.save(productItem);
        }catch(Exception e){
            throw new RuntimeException("Unexpected Error Occurred "+e.getMessage());
        }
    }

    @Override
    @Transactional
    public ProductItem updateProductItem(Long id, ProductItemDto productItemDto) {
        try{
            ProductItem productItem = productItemRepo.findById(id).orElseThrow(() -> new RuntimeException("Please Enter Valid ID"));
            productItemMapper.updateProductItemFromDto(productItemDto, productItem);
            return productItemRepo.save(productItem);
        }catch(Exception e){
            throw new RuntimeException("Unexpected Error Occurred "+e.getMessage());
        }
    }

    @Override
    @Transactional(readOnly = true)
    public List<ProductItem> getAllProductItem() {
        try{
            return productItemRepo.findAll();
        }catch(Exception e){
            throw new RuntimeException("Unexpected Error Occurred "+e.getMessage());
        }
    }

    @Override
    @Transactional(readOnly = true)
    public ProductItem findProductItemById(Long id) {
        try{
            return productItemRepo.findById(id).orElseThrow(() -> new RuntimeException("Please Enter Valid ID"));
        }catch (Exception e){
            throw new RuntimeException("Unexpected Error Occurred "+e.getMessage());
        }
    }

    @Override
    @Transactional
    public String deleteProductItemById(Long id) {
        try{
            productItemRepo.findById(id).orElseThrow(() -> new RuntimeException("Please Enter Valid ID"));
            productItemRepo.deleteById(id);
            return "Successfully Deleted";
        }catch(Exception e){
            throw new RuntimeException("Unexpected Error Occurred "+e.getMessage());
        }
    }
}
