package com.metacube.training.dao;

import com.metacube.training.model.Job;

public interface JobDAO {
    
    public String INSERT="INSERT INTO Job(title) VALUES(?)";
    
    public boolean addJob(Job job);
    
}
