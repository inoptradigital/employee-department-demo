package com.inoptra.employeedepartmentdemo.dtos;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@Getter
@Builder
@EqualsAndHashCode
public class EmployeeDto {

    private Long id;

    private String name;
}
