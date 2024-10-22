package com.project1.project1.repository;

import com.project1.project1.domain.Product;
import com.project1.project1.domain.ProductId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, ProductId> {
    ProductId findByName(String name);
}
