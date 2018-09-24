package com.metacube.training.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.omg.CORBA.Request;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
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
	
	@GetMapping(value="/login")
	public ModelAndView login(HttpServletResponse response) throws IOException{
		return new ModelAndView("login");
	}
	
	@GetMapping(value="/dashboard")
	public String dashboard(HttpServletRequest request)
	{
		if(request.isUserInRole("ROLE_ADMIN"))
		{
			return "redirect:/admin/dashboard";
		}
		return "redirect:/employee/profile";
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
