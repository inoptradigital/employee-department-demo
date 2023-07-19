package com.inoptra.employeedepartmentdemo.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.ToString;

import java.util.List;

/* @Author: Shrikrishna Prabhumirashi
 * @Description:
 * SalaryComponent is dependent upon base salary and can be calculated as baseSalary multiplied by respective factor.
 *  i.e. SalaryComponent_amount = baseSalary * factor;
 *  Actual salary can be calculated as sum of all SalaryComponent amounts.
 * */
@Entity
@Table(name = "salaries")
@ToString
public class Salary {

	@Id
	private Long id;

	private double baseSalary;

	@OneToMany(mappedBy="salary")
	private List<SalaryComponent> salaryComponents;

	public double getBaseSalary() {
		return baseSalary;
	}
	public void setBaseSalary(double baseSalary) {
		this.baseSalary = baseSalary;
	}
	public List<SalaryComponent> getSalaryComponents() {
		return salaryComponents;
	}
	public void setSalaryComponents(List<SalaryComponent> salaryComponents) {
		this.salaryComponents = salaryComponents;
	}
	
}
