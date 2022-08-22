package com.inoptra.employeedepartmentdemo.services.impl;

import com.inoptra.employeedepartmentdemo.exceptions.DepartmentNotFoundException;
import com.inoptra.employeedepartmentdemo.models.Department;
import com.inoptra.employeedepartmentdemo.repositories.DepartmentRepository;
import com.inoptra.employeedepartmentdemo.services.DepartmentService;
import com.inoptra.employeedepartmentdemo.services.EmployeeService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
@RequiredArgsConstructor
public class DepartmentServiceImpl implements DepartmentService {

    private final EmployeeService employeeService;

    private final DepartmentRepository departmentRepository;

    @Override
    public List<Department> getDepartments() {
        return departmentRepository.findAll();
    }

    @Override
    public Department getDepartment(long id) {
        return getDepartmentById(id);
    }

    private Department getDepartmentById(long id) {
        Optional<Department> existingDepartmentOptional = departmentRepository.findById(id);
        if (existingDepartmentOptional.isPresent()) {
            return existingDepartmentOptional.get();
        } else {
            throw new DepartmentNotFoundException(id);
        }
    }

    @Override
    public Department addDepartment(Department department) {
        return departmentRepository.save(department);
    }

    @Override
    public Department updateDepartment(long id, Department department) {
        Department existingDepartment = getDepartmentById(id);
        existingDepartment.setName(department.getName());
        existingDepartment.setEmployees(department.getEmployees());
        return departmentRepository.save(existingDepartment);
    }

    @Override
    public void deleteDepartment(long id) {
        Department existingDepartment = getDepartmentById(id);
        departmentRepository.delete(existingDepartment);
    }

    @Override
    public Optional<Double> getSalaryForTheDepartment(Department department) {
        Double salary = null;
        if (!CollectionUtils.isEmpty(department.getEmployees())) {
            salary = department.getEmployees().stream().mapToDouble(employeeService::getSalary).sum();
        }
        return Optional.of(salary);
    }
}
