package com.crudoperations.service;

import com.crudoperations.dao.EmployeeRepo;
import com.crudoperations.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    private EmployeeRepo employeeRepo;

    @Autowired
    public EmployeeService(EmployeeRepo employeeRepo) {
        this.employeeRepo = employeeRepo;
    }

    public List<Employee> getAllEmployees()
    {
        return employeeRepo.findAll();
    }

    public Employee getEmployeeById(int employeeId)
    {

         return employeeRepo.findByEmployeeId(employeeId);
    }
    public Employee saveEmployee(Employee employee)
    {
        return employeeRepo.save(employee);
    }

    public void deleteEmployee(Employee employeeId)
    {
         employeeRepo.delete(employeeId);
    }



}
