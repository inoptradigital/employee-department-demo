package com.inoptra.employeedepartmentdemo.controllers;

import com.inoptra.employeedepartmentdemo.models.Employee;
import com.inoptra.employeedepartmentdemo.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/employees/{employeeId}")
    public Employee getEmployeeById(@PathVariable Long employeeId){
        return employeeService.getEmployeeById(employeeId);
    }

    @PostMapping("/employees/add")
    public Employee addEmployee(@RequestBody Employee employee){
        return employeeService.addEmployee(employee);
    }

    @PutMapping("/employees/update")
    public Employee updateEmployee(@RequestBody Employee employee){
        return employeeService.updateEmployee(employee);
    }

    @DeleteMapping("/employees/{employeeId}")
    public ResponseEntity<Long> deleteEmployee(@PathVariable Long employeeId){
        employeeService.deleteEmployee(employeeId);
        return new ResponseEntity<>(employeeId, HttpStatus.OK);
    }

}
