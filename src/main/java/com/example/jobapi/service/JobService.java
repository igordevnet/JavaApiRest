package com.example.jobapi.service;

import java.util.List;

import com.example.jobapi.model.JobPost;
import com.example.jobapi.repository.JobRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
@AllArgsConstructor
public class JobService {

    public JobRepository repo;

    public List<JobPost> getAllJobs() {
        return repo.getAllJobs();
    }

    public JobPost getJob(int id) {
        return repo.getJobById(id);
    }

    public void addJobPost(JobPost jobPost) throws Exception {
        var post = getJob(jobPost.getPostId());

        if(post != null) throw new Exception("This Post alredy exists");

        repo.addJobPost(jobPost);
    }

    public void updateJob(JobPost updatedJob) {
        repo.updateJob(updatedJob);
    }

    public void deleteJob(int id) {
        repo.deleteJob(id);
    }
}