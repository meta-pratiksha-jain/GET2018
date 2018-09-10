package com.metacube.training.dao;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.metacube.training.mappers.EmployeeMapper;
import com.metacube.training.model.Employee;

@Repository
public class EmployeeDAOImplementation implements EmployeeDAO{
    
    public static final String CHECK_EMPLOYEE_LOGIN="SELECT * FROM Employee WHERE email=? AND password=?"; 

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

    @Override
    public Employee login(String email, String password) {
        Employee employee=jdbcTemplate.queryForObject(CHECK_EMPLOYEE_LOGIN, new Object[]{email,password},new EmployeeMapper());
        if(employee.getId()==0)
        {
            return null;
        }
        else 
        {
            return employee;
        }
    }

}
