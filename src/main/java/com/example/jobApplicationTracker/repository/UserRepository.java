package com.example.jobApplicationTracker.repository;

import com.example.jobApplicationTracker.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByEmail(String username);
}
