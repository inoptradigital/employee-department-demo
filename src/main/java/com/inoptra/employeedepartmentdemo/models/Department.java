package com.inoptra.employeedepartmentdemo.models;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

/**
 * @Author: Shrikrishna Prabhumirashi
 * @Description:
 * Represents {@code Department} entity
 **/
@Entity
@Table(name = "DEPARTMENT")
@Data
public class Department {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "DEPARTMENT_ID")
	private Long id;

	private String name;

	@OneToMany
	private List<Employee> employees;
    
}
