package com.example.jobApplicationTracker.service;

public interface AiMatcherService {
    String getJobMatch(String resumeText, String jobDescription);
}
