package com.metacube.training.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.metacube.training.dao.ProjectDAO;
import com.metacube.training.model.Project;

@Service
public class ProjectServiceImplementation implements ProjectService{
    
    @Autowired
    ProjectDAO projectDAO;

    @Override
    public boolean createProject(Project project) {
    	System.out.println("dfgjkndkfnglk");
        return projectDAO.createProject(project);
    }

    @Override
    public Project getProjectById(int id) {
        return projectDAO.getProjectById(id);
    }

    @Override
    public List<Project> getAllProjects() {
        return projectDAO.getAllProjects();
    }

    @Override
    public boolean updateProject(Project project) {
        return projectDAO.updateProject(project);
    }

    @Override
    public boolean deleteProject(int id) {
        return projectDAO.deleteProject(id);
    }

}
