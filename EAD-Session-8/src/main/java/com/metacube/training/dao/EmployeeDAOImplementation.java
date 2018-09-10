package com.metacube.training.dao;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.metacube.training.model.Employee;

@Repository
public class EmployeeDAOImplementation implements EmployeeDAO{

	JdbcTemplate jdbcTemplate;
	
	@Autowired
    public EmployeeDAOImplementation(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }
	
	@Override
	public boolean addEmployee(Employee employee) {
		int insertedRows=jdbcTemplate.update(INSERT,employee.getFirstName(),employee.getMiddleName(),employee.getLastName(),employee.getEmail(),employee.getDateOfBirth(),employee.getDateOfJoining(),employee.getGender());
        if(insertedRows==0)
        {
            return false;
        }
        return true;
    }

}
