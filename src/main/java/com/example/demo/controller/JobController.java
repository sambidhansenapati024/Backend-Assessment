package com.example.demo.controller;

import com.example.demo.dto.JobRequest;
import com.example.demo.entity.Job;
import com.example.demo.service.JobService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/jobs")
public class JobController {

    private final JobService jobService;

    public JobController(JobService jobService) {
        this.jobService = jobService;
    }

    @PreAuthorize("hasAnyRole('OWNER','COLLABORATOR')")
    @PostMapping
    public Job submit(@RequestBody JobRequest request) {
        Job job = new Job();
        job.setId(request.jobId);
        return jobService.submit(job);
    }
}
