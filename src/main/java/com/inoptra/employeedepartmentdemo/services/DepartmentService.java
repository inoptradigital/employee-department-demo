package com.inoptra.employeedepartmentdemo.services;

import com.inoptra.employeedepartmentdemo.repositories.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @Author: Shrikrishna Prabhumirashi
 * @Description:
 * Service layer contract which supports operations on Department object
 **/
//TODO: Define Interface for this service to comply with Strategy design pattern.
public class DepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository;

}
