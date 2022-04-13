package com.project.SpringBootThymeLeafCrudWebApp.servicesimpl;

import com.project.SpringBootThymeLeafCrudWebApp.models.Employee;
import com.project.SpringBootThymeLeafCrudWebApp.repository.EmployeeRepository;
import com.project.SpringBootThymeLeafCrudWebApp.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    @Override
    public void saveEmployee(Employee employee) {
        employeeRepository.save(employee);
    }
}
