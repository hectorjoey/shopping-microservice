package com.hectordevelopers.productservices.service;

import com.hectordevelopers.productservices.dto.ProductDto;
import com.hectordevelopers.productservices.model.Product;
import com.hectordevelopers.productservices.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;


@RequiredArgsConstructor
@Service
public class ProductService {
    private final ProductRepository productRepository;

    //create product
    public Product createProduct(ProductDto productDto) {
        Product product = new Product();
        product.setName(productDto.getName());
        product.setPrice(productDto.getPrice());
        product.setDescription(productDto.getDescription());
//        productRepository.save(product);
        return productRepository.save(product);
    }

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }
}
