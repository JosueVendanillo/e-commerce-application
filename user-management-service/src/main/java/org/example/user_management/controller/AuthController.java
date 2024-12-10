package org.example.user_management.controller;

import org.example.user_management.model.User;
import org.example.user_management.service.UserService;
import org.example.user_management.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

//    @Autowired
//    private AuthenticationManager authenticationManager;

//    @Autowired
//    private JwtUtil jwtUtil;

    @Autowired
    private UserService userService;
//    private MyUserDetailsService userDetailsService;
//
//    @PostMapping("/login")
//    public ResponseEntity<?> login(@RequestBody AuthRequest authRequest) {
//        try {
//            authenticationManager.authenticate(
//                    new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword())
//            );
//        } catch (BadCredentialsException e) {
//            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid username or password");
//        }
//
//        final UserDetails userDetails = userDetailsService.loadUserByUsername(authRequest.getUsername());
//        final String jwt = jwtUtil.generateToken(userDetails.getUsername());
//
//        return ResponseEntity.ok(new AuthResponse(jwt));
//    }


    @CrossOrigin(origins = "http://localhost:3000")  // Allow CORS for this method
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody User loginRequest) {

        System.out.println("Login attempt: " + loginRequest.getEmail());
        // Validate user credentials
        User existingUser = userService.searchUserEmail(loginRequest.getEmail());
        System.out.println(existingUser.toString());
        if (existingUser == null) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("User not found");
        }

        // Check password (assuming passwords are stored as plain text, which is not recommended)
        if (!existingUser.getPassword().equals(loginRequest.getPassword())) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid email or password");
        }

        // Return success response
        return ResponseEntity.ok("Login successful");
    }
}

