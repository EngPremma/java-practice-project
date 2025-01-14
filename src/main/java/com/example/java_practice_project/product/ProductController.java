package com.example.java_practice_project.product;

import com.example.java_practice_project.product.model.Product;
import com.example.java_practice_project.product.model.ProductDTO;
import com.example.java_practice_project.product.model.SearchProductQuery;
import com.example.java_practice_project.product.services.CreateProductService;
import com.example.java_practice_project.product.services.GetProductService;
import com.example.java_practice_project.product.services.GetProductsService;
import com.example.java_practice_project.product.services.SearchProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {
    private final GetProductsService getProductsService;

    private final GetProductService getProductService;

    private final SearchProductService searchProductService;

    private final CreateProductService createProductService;

    public ProductController(GetProductsService getProductsService,
                             GetProductService getProductService,
                             SearchProductService searchProductService,
                             CreateProductService createProductService) {
        this.getProductsService = getProductsService;
        this.getProductService = getProductService;
        this.searchProductService = searchProductService;
        this.createProductService = createProductService;
    }

    @GetMapping("/")
    public ResponseEntity<List<ProductDTO>> getProducts() {
        return getProductsService.execute(null);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductDTO> getProductById(@PathVariable Integer id) {
        return getProductService.execute(id);
    }

    @GetMapping("/search")
    public ResponseEntity<List<ProductDTO>> searchProduct(@RequestParam(defaultValue = "") String name,
                                                          @RequestParam String sort) {
        return searchProductService.execute(new SearchProductQuery(name, sort));
    }

    @PostMapping("/")
    public ResponseEntity<ProductDTO> createProduct(@RequestBody Product product) {
        return createProductService.execute(product);
    }
}
