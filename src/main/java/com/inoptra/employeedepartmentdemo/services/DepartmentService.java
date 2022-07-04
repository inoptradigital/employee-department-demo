package com.inoptra.employeedepartmentdemo.services;

import com.inoptra.employeedepartmentdemo.exceptions.DepartmentNotFound;
import com.inoptra.employeedepartmentdemo.models.Department;
import com.inoptra.employeedepartmentdemo.models.Employee;
import com.inoptra.employeedepartmentdemo.repositories.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * @Author: Shrikrishna Prabhumirashi
 * @Description:
 * Service layer contract which supports operations on Department object
 **/
//TODO: Define Interface for this service to comply with Strategy design pattern.
@Service
public class DepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository;

    public Department getDepartmentById(Long id){
        return departmentRepository.findById(id).orElseThrow(()-> new DepartmentNotFound(id));
    }

    public Department addDepartment(Department department){
        return departmentRepository.save(department);
    }

    public Department updateDepartment(Department department){
        return departmentRepository.save(department);
    }

    public double getTotalSalaryForDepartment(Long id){
        Optional<Department> optDepartment = departmentRepository.findById(id);
        if(!optDepartment.isPresent()) return 0.0;

        Department department = optDepartment.get();
        double total = department.getEmployees()
                .stream()
                .map(employee -> this.calculateSalary(employee))
                .reduce(0.0, Double::sum);

        return total;
    }

    public double getAverageSalaryForDepartment(Long id){
        Optional<Department> optDepartment = departmentRepository.findById(id);
        if(!optDepartment.isPresent()) return 0.0;

        Department department = optDepartment.get();
        double total = department.getEmployees()
                .stream()
                .map(employee -> this.calculateSalary(employee))
                .mapToDouble(Double::doubleValue)
                .average()
                .getAsDouble();

        return total;
    }

    //TODO: consolidate this method to util for sharing with other services.
    private double calculateSalary(Employee emp){
        return emp
                .getSalary()
                .getSalaryComponents()
                .parallelStream()
                .reduce(
                        Double.valueOf(0.0),
                        (total, sc) -> total + (sc.getFactor() *  emp.getSalary().getBaseSalary()),
                        (c1, c2) -> c1 + c2
                );
    }
}
