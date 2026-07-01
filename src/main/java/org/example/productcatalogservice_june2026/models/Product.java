package org.example.productcatalogservice_june2026.models;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
public class Product extends BaseModel {
    private String name;
    private String description;
    private Double price;
    private String imageUrl;
    @ManyToOne(cascade = CascadeType.ALL)
    private Category category;
    private Boolean isPrimeSaleSpecific; //This is why we need DTO
}


//1                1
//product         category
//M                 1
//
//M                 1




//1                   m
//student             teacher
//m                    1
//
//m   :  m