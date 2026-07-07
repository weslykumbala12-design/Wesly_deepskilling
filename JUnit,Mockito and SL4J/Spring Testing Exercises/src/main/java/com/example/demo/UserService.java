package com.example.demo;

import java.util.NoSuchElementException;

import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(
            UserRepository userRepository
    ) {
        this.userRepository = userRepository;
    }

    public User getUserById(Long id) {
        return userRepository
                .findById(id)
                .orElse(null);
    }

    public User getUserByIdOrThrow(Long id) {
        return userRepository
                .findById(id)
                .orElseThrow(
                    () -> new NoSuchElementException(
                        "User not found"
                    )
                );
    }

    public User saveUser(User user) {
        return userRepository.save(user);
    }
}