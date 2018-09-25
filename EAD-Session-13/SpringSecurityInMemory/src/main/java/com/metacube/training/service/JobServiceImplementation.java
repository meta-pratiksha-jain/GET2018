package com.metacube.training.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.metacube.training.model.Job;
import com.metacube.training.repository.JobRepository;

@Service
public class JobServiceImplementation implements JobService {
    @Autowired
    JobRepository<Job> jobRepository;
    //JobDAO jobDAO;

    @Override
    @Transactional
    public boolean addJob(Job job) {
    	try{
			jobRepository.save(job);
		}catch(Exception e){
			return false;
		}
		return true;
    }

	@Override
	@Transactional
	public List<Job> getAllJobs() {
		return jobRepository.findAll();
	}

}
