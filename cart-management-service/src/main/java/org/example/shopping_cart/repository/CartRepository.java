package com.market.e_commerce_app.shopping_cart.repository;

import com.market.e_commerce_app.shopping_cart.model.Cart;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CartRepository extends MongoRepository<Cart,Long> {
    Optional<Cart> findByUserId(String userId);

}
