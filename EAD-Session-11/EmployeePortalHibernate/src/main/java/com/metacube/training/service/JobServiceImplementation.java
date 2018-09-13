package com.metacube.training.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.metacube.training.dao.JobDAO;
import com.metacube.training.model.Job;

@Service
public class JobServiceImplementation implements JobService {
    @Autowired
    JobDAO jobDAO;

    @Override
    public boolean addJob(Job job) {
        return jobDAO.addJob(job);
    }

	@Override
	public List<Job> getAllJobs() {
		return jobDAO.getAllJobs();
	}

}
