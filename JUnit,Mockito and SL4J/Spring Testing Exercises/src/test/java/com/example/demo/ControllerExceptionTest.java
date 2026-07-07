package com.example.demo;

import java.util.NoSuchElementException;

import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

public class ControllerExceptionTest {

    @Test
    void testUserNotFound() throws Exception {
        UserService mockService =
                mock(UserService.class);

        when(mockService.getUserByIdOrThrow(99L))
                .thenThrow(
                    new NoSuchElementException()
                );

        UserController controller =
                new UserController(mockService);

        MockMvc mockMvc =
                MockMvcBuilders
                        .standaloneSetup(controller)
                        .setControllerAdvice(
                            new GlobalExceptionHandler()
                        )
                        .build();

        mockMvc.perform(
                get("/users/99")
        )
        .andExpect(
                status().isNotFound()
        )
        .andExpect(
                content().string(
                    "User not found"
                )
        );
    }
}