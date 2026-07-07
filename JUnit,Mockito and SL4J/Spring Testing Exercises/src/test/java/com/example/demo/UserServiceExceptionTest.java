package com.example.demo;

import java.util.NoSuchElementException;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class UserServiceExceptionTest {

    @Test
    void testMissingUser() {
        UserRepository mockRepository =
                mock(UserRepository.class);

        when(mockRepository.findById(99L))
                .thenReturn(Optional.empty());

        UserService service =
                new UserService(mockRepository);

        assertThrows(
                NoSuchElementException.class,
                () -> service
                        .getUserByIdOrThrow(99L)
        );
    }
}