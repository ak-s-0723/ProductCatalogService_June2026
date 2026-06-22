package org.example.productcatalogservice_june2026.services;

import org.example.productcatalogservice_june2026.models.Product;

import java.util.List;

public interface IProductService {
    Product getProductById();

    List<Product> getAllProducts();

    Product createProduct(Product product);
}
