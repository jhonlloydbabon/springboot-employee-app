package com.example.employeesystem.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@Table(
        name = "employee",
        uniqueConstraints = @UniqueConstraint(
                name = "employeeEmail",
                columnNames = "employee_email"
        )
)
public class EmployeeEntity {
    @Id
    @SequenceGenerator(
            name = "employee_sequence",
            sequenceName = "employee_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "employee_sequence"
    )
    private Long employeeId;
    private String employeeFirstname;
    private String employeeLastname;
    @Column(name = "employee_email")
    private String employeeEmail;
}
