package com.example.jobApplicationTracker.controller;

import com.example.jobApplicationTracker.entity.ApplicationTracker;
import com.example.jobApplicationTracker.service.ApplicationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/applications")
@RequiredArgsConstructor
public class ApplicationController {

    private final ApplicationService applicationService;

    @PostMapping("/apply/{userId}/{jobId}")
    public ResponseEntity<ApplicationTracker> applyForJob(@PathVariable Long userId, @PathVariable Long jobId) {
        return ResponseEntity.ok(applicationService.applyForJob(userId, jobId));
    }

    @GetMapping("/{userId}")
    public ResponseEntity<List<ApplicationTracker>> getUserApplications(@PathVariable Long userId) {
        return ResponseEntity.ok(applicationService.getUserApplications(userId));
    }

    @PutMapping("/{applicationId}/status")
    public ResponseEntity<ApplicationTracker> updateStatus(@PathVariable Long applicationId,
                                                           @RequestParam String status) {
        return ResponseEntity.ok(applicationService.updateStatus(applicationId, status));
    }
}

