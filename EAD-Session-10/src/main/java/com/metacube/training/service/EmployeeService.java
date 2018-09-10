package com.metacube.training.service;

import com.metacube.training.model.Employee;

public interface EmployeeService {
    
    public boolean addEmployee(Employee employee);
    
    public Employee login(String email,String password);

}
