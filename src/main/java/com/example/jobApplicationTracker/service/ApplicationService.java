package com.example.jobApplicationTracker.service;

import com.example.jobApplicationTracker.entity.ApplicationTracker;

import java.util.List;

public interface ApplicationService {

    ApplicationTracker applyForJob(Long userId, Long jobId);
    List<ApplicationTracker> getUserApplications(Long userId);
    ApplicationTracker updateStatus(Long applicationId, String status);
}
