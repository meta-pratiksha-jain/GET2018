package com.metacube.training.dao;

import java.util.List;

import com.metacube.training.model.Job;

public interface JobDAO {
    
    public List<Job> getAllJobs();
    
    public boolean addJob(Job job);
    
}
