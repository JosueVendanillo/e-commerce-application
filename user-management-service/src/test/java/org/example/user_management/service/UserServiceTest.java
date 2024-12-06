package org.example.user_management.service;

import org.example.user_management.model.User;
import org.example.user_management.repository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.List;

import static org.mockito.Mockito.*;

class UserServiceTest {
    @BeforeEach
    void setUp() {

    }

    private final UserRepository userRepository = mock(UserRepository.class);
    private final UserService userService = new UserService(userRepository);

    @Test
    void testDeleteUserSuccess() {
        String userId = "12345";
        when(userRepository.existsById(userId)).thenReturn(true);

        userService.deleteUserById(userId);

        verify(userRepository, times(1)).deleteById(userId);
    }

    @Test
    void testDeleteUserNotFound() {
        String userId = "67890";
        when(userRepository.existsById(userId)).thenReturn(false);

        try {
            userService.deleteUserById(userId);
        } catch (IllegalArgumentException e) {
            assert e.getMessage().equals("User with ID " + userId + " does not exist.");
        }

        verify(userRepository, never()).deleteById(userId);
    }


    @Test
    public void testUpdateUser() {
//        String id = "cc8e610c-38ab-40cc-b72b-ad3cf3f0e613";
//        User existingUser = new User("johnny123", "securepassword123", "johnnyB@example.com", List.of("USER"));
//        User updatedUser = new User("johnny_updated", "newsecurepassword123", "johnny_updated@example.com", List.of("ADMIN", "USER"));
//
//        when(userRepository.findById(id)).thenReturn(Optional.of(existingUser));
//        when(userRepository.save(any(User.class))).thenReturn(updatedUser);
//
//        User result = userService.updateUser(id, updatedUser);
//
//        assertEquals("johnny_updated", result.getUsername());
//        assertEquals("newsecurepassword123", result.getPassword());
//        assertEquals("johnny_updated@example.com", result.getEmail());
//        assertTrue(result.getRoles().contains("ADMIN"));
    }

}
