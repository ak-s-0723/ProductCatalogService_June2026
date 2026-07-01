package org.example.productcatalogservice_june2026.controllers;

import org.example.productcatalogservice_june2026.dtos.CategoryDto;
import org.example.productcatalogservice_june2026.dtos.ProductDto;
import org.example.productcatalogservice_june2026.models.Category;
import org.example.productcatalogservice_june2026.models.Product;
import org.example.productcatalogservice_june2026.services.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

//bean = singleton object which we want spring to manage

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    //@Qualifier("fkps")
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
    public ResponseEntity<ProductDto> getProductById(@PathVariable("id") Long productId) {
        if (productId <= 0) {
              //return new ResponseEntity<>(null,HttpStatus.BAD_REQUEST);
            throw new IllegalArgumentException("Please pass positive product Id");
        }

       Product product = productService.getProductById(productId);
       if (product == null) {
           //return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
           throw new NullPointerException("Product not available");
       }
       ProductDto productDto = from(product);
       return new ResponseEntity<>(productDto,HttpStatus.OK);
    }


    @PostMapping
    public ProductDto createProduct(@RequestBody ProductDto productDto) {
        return productDto;
    }


    @PutMapping("{id}")
    public ResponseEntity<ProductDto> replaceProduct(@PathVariable Long id,
                                     @RequestBody ProductDto productDto)
    {
        if (id <= 0) {
            return new ResponseEntity<>(null,HttpStatus.BAD_REQUEST);
        }

        Product inputProduct = from(productDto);
        Product outputProduct = productService.replaceProduct(id,inputProduct);

        if (outputProduct == null) {
           return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
        }

        ProductDto response = from(outputProduct);
        return new ResponseEntity<>(response,HttpStatus.OK);
    }


    private Product from(ProductDto productDto) {
        Product product = new Product();
        product.setId(productDto.getId());
        product.setName(productDto.getName());
        product.setPrice(productDto.getPrice());
        product.setImageUrl(productDto.getImageUrl());
        product.setDescription(productDto.getDescription());
        if(productDto.getCategory() != null) {
            Category category = new Category();
            category.setName(productDto.getCategory().getName());
            category.setId(productDto.getCategory().getId());
            product.setCategory(category);
        }
        return product;
    }

    private ProductDto from(Product product) {
        ProductDto productDto = new ProductDto();
        productDto.setName(product.getName());
        productDto.setId(product.getId());
        productDto.setDescription(product.getDescription());
        productDto.setPrice(product.getPrice());
        productDto.setImageUrl(product.getImageUrl());
        if(product.getCategory() != null) {
            CategoryDto categoryDto = new CategoryDto();
            categoryDto.setDescription(product.getCategory().getDescription());
            categoryDto.setName(product.getCategory().getName());
            categoryDto.setId(product.getCategory().getId());
            productDto.setCategory(categoryDto);
        }

        return productDto;
    }

}

//H/W 22 June 22
//1. Look for a method in Rest Template which we can use to call FakeStore Endpoint
//2. Complete ProductDto from Product Mapper
//3. Try adding Delete, Put API in product controller


