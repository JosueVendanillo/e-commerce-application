package org.example.user_management.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@Document(collection = "users")  // Use @Entity if using SQL
public class User {
    @Id
    private Long id;
    private String username;
    private String password;
    private String email;
    private List<String> roles;
}

