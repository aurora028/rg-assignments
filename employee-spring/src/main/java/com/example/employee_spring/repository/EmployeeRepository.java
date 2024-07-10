package com.example.employee_spring.repository;

import com.example.employee_spring.model.Employee;
import org.springframework.data.repository.CrudRepository;

public interface EmployeeRepository extends CrudRepository<Employee, Integer> {
}
