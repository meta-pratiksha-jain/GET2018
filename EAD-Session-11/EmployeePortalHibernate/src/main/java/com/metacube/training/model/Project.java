package com.metacube.training.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Project")
public class Project {
	
	@Override
	public String toString()
	{
		return "Project [id=" + id + ", name=" + name + ", description=" + description + ", startDate=" + startDate + ", endDate=" + endDate + "]";
	}
	
	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;
	
	@Column(name="name")
    private String name;
	
	@Column(name="description")
    private String description;
	
	@Column(name="start_date")
    private Date startDate;
	
	@Column(name="end_date")
    private Date endDate;
	
	@Column(name="project_logo")
    private String projectLogo;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public String getProjectLogo() {
        return projectLogo;
    }

    public void setProjectLogo(String projectLogo) {
        this.projectLogo = projectLogo;
    }
    
    

}

