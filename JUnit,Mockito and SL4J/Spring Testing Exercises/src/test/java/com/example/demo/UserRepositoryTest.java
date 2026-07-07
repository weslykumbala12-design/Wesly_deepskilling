package com.example.demo;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
public class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    void testFindByName() {
        userRepository.save(
                new User(null, "David")
        );

        userRepository.save(
                new User(null, "David")
        );

        List<User> users =
                userRepository.findByName(
                        "David"
                );

        assertEquals(2, users.size());
    }
}