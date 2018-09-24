package com.metacube.training.service;

import java.util.List;

import com.metacube.training.model.Employee;
import com.metacube.training.model.JobDetails;

public interface EmployeeService {
	
	public boolean addEmployee(Employee employee);
	
	public List<Employee> getAllEmployees();
	
	public Employee login(String email,String password);
	
	public boolean enableEmployee(int id);
	
	public boolean disableEmployee(int id);
	
	public Employee getEmployee(int id);
	
	public boolean updateEmployee(Employee employee);
	
	public List<Employee> searchEmployee(String type,String inputValue);
	
	public Employee getEmployeeByEmail(String email);
	
	public void addJobDetails(JobDetails jobDetails);

}
