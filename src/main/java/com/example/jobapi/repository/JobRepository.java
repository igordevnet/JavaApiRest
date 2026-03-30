package com.example.jobapi.repository;

import java.util.ArrayList;
import java.util.List;

import com.example.jobapi.model.JobPost;
import org.springframework.stereotype.Repository;

@Repository
public class JobRepository {

    List<JobPost> jobs = new ArrayList<>();

    public JobRepository() {
        jobs.add(new JobPost(1, "Java Developer", "Must have good experience in core Java and advanced Java", 2,
                List.of("Core Java", "J2EE", "Spring Boot", "Hibernate")));

        jobs.add(
                new JobPost(2, "Frontend Developer", "Experience in building responsive web applications using React",
                        3, List.of("HTML", "CSS", "JavaScript", "React")));

        jobs.add(new JobPost(3, "Data Scientist", "Strong background in machine learning and data analysis", 4,
                List.of("Python", "Machine Learning", "Data Analysis")));

        jobs.add(new JobPost(4, "Network Engineer",
                "Design and implement computer networks for efficient data communication", 5,
                List.of("Networking", "Cisco", "Routing", "Switching")));

        jobs.add(new JobPost(5, "Mobile App Developer", "Experience in mobile app development for iOS and Android",
                        3, List.of("iOS Development", "Android Development", "Mobile App")));
    }

    public List<JobPost> getAllJobs() {
        return jobs;
    }

    public void addJobPost(JobPost job) {
        jobs.add(job);
    }

    public JobPost getJobById(int id) {
        for(JobPost job : jobs){
            if(job.getPostId() == id){
                return job;
            }
        }

        return null;
    }

    public void updateJob(JobPost updatedJob) {
        for(JobPost job : jobs) {
            if (job.getPostId() == updatedJob.getPostId()) {
                if (updatedJob.getPostDesc() != null) {
                    job.setPostDesc(updatedJob.getPostDesc());
                }
                if (updatedJob.getPostProfile() != null) {
                    job.setPostProfile(updatedJob.getPostProfile());
                }
                if (updatedJob.getPostTechStack() != null) {
                    job.setPostTechStack(updatedJob.getPostTechStack());
                }
                if (updatedJob.getReqExperience() != null) {
                    job.setReqExperience(updatedJob.getReqExperience());
                }

                return;
            }
        }
    }

    public void deleteJob(int id) {
        JobPost job = getJobById(id);

        if (job != null) {
            jobs.remove(job);
        }
    }
}
