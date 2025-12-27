package com.example.demo.service;

import com.example.demo.config.JwtUtil;
import com.example.demo.dto.LoginRequest;
import com.example.demo.dto.LoginResponse;
import com.example.demo.entity.User;
import com.example.demo.repo.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {
    private final JwtUtil jwtUtil;
    private final UserRepository repo;

    public LoginResponse login(LoginRequest req) {
        User u=repo.findByEmail(req.email).orElseThrow();
        LoginResponse r=new LoginResponse();
        r.accessToken=jwtUtil.generateToken(u.getEmail());
        r.refreshToken=r.accessToken;
        return r;
    }
}

