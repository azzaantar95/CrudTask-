package com.crudoperations.controller;

import com.crudoperations.model.Employee;
import com.crudoperations.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("http://localhost:4200")
@RequestMapping("/api/v1/")
public class EmployeeController {

    private EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("allEmployees")
    public List<Employee> getAllOrders() {
        return employeeService.getAllEmployees();
    }


    @PostMapping("Employees")
    public Employee saveEmployee(@RequestBody Employee employee) {
        return employeeService.saveEmployee(employee);
    }


    // get employee by id

    @GetMapping("employees/{id}")
    public Employee getEmployeeById(@PathVariable int id) {
         return  employeeService.getEmployeeById(id);
    }


    // update employee by id

    @PutMapping("employees/{id}")
    public Employee editEmployeeById(@PathVariable int id,@RequestBody Employee detailsEmployee) {

        Employee employee= employeeService.getEmployeeById(id);

        employee.setEmployeeName(detailsEmployee.getEmployeeName());
        employee.setEmployeeCode(detailsEmployee.getEmployeeCode());
        employee.setEmployeeAddress(detailsEmployee.getEmployeeAddress());
        employee.setEmployeeEmail(detailsEmployee.getEmployeeEmail());
        return  employeeService.saveEmployee(employee);
    }

    @DeleteMapping("employees/{id}")
    public void deleteEmployeeById(@PathVariable int id) {

        Employee employee= employeeService.getEmployeeById(id);

        employeeService.deleteEmployee(employee);
    }



}
