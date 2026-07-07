package com.example.demo;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import static org.mockito.Mockito.when;

public class UserServiceTest {

    @Test
    void testGetUserById() {
        UserRepository mockRepository =
                Mockito.mock(
                    UserRepository.class
                );

        User mockUser =
                new User(1L, "Alice");

        when(
            mockRepository.findById(1L)
        ).thenReturn(
            Optional.of(mockUser)
        );

        UserService userService =
                new UserService(
                    mockRepository
                );

        User result =
                userService.getUserById(1L);

        assertEquals(
            1L,
            result.getId()
        );

        assertEquals(
            "Alice",
            result.getName()
        );
    }
}