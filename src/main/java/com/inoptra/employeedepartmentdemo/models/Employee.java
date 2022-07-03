package com.inoptra.employeedepartmentdemo.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

/**
 * @Author: Shrikrishna Prabhumirashi
 * @Description:
 * Represents Employee entity
 **/
@Entity
@Getter
@Setter
public class Employee {

	@Id
	@GeneratedValue
	private Long id;

	private String name;

	@OneToOne(mappedBy = "employee", fetch = FetchType.LAZY,
			cascade = CascadeType.ALL)
	private Salary salary;

	@ManyToOne(fetch = FetchType.LAZY)
	@JsonBackReference
	private Department department;

}
