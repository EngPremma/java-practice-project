package com.example.java_practice_project.product.services;

import com.example.java_practice_project.Command;
import com.example.java_practice_project.category.CategoryRepository;
import com.example.java_practice_project.exceptions.CategoryNotFoundException;
import com.example.java_practice_project.product.ProductRepository;
import com.example.java_practice_project.product.model.Product;
import com.example.java_practice_project.product.model.ProductDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class CreateProductService implements Command<Product, ProductDTO> {
    private final ProductRepository productRepository;

    private final CategoryRepository categoryRepository;

    public CreateProductService(ProductRepository productRepository, CategoryRepository categoryRepository) {
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
    }

    @Override
    public ResponseEntity<ProductDTO> execute(Product product) {
        categoryRepository.findById(product.getCategory().getId())
                .orElseThrow(CategoryNotFoundException::new);

        Product saveproduct = productRepository.save(product);

        return ResponseEntity.status(HttpStatus.CREATED).body(new ProductDTO(saveproduct));
    }
}
