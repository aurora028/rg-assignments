package com.example.employee_spring.service;

import com.example.employee_spring.model.Employee;
import com.example.employee_spring.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public Employee save(Employee employee) {
        return employeeRepository.save(employee);
    }

    public Employee findById(int id) {
        return employeeRepository.findById(id).orElse(null);
    }

    public Iterable<Employee> findAll() {
        return employeeRepository.findAll();
    }

    public void deleteById(int id) {
        employeeRepository.deleteById(id);
    }
}
