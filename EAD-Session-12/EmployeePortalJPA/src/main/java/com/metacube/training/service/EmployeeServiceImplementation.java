package com.metacube.training.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.metacube.training.model.Employee;
import com.metacube.training.repository.EmployeeRepository;

@Service
public class EmployeeServiceImplementation implements EmployeeService{
	@Autowired
	EmployeeRepository<Employee> employeeRepository;
	//EmployeeDAO employeeDAO;

	@Override
	@Transactional
	public boolean addEmployee(Employee employee) {	
		try{
			employeeRepository.save(employee);
			
			}
			catch(Exception e){
				return false;
			}
			return true;
	}

	@Override
	@Transactional
	public Employee login(String email, String password) {
	    return employeeRepository.findEmployeeByEmailAndPassword(email,password);
	}

	@Override
	@Transactional
	public List<Employee> getAllEmployees() {
		return employeeRepository.findAll();
	}

	@Override
	@Transactional
	public boolean enableEmployee(int id) {
		return employeeRepository.enableEmployee(id)>0;
	}

	@Override
	@Transactional
	public boolean disableEmployee(int id) {
		return employeeRepository.disableEmployee(id)>0;
	}

	@Override
	@Transactional
	public Employee getEmployee(int id) {
		return employeeRepository.findOne(id);
	}

	@Override
	@Transactional
	public boolean updateEmployee(Employee employee) {
		try{
			employeeRepository.save(employee);			
			}
			catch(Exception e){
				return false;
			}
			return true;
	}

}
