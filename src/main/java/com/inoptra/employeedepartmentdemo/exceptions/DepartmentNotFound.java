package com.inoptra.employeedepartmentdemo.exceptions;

/**
 * @Author: Shrikrishna Prabhumirashi
 * @Description:
 * Represents business exception thrown when department not found in the context
 **/
public class DepartmentNotFound extends RuntimeException{
    public DepartmentNotFound(Long id){
        super("Could not find department " + id);
    }
}
