package com.example.java_practice_project.product;

import com.example.java_practice_project.product.model.ProductDTO;
import com.example.java_practice_project.product.services.GetProductService;
import com.example.java_practice_project.product.services.GetProductsService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {
    private final GetProductsService getProductsService;

    private final GetProductService getProductService;

    public ProductController(GetProductsService getProductsService, GetProductService getProductService) {
        this.getProductsService = getProductsService;
        this.getProductService = getProductService;
    }

    @GetMapping("/")
    public ResponseEntity<List<ProductDTO>> getProducts() {
        return getProductsService.execute(null);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductDTO> getProductById(@PathVariable Integer id) {
        return getProductService.execute(id);
    }
}
