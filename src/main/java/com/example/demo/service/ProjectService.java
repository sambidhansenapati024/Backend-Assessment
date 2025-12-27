package com.example.demo.service;

import com.example.demo.entity.Project;
import com.example.demo.repo.ProjectRepository;
import com.example.demo.repo.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProjectService {
    private final ProjectRepository repo;
    public Project create(Project p){ return repo.save(p); }
}
