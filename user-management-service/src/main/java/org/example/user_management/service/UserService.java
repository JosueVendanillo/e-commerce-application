package org.example.user_management.service;

import org.example.user_management.model.User;
import org.example.user_management.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private UserRepository userRepository;

    public User register(User user){
        System.out.println("Register successful!");
        return userRepository.save(user);
    }
}
