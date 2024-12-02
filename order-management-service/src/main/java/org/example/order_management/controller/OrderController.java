package org.example.order_management.controller;


import org.example.order_management.model.Order;
import org.example.order_management.service.OrderService;
import org.example.shopping_cart.model.CartItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/orders")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping("/{userId}")
    public ResponseEntity<Order> placeOrder(@PathVariable String userId, @RequestBody List<CartItem> items){
        return ResponseEntity.ok(orderService.placeOrder(userId, items));
    }

    @GetMapping("/{userId")
    public ResponseEntity<List<Order>> getOrders(@PathVariable String userId){
        return  ResponseEntity.ok(orderService.getOrdersByUser(userId));
    }

}
