package com.example.java_practice_project.product;

import com.example.java_practice_project.product.model.Product;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {
    List<Product> findByNameContainingOrDescriptionContaining(String name, String description, Pageable pageable);
}
