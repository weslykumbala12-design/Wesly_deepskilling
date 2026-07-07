package com.example.demo;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class UserControllerTest {

    @Test
    void testGetUser() {
        UserService mockUserService =
                Mockito.mock(UserService.class);

        User mockUser =
                new User(1L, "John");

        when(
            mockUserService.getUserById(1L)
        ).thenReturn(mockUser);

        UserController controller =
                new UserController(
                    mockUserService
                );

        ResponseEntity<User> response =
                controller.getUser(1L);

        assertEquals(
            200,
            response.getStatusCode().value()
        );

        assertEquals(
            "John",
            response.getBody().getName()
        );
    }
}