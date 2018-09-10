package com.metacube.training.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.metacube.training.model.Employee;
import com.metacube.training.model.Job;
import com.metacube.training.model.Project;
import com.metacube.training.model.Skill;
import com.metacube.training.service.EmployeeService;
import com.metacube.training.service.JobService;
import com.metacube.training.service.ProjectService;
import com.metacube.training.service.SkillService;

@Controller
@RequestMapping("/admin")
public class AdminController {
    
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public ModelAndView login() {
        return new ModelAndView("admin/login");
    }
    
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ModelAndView login(@RequestParam(value = "email") String email,@RequestParam(value = "password") String password) {
        return new ModelAndView("admin/dashboard", "email", email);
    }
    
    @Autowired
    ProjectService projectService;
    
    @RequestMapping(value = "/project", method = RequestMethod.GET)
    public ModelAndView project(Model model) {
        model.addAttribute("projects",projectService.getAllProjects());
        return new ModelAndView("admin/projects");
    }
    
    @GetMapping(value="/project/add")
    public ModelAndView addProject(Model model){
        model.addAttribute(new Project());
        return new ModelAndView("admin/editProject");
    }
    
    @RequestMapping(value = "/project", method = RequestMethod.POST)
    public String saveProject(@ModelAttribute("project") Project project) {
        boolean isProjectSaved=false;
        if(project!=null)
        {
            if(project.getId()==0)
            {
                isProjectSaved=projectService.createProject(project);
            }
            else if(project.getId()!=0)
            {
                isProjectSaved=projectService.updateProject(project);
            }
        }
        if(isProjectSaved)
        {
            return "redirect:/admin/project";
        }
        else
        {
            return "redirect:/admin/edit";
        }
    }
    
    @PostMapping(value="/project/edit")
    public ModelAndView editProject(@RequestParam("id") int id){
        Project project=projectService.getProjectById(id);
        return new ModelAndView("admin/editProject", "project", project);
    }
    
    @PostMapping(value="/project/delete")
    public String deleteProject(@RequestParam("id") int id){
        projectService.deleteProject(id);
        return "redirect:/admin/project";
    }
    
    @Autowired
    JobService jobService;
    
    @RequestMapping(value = "/job", method = RequestMethod.GET)
    public ModelAndView job(Model model) {
        model.addAttribute(new Job());
        return new ModelAndView("admin/addJob");
    }
    
    @RequestMapping(value = "/job/add", method = RequestMethod.POST)
    public String job(@ModelAttribute("job") Job job) {
        boolean isJobAdded=false;
        if(job!=null)
        {
            isJobAdded=jobService.addJob(job);
        }
        if(isJobAdded)
        {
            return "redirect:/admin/dashboard";
        }
        else
        {
            return "redirect:/admin/addJob";
        }
    }
    
    @Autowired
    SkillService skillService;
    
    @RequestMapping(value = "/skill", method = RequestMethod.GET)
    public ModelAndView skill(Model model) {
        model.addAttribute(new Skill());
        return new ModelAndView("admin/addSkill");
    }
    
    @RequestMapping(value = "/skill/add", method = RequestMethod.POST)
    public String skill(@ModelAttribute("skill") Skill skill) {
        boolean isSkillAdded=false;
        if(skill!=null)
        {
            isSkillAdded=skillService.addSkill(skill);
        }
        if(isSkillAdded)
        {
            return "redirect:/admin/dashboard";
        }
        else
        {
            return "redirect:/admin/addSkill";
        }
    }
    
    @Autowired
    EmployeeService employeeService;
    
    @RequestMapping(value = "/addEmployee", method = RequestMethod.GET)
    public ModelAndView addEmployee(Model model) {
        model.addAttribute(new Employee());
        return new ModelAndView("admin/addEmployee");
    }
    
    @RequestMapping(value = "/addEmployee", method = RequestMethod.POST)
    public String addEmployee(@ModelAttribute("employee") Employee employee) {
        boolean isEmployeeAdded=false;
        if(employee!=null)
        {
            isEmployeeAdded=employeeService.addEmployee(employee);
        }
        if(isEmployeeAdded)
        {
            return "redirect:/admin/addEmployee";
        }
        else
        {
            return "redirect:/admin/addEmployee";
        }
    }
    
    @GetMapping(value="/logout")
    public ModelAndView logout()
    {
        return new ModelAndView("home");
    }
    
}