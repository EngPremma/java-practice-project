package com.example.java_practice_project.product.services;

import com.example.java_practice_project.Command;
import com.example.java_practice_project.product.ProductRepository;
import com.example.java_practice_project.product.model.Product;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DeleteProductService implements Command<Integer, Void> {
    private final ProductRepository productRepository;

    public DeleteProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public ResponseEntity<Void> execute(Integer id) {
        Optional<Product> optionalProduct = productRepository.findById(id);

        if (optionalProduct.isPresent()) {
            productRepository.deleteById(id);

            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }

        throw new RuntimeException("Product not found");
    }
}
