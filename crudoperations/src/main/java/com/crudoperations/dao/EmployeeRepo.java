package com.crudoperations.dao;

import com.crudoperations.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepo extends JpaRepository<Employee,Integer> {


    public Employee findByEmployeeId(int employeeId);


}

