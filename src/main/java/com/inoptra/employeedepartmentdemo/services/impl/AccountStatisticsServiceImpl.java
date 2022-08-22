package com.inoptra.employeedepartmentdemo.services.impl;

import com.inoptra.employeedepartmentdemo.models.Department;
import com.inoptra.employeedepartmentdemo.services.AccountStatisticsService;
import com.inoptra.employeedepartmentdemo.services.DepartmentService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
@RequiredArgsConstructor
public class AccountStatisticsServiceImpl implements AccountStatisticsService {

    private final DepartmentService departmentService;

    @Override
    public double getTotalSalaryForAllDepartments() {
        List<Department> allDepartments = departmentService.getDepartments();
        return getTotalSalaryForAllDepartments(allDepartments);
    }

    @Override
    public double getTotalSalaryForDepartment(long departmentId) {
        Department department = departmentService.getDepartment(departmentId);
        return departmentService.getSalaryForTheDepartment(department).orElse(0.0);
    }

    @Override
    public double getAverageSalaryForAllDepartments() {
        List<Department> allDepartments = departmentService.getDepartments();
        long allEmpCount = allDepartments.stream().mapToLong(department -> department.getEmployees().size()).sum();
        double totalSalary = getTotalSalaryForAllDepartments(allDepartments);
        return totalSalary / allEmpCount;
    }

    private double getTotalSalaryForAllDepartments(List<Department> allDepartments) {
        double totalSalary = 0.0;
        if (!CollectionUtils.isEmpty(allDepartments)) {
            for (Department department : allDepartments) {
                Optional<Double> optionalSalary = departmentService.getSalaryForTheDepartment(department);
                if (optionalSalary.isPresent()) {
                    totalSalary += optionalSalary.get();
                }
            }
        }
        return totalSalary;
    }

    @Override
    public double getAverageSalaryForDepartment(long departmentId) {
        Department department = departmentService.getDepartment(departmentId);
        if (!CollectionUtils.isEmpty(department.getEmployees())) {
            double departmentSalary = departmentService.getSalaryForTheDepartment(department).orElse(0.0);
            return departmentSalary / department.getEmployees().size();
        }
        return 0.0;
    }
}
