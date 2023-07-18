package com.inoptra.employeedepartmentdemo.exceptions;

import static java.lang.String.format;

/**
 * @Author: Shrikrishna Prabhumirashi
 * @Description:
 * Represents business exception thrown when department not found in the context
 **/
public class DepartmentNotFoundException extends Exception {

    public DepartmentNotFoundException(final long deptId) {
        super(format("%s not found", deptId));
    }

}
