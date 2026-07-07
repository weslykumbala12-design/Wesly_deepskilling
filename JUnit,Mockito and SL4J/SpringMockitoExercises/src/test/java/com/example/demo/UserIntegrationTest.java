package com.example.demo;

import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.when;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class UserIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UserService userService;

    @Test
    void testGetUserIntegration()
            throws Exception {

        User mockUser =
                new User(1L, "David");

        when(
            userService.getUserById(1L)
        ).thenReturn(mockUser);

        mockMvc.perform(
            get("/users/1")
        )
        .andExpect(
            status().isOk()
        )
        .andExpect(
            jsonPath("$.id").value(1)
        )
        .andExpect(
            jsonPath("$.name")
                .value("David")
        );
    }
}