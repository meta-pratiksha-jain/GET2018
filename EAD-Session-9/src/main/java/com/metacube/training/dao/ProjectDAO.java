package com.metacube.training.dao;

import java.util.List;
import com.metacube.training.model.Project;

public interface ProjectDAO {
    
    public static final String INSERT="INSERT INTO PROJECT(name,description,start_date,end_date) VALUES(?,?,?,?)";
    public static final String GET_PROJECT_BY_ID="SELECT id,name,description,start_date,end_date FROM PROJECT WHERE id=? AND is_enable=true";
    public static final String GET_ALL="SELECT id,name,description,start_date,end_date,project_logo FROM PROJECT";
    public static final String UPDATE="UPDATE PROJECT SET name=?,description=?,start_date=?,end_date=? WHERE id=?";
    public static final String DELETE="UPDATE PROJECT SET is_enable=FALSE WHERE id=?";
    
    boolean createProject(Project project);
    
    Project getProjectById(int id);

    List<Project> getAllProjects();
    
    boolean updateProject(Project project);

    boolean deleteProject(int id);
    
}

