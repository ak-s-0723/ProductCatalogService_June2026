package org.example.productcatalogservice_june2026.controllers;

import jakarta.websocket.Endpoint;
import org.example.productcatalogservice_june2026.dtos.ProductDto;
import org.example.productcatalogservice_june2026.models.Product;
import org.example.productcatalogservice_june2026.services.IProductService;
import org.example.productcatalogservice_june2026.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

//bean = singleton object which we want spring to manage

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private IProductService productService;


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
       Product product = productService.getProductById();
       return from(product);
    }


    @PostMapping
    public ProductDto createProduct(@RequestBody ProductDto productDto) {
        return productDto;
    }

    private ProductDto from(Product product) {
        ProductDto productDto = new ProductDto();
        productDto.setId(product.getId());
        productDto.setName(productDto.getName());
        return productDto;
    }

}

//H/W 22 June 22
//1. Look for a method in Rest Template which we can use to call FakeStore Endpoint
//2. Complete ProductDto from Product Mapper
//3. Try adding Delete, Put API in product controller