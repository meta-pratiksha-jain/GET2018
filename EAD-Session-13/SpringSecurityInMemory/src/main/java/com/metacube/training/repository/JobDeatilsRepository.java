package com.metacube.training.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.metacube.training.model.JobDetails;

public interface JobDeatilsRepository extends JpaRepository<JobDetails, Integer> {
	
	public List<JobDetails> findJobDetailsByProjectNameContainingIgnoreCase(String projectName);

}
