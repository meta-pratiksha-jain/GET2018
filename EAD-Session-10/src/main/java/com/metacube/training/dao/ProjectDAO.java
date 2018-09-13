package com.metacube.training.dao;

import java.util.List;
import com.metacube.training.model.Project;

public interface ProjectDAO {
    
    
    
    boolean createProject(Project project);
    
    Project getProjectById(int id);

    List<Project> getAllProjects();
    
    boolean updateProject(Project project);

    boolean deleteProject(int id);
    
}

