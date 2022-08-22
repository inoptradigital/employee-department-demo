package com.inoptra.employeedepartmentdemo.exceptions;

/**
 * @Author: Shrikrishna Prabhumirashi
 * @Description:
 * Represents business exception thrown when department not found in the context
 **/
public class DepartmentNotFoundException extends RuntimeException{
    public DepartmentNotFoundException(long departmentId){
        super("No Department found with given Id in the database" + departmentId);
    }
}
