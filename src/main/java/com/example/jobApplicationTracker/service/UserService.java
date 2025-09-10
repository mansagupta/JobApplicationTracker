package com.example.jobApplicationTracker.service;

import com.example.jobApplicationTracker.dto.LoginRequest;
import com.example.jobApplicationTracker.dto.LoginResponse;
import com.example.jobApplicationTracker.dto.RegisterUserRequest;

public interface UserService {

    Boolean registerUser(RegisterUserRequest request);

    LoginResponse login(LoginRequest request);
}
