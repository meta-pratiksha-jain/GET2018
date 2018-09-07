package com.metacube.training.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;
import com.metacube.training.model.Job;

public class JobMapper implements RowMapper<Job> {

    @Override
    public Job mapRow(ResultSet resultSet, int i) throws SQLException {
        Job job=new Job();
        job.setId(resultSet.getInt("id"));
        job.setTitle("title");
        return job;
    }

}
