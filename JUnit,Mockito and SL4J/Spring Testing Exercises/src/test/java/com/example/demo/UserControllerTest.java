package com.example.demo;

import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

public class UserControllerTest {

    @Test
    void testGetUser() throws Exception {
        UserService mockService =
                mock(UserService.class);

        User user =
                new User(1L, "John");

        when(mockService.getUserByIdOrThrow(1L))
                .thenReturn(user);

        UserController controller =
                new UserController(mockService);

        MockMvc mockMvc =
                MockMvcBuilders
                        .standaloneSetup(controller)
                        .build();

        mockMvc.perform(
                get("/users/1")
        )
        .andExpect(status().isOk())
        .andExpect(
                jsonPath("$.id").value(1)
        )
        .andExpect(
                jsonPath("$.name").value("John")
        );
    }
}