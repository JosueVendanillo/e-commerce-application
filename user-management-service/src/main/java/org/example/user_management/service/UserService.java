package org.example.user_management.service;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.example.user_management.model.User;
import org.example.user_management.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@NoArgsConstructor
@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;
//    @Autowired
//    private PasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

//    public UserService(PasswordEncoder passwordEncoder) {
//        this.passwordEncoder = passwordEncoder;
//    }

//    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
//        this.userRepository = userRepository;
//        this.passwordEncoder = passwordEncoder;
//    }

    public User register(User user){
        if (userRepository.findByUsername(user.getUsername()).isPresent()) {
            throw new IllegalArgumentException("Username is already taken!");
        }
        // Encode the password before saving the user
//        user.setPassword(passwordEncoder.encode(user.getPassword()));

        System.out.println(Arrays.toString(User.class.getDeclaredMethods()));

        System.out.println("Register successful!");
        return userRepository.save(user);
    }



    /**
     * Find a user by username.
     *
     * @param username The username of the user.
     * @return An optional containing the user if found, otherwise empty.
     */
    public Optional<User> findByUsername(String username) {
        return userRepository.findByUsername(username);
    }


    /**
     * Search users by username or email.
     *
     * @param username The username to search for.
     * @param email The email to search for.
     * @return A list of users that match the search criteria.
     */
    public List<User> searchUsers(String username, String email){
        if(username != null && email != null){
            System.out.println("User found: " + username + " " + email);
            return userRepository.findByUsernameContainingOrEmailContaining(username,email);
        } else if (username != null ) {
            System.out.println("User found: " + username);
            return userRepository.findByUsernameContaining(username);
        }else if (email != null){
            System.out.println("User found: " + email);
            return userRepository.findByEmailContaining(email);
        }
        System.out.println("No User found!");
        return List.of();
    }


    /**
     * Update user details.
     *
     * @param user The user details to update.
     * @return The updated user object.
     */
    public User updateUser(User user) {
        // Ensure the user exists before updating
        Optional<User> existingUser = userRepository.findById(user.getId());
        if (!existingUser.isPresent()) {
            throw new IllegalArgumentException("User not found!");
        }

        // Update user details and save
        User updatedUser = existingUser.get();
        updatedUser.setEmail(user.getEmail());
        updatedUser.setRoles(user.getRoles());

        return userRepository.save(updatedUser);
    }

    /**
     * Delete a user by ID.
     *
     * @param userId The ID of the user to delete.
     */

    public void deleteUser(String userId) {

        if(userRepository.existsById(userId)){
            System.out.println("User deleted successfully!");
            userRepository.deleteById(userId);
        }else{
            throw new IllegalArgumentException("UserId with ID " + userId + "does not exist.");
        }

    }
}
