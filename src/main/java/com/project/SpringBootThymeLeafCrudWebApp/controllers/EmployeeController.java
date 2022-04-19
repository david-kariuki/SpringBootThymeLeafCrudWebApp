package com.project.SpringBootThymeLeafCrudWebApp.controllers;

import com.project.SpringBootThymeLeafCrudWebApp.models.Employee;
import com.project.SpringBootThymeLeafCrudWebApp.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/showUpdateForm/{id}")
    public String showUpdateForm(@PathVariable (value = "id") long id, Model model) {
        Employee employee = employeeService.getEmployeeById(id); // Get employee from the service
        model.addAttribute("employeeById", employee); // Set employee object to model
        return "update_employee";
    }

    @GetMapping("/deleteEmployee/{id}")
    public  String deleteEmployee(@PathVariable (value = "id") long id, Model model) {

        boolean deleted = employeeService.deleteEmployeeById(id); // Get employee from the service
        model.addAttribute("deleted", deleted); // Add status to model
        return "redirect:/"; // Redirect
    }
}
