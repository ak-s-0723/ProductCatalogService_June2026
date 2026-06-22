package org.example.productcatalogservice_june2026.controllers;

import org.example.productcatalogservice_june2026.dtos.ProductDto;
import org.example.productcatalogservice_june2026.models.Product;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

//bean = singleton object which we want spring to manage

@RestController
@RequestMapping("/products")
public class ProductController {

    @GetMapping
    public List<ProductDto> getAllProducts() {
        ProductDto productDto = new ProductDto();
        productDto.setId(2L);
        productDto.setName("Iphone");
        List<ProductDto> productDtos = new ArrayList<>();
        productDtos.add(productDto);
        return productDtos;
    }

    @GetMapping("{id}")
    public ProductDto getProductById(@PathVariable("id") Long productId) {
        ProductDto productDto = new ProductDto();
        productDto.setId(productId);
        productDto.setName("Macbook");
        return productDto;
    }


    @PostMapping
    public ProductDto createProduct(@RequestBody ProductDto productDto) {
        return productDto;
    }

}

