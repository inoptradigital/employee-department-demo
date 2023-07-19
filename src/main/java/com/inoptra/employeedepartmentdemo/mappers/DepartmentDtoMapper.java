package com.inoptra.employeedepartmentdemo.mappers;

import com.inoptra.employeedepartmentdemo.dtos.DepartmentDto;
import com.inoptra.employeedepartmentdemo.models.Department;
import org.mapstruct.Mapper;

@Mapper
public interface DepartmentDtoMapper {

    DepartmentDto mapDepartmentToDto(Department department);
}
