package com.example.java_practice_project.product.model;

import com.example.java_practice_project.category.model.Category;

//@Data
public class ProductDTO {
    private Integer id;
    private String name;
    private String description;
    private Double price;
    private String manufacturer;
    private Region region;
    private Category category;

    public ProductDTO(Product product) {
        this.id = product.getId();
        this.name = product.getName();
        this.description = product.getDescription();
        this.price = product.getPrice();
        this.manufacturer = product.getManufacturer();
        this.region = product.getRegion();
        this.category = product.getCategory();
    }

    //    Temporary fix
    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public Double getPrice() {
        return price;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public Region getRegion() {
        return region;
    }

    public Category getCategory() {
        return category;
    }
}
