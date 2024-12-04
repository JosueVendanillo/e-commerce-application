package org.example.user_management.repository;

import org.example.user_management.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends MongoRepository<User, String> {
    Optional<User> findByUsername(String username);

    List<User> findByUsernameContaining(String username);

    List<User> findByEmailContaining(String email);

    List<User> findByUsernameContainingOrEmailContaining(String username, String email);
}
