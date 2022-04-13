package com.project.SpringBootThymeLeafCrudWebApp.services;

import com.project.SpringBootThymeLeafCrudWebApp.models.Employee;
import org.springframework.stereotype.Service;

import java.util.List;

public interface EmployeeService {

    List<Employee> getAllEmployees();
    void saveEmployee(Employee employee);
}
