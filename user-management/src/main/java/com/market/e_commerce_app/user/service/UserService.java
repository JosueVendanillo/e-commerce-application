package com.market.e_commerce_app.user.service;

import com.market.e_commerce_app.user.model.User;
import com.market.e_commerce_app.user.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private UserRepository userRepository;

    public User register(User user){
        return userRepository.save(user);
    }
}
