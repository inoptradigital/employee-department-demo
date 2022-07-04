package com.inoptra.employeedepartmentdemo.controllers;

import com.inoptra.employeedepartmentdemo.services.DepartmentService;
import com.inoptra.employeedepartmentdemo.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
* @Author: Shrikrishna Prabhumirashi
* @Description:
* Supports Account keeping for Employees working under department
* Below are few operations supported by this controller
*  - Get total salary to be paid to a department
*  - Get total salary to be paid to all departments
*  - Get average salary to be paid to a department
*  - Get average salary to be paid to all departments
**/

@RequestMapping("/account/accountstats")
public class AccountStatisticsController {

	@Autowired
	private DepartmentService departmentService;

	@Autowired
	private EmployeeService employeeService;

	@GetMapping("/all/total")
	public double getTotalSalaryForAllDepartments() {
		return employeeService.getTotalSalaryForAllDepartments();
	}
	
	@GetMapping("/{deptId}/total")
	public double getTotalSalaryForDepartment() {
		return 0.0;
	}
	
	@GetMapping("/all/avg")
	public double getAverageSalaryForAllDepartments() {
		return employeeService.getAverageSalaryForAllDepartments();
	}
	
	@GetMapping("/{deptId}/avg")
	public double getAverageSalaryForDepartment() {
		return 0.0;	
	}
}
