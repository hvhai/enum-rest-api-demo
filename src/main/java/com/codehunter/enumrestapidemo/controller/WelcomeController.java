package com.codehunter.enumrestapidemo.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api/welcome")
public class WelcomeController {
    @Value("${app.welcome.user}")
    private String username;

    @GetMapping
    public String sayHello() {
        return "Hello " + username;
    }

    @GetMapping(path = "/with-exception")
    public String welcomeWithException() {
        throw new RuntimeException("Unexpected exception");
    }
}
