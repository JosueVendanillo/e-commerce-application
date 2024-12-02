package org.example.catalog_management.model;

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