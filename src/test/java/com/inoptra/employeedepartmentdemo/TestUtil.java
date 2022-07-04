package com.inoptra.employeedepartmentdemo;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.inoptra.employeedepartmentdemo.models.Department;
import com.inoptra.employeedepartmentdemo.models.Employee;
import com.inoptra.employeedepartmentdemo.models.Salary;
import com.inoptra.employeedepartmentdemo.models.SalaryComponent;

public class TestUtil {

    public static Department buildDepartment(String name){
        //TODO: Builder would make this look cleaner.
        Department department = new Department(name);
        return department;
    }

    public static Employee buildEmployee(String name){
        Employee employee = new Employee(name);
        return employee;
    }

    public static Salary buildSalary(double base){
        Salary salary = new Salary(base);
        return salary;
    }

    public static SalaryComponent buildSalaryComponent(String name, double factor){
        return new SalaryComponent(name, factor);
    }

    public static String asJsonString(final Object obj){
        try{
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e){
            throw new RuntimeException(e);
        }
    }

}
