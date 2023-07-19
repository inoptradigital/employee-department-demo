package com.inoptra.employeedepartmentdemo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.inoptra.employeedepartmentdemo.models.Employee;

import java.util.List;

/**
 * @Author: Shrikrishna Prabhumirashi
 * @Description:
 * Persistence layer which performs operations on Employee entity
 **/
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    List<Employee> findByDepartmentId(final long deptId);
}
