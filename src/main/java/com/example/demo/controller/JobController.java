package com.example.demo.controller;

import com.example.demo.dto.JobRequest;
import com.example.demo.entity.Job;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/jobs")
public class JobController {
    private final AuthService service;

    @PreAuthorize("hasAnyRole('OWNER','COLLABORATOR')")
    @PostMapping
    public Job submit(@RequestBody JobRequest req) {
        Job j=new Job(); j.setId(req.jobId);
        return service.submit(j);
    }
}

