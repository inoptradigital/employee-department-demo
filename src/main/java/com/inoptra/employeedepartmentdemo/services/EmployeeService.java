package com.inoptra.employeedepartmentdemo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.inoptra.employeedepartmentdemo.models.Employee;
import com.inoptra.employeedepartmentdemo.repositories.EmployeeRepository;

/**
 * @Author: Shrikrishna Prabhumirashi
 * @Description:
 * Service layer contract which supports operations on Employee object
 **/
//TODO: Define Interface for this service to comply with Strategy design pattern.
public class EmployeeService {
	@Autowired
	private EmployeeRepository employeeRepository;
	
	/**
	 * Compute and return salary for given employee
	 * @return Calculate salary of employee and return the same if employee with given @param empId exists
	 * @return 0.0, otherwise.
	 */
	public double getSalary(long empId) {
		
		Optional<Employee> optEmployee = employeeRepository.findById(empId);
		
		if(!optEmployee.isPresent()) return 0.0;
		
		Employee emp = optEmployee.get();
		
		return this.calculateSalary(emp);
	}

	public double getTotalSalaryForAllDepartments(){
		List<Employee> employees = employeeRepository.findAll();
		if(employees.size()<1) return 0.0;

		double total = employees
						.stream()
						.map(emp -> this.calculateSalary(emp))
						.reduce(0.0, Double::sum);

		return total;
	}

	private double calculateSalary(Employee emp){
		return emp
				.getSalary()
				.getSalaryComponents()
				.parallelStream()
				.reduce(
						Double.valueOf(0.0),
						(total, sc) -> total + (sc.getFactor() *  emp.getSalary().getBaseSalary()),
						(c1, c2) -> c1 + c2
				);
	}
}
