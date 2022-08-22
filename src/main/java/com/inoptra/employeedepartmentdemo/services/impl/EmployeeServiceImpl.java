package com.inoptra.employeedepartmentdemo.services.impl;

import com.inoptra.employeedepartmentdemo.exceptions.EmployeeNotFoundException;
import com.inoptra.employeedepartmentdemo.models.Employee;
import com.inoptra.employeedepartmentdemo.repositories.EmployeeRepository;
import com.inoptra.employeedepartmentdemo.services.EmployeeService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {
    private final EmployeeRepository employeeRepository;

    @Override
    public List<Employee> getEmployees() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee addEmployee(Employee employee) {
        return employeeRepository.save(employee);

    }

    @Override
    public Employee updateEmployee(long id, Employee employee) {
        Optional<Employee> employeeOptional = employeeRepository.findById(id);
        if (employeeOptional.isPresent()) {
            Employee existingEmp = employeeOptional.get();
            existingEmp.setName(employee.getName());
            existingEmp.setSalary(employee.getSalary());
            existingEmp.setDepartment(employee.getDepartment());
            return employeeRepository.save(existingEmp);
        } else {
            throw new EmployeeNotFoundException(id);
        }
    }

    @Override
    public void deleteEmployee(long id) {
        Optional<Employee> employeeOptional = employeeRepository.findById(id);
        if (employeeOptional.isPresent()) {
            employeeRepository.deleteById(id);
        } else {
            throw new EmployeeNotFoundException(id);
        }
    }

    /**
     * Compute and return salary for given employee
     *
     * @return Calculate salary of employee and return the same
     * @return 0.0, otherwise.
     */
    @Override
    public double getSalary(Employee employee) {
        return employee.getSalary().getSalaryComponents().parallelStream().reduce(0.0,
            (total, sc) -> total + (sc.getFactor() * employee.getSalary().getBaseSalary()), Double::sum);
    }
}
