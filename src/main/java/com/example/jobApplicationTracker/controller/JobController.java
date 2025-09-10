package com.example.jobApplicationTracker.controller;

import com.example.jobApplicationTracker.entity.JobListing;
import com.example.jobApplicationTracker.service.AiMatcherService;
import com.example.jobApplicationTracker.service.JobService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/jobs")
@RequiredArgsConstructor
public class JobController {

    private final JobService jobService;
    private final AiMatcherService aiMatcherService;

    @GetMapping
    public List<JobListing> getAllJobs() {
        return jobService.getAllJobs();
    }

    @PostMapping("/ai-match")
    public ResponseEntity<String> matchJob(@RequestBody Map<String, String> request) {
        String resume = request.get("resume");
        String jobDesc = request.get("jobDescription");
        String aiResult = aiMatcherService.getJobMatch(resume, jobDesc);
        return ResponseEntity.ok(aiResult);
    }
}

