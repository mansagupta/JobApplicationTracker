package com.example.jobApplicationTracker.repository;

import com.example.jobApplicationTracker.entity.ApplicationTracker;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ApplicationRepository extends JpaRepository<ApplicationTracker, Long> {
    List<ApplicationTracker> findByUserId(Long userId);
}
