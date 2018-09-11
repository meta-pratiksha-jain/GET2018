package com.metacube.training.mappers;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.metacube.training.model.Employee;

public class EmployeeMapper implements RowMapper<Employee> {
	
	@Override
    public Employee mapRow(ResultSet resultSet, int i) throws SQLException {
        Employee employee=new Employee();
        employee.setId(resultSet.getInt("id"));
        employee.setFirstName(resultSet.getString("first_name"));
        employee.setMiddleName(resultSet.getString("middle_name"));
        employee.setLastName(resultSet.getString("last_name"));
        employee.setEmail(resultSet.getString("email"));
        employee.setDateOfBirth(Date.valueOf(resultSet.getString("date_of_birth")));
        employee.setGender(resultSet.getString("gender"));
        return employee;
    }

}
