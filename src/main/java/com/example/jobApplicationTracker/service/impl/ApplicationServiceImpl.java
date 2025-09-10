package com.example.jobApplicationTracker.service.impl;

import com.example.jobApplicationTracker.entity.ApplicationTracker;
import com.example.jobApplicationTracker.entity.JobListing;
import com.example.jobApplicationTracker.entity.User;
import com.example.jobApplicationTracker.repository.ApplicationRepository;
import com.example.jobApplicationTracker.repository.JobRepository;
import com.example.jobApplicationTracker.repository.UserRepository;
import com.example.jobApplicationTracker.service.ApplicationService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ApplicationServiceImpl implements ApplicationService {

    @Autowired
    private ApplicationRepository applicationRepository;

    @Autowired
    private JobRepository jobRepository;

    @Autowired
    private UserRepository userRepository;

    @Override
    public ApplicationTracker applyForJob(Long userId, Long jobId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));
        JobListing job = jobRepository.findById(jobId)
                .orElseThrow(() -> new RuntimeException("Job not found"));

        ApplicationTracker application = new ApplicationTracker();
        application.setUser(user);
        application.setJob(job);
        application.setStatus("APPLIED");
        application.setAppliedDate(LocalDate.now());

        return applicationRepository.save(application);
    }

    @Override
    public List<ApplicationTracker> getUserApplications(Long userId) {
        return applicationRepository.findByUserId(userId);
    }

    @Override
    public ApplicationTracker updateStatus(Long applicationId, String status) {
        ApplicationTracker app = applicationRepository.findById(applicationId)
                .orElseThrow(() -> new RuntimeException("Application not found"));
        app.setStatus(status);
        return applicationRepository.save(app);
    }
}

