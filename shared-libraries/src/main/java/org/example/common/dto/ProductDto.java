package org.example.common.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductDto implements Serializable {

    private String id;           // Unique identifier for the product
    private String name;         // Product name
    private String description;  // Product description
    private double price;        // Product price
    private String category;     // Product category (e.g., Electronics, Clothing)
    private int stockQuantity;   // Quantity available in stock



}
