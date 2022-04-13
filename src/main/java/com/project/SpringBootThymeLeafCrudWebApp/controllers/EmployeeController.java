package com.project.SpringBootThymeLeafCrudWebApp.controllers;

import com.project.SpringBootThymeLeafCrudWebApp.models.Employee;
import com.project.SpringBootThymeLeafCrudWebApp.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    // Method to display list of employees
    @GetMapping("/")
    public String viewHomePage(Model model) {
        model.addAttribute("listEmployees", employeeService.getAllEmployees());
        return "index"; // home thymeleaf called here as index
    }

    @GetMapping("/showNewEmployeeForm")
    public String showNewEmployeeForm(Model model) {
        // Create model attribute to bind form data
        Employee employee = new Employee();
        model.addAttribute("employee", employee);
        return "new_employee";
    }

    @PostMapping(path = "/saveEmployee")
    public String saveEmployee(@ModelAttribute("employee") Employee employee) {
        // Save employee to database
        employeeService.saveEmployee(employee);
        return "redirect:/";
    }
}
