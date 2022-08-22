package com.inoptra.employeedepartmentdemo.services;

public interface AccountStatisticsService {
    double getTotalSalaryForAllDepartments();

    double getTotalSalaryForDepartment(long departmentId);

    double getAverageSalaryForAllDepartments();

    double getAverageSalaryForDepartment(long departmentId);
}
