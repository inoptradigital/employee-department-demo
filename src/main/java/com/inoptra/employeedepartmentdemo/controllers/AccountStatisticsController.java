package com.inoptra.employeedepartmentdemo.controllers;

import com.inoptra.employeedepartmentdemo.services.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.websocket.server.PathParam;

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
@RestController
public class AccountStatisticsController {

	@Autowired
	private AccountService accountService;

	@GetMapping("/all/total")
	public double getTotalSalaryForAllDepartments() {

		return accountService.getTotalSalaryForAllDepartments();
	}
	
	@GetMapping("/{deptId}/total")
	public double getTotalSalaryForDepartment(@PathVariable("deptId") final long deptId) {
		return accountService.getTotalSalaryForDepartment(deptId);
	}
	
	@GetMapping("/all/avg")
	public double getAverageSalaryForAllDepartments() {
		return accountService.getAverageSalaryForAllDepartments();
	}
	
	@GetMapping("/{deptId}/avg")
	public double getAverageSalaryForDepartment(@PathVariable("deptId") final long deptId) {
		return accountService.getAverageSalaryForDepartment(deptId);
	}
}
