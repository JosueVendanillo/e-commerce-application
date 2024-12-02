package org.example.common.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderDto implements Serializable {

    private String id;                  // Unique identifier for the order
    private String userId;              // ID of the user who placed the order
    private List<String> productIds;    // List of product IDs in the order
    private double totalAmount;         // Total price of the order
    private String status;              // Order status (e.g., PENDING, COMPLETED)
    private LocalDateTime orderDate;    // Timestamp of when the order was placed

}
