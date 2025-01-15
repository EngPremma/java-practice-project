package com.example.java_practice_project.exceptions;

public class CategoryNotFoundException extends RuntimeException {
    public CategoryNotFoundException() {
        super(ErrorMessages.CATEGORY_NOT_FOUND.getMessage());
    }
}
