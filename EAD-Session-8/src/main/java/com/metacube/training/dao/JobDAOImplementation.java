package com.metacube.training.dao;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.metacube.training.model.Job;

@Repository
public class JobDAOImplementation implements JobDAO {
    JdbcTemplate jdbcTemplate;

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
