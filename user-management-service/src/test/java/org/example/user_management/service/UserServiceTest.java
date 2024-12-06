package org.example.user_management.service;

import org.example.user_management.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.mockito.Mockito.*;

class UserServiceTest {

    private final UserRepository userRepository = mock(UserRepository.class);
    private final UserService userService = new UserService(userRepository);

    @Test
    void testDeleteUserSuccess() {
        String userId = "12345";
        when(userRepository.existsById(userId)).thenReturn(true);

        userService.deleteUser(userId);

        verify(userRepository, times(1)).deleteById(userId);
    }

    @Test
    void testDeleteUserNotFound() {
        String userId = "67890";
        when(userRepository.existsById(userId)).thenReturn(false);

        try {
            userService.deleteUser(userId);
        } catch (IllegalArgumentException e) {
            assert e.getMessage().equals("User with ID " + userId + " does not exist.");
        }

        verify(userRepository, never()).deleteById(userId);
    }
}
