package com.sangura.ruralconnect.productService.service.impl;

import com.sangura.ruralconnect.productService.dto.ProductDto;
import com.sangura.ruralconnect.productService.entities.Product;
import com.sangura.ruralconnect.productService.mappers.ProductMapper;
import com.sangura.ruralconnect.productService.repo.ProductRepo;
import com.sangura.ruralconnect.productService.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductMapper productMapper;
    private final ProductRepo productRepo;
    @Override
    @Transactional
    public Product createProduct(ProductDto productDto) {
        try{
            Product product = productMapper.toEntity(productDto);
            return productRepo.save(product);
        }catch(Exception e){
            throw new RuntimeException("Unexpected Error Occurred "+e.getMessage());
        }
    }

    @Override
    @Transactional
    public Product updateProduct(Long id, ProductDto productDto) {
        try{
            Product existingProduct = productRepo.findById(id).orElseThrow(()-> new RuntimeException("Please Enter Correct Product ID"));
            productMapper.updateProduct(productDto, existingProduct);
            return productRepo.save(existingProduct);
        }catch(Exception e){
            throw new RuntimeException("Unexpected Error Occurred "+e.getMessage());
        }
    }

    @Override
    @Transactional(readOnly = true)
    public List<Product> getAllProduct() {
        try{
            return productRepo.findAll();
        }catch(Exception e){
            throw new RuntimeException("Unexpected Error Occurred "+e.getMessage());
        }
    }

    @Override
    @Transactional(readOnly = true)
    public Product findProduct(Long id) {
        try{
            Product product = productRepo.findById(id).orElseThrow(()-> new RuntimeException("Please Enter Correct Product ID"));
            return product;
        }catch(Exception e){
            throw new RuntimeException("Unexpected Error Occurred "+e.getMessage());
        }
    }

    @Override
    @Transactional
    public String deleteProductById(Long id) {
        try{
            productRepo.findById(id).orElseThrow(()-> new RuntimeException("Please Enter Correct Product ID"));
            productRepo.deleteById(id);
            return "Successfully Deleted";
        }catch(Exception e){
            throw new RuntimeException("Unexpected Error Occurred "+e.getMessage());
        }
    }
}
