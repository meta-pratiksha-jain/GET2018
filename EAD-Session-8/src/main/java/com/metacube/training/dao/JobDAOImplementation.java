package com.metacube.training.dao;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.metacube.training.model.Job;

@Repository
public class JobDAOImplementation implements JobDAO {
    JdbcTemplate jdbcTemplate;

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

}
