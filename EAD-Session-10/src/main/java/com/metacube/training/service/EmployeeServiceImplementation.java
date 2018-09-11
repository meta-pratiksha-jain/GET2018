package com.metacube.training.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.metacube.training.dao.EmployeeDAO;
import com.metacube.training.model.Employee;

@Service
public class EmployeeServiceImplementation implements EmployeeService{
	@Autowired
	EmployeeDAO employeeDAO;

	@Override
	public boolean addEmployee(Employee employee) {	
		return employeeDAO.addEmployee(employee);
	}

	@Override
	public Employee login(String email, String password) {
		return employeeDAO.login(email,password);
	}

	@Override
	public List<Employee> getAllEmployees() {
		return employeeDAO.getAllEmployees();
	}

	@Override
	public boolean enableEmployee(int id) {
		return employeeDAO.enableEmployee(id);
	}

	@Override
	public boolean disableEmployee(int id) {
		return employeeDAO.disableEmployee(id);
	}

}
