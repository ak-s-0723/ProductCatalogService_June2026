package org.example.productcatalogservice_june2026.dtos;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class FakeStoreProductDto {
    private String title;
    private Long id;
    private String description;
    private String category;
    private Double price;
    private String image;
}
