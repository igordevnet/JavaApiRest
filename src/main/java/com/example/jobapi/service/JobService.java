package com.example.jobapi.service;

import java.util.List;
import java.util.Optional;

import com.example.jobapi.model.JobPost;
import com.example.jobapi.repository.JobRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@AllArgsConstructor
public class JobService {

    public JobRepository repo;

    public List<JobPost> getAllJobs() {
        return repo.findAll();
    }

    public Optional<JobPost> getJob(int postId) {
        return repo.findById(postId);
    }

    public void addJobPost(JobPost jobPost) throws Exception {
        var post = getJob(jobPost.getPostId());

        if(post.isPresent()) throw new Exception("This Post already exists");

        repo.save(jobPost);
    }

    public void updateJob(JobPost updatedJob) {
        repo.save(updatedJob);
    }

    public void deleteJob(int id) {
        repo.deleteById(id);
    }

    public void addJobs() {
        repo.save(new JobPost(1, "Java Developer", "Must have good experience in core Java and advanced Java", 2,
                List.of("Core Java", "J2EE", "Spring Boot", "Hibernate")));

        repo.save(
                new JobPost(2, "Frontend Developer", "Experience in building responsive web applications using React",
                        3, List.of("HTML", "CSS", "JavaScript", "React")));

        repo.save(new JobPost(3, "Data Scientist", "Strong background in machine learning and data analysis", 4,
                List.of("Python", "Machine Learning", "Data Analysis")));

        repo.save(new JobPost(4, "Network Engineer",
                "Design and implement computer networks for efficient data communication", 5,
                List.of("Networking", "Cisco", "Routing", "Switching")));

        repo.save(new JobPost(5, "Mobile App Developer", "Experience in mobile app development for iOS and Android",
                3, List.of("iOS Development", "Android Development", "Mobile App")));
    }

    public List<JobPost> search(String keyword) {

        return repo.findByPostProfileContainingOrPostDescContaining(keyword, keyword);
    }
}