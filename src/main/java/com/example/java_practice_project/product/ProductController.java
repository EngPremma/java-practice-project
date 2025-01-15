package com.example.java_practice_project.product;

import com.example.java_practice_project.product.model.Product;
import com.example.java_practice_project.product.model.ProductDTO;
import com.example.java_practice_project.product.model.SearchProductQuery;
import com.example.java_practice_project.product.model.UpdateProductCommand;
import com.example.java_practice_project.product.services.*;
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

    private final UpdateProductService updateProductService;

    private final DeleteProductService deleteProductService;

    public ProductController(GetProductsService getProductsService,
                             GetProductService getProductService,
                             SearchProductService searchProductService,
                             CreateProductService createProductService,
                             UpdateProductService updateProductService,
                             DeleteProductService deleteProductService) {
        this.getProductsService = getProductsService;
        this.getProductService = getProductService;
        this.searchProductService = searchProductService;
        this.createProductService = createProductService;
        this.updateProductService = updateProductService;
        this.deleteProductService = deleteProductService;
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

    @PutMapping("/{id}")
    public ResponseEntity<ProductDTO> updateProduct(@PathVariable Integer id, @RequestBody Product product) {
        return updateProductService.execute(new UpdateProductCommand(id, product));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable Integer id) {
        return deleteProductService.execute(id);
    }
}
