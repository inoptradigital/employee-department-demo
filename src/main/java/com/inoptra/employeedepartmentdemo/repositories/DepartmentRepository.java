package com.inoptra.employeedepartmentdemo.repositories;

import com.inoptra.employeedepartmentdemo.models.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

/**
 * @Author: Shrikrishna Prabhumirashi
 * @Description:
 * Persistence layer which performs operations on Department entity
 **/
@RepositoryRestResource(collectionResourceRel = "department", path = "departments")
public interface DepartmentRepository extends JpaRepository<Department, Long> {
}
