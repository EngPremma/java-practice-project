package com.example.java_practice_project.product.services;

import com.example.java_practice_project.Query;
import com.example.java_practice_project.product.ProductRepository;
import com.example.java_practice_project.product.model.ProductDTO;
import com.example.java_practice_project.product.model.SearchProductQuery;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SearchProductService implements Query<SearchProductQuery, List<ProductDTO>> {
    private final ProductRepository productRepository;

    public SearchProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public ResponseEntity<List<ProductDTO>> execute(SearchProductQuery query) {
        int pageNumber = 0;
        int limit = 5;
        String nameQuery = query.getName();
        String[] sortQuery = query.getSort().split(":");

        Sort sort = sortQuery[1].equalsIgnoreCase("asc") ?
                Sort.by(sortQuery[0]).ascending() : Sort.by(sortQuery[0]).descending();

        Pageable pageable = PageRequest.of(pageNumber, limit, sort);

        List<ProductDTO> productDTOS = productRepository
                .findByNameContainingOrDescriptionContaining(nameQuery, nameQuery, pageable)
                .stream()
                .map(ProductDTO::new)
                .toList();

        return ResponseEntity.ok(productDTOS);
    }
}
