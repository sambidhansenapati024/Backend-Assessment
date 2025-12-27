package com.example.demo.service;

import com.example.demo.entity.Job;
import com.example.demo.repo.JobRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class JobService {
    private static final int MAX=3;
    private final JobRepository repo;

    public Job submit(Job j){
        if(repo.existsById(j.getId())) return repo.findById(j.getId()).get();
        j.setStatus("PENDING"); repo.save(j); process(j.getId()); return j;
    }

    @Async
    public void process(String id){
        Job j=repo.findById(id).orElseThrow();
        try{
            j.setStatus("RUNNING"); Thread.sleep(2000);
            j.setStatus("COMPLETED"); j.setResult("SUCCESS");
        }catch(Exception e){
            j.setRetryCount(j.getRetryCount()+1);
            if(j.getRetryCount()<MAX) process(id);
            else j.setStatus("FAILED");
        }
        repo.save(j);
    }
}

