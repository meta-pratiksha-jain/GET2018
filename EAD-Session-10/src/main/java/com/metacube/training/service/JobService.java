package com.metacube.training.service;

import java.util.List;

import com.metacube.training.model.Job;

public interface JobService {
    public boolean addJob(Job job);
    
    public List<Job> getAllJobs();

}
