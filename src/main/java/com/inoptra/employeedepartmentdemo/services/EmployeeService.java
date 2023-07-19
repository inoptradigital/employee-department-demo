package com.inoptra.employeedepartmentdemo.services;

import com.inoptra.employeedepartmentdemo.dtos.EmployeeDto;
import com.inoptra.employeedepartmentdemo.exceptions.DepartmentNotFoundException;
import com.inoptra.employeedepartmentdemo.mappers.EmployeeDtoMapper;
import com.inoptra.employeedepartmentdemo.models.Employee;
import com.inoptra.employeedepartmentdemo.repositories.EmployeeRepository;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * @Author: Shrikrishna Prabhumirashi
 * @Description:
 * Service layer contract which supports operations on Employee object
 **/
@Service
public class EmployeeService {

	private final EmployeeDtoMapper employeeDtoMapper = Mappers.getMapper(EmployeeDtoMapper.class);
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

	public int getEmployeeStrength() {
		return (int) employeeRepository.count();
	}

	public List<EmployeeDto> getAllEmployees() {
		// TODO(sreejit): make it pageable
		return employeeDtoMapper.mapEmployeeListToDtoList(employeeRepository.findAll());
	}

	public List<EmployeeDto> getEmployeesForDepartment(final long deptId) throws DepartmentNotFoundException {
		return employeeDtoMapper.mapEmployeeListToDtoList(employeeRepository.findByDepartmentId(deptId));
	}

}
