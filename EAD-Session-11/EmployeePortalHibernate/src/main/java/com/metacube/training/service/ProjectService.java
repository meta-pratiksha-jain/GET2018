package com.metacube.training.service;

import java.util.List;

import com.metacube.training.model.Project;

public interface ProjectService {
    
    boolean createProject(Project project);
    
    Project getProjectById(int id);

    List<Project> getAllProjects();
    
    boolean updateProject(Project project);

    boolean deleteProject(int id);

}
