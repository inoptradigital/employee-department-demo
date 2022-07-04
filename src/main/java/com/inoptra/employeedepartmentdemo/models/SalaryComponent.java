package com.inoptra.employeedepartmentdemo.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

/* @Author: Shrikrishna Prabhumirashi
 * @Description:
 * SalaryComponent is dependent upon base salary and can be calculated as baseSalary multiplied by respective factor.
 *  i.e. SalaryComponent_amount = baseSalary * factor;
 *  Actual salary can be calculated as sum of all SalaryComponent amounts.
 * */
@Entity
@Getter
@Setter
public class SalaryComponent {

	@Id
	@GeneratedValue
	private Long id;

	private String name;

	private double factor;

	protected SalaryComponent(){}

	public SalaryComponent(String name, double factor){
		this.name = name;
		this.factor = factor;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JsonBackReference
	private Salary salary;
}
