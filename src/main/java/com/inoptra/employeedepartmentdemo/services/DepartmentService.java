package com.inoptra.employeedepartmentdemo.services;

import com.inoptra.employeedepartmentdemo.exceptions.DepartmentNotFound;
import com.inoptra.employeedepartmentdemo.models.Department;
import com.inoptra.employeedepartmentdemo.repositories.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

}
