package com.project.SpringBootThymeLeafCrudWebApp.repository;

import com.project.SpringBootThymeLeafCrudWebApp.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

// Gives CRUD operations
@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}
