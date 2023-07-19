package com.inoptra.employeedepartmentdemo.dtos;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@Getter
@Builder
@EqualsAndHashCode
public class DepartmentDto {

    private Long id;

    private String name;

}
