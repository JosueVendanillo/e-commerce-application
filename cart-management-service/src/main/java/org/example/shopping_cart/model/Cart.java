package org.example.shopping_cart.model;


import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@Data
@Document(collection = "carts")
public class Cart {
    @Id
    private Long id;
    private String userId;
    private List<CartItem> items = new ArrayList<>();
}

