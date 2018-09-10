package com.metacube.training.service;

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

}
