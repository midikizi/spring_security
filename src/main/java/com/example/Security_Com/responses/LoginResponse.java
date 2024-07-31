package com.example.Security_Com.responses;

import lombok.Builder;
import lombok.Getter;

@Builder
public class LoginResponse {
    @Getter
    private String token;

    private long expiresIn;
}
