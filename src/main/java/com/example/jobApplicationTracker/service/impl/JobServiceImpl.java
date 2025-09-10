package com.example.jobApplicationTracker.service.impl;

import com.example.jobApplicationTracker.entity.JobListing;
import com.example.jobApplicationTracker.repository.JobRepository;
import com.example.jobApplicationTracker.service.JobService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class JobServiceImpl implements JobService {

    @Autowired
    private JobRepository jobRepository;

    @Override
    public List<JobListing> getAllJobs() {
        return jobRepository.findAll();
    }

    @Override
    public JobListing saveJob(JobListing job) {
        return jobRepository.save(job);
    }

    @Override
    public Optional<JobListing> findById(Long id) {
        return jobRepository.findById(id);
    }
}

