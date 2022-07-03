package com.inoptra.employeedepartmentdemo.models;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

/* @Author: Shrikrishna Prabhumirashi
 * @Description:
 * SalaryComponent is dependent upon base salary and can be calculated as baseSalary multiplied by respective factor.
 *  i.e. SalaryComponent_amount = baseSalary * factor;
 *  Actual salary can be calculated as sum of all SalaryComponent amounts.
 * */
@Entity
@Getter
@Setter
public class Salary {

	@Id
	@GeneratedValue
	private Long id;

	private double baseSalary;

	@OneToMany(mappedBy = "salary", fetch = FetchType.EAGER, //TODO: fix JSON failed to lazily init a collection.
			cascade = CascadeType.ALL, orphanRemoval = true)
	@JsonManagedReference
	private List<SalaryComponent> salaryComponents;

	@ManyToOne(fetch = FetchType.LAZY)
	private Employee employee;

}
