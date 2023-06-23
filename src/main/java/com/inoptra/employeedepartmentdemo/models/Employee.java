package com.inoptra.employeedepartmentdemo.models;

import lombok.Data;

import javax.persistence.*;

/**
 * @Author: Shrikrishna Prabhumirashi
 * @Description:
 * Represents Employee entity
 **/
@Entity
@Table(name = "EMPLOYEE")
@Data
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "EMPLOYEE_ID")
	private Long id;

	private String name;

	@OneToOne
	private Salary salary;

	@OneToOne
	private Department department;
    
}
