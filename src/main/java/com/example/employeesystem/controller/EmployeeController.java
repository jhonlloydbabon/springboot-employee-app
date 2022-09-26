package com.example.employeesystem.controller;

import com.example.employeesystem.model.Employee;
import com.example.employeesystem.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "http://localhost:3000/")
@RestController
public class EmployeeController {
    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @PostMapping("/api/v1/employee")
    public ResponseEntity<Employee> saveEmployee(@RequestBody Employee employee){
        Employee result = employeeService.saveEmployee(employee);
        return ResponseEntity.ok(result);
    }

    @GetMapping("/api/v1/employee")
    public List<Employee> fetchEmployee(){
        return employeeService.fetchEmployee();
    }

    @DeleteMapping("/api/v1/employee/{id}")
    public ResponseEntity<Map<String, Boolean>> deleteEmployee(@PathVariable("id") Long id){
        Boolean isDeleted = false;
        isDeleted = employeeService.deleteEmployee(id);
        Map<String, Boolean> result = new HashMap<>();
        result.put("deleted", isDeleted);
        return ResponseEntity.ok(result);
    }

    @GetMapping("/api/v1/employee/{id}")
    public ResponseEntity<Employee> fetchById(@PathVariable("id") Long id){
        Employee employee = null;
        employee = employeeService.fetchById(id);
        return ResponseEntity.ok(employee);
    }

    @PutMapping("/api/v1/employee/{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable("id") Long id,
                                                   @RequestBody Employee employee){
        employee = employeeService.updateEmployee(id, employee);
        return ResponseEntity.ok(employee);
    }

}

