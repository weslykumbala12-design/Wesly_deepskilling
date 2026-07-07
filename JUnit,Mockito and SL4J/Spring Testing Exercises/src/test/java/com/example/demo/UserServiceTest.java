package com.example.demo;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class UserServiceTest {

    @Test
    void testGetUserById() {
        UserRepository mockRepository =
                mock(UserRepository.class);

        User user =
                new User(1L, "John");

        when(mockRepository.findById(1L))
                .thenReturn(Optional.of(user));

        UserService service =
                new UserService(mockRepository);

        User result =
                service.getUserById(1L);

        assertEquals("John", result.getName());
    }
}