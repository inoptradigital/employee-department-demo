package com.inoptra.employeedepartmentdemo.exceptions;

/**
 * @Author: Shrikrishna Prabhumirashi
 * @Description:
 * Represents business exception thrown when employee not found in the context
 **/
public class EmployeeNotFoundException extends RuntimeException {
    public EmployeeNotFoundException(long employeeId) {
        super("No employee found with given Id in the database" + employeeId);
    }
}
