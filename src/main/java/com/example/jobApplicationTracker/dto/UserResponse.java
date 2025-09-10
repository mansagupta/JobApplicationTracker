package com.example.jobApplicationTracker.dto;

import lombok.Data;

@Data
public class UserResponse {
    private String email;
    private String password;
    private String fullName;
}
