package com.example.java_practice_project.exceptions;

public class ProductNotFoundException extends RuntimeException {
    public ProductNotFoundException() {
        super(ErrorMessages.PRODUCT_NOT_FOUND.getMessage());
    }
}
