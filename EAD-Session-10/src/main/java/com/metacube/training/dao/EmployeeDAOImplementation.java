package com.metacube.training.dao;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.metacube.training.mappers.EmployeeMapper;
import com.metacube.training.mappers.JobMapper;
import com.metacube.training.model.Employee;
import com.metacube.training.model.Job;

@Repository
public class EmployeeDAOImplementation implements EmployeeDAO{
	
	public String INSERT="INSERT INTO Employee(first_name,middle_name,last_name,email,date_of_birth,gender) "
	           + "VALUES(?,?,?,?,?,?,?)";
	public static final String GET_ALL="SELECT * FROM Employee";
	public static final String CHECK_EMPLOYEE_LOGIN="SELECT * FROM Employee WHERE email=? AND password=?";
	public static final String ENABLE_EMPLOYEE="UPDATE Employee SET is_enable=true WHERE id=?";
	public static final String DISABLE_EMPLOYEE="UPDATE Employee SET is_enable=false WHERE id=?";

	JdbcTemplate jdbcTemplate;
	
	@Autowired
    public EmployeeDAOImplementation(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }
	
	@Override
	public boolean addEmployee(Employee employee) {
		int insertedRows=jdbcTemplate.update(INSERT,employee.getFirstName(),employee.getMiddleName(),employee.getLastName(),employee.getEmail(),employee.getDateOfBirth(),employee.getGender());
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

	@Override
	public List<Employee> getAllEmployees() {
		List<Employee> listOfEmployee=jdbcTemplate.query(GET_ALL, new EmployeeMapper());
        return listOfEmployee;

	}

	@Override
	public boolean enableEmployee(int id) {
		int updatedRows=jdbcTemplate.update(ENABLE_EMPLOYEE,id);
		if(updatedRows==0)
		{
			return false;
		}
		return true;
	}

	@Override
	public boolean disableEmployee(int id) {
		int updatedRows=jdbcTemplate.update(DISABLE_EMPLOYEE,id);
		if(updatedRows==0)
		{
			return false;
		}
		return true;
	}

}
