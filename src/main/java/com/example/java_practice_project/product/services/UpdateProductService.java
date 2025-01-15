package com.example.java_practice_project.product.services;

import com.example.java_practice_project.Command;
import com.example.java_practice_project.product.ProductRepository;
import com.example.java_practice_project.product.model.Product;
import com.example.java_practice_project.product.model.ProductDTO;
import com.example.java_practice_project.product.model.UpdateProductCommand;
import org.springframework.cache.annotation.CachePut;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UpdateProductService implements Command<UpdateProductCommand, ProductDTO> {
    private final ProductRepository productRepository;

    public UpdateProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    @CachePut(value = "productsCache", key = "#command.getId()")
    public ResponseEntity<ProductDTO> execute(UpdateProductCommand command) {
        Optional<Product> optionalProduct = productRepository.findById(command.getId());

        if (optionalProduct.isPresent()) {
            Product product = command.getProduct();
            product.setId(command.getId());
            Product updatedProduct = productRepository.save(product);

            return ResponseEntity.ok(new ProductDTO(updatedProduct));
        }

        throw new RuntimeException("Product not found");
    }
}
