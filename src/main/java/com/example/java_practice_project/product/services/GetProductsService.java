package com.example.java_practice_project.product.services;

import com.example.java_practice_project.Query;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class GetProductsService implements Query<Void,String> {

    @Override
    public ResponseEntity<String> execute(Void input) {
        return ResponseEntity.ok("products");
    }
}
