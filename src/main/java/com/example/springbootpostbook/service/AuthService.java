package com.example.springbootpostbook.service;

import com.example.springbootpostbook.dto.AuthResponse;
import com.example.springbootpostbook.dto.register.request.LoginRequest;
import com.example.springbootpostbook.dto.register.request.RegisterRequest;
import com.example.springbootpostbook.entity.User;
import com.example.springbootpostbook.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class AuthService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public void register (RegisterRequest request) {
        boolean exist = userRepository.findByUsername(request.getUsername())
                .isPresent();

        if (exist) {
            throw new RuntimeException("Username already exist");
        }

        User user = User.builder()
                .username(request.getUsername())
                .password(passwordEncoder.encode(request.getPassword()))
                .build();

        userRepository.save(user);
    }

    public AuthResponse login (LoginRequest request) {
        User user = userRepository.findByUsername(request.getUsername())
                .orElseThrow(() -> new RuntimeException("Invalid username or passwword"));

        boolean matches = passwordEncoder.matches(
                request.getPassword(),
                user.getPassword()
        );

        if (!matches) {
            throw new RuntimeException("Invalid password");
        }

        String token = UUID.randomUUID().toString();

        user.setToken(token);

        userRepository.save(user);

        return AuthResponse.builder()
                .token(token)
                .build();
    }
}
