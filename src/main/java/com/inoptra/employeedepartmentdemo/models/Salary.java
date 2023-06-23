package com.inoptra.employeedepartmentdemo.models;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

/* @Author: Shrikrishna Prabhumirashi
 * @Description:
 * SalaryComponent is dependent upon base salary and can be calculated as baseSalary multiplied by respective factor.
 *  i.e. SalaryComponent_amount = baseSalary * factor;
 *  Actual salary can be calculated as sum of all SalaryComponent amounts.
 * */
@Entity
@Table(name = "SALARY")
@Data
public class Salary {
	@Id
	private Long id;
	private double baseSalary;
	@OneToMany
	private List<SalaryComponent> salaryComponents;
}
