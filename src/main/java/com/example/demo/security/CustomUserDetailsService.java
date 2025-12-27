package com.example.demo.security;

import com.example.demo.repo.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {
    private final UserRepository repo;

    public CustomUserDetailsService(UserRepository repo) { this.repo = repo; }

    public UserDetails loadUserByUsername(String email) {
        return new CustomUserDetails(
                repo.findByEmail(email).orElseThrow()
        );
    }
}

