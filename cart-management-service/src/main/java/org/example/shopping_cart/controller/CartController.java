package org.example.shopping_cart.controller;



import org.example.shopping_cart.model.Cart;
import org.example.shopping_cart.model.CartItem;
import org.example.shopping_cart.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cart")
public class CartController {

    @Autowired
    private CartService cartService;

    @GetMapping("/{userId}")
    public ResponseEntity<Cart> getCart(@PathVariable String userId){
        return  ResponseEntity.ok(cartService.getCartByUser(userId));
    }

    @PostMapping("/{userId}/add")
    public ResponseEntity<Cart> addItem(@PathVariable String userId, @RequestBody CartItem item){
        return  ResponseEntity.ok(cartService.addItemToCart(userId,item));
    }

    @DeleteMapping("/{userId}/remove/{productId}")
    public ResponseEntity<Cart> removeItem(@PathVariable String userId, @PathVariable String productId){
        return ResponseEntity.ok(cartService.removeItemToCart(userId,productId));
    }
}
