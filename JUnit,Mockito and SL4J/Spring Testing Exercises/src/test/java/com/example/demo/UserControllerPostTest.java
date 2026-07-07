package com.example.demo;

import org.junit.jupiter.api.Test;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

public class UserControllerPostTest {

    @Test
    void testCreateUser() throws Exception {
        UserService mockService =
                mock(UserService.class);

        User savedUser =
                new User(1L, "John");

        when(mockService.saveUser(any(User.class)))
                .thenReturn(savedUser);

        UserController controller =
                new UserController(mockService);

        MockMvc mockMvc =
                MockMvcBuilders
                        .standaloneSetup(controller)
                        .build();

        mockMvc.perform(
                post("/users")
                    .contentType(
                        MediaType.APPLICATION_JSON
                    )
                    .content(
                        "{\"name\":\"John\"}"
                    )
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