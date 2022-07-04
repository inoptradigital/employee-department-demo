package com.inoptra.employeedepartmentdemo.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class GlobalExceptionHandlerAdvice {

    @ResponseBody
    @ExceptionHandler(DepartmentNotFound.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String departmentNotFoundHandler(DepartmentNotFound ex){
        return ex.getMessage();
    }

    @ResponseBody
    @ExceptionHandler(EmployeeNotFound.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String employeeNotFoundHandler(EmployeeNotFound ex){
        return ex.getMessage();
    }

    @ResponseBody
    @ExceptionHandler(DeleteEmployeeException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    String deleteEmployeeException(DeleteEmployeeException ex) {return ex.getMessage();} //TODO: Fix error message

}
