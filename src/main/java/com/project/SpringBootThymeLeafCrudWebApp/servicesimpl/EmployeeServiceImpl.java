package com.project.SpringBootThymeLeafCrudWebApp.servicesimpl;

import com.project.SpringBootThymeLeafCrudWebApp.model.Employee;
import com.project.SpringBootThymeLeafCrudWebApp.repository.EmployeeRepository;
import com.project.SpringBootThymeLeafCrudWebApp.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }
}
