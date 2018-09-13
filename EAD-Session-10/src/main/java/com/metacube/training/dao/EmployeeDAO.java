package com.metacube.training.dao;

import java.util.List;

import com.metacube.training.model.Employee;

public interface EmployeeDAO {
	
    public boolean enableEmployee(int id);
    
    public boolean disableEmployee(int id);
    
    public boolean addEmployee(Employee employee);
    
    public List<Employee> getAllEmployees();
    
    public Employee login(String email,String password);
    
    public Employee getEmployee(int id);
    
    public boolean updateEmployee(Employee employee);

}
