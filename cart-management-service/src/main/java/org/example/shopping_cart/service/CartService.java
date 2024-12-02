package org.example.shopping_cart.service;

import com.market.e_commerce_app.shopping_cart.repository.CartRepository;
import org.example.shopping_cart.model.Cart;
import org.springframework.stereotype.Service;

@Service
public class CartService {

    private CartRepository cartRepository;

    public Cart getCartByUser(String userId){
        return cartRepository.findByUserId(userId).orElse(new Cart());
    }

    public Cart addItemToCart(String userId, CartItem cartItem) {
        Cart cart = getCartByUser(userId);
//        cart.getItems().add(cartItem); // Add logic to update quantity if item exists
        return cartRepository.save(cart);
    }


    public Cart removeItemToCart(String userId, String productId){
        Cart cart = getCartByUser(userId);
//        cart.getItems().removeIf(item -> item.getProductId().equals(productId));
        return cartRepository.save(cart);
    }
}
