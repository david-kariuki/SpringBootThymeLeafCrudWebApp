package com.project.spring_thymeleaf_crud_webapp.repository;

import com.project.spring_thymeleaf_crud_webapp.models.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

// Gives CRUD operations
@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}
