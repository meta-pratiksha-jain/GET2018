package com.metacube.training.service;

import java.util.List;

import com.metacube.training.model.Employee;

public interface EmployeeService {
	
	public boolean addEmployee(Employee employee);
	
	public List<Employee> getAllEmployees();
	
	public Employee login(String email,String password);
	
	public boolean enableEmployee(int id);
	
	public boolean disableEmployee(int id);

}
