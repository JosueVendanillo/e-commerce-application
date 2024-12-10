package org.example.user_management.controller;

import org.example.user_management.model.User;
import org.example.user_management.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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

    @CrossOrigin(origins = "http://localhost:3000")  // Allow CORS for this method
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


//    @GetMapping("/search")
//    public ResponseEntity<List<User>> searchUsers(
//            @RequestParam(required = false) String username,
//            @RequestParam(required = false) String email){
//
//        try {
//            List<User> users  =userService.searchUsers(username,email);
//            if(users.isEmpty()){
//
//                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(users); // No users found
//            }
//
//            return ResponseEntity.ok(users);
//        }catch (Exception e){
//            Map<String, String> errorResponse = Map.of("error", "User search failed");
//            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
//        }
//
//    }
//    @GetMapping("/search")
//    public Page<User> findAllUsers(Pageable pageable) {
//       return userService.findAll(pageable);
//
//    }
    @CrossOrigin(origins = "http://localhost:3000")  // Allow CORS for this method
    @GetMapping("/search")
    public ResponseEntity<Page<User>> findAllUsers(Pageable pageable){
        try{
            Page<User> user = userService.findAll(pageable);
            if(user.isEmpty()){
               return ResponseEntity.status(HttpStatus.NOT_FOUND).body(user);
            }
            return ResponseEntity.ok(user);
        }catch (Exception e){
            Map<String, String> errorResponse = Map.of("error", "User search failed");
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }


    @PutMapping("/update/{id}")
    public ResponseEntity<User> updateUser(@PathVariable String id, @RequestBody User updatedUser){
        User updated = userService.updateUser(id,updatedUser);
        return ResponseEntity.ok(updated);
    }


//    @DeleteMapping("/delete/{id}")
//    public ResponseEntity<String> deleteUser(@RequestParam("id") String userId) {
////        try{
//            userService.deleteUser(userId);
//            return ResponseEntity.ok("User with ID " + userId + " deleted successfully.");
////        }catch (Exception e) {
////            return ResponseEntity.badRequest().body(e.getMessage());
////        }
//    }

    @DeleteMapping("/delete")
    public ResponseEntity<String> deleteUser(@RequestParam String id) {
        boolean deleted = userService.deleteUserById(id);
        if (deleted) {
            return ResponseEntity.ok("User deleted successfully");
        } else {
            return ResponseEntity.status(404).body("User not found");
        }
    }

}
