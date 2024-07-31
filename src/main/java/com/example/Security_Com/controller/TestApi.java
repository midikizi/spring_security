package com.example.Security_Com.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestApi {
    @GetMapping("/api/test")
    public String testApi() {
        return "Hello World";
    }
}
