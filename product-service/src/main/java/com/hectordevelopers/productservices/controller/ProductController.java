package com.hectordevelopers.productservices.controller;

import com.hectordevelopers.productservices.dto.ProductDto;
import com.hectordevelopers.productservices.model.Product;
import com.hectordevelopers.productservices.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/product/")
public class ProductController {
    private final ProductService productService;

    @PostMapping("create")
    public ResponseEntity<Product> create(@RequestBody ProductDto product) {
        return new ResponseEntity<>(productService.createProduct(product), HttpStatus.CREATED);
    }

    @GetMapping("all")
    public ResponseEntity <List<Product>> getProducts(){
        return  new ResponseEntity<>(productService.getAllProducts(), HttpStatus.OK);
    }
}
