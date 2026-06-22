package org.example.productcatalogservice_june2026.services;

import org.example.productcatalogservice_june2026.dtos.FakeStoreProductDto;
import org.example.productcatalogservice_june2026.models.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class ProductService implements IProductService {

    @Autowired
    private RestTemplateBuilder restTemplateBuilder;

    @Override
    public Product getProductById() {
        RestTemplate restTemplate = restTemplateBuilder.build();

    }

    @Override
    public List<Product> getAllProducts() {
        return null;
    }

    @Override
    public Product createProduct(Product product) {
        return null;
    }

//    private Product from(FakeStoreProductDto fakeStoreProductDto) {
//
//    }
}
