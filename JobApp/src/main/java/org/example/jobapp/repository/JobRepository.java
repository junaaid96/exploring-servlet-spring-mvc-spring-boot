package org.example.jobapp.repository;

import org.example.jobapp.model.JobPost;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Repository
public class JobRepository {
    List<JobPost> jobPosts = new ArrayList<>(Arrays.asList(
            new JobPost(1, "Java", "Java Developer", 2, Arrays.asList("Java", "Spring", "Hibernate")),
            new JobPost(2, "Python", "Python Developer", 2, Arrays.asList("Python", "Django", "Flask")),
            new JobPost(3, "JavaScript", "JavaScript Developer", 2, Arrays.asList("JavaScript", "React", "Angular"))));


    public List<JobPost> getJobPosts() {
        return jobPosts;
    }

    // DTO: jobPost (transfer between Controller to Service to Repository)
    public void addJob(JobPost jobPost) {
        jobPosts.add(jobPost);
    }
}
