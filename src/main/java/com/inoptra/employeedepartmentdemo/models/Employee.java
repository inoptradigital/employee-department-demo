package com.inoptra.employeedepartmentdemo.models;

import jakarta.persistence.*;
import lombok.ToString;


/**
 * @Author: Shrikrishna Prabhumirashi
 * @Description:
 * Represents Employee entity
 **/
@Entity
@Table(name = "employees")
@ToString
public class Employee {

	@Id
	private Long id;

	private String name;

	@OneToOne
	@JoinColumn(name="salary_id", nullable=false)
	private Salary salary;

	@ManyToOne
	@JoinColumn(name="department_id", nullable=false)
	private Department department;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Salary getSalary() {
		return salary;
	}

	public void setSalary(Salary salary) {
		this.salary = salary;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}
    
}
