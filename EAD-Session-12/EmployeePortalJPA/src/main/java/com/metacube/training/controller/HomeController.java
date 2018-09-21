package com.metacube.training.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.metacube.training.model.Employee;
import com.metacube.training.service.EmployeeService;

@Controller
public class HomeController {

	@RequestMapping(value="/")
	public ModelAndView test(HttpServletResponse response) throws IOException{
		return new ModelAndView("home");
	}
	
	@Autowired
	EmployeeService employeeService;
	
	@PostMapping(value="/searchEmployee")
	public ModelAndView searchEmployee(Model model, @RequestParam("type") String type, @RequestParam("inputValue") String inputValue)
	{
		List<Employee> listOfEmployee=employeeService.searchEmployee(type, inputValue);
		model.addAttribute("employees",listOfEmployee);
		return new ModelAndView("showEmployees");
	}
}
