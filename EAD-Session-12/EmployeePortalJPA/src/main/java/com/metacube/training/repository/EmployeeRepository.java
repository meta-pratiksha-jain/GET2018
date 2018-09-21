package com.metacube.training.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.metacube.training.model.Employee;

@Repository
public interface EmployeeRepository<P> extends JpaRepository<Employee, Integer> {
	
	@Query("from Employee where email=?1 and password=?2")
	public Employee findEmployeeByEmailAndPassword(String email,String password);
	
//	public Employee findEmployeeById(int id);
	
	@Modifying
	@Query("update Employee set isEnable=true where id=?1")
	public int enableEmployee(int id);
	
	@Modifying
	@Query("update Employee set isEnable=false where id=?1")
	public int disableEmployee(int id);
	
	public Employee findEmployeeByEmail(String email);
	
	public List<Employee> findEmployeeByFirstNameContainingIgnoreCase(String firstName);

}
