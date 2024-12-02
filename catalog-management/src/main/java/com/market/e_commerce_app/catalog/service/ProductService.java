package com.market.e_commerce_app.catalog.service;

import com.market.e_commerce_app.catalog.model.Product;
import com.market.e_commerce_app.catalog.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public List<Product> getAllProducts(){
        return productRepository.findAll();
    }
}