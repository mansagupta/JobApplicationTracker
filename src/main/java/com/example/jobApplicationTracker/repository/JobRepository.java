package com.example.jobApplicationTracker.repository;

import com.example.jobApplicationTracker.entity.JobListing;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JobRepository extends JpaRepository<JobListing, Long> {
}
