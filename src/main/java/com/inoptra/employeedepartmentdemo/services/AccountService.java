package com.inoptra.employeedepartmentdemo.services;

import com.inoptra.employeedepartmentdemo.exceptions.DepartmentNotFoundException;
import com.inoptra.employeedepartmentdemo.models.Department;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class AccountService {

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private DepartmentService departmentService;

    public double getTotalSalaryForAllDepartments() {
        final List<Department> departments = departmentService.getAllDepartments();

        return departments.stream()
                .flatMap(department -> department.getEmployees().stream())
                .map(employee -> employeeService.getSalary(employee.getId()))
                .reduce(0.0, (t, s) -> t + s);
    }

    public double getAverageSalaryForAllDepartments() {
        final int employeeStrength = employeeService.getEmployeeStrength();
        if (employeeStrength == 0) {
            return 0.0;
        }

        return getTotalSalaryForAllDepartments()/employeeStrength;
    }

    public double getTotalSalaryForDepartment(final long deptId) {
        try {
            final var employeesList = employeeService.getEmployeesForDepartment(deptId);
            final double totalSalary = employeesList.stream()
                    .map(employee -> employeeService.getSalary(employee.getId()))
                    .reduce(0.0, (t, s) -> t + s);

            return totalSalary;
        } catch (final DepartmentNotFoundException e) {
            log.error("No department exists with id {}", deptId);
            return 0.0;
        }
    }

    public double getAverageSalaryForDepartment(final long deptId) {
        try {
            final var employeesList = employeeService.getEmployeesForDepartment(deptId);
            if (employeesList.size() == 0) {
                return 0.0;
            }
            final double totalSalary = employeesList.stream()
                    .map(employee -> employeeService.getSalary(employee.getId()))
                    .reduce(0.0, (t, s) -> t + s);

            return totalSalary/employeesList.size();
        } catch (final DepartmentNotFoundException e) {
            log.error("No department exists with id {}", deptId);
            return 0.0;
        }
    }
}
