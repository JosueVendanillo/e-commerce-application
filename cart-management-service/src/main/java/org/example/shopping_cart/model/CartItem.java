package org.example.shopping_cart.model;

import lombok.Data;
import org.springframework.data.annotation.Id;

@Data
public class CartItem {
    @Id
    private String productId;
    private int quantity;
    private double price; // Store price at the time of adding

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
