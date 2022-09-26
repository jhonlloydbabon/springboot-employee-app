package com.example.employeesystem.service;

import com.example.employeesystem.model.Employee;

import java.util.List;

public interface EmployeeService {
    Employee saveEmployee(Employee employee);

    List<Employee> fetchEmployee();

    boolean deleteEmployee(Long id);

    Employee fetchById(Long id);

    Employee updateEmployee(Long id, Employee emp);
}
