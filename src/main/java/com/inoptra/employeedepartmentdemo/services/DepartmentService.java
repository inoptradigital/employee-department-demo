package com.inoptra.employeedepartmentdemo.services;

import com.inoptra.employeedepartmentdemo.models.Department;

import java.util.List;
import java.util.Optional;

/**
 * @Author: Shrikrishna Prabhumirashi
 * @Description:
 * Service layer contract which supports operations on Department object
 **/
public interface DepartmentService {

    List<Department> getDepartments();

    Department getDepartment(long id);

    Department addDepartment(Department department);

    Department updateDepartment(long id, Department department);

    void deleteDepartment(long id);

    Optional<Double> getSalaryForTheDepartment(Department department);
}
