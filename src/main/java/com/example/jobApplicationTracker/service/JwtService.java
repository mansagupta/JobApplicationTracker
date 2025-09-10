package com.example.jobApplicationTracker.service;

import com.example.jobApplicationTracker.entity.User;
import org.springframework.security.core.userdetails.UserDetails;

public interface JwtService {

    String generateToken(User user);

    String extractUsername(String token);

    Boolean validateToken(String token, UserDetails userDetails);
}
