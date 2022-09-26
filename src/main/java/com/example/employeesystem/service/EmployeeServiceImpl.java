package com.example.employeesystem.service;

import com.example.employeesystem.entity.EmployeeEntity;
import com.example.employeesystem.model.Employee;
import com.example.employeesystem.repository.EmployeeRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class EmployeeServiceImpl implements EmployeeService{

    private EmployeeRepository employeeRepository;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository){
        this.employeeRepository = employeeRepository;
    }
    @Override
    public Employee saveEmployee(Employee employee) {
        EmployeeEntity employeeEntity = new EmployeeEntity();
        BeanUtils.copyProperties(employee, employeeEntity);
        employeeRepository.save(employeeEntity);
        return employee;
    }

    @Override
    public List<Employee> fetchEmployee() {
        List<EmployeeEntity> entityList  = employeeRepository.findAll();
        List<Employee> employeeList = entityList.stream()
                .map(employee -> new Employee(
                        employee.getEmployeeId(),
                        employee.getEmployeeFirstname(),
                        employee.getEmployeeLastname(),
                        employee.getEmployeeEmail()
                ))
                .collect(Collectors.toList());
        return employeeList;
    }

    @Override
    public boolean deleteEmployee(Long id) {
        EmployeeEntity employeeEntity = employeeRepository.findById(id).get();
        employeeRepository.delete(employeeEntity);
        return true;
    }

    @Override
    public Employee fetchById(Long id) {
        EmployeeEntity employeeEntity = employeeRepository.findById(id).get();
        Employee employee = new Employee();
        BeanUtils.copyProperties(employeeEntity, employee);
        return employee;
    }

    @Override
    public Employee updateEmployee(Long id, Employee emp) {

        EmployeeEntity employeeEntity = employeeRepository.findById(id).get();

        if(Objects.nonNull(emp.getEmployeeFirstname())
                && !"".equalsIgnoreCase(emp.getEmployeeFirstname())){
            employeeEntity.setEmployeeFirstname(emp.getEmployeeFirstname());
        }
        if(Objects.nonNull(emp.getEmployeeLastname())
                && !"".equalsIgnoreCase(emp.getEmployeeLastname())){
            employeeEntity.setEmployeeLastname(emp.getEmployeeLastname());
        }
        if(Objects.nonNull(emp.getEmployeeEmail())
                && !"".equalsIgnoreCase(emp.getEmployeeEmail())){
            employeeEntity.setEmployeeEmail(emp.getEmployeeEmail());
        }

        employeeRepository.save(employeeEntity);
        return emp;
    }
}
