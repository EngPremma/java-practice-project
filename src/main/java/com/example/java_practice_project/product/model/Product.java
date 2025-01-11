package com.example.java_practice_project.product.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Entity
@Data
@Table(name = "product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

//    @NotNull(message = "Name is required")
//    @Column(name = "name")
//    private String name;
//
//    @Size(min = 20, message = "Description must be 20 characters")
//    @Column(name = "description")
//    private String description;
//
//    @PositiveOrZero(message = "Price cannot be negative")
//    @Column(name = "price")
//    private Double price;
//
//    @NotNull(message = "Manufacturer is required")
//    @Column(name = "manufacturer")
//    private String manufacturer;
//
//    @Column(name = "created")
//    private String created;
//
//    @Column(name = "updated")
//    private String updated;
//
//    @Enumerated(EnumType.STRING)
//    @Column(name = "region")
//    private Region region;
//
//    @Column(name = "category_id")
//    private String categoryId;
}
