package org.example.order_management.service;


import org.example.order_management.model.Order;
import org.example.order_management.repository.OrderRepository;

import org.example.shopping_cart.model.CartItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    public Order placeOrder(String userId, List<CartItem> items){
        double total = items.stream()
                .mapToDouble(item -> item.getPrice() * item.getQuantity()).sum();


        Order order = new Order();
        order.setUserId(userId);
        order.setItems(items);
        order.setTotalAmount(total);
        order.setStatus("Pending");
        order.setOrderDate(LocalDateTime.now());
        return orderRepository.save(order);



//        // Validate products and calculate total
//        double totalAmount = 0;
//        for (OrderItem item : items) {
//            Product product = productService.getProductById(item.getProductId());
//            if (product.getStock() < item.getQuantity()) {
//                throw new IllegalArgumentException("Product out of stock: " + product.getName());
//            }
//            totalAmount += item.getQuantity() * product.getPrice();
//        }
//
//        // Save order
//        Order order = new Order();
//        order.setUserId(userId);
//        order.setOrderDate(LocalDateTime.now());
//        order.setStatus("Pending");
//        order.setTotalAmount(totalAmount);
//        order.setItems(items);
//
//        return orderRepository.save(order);

    }

    public List<Order> getOrdersByUser(String userId){
        return orderRepository.findByUserId(userId);
    }

}
