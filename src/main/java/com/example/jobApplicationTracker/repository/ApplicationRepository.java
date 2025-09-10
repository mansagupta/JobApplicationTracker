package com.example.jobApplicationTracker.repository;

import com.example.jobApplicationTracker.entity.ApplicationTracker;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ApplicationRepository extends JpaRepository<ApplicationTracker, Long> {
}
