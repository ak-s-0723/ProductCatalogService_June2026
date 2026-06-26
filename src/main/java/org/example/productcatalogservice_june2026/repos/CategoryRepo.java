package org.example.productcatalogservice_june2026.repos;

import org.example.productcatalogservice_june2026.models.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepo extends JpaRepository<Category,Long> {
}
