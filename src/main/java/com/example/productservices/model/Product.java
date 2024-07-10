package com.example.productservices.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true)
    private Long id;

    @Column(nullable = false)
    private String name;

//    @Column(name = "desc") olmaz cunki "DESC" bir funksiyadir SQL-de
    @Column(columnDefinition = "TEXT")
    private String description;

    @Column(nullable = false)
    private double price;

//    public Product() {}
//
//    public Product(Long id, String name, String description, double price) {
//        this.id = id;
//        this.name = name;
//        this.description = description;
//        this.price = price;
//    }
}
