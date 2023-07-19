package com.inoptra.employeedepartmentdemo.services;

import com.inoptra.employeedepartmentdemo.dtos.DepartmentDto;
import com.inoptra.employeedepartmentdemo.exceptions.DepartmentNotFoundException;
import com.inoptra.employeedepartmentdemo.mappers.DepartmentDtoMapper;
import com.inoptra.employeedepartmentdemo.models.Department;
import com.inoptra.employeedepartmentdemo.repositories.DepartmentRepository;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: Shrikrishna Prabhumirashi
 * @Description:
 * Service layer contract which supports operations on Department object
 **/
@Service
public class DepartmentService {

    private final DepartmentDtoMapper departmentDtoMapper = Mappers.getMapper(DepartmentDtoMapper.class);

    @Autowired
    private DepartmentRepository departmentRepository;

    public List<Department> getAllDepartments() {
        return departmentRepository.findAll();
    }

    public int getTotalNumberOfDepartments() {
        return (int) departmentRepository.count();
    }

    public DepartmentDto getDepartmentInfo(final long deptId) throws DepartmentNotFoundException {
        if(!departmentRepository.existsById(deptId)) {
            throw new DepartmentNotFoundException(deptId);
        }

        return departmentDtoMapper.mapDepartmentToDto(departmentRepository.findById(deptId).get());
    }
}
