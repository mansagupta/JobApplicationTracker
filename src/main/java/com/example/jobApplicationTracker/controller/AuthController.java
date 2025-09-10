package com.example.jobApplicationTracker.controller;

import com.example.jobApplicationTracker.dto.LoginRequest;
import com.example.jobApplicationTracker.dto.LoginResponse;
import com.example.jobApplicationTracker.dto.RegisterUserRequest;
import com.example.jobApplicationTracker.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final UserService userService;

    @PostMapping("/register")
    public ResponseEntity<Boolean> register(@RequestBody RegisterUserRequest request) {
        return ResponseEntity.ok(userService.registerUser(request));
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest request) {
        LoginResponse response = userService.login(request);
        if(ObjectUtils.isEmpty(response)) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Invalid Credentials!");
        }
        return ResponseEntity.ok(response);
    }
}
