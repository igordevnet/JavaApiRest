package com.example.jobapi.controller;

import com.example.jobapi.model.JobPost;
import com.example.jobapi.service.JobService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/job")
@AllArgsConstructor
public class JobController {

    private JobService service;

    @GetMapping()
    @RequestMapping("/all")
    public List<JobPost> getAllJobs(){
        return service.getAllJobs();
    }

    @GetMapping()
    @RequestMapping("/one/{id}")
    public Optional<JobPost> getJob(
            @PathVariable("id") int id
    ){
        return service.getJob(id);
    }

    @PostMapping
    @RequestMapping("new")
    public void saveJob(
            @RequestBody JobPost newJob
    ) throws Exception {
        service.addJobPost(newJob);
    }

    @GetMapping
    @RequestMapping("search")
    public List<JobPost> searchByKeyword(
            @RequestParam("keyword") String keyword
    ) {
        return service.search(keyword);
    }

    @PatchMapping
    @RequestMapping("update")
    public void updateJob(
            @RequestBody JobPost updatedJob
    ) {
        service.updateJob(updatedJob);
    }

    @DeleteMapping
    @RequestMapping("delete")
    public void deleteJob(
            @RequestParam("id") int id
    ) {
        service.deleteJob(id);
    }
}
