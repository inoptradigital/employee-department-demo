package com.inoptra.employeedepartmentdemo.controllers;

import com.inoptra.employeedepartmentdemo.models.Department;
import com.inoptra.employeedepartmentdemo.models.ErrorModel;
import com.inoptra.employeedepartmentdemo.services.DepartmentService;
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
@RequestMapping("rest/api/department")
@Slf4j
@RequiredArgsConstructor
public class DepartmentController {

    private final DepartmentService departmentService;

    @Operation(description = "Gets the list of all the department")
    @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "Success"),
        @ApiResponse(responseCode = "404", description = "No Data Found Found",
            content = @Content(schema = @Schema(implementation = ErrorModel.class))),
        @ApiResponse(responseCode = "500", description = "Internal Server Error",
            content = @Content(schema = @Schema(implementation = ErrorModel.class)))})
    @GetMapping
    public HttpEntity<List<Department>> getDepartments() {
        log.info("DepartmentController: getDepartments()");
        List<Department> departments = departmentService.getDepartments();
        return new ResponseEntity<>(departments, HttpStatus.OK);
    }

    @Operation(description = "get an existing Department")
    @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "Success"),
        @ApiResponse(responseCode = "404", description = "No Data Found Found",
            content = @Content(schema = @Schema(implementation = ErrorModel.class))),
        @ApiResponse(responseCode = "500", description = "Internal Server Error",
            content = @Content(schema = @Schema(implementation = ErrorModel.class)))})
    @GetMapping("/{departmentId}")
    public HttpEntity<Department> getDepartment(@PathVariable(name = "departmentId") long id,
        @RequestBody @Valid Department department) {
        log.info("DepartmentController: getDepartment()");
        department = departmentService.updateDepartment(id, department);
        return new ResponseEntity<>(department, HttpStatus.OK);
    }

    @Operation(description = "Adds a new Department")
    @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "Success"),
        @ApiResponse(responseCode = "404", description = "No Data Found Found",
            content = @Content(schema = @Schema(implementation = ErrorModel.class))),
        @ApiResponse(responseCode = "500", description = "Internal Server Error",
            content = @Content(schema = @Schema(implementation = ErrorModel.class)))})
    @PostMapping
    public HttpEntity<Department> addDepartment(@RequestBody @Valid Department department) {
        log.info("DepartmentController: addDepartment()");
        department = departmentService.addDepartment(department);
        return new ResponseEntity<>(department, HttpStatus.OK);
    }

    @Operation(description = "Updates an existing Department")
    @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "Success"),
        @ApiResponse(responseCode = "404", description = "No Data Found Found",
            content = @Content(schema = @Schema(implementation = ErrorModel.class))),
        @ApiResponse(responseCode = "500", description = "Internal Server Error",
            content = @Content(schema = @Schema(implementation = ErrorModel.class)))})
    @PutMapping("/{departmentId}")
    public HttpEntity<Department> updateDepartment(@PathVariable(name = "departmentId") long id,
        @RequestBody @Valid Department department) {
        log.info("DepartmentController: updateDepartment()");
        department = departmentService.updateDepartment(id, department);
        return new ResponseEntity<>(department, HttpStatus.OK);
    }

    @Operation(description = "Deletes an existing Department")
    @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "Success"),
        @ApiResponse(responseCode = "404", description = "No Data Found Found",
            content = @Content(schema = @Schema(implementation = ErrorModel.class))),
        @ApiResponse(responseCode = "500", description = "Internal Server Error",
            content = @Content(schema = @Schema(implementation = ErrorModel.class)))})
    @DeleteMapping("/{departmentId}")
    public HttpEntity<String> deleteDepartment(@PathVariable(name = "departmentId") long id) {
        log.info("DepartmentController: deleteDepartment()");
        departmentService.deleteDepartment(id);
        return new ResponseEntity<>("Successfully deleted the department", HttpStatus.OK);
    }
}
