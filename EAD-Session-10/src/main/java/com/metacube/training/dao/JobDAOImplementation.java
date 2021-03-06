package com.metacube.training.dao;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.metacube.training.mappers.JobMapper;
import com.metacube.training.mappers.ProjectMapper;
import com.metacube.training.model.Job;
import com.metacube.training.model.Project;

@Repository
public class JobDAOImplementation implements JobDAO {
    JdbcTemplate jdbcTemplate;
    public static final String INSERT="INSERT INTO Job(title) VALUES(?)";
    
    public static final String GET_ALL="SELECT * FROM Job";

    @Autowired
    public JobDAOImplementation(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }
    
    @Override
    public boolean addJob(Job job) {
        int insertedRows=jdbcTemplate.update(INSERT,job.getTitle());
        if(insertedRows==0)
        {
            return false;
        }
        return true;
    }

	@Override
	public List<Job> getAllJobs() {
		List<Job> listOfJob=jdbcTemplate.query(GET_ALL, new JobMapper());
        return listOfJob;
	}

}
