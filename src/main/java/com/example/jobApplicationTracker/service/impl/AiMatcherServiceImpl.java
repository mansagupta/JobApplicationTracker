package com.example.jobApplicationTracker.service.impl;

import com.example.jobApplicationTracker.service.AiMatcherService;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@Service
public class AiMatcherServiceImpl implements AiMatcherService {

    private final RestTemplate restTemplate = new RestTemplate();
    private final String N8N_WEBHOOK_URL = "http://localhost:5678/webhook/job-matcher";

    public String getJobMatch(String resumeText, String jobDescription) {
        Map<String, String> payload = new HashMap<>();
        payload.put("resume", resumeText);
        payload.put("jobDescription", jobDescription);

        HttpEntity<Map<String, String>> request = new HttpEntity<>(payload);
        ResponseEntity<String> response = restTemplate.postForEntity(N8N_WEBHOOK_URL, request, String.class);

        return response.getBody();
    }
}
