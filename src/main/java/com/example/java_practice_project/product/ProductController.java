package com.example.java_practice_project.product;

import com.example.java_practice_project.product.services.GetProductsService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/products")
public class ProductController {
    private final GetProductsService getProductsService;

    public ProductController(GetProductsService getProductsService) {
        this.getProductsService = getProductsService;
    }

    @GetMapping("/")
    public ResponseEntity<String> getProducts() {
        return getProductsService.execute(null);
    }
}
