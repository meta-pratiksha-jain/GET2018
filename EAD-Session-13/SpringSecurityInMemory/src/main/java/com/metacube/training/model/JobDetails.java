package com.metacube.training.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="JobDetails")
public class JobDetails {
	
	@Id
	@Column(name="job_detail_id")
	private int jobDetailId;
	
	@Column(name="employee_id")
	private int employeeId;
	
	@Column(name="date_of_joining")
	private Date dateOfJoining;
	
	@Column(name="experience")
	private int experience;
	
	@Column(name="project_name")
	private String projectName;
	
	@Column(name="job_title")
	private String jobTitle;
	
	public int getJobDetailId() {
		return jobDetailId;
	}

	public void setJobDetailId(int jobDetailId) {
		this.jobDetailId = jobDetailId;
	}

	public int getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

	public Date getDateOfJoining() {
		return dateOfJoining;
	}

	public void setDateOfJoining(Date dateOfJoining) {
		this.dateOfJoining = dateOfJoining;
	}

	public int getExperience() {
		return experience;
	}

	public void setExperience(int experience) {
		this.experience = experience;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public String getJobTitle() {
		return jobTitle;
	}

	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}

}
