package org.example.jobapp.controller;

import org.example.jobapp.model.JobPost;
import org.example.jobapp.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class HomeController {
    @Autowired
    private JobService jobService;

    @GetMapping({"/", "/home"})
    public String home() {
        return "home";
    }

    @GetMapping("/addjob")
    public String addJob() {
        return "addjob";
    }

    @GetMapping("/viewalljobs")
    public String viewAllJobs(Model model) {
        List<JobPost> jobPosts = jobService.getJobPosts();
        model.addAttribute("jobPosts", jobPosts);
        return "viewalljobs";
    }

    @PostMapping("handleForm")
    // DTO: jobPost (transfer between Controller to Service to Repository)
    public String handleForm(JobPost jobPost) {
        jobService.addJob(jobPost);
        return "success";
    }
}
