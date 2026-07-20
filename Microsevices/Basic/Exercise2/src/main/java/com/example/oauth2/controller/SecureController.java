package com.example.oauth2.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SecureController {

    @GetMapping("/")
    public String home() {
        return "Welcome to OAuth2 Resource Server";
    }

    @GetMapping("/public")
    public String publicEndpoint() {
        return "This is a public endpoint";
    }

    @GetMapping("/secure")
    public String secureEndpoint() {
        return "This is a secure endpoint";
    }

}