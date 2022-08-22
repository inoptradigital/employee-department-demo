package com.inoptra.employeedepartmentdemo.controllers;

import com.inoptra.employeedepartmentdemo.models.Employee;
import com.inoptra.employeedepartmentdemo.models.ErrorModel;
import com.inoptra.employeedepartmentdemo.services.EmployeeService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("rest/api/employee")
@Slf4j
@RequiredArgsConstructor
public class EmployeeController {

    private final EmployeeService employeeService;

    @Operation(description = "Gets the list of all the employee")
    @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "Success"),
        @ApiResponse(responseCode = "404", description = "No Data Found Found",
            content = @Content(schema = @Schema(implementation = ErrorModel.class))),
        @ApiResponse(responseCode = "500", description = "Internal Server Error",
            content = @Content(schema = @Schema(implementation = ErrorModel.class)))})
    @GetMapping
    public HttpEntity<List<Employee>> getEmployees() {
        log.info("EmployeeController: getEmployees()");
        List<Employee> employees = employeeService.getEmployees();
        return new ResponseEntity<>(employees, HttpStatus.OK);
    }

    @Operation(description = "Adds a new Employee")
    @ApiResponses(value = {@ApiResponse(responseCode = "201", description = "Success"),
        @ApiResponse(responseCode = "404", description = "No Data Found Found",
            content = @Content(schema = @Schema(implementation = ErrorModel.class))),
        @ApiResponse(responseCode = "500", description = "Internal Server Error",
            content = @Content(schema = @Schema(implementation = ErrorModel.class)))})
    @PostMapping
    public HttpEntity<Employee> addEmployee(@RequestBody @Valid Employee employee) {
        log.info("EmployeeController: addEmployee()");
        employee = employeeService.addEmployee(employee);
        return new ResponseEntity<>(employee, HttpStatus.OK);
    }

    @Operation(description = "Updates an existing Employee")
    @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "Success"),
        @ApiResponse(responseCode = "404", description = "No Data Found Found",
            content = @Content(schema = @Schema(implementation = ErrorModel.class))),
        @ApiResponse(responseCode = "500", description = "Internal Server Error",
            content = @Content(schema = @Schema(implementation = ErrorModel.class)))})
    @PutMapping("/{employeeId}")
    public HttpEntity<Employee> updateEmployee(@PathVariable(name = "employeeId") long id,
        @RequestBody @Valid Employee employee) {
        log.info("EmployeeController: updateEmployee()");
        employee = employeeService.updateEmployee(id, employee);
        return new ResponseEntity<>(employee, HttpStatus.OK);
    }

    @Operation(description = "deletes an existing Employee")
    @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "Success"),
        @ApiResponse(responseCode = "404", description = "No Data Found Found",
            content = @Content(schema = @Schema(implementation = ErrorModel.class))),
        @ApiResponse(responseCode = "500", description = "Internal Server Error",
            content = @Content(schema = @Schema(implementation = ErrorModel.class)))})
    @DeleteMapping("/{employeeId}")
    public HttpEntity<String> deleteEmployee(@PathVariable(name = "employeeId") long id) {
        log.info("EmployeeController: deleteEmployee()");
        employeeService.deleteEmployee(id);
        return new ResponseEntity<>("Successfully deleted the employee", HttpStatus.OK);
    }
}
