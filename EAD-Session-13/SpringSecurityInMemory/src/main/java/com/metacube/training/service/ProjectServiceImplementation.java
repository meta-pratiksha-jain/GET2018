package com.metacube.training.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.metacube.training.model.Project;
import com.metacube.training.repository.ProjectRepository;

@Service
public class ProjectServiceImplementation implements ProjectService{
    
    @Autowired
    private ProjectRepository<Project> projectRepository;
    //ProjectDAO projectDAO;

    @Override
    @Transactional
    public boolean createProject(Project project) {
    	try{
			projectRepository.save(project);
			
		}catch(Exception e){
			return false;
		}
		return true;
    }

    @Override
    @Transactional
    public Project getProjectById(int id) {
        return projectRepository.findOne(id);
    }

    @Override
    @Transactional
    public List<Project> getAllProjects() {
    	List<Project> projectList=(List<Project>) projectRepository.findAll();
    	return projectList;
    }

    @Override
    @Transactional
    public boolean updateProject(Project project) {
    	try{
			projectRepository.save(project);
			
		}catch(Exception e){
			return false;
		}
		return true;
    }

    @Override
    @Transactional
    public boolean deleteProject(int id) {
        return projectRepository.deleteProject(id)>0;
    }

}
