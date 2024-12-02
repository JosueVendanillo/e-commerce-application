package org.example.common.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDto implements Serializable {

    private String id;         // Unique identifier for the user
    private String firstName;  // User's first name
    private String lastName;   // User's last name
    private String email;      // User's email address
    private String role;       // User's role (e.g., ADMIN, USER)
    private boolean isActive;  // Status indicating if the user is active


}
