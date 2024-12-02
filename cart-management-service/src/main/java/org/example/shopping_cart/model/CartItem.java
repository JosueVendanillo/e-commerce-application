package org.example.shopping_cart.model;

import lombok.Data;
import org.springframework.data.annotation.Id;

@Data
public class CartItem {
    @Id
    private String productId;
    private int quantity;
    private double price; // Store price at the time of adding

}
