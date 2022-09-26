package com.example.employeesystem.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Employee {
    private Long employeeId;
    private String employeeFirstname;
    private String employeeLastname;
    private String employeeEmail;
}
