package org.example.jobapp.service;

import org.example.jobapp.model.JobPost;
import org.example.jobapp.repository.JobRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobService {
    @Autowired
    private JobRepository jobRepository;

    // DTO: jobPost (transfer between Controller to Service to Repository)
    public void addJob(JobPost jobPost) {
        jobRepository.addJob(jobPost);
    }

    public List<JobPost> getJobPosts() {
        return jobRepository.getJobPosts();
    }
}
