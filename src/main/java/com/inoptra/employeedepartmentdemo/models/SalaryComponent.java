package com.inoptra.employeedepartmentdemo.models;

import lombok.ToString;

import javax.persistence.*;

/* @Author: Shrikrishna Prabhumirashi
 * @Description:
 * SalaryComponent is dependent upon base salary and can be calculated as baseSalary multiplied by respective factor.
 *  i.e. SalaryComponent_amount = baseSalary * factor;
 *  Actual salary can be calculated as sum of all SalaryComponent amounts.
 * */
@Entity
@Table(name = "salary_components")
@ToString
public class SalaryComponent {

	@Id
	private Long id;

	private String name;

	private double factor;

	@ManyToOne
	@JoinColumn(name="salary_id", nullable=false)
	private Salary salary;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getFactor() {
		return factor;
	}

	public void setFactor(double factor) {
		this.factor = factor;
	}
}
