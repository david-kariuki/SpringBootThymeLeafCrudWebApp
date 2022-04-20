package com.project.spring_thymeleaf_crud_webapp.services;

import com.project.spring_thymeleaf_crud_webapp.models.Employee;

import java.util.List;

public interface EmployeeService {

    List<Employee> getAllEmployees();

    void saveEmployee(Employee employee);

    Employee getEmployeeById(Long employeeId);

    boolean deleteEmployeeById(Long employeeId);
}
