package com.crudoperations.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "employee")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "employeeId")
    private int employeeId;

    @Column(name = "employeeCode")
    private String employeeCode;

    @Column(name = "employeeName")
    private String employeeName;

    @Column(name = "employeeAddress")
    private String employeeAddress;

    @Column(name = "employeeEmail")
    private String employeeEmail;

}
