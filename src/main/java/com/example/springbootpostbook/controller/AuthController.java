package com.example.springbootpostbook.controller;

import com.example.springbootpostbook.dto.AuthResponse;
import com.example.springbootpostbook.dto.register.request.LoginRequest;
import com.example.springbootpostbook.dto.register.request.RegisterRequest;
import com.example.springbootpostbook.service.AuthService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {
    private final AuthService authService;

    @PostMapping("/register")
    public String register (@Valid @RequestBody RegisterRequest request) {
        authService.register(request);
        return "User registered successfully";
    }

    @PostMapping("/login")
    public AuthResponse login (@Valid @RequestBody LoginRequest request) {
        return authService.login(request);
    }
}
