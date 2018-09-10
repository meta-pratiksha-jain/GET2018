package com.metacube.training.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.metacube.training.model.Employee;
import com.metacube.training.service.EmployeeService;

@Controller
@RequestMapping(value="/employee")
public class EmployeeController {
    @Autowired
    EmployeeService employeeService;
    
        @GetMapping(value = "/login")
        public ModelAndView login() {
            return new ModelAndView("employee/login");
        }
        
        @PostMapping(value = "/login")
        public String login(@RequestParam(value = "email") String email,@RequestParam(value = "password") String password,Model model) {
            Employee employee=employeeService.login(email,password);
            if(employee==null)
            {
                return "redirect:/employee/login";
            }
            else
            {
                model.addAttribute(employee);
                return "employee/dashboard";
            }
        }

}
