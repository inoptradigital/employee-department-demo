package com.inoptra.employeedepartmentdemo.controllers;

import com.inoptra.employeedepartmentdemo.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.http.HttpResponse;

@RequestMapping("/employees")
@RestController
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @PostMapping("")
    public ResponseEntity createEmployee() {
        // TODO (sreejit): Implement create operation with request body
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @PutMapping("/{empId}")
    public ResponseEntity updateEmployee(@PathVariable("empId") final Long empId) {
        // TODO (sreejit): Implement update operation with request body
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @DeleteMapping("/{empId}")
    public ResponseEntity deleteEmployee(@PathVariable("empId") final Long empId) {
        // TODO (sreejit): Implement delete operation
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
