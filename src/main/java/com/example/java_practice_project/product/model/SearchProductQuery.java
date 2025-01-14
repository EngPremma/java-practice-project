package com.example.java_practice_project.product.model;

public class SearchProductQuery {
    private String name;

    private String sort;

    public SearchProductQuery(String name, String sort) {
        this.name = name;
        this.sort = sort;
    }

    public String getName() {
        return name;
    }

    public String getSort() {
        return sort;
    }

}
