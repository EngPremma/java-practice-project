package com.example.java_practice_project.product.services;

import com.example.java_practice_project.Query;
import com.example.java_practice_project.product.ProductRepository;
import com.example.java_practice_project.product.model.Product;
import com.example.java_practice_project.product.model.ProductDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetProductsService implements Query<Void, List<ProductDTO>> {
    private final ProductRepository productRepository;

    public GetProductsService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public ResponseEntity<List<ProductDTO>>

    execute(Void input) {
        List<Product> products = productRepository.findAll();

        List<ProductDTO> productDTOS = products.stream().map(ProductDTO::new).toList();

//        CustomResponse<List<ProductDTO>> customResponse = new CustomResponse<>(
//                "get products successfully",
//                productDTOS);

        return ResponseEntity.status(HttpStatus.OK).body(productDTOS);
    }
}