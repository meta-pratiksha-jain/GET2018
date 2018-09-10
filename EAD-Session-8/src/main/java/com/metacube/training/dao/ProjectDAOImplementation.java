package com.metacube.training.dao;

import java.util.List;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import com.metacube.training.mappers.ProjectMapper;
import com.metacube.training.model.Project;

@Repository
public class ProjectDAOImplementation implements ProjectDAO {
    private JdbcTemplate jdbcTemplate;
    
    @Autowired
    public ProjectDAOImplementation(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }
    
    @Override
    public boolean createProject(Project project) {
        int insertedRows=jdbcTemplate.update(INSERT,project.getName(), project.getDescription(),project.getStartDate(),project.getEndDate());
        if(insertedRows==0)
        {
            return false;
        }
        return true;
    }

    @Override
    public Project getProjectById(int id) {
        Project project= jdbcTemplate.queryForObject(GET_PROJECT_BY_ID, new Object[] {id}, new ProjectMapper());
        return project;
    }

    @Override
    public List<Project> getAllProjects() {
        List<Project> listOfproject=jdbcTemplate.query(GET_ALL, new ProjectMapper());
        return listOfproject;
    }

    @Override
    public boolean updateProject(Project project) {
        int updatedRows=jdbcTemplate.update(UPDATE,project.getName(), project.getDescription(),project.getStartDate(),project.getEndDate(),project.getId());
        if(updatedRows==0)
        {
            return false;
        }
        return true;
    }

    @Override
    public boolean deleteProject(int id) {
        int updatedRows=jdbcTemplate.update(DELETE,id);
        if(updatedRows==0)
        {
            return false;
        }
        return true;
    }

}
