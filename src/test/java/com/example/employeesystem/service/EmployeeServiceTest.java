package com.example.employeesystem.service;

import com.example.employeesystem.entity.EmployeeEntity;
import com.example.employeesystem.model.Employee;
import com.example.employeesystem.repository.EmployeeRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.beans.Beans;

@SpringBootTest
class EmployeeServiceTest {

    @Autowired
    private EmployeeService employeeService;


    @Test
    public void fetchById(){
        Employee employee = employeeService.fetchById(70L);
        System.out.println(employee);
    }
}