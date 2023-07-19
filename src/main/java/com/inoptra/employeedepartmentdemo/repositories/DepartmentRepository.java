package com.inoptra.employeedepartmentdemo.repositories;

import com.inoptra.employeedepartmentdemo.models.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import com.inoptra.employeedepartmentdemo.models.Department;

import java.util.List;

/**
 * @Author: Shrikrishna Prabhumirashi
 * @Description:
 * Persistence layer which performs operations on Department entity
 **/
public interface DepartmentRepository extends JpaRepository<Department, Long> {


}
