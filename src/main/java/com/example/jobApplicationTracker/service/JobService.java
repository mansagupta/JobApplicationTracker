package com.example.jobApplicationTracker.service;

import com.example.jobApplicationTracker.entity.JobListing;

import java.util.List;
import java.util.Optional;

public interface JobService {

    List<JobListing> getAllJobs();
    JobListing saveJob(JobListing job);
    Optional<JobListing> findById(Long id);
}
