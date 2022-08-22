package com.inoptra.employeedepartmentdemo.repositories;

import com.inoptra.employeedepartmentdemo.models.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

/**
 * @Author: Shrikrishna Prabhumirashi
 * @Description:
 * Persistence layer which performs operations on Employee entity
 **/
@RepositoryRestResource(collectionResourceRel = "employee", path = "employees")
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
