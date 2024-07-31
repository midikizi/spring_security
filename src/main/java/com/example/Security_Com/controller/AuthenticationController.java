package com.example.Security_Com.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Security_Com.dtos.LoginUserDto;
import com.example.Security_Com.dtos.RegisterUserDto;
import com.example.Security_Com.models.User;
import com.example.Security_Com.repository.UserRepository;
import com.example.Security_Com.responses.LoginResponse;
import com.example.Security_Com.service.AuthenticationService;
import com.example.Security_Com.service.JwtService;

@RestController
@RequestMapping("/auth")
public class AuthenticationController {
    private final JwtService jwtService;

    private final AuthenticationService authenticationService;

    public AuthenticationController(JwtService jwtService, AuthenticationService authenticationService, 
    UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.jwtService = jwtService;
        this.authenticationService = authenticationService;
    }


    @PostMapping("/register")
    public ResponseEntity<User> register(@RequestBody RegisterUserDto input) {
        User registeruser = authenticationService.signup(input);
        return ResponseEntity.ok(registeruser);
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(@RequestBody LoginUserDto input) {
        User authenticateuser = authenticationService.authenticate(input);
        String token = jwtService.generateToken(authenticateuser);
        LoginResponse loginResponse = LoginResponse.builder()
                .token(token)
                .expiresIn(jwtService.getExpirationTime())
                .build();
        return ResponseEntity.ok(loginResponse);
    }

}