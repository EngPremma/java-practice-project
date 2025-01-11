package com.example.java_practice_project.product.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductDTO {
    private Integer id;
    private String name;
    private String description;

    public ProductDTO(Product product) {
//        this.id = product.getId();
    }
}
