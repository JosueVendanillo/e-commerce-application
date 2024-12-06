package org.example.user_management.controller;

import org.example.user_management.model.User;
import org.example.user_management.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/users")
public class UserController {
    @Autowired
    private UserService userService;


    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("register")
    public ResponseEntity<User> register(@RequestBody User user){
        try {
            User savedUser = userService.register(user);
            return ResponseEntity.ok(savedUser);  // Return saved user
        } catch (Exception e) {
            // Return error message
            Map<String, String> errorResponse = new HashMap<>();
            errorResponse.put("error", "User registration failed");
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new User());  // Handle errors
        }
    }


    @GetMapping("/search")
    public ResponseEntity<List<User>> searchUsers(
            @RequestParam(required = false) String username,
            @RequestParam(required = false) String email){

        try {
            List<User> users  =userService.searchUsers(username,email);
            if(users.isEmpty()){

                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(users); // No users found
            }

            return ResponseEntity.ok(users);
        }catch (Exception e){
            Map<String, String> errorResponse = Map.of("error", "User search failed");
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }

    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable("id") String userId) {
        try{
            userService.deleteUser(userId);
            return ResponseEntity.ok("User with ID " + userId + " deleted successfully.");
        }catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }


}
