package com.metacube.training.dao;

import com.metacube.training.model.Employee;

public interface EmployeeDAO {
	
    public String INSERT="INSERT INTO Employee(first_name,middle_name,last_name,email,date_of_birth,date_of_joining,gender) "
    		           + "VALUES(?,?,?,?,?,?,?)";
    
    public boolean addEmployee(Employee employee);

}
