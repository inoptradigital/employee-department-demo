package com.inoptra.employeedepartmentdemo.services;

import com.inoptra.employeedepartmentdemo.models.Employee;

import java.util.List;

/**
 * @Author: Shrikrishna Prabhumirashi
 * @Description:
 * Service layer contract which supports operations on Employee object
 **/
public interface EmployeeService {
    double getSalary(Employee employee);

    List<Employee> getEmployees();

    Employee addEmployee(Employee employee);

    Employee updateEmployee(long id, Employee employee);

    void deleteEmployee(long id);
}
