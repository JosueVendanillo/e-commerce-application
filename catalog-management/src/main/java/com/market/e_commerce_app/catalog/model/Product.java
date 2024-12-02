package com.market.e_commerce_app.catalog.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "products")  // Use @Entity if using SQL
public class Product {
    @Id
    private String id;
    private String name;
    private String description;
    private double price;
    private int stock;
}