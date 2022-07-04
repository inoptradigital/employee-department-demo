package com.inoptra.employeedepartmentdemo.exceptions;

public class DeleteEmployeeException extends RuntimeException{
    public DeleteEmployeeException (Long id, Exception ex){
        super("Error delete employee id " +id, ex);
    }
}
