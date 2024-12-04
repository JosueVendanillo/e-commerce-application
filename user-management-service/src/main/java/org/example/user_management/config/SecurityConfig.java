package org.example.user_management.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf.disable()) // Use the new syntax to disable CSRF
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/api/users/register","/api/users/search").permitAll() // Allow access to register
                        .anyRequest().authenticated() // Secure other endpoints
                )
                .formLogin(form -> form.disable()); // Disable default login page

        return http.build();
    }



}