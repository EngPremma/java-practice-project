package com.example.java_practice_project.product.model;

//@Data
public class ProductDTO {
    private Integer id;
    private String name;
    private String description;
    private Double price;
    private String manufacturer;
    private Region region;
    private String categoryId;

    public ProductDTO(Product product) {
        this.id = product.getId();
        this.name = product.getName();
        this.description = product.getDescription();
        this.price = product.getPrice();
        this.manufacturer = product.getManufacturer();
        this.region = product.getRegion();
        this.categoryId = product.getCategoryId();
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

    public String getCategoryId() {
        return categoryId;
    }
}
