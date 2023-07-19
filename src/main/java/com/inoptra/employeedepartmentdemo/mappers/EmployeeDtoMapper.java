package com.inoptra.employeedepartmentdemo.mappers;

import com.inoptra.employeedepartmentdemo.dtos.EmployeeDto;
import com.inoptra.employeedepartmentdemo.models.Employee;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface EmployeeDtoMapper {

    EmployeeDto mapEmployeeToDto(Employee employee);
    List<EmployeeDto> mapEmployeeListToDtoList(List<Employee> employee);
}
