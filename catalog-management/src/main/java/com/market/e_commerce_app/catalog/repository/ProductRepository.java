package com.market.e_commerce_app.catalog.repository;

import com.market.e_commerce_app.catalog.model.Product;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends MongoRepository<Product, String> {
    List<Product> findByNameContaining(String name);

}
