package com.inoptra.employeedepartmentdemo.exceptions;

/**
 * @Author: Shrikrishna Prabhumirashi
 * @Description:
 * Represents business exception thrown when employee not found in the context
 **/
public class EmployeeNotFound extends RuntimeException{
    public EmployeeNotFound(Long id){
        super("Could not find employee "+ id);
    }
}
