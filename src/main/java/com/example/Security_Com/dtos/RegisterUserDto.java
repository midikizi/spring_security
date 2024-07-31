package com.example.Security_Com.dtos;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

// @Getter @Setter
// @AllArgsConstructor
public record RegisterUserDto (
    String username,
    String password,
    String email
    // getters and setters here...
){}
