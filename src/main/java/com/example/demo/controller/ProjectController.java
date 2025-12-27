package com.example.demo.controller;

import com.example.demo.entity.Project;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/projects")
public class ProjectController {

    private final AuthService service;

    @PreAuthorize("hasRole('OWNER')")
    @PostMapping
    public Project create(@RequestBody Project p) { return service.create(p); }
}
