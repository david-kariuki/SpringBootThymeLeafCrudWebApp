package com.project.SpringBootThymeLeafCrudWebApp.servicesimpl;

import com.project.SpringBootThymeLeafCrudWebApp.models.Employee;
import com.project.SpringBootThymeLeafCrudWebApp.repository.EmployeeRepository;
import com.project.SpringBootThymeLeafCrudWebApp.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    @Override
    public Employee getEmployeeById(Long employeeId) {
        Optional<Employee> optionalEmployee = employeeRepository.findById(employeeId);
        Employee employee = null;
        if (optionalEmployee.isPresent()) {
            employee = optionalEmployee.get();
        } else {
            throw new RuntimeException("Employee not found for id : " + employeeId + "!!");
        }
        return employee;
    }

    @Override
    public boolean deleteEmployeeById(Long employeeId) {

        Optional<Employee> optionalEmployee = employeeRepository.findById(employeeId);

        if (optionalEmployee.isPresent()) {
            Employee employee = optionalEmployee.get();
            employeeRepository.delete(employee);

            return true;
        } else {
            throw new RuntimeException("Employee not found for id : " + employeeId + "!!");
        }
    }
}
