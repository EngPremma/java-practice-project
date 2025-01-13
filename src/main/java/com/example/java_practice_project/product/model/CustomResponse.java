package com.example.java_practice_project.product.model;

public class CustomResponse<T> {
    private String message;

    private T docs;

    public CustomResponse(String message, T docs) {
        this.message = message;
        this.docs = docs;
    }

    public T getDocs() {
        return docs;
    }

    public String getMessage() {
        return message;
    }
}
