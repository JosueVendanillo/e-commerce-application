package org.example.order_management.repository;

import com.market.e_commerce_app.order_management.model.Order;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends MongoRepository<Order,Long> {
    List<Order> findByUserId(String userId);
}