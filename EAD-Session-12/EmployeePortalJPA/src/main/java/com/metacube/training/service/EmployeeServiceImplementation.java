package com.metacube.training.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.metacube.training.model.Employee;
import com.metacube.training.model.JobDetails;
import com.metacube.training.model.Project;
import com.metacube.training.model.Skill;
import com.metacube.training.repository.EmployeeRepository;
import com.metacube.training.repository.JobDeatilsRepository;
import com.metacube.training.repository.JobRepository;
import com.metacube.training.repository.ProjectRepository;
import com.metacube.training.repository.SkillRepository;

@Service
public class EmployeeServiceImplementation implements EmployeeService{
	@Autowired
	EmployeeRepository<Employee> employeeRepository;
	
	@Autowired
	SkillRepository<Skill> skillRepository;
	
	@Autowired
	ProjectRepository<Project> projectRepository;
	
	@Autowired
	JobDeatilsRepository jobDetailsRepository;

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
	
	@Override
	@Transactional
	public List<Employee> searchEmployee(String type, String inputValue) {
		List<Employee> listOfEmployee=new ArrayList<Employee>();
	    switch(type)
	    {
	    case "name":
	    	listOfEmployee=employeeRepository.findEmployeeByFirstNameContainingIgnoreCase(inputValue);
	    	break;
	    case "project":
	    	List<JobDetails> listOfEmployeeJobDetails=jobDetailsRepository.findJobDetailsByProjectNameContainingIgnoreCase(inputValue);
	    	for(JobDetails employeeJobDetails:listOfEmployeeJobDetails)
	    	{
	    		int employeeId=employeeJobDetails.getEmployeeId();
	    		Employee employee=employeeRepository.findOne(employeeId);
	    		listOfEmployee.add(employee);
	    	}
	    	break;
	    default:
	    	return null;
	    }
		return listOfEmployee;
	}

	@Override
	@Transactional
	public Employee getEmployeeByEmail(String email) {
		Employee employee=employeeRepository.findEmployeeByEmail(email);
		return employee;
	}
	
	@Override
	@Transactional
	public void addJobDetails(JobDetails jobDetails) {
		try{
			jobDetailsRepository.save(jobDetails);
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}

}
