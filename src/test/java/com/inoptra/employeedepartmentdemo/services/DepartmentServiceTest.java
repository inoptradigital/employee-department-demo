package com.inoptra.employeedepartmentdemo.services;

import com.inoptra.employeedepartmentdemo.TestUtil;
import com.inoptra.employeedepartmentdemo.models.Department;
import com.inoptra.employeedepartmentdemo.models.Employee;
import com.inoptra.employeedepartmentdemo.models.Salary;
import com.inoptra.employeedepartmentdemo.models.SalaryComponent;
import com.inoptra.employeedepartmentdemo.repositories.DepartmentRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class DepartmentServiceTest {

    @Mock
    private DepartmentRepository departmentRepository;

    @InjectMocks
    private DepartmentService departmentService;

    @Test
    public void testGetTotalSalaryForDepartment(){
        Department department = TestUtil.buildDepartment("HR");
        department.setId(1L);
        Employee employeeOne = TestUtil.buildEmployee("Joe One");
        employeeOne.setId(3L);

        SalaryComponent salaryComponentTwo = TestUtil.buildSalaryComponent("two", 2);
        SalaryComponent salaryComponentThree = TestUtil.buildSalaryComponent("three", 3);

        Salary salary = TestUtil.buildSalary(10000);
        salary.addSalaryComponent(salaryComponentTwo);
        salary.addSalaryComponent(salaryComponentThree);

        employeeOne.setSalary(salary);

        Employee employeeTwo = TestUtil.buildEmployee("Joe Two");
        employeeOne.setId(4L);

        SalaryComponent salaryComponentFour = TestUtil.buildSalaryComponent("two", 4);
        SalaryComponent salaryComponentFive = TestUtil.buildSalaryComponent("three", 5);

        Salary salaryTwo = TestUtil.buildSalary(20000);
        salaryTwo.addSalaryComponent(salaryComponentFour);
        salaryTwo.addSalaryComponent(salaryComponentFive);

        employeeTwo.setSalary(salaryTwo);

        department.addEmployee(employeeOne);
        department.addEmployee(employeeTwo);

        when(departmentRepository.findById(1L)).thenReturn(java.util.Optional.of(department));

        double total = departmentService.getTotalSalaryForDepartment(1L);
        Assertions.assertEquals(230000, total);
    }

    @Test
    public void testGetAverageSalaryForDepartment(){
        Department department = TestUtil.buildDepartment("HR");
        department.setId(1L);
        Employee employeeOne = TestUtil.buildEmployee("Joe One");
        employeeOne.setId(3L);

        SalaryComponent salaryComponentTwo = TestUtil.buildSalaryComponent("two", 2);
        SalaryComponent salaryComponentThree = TestUtil.buildSalaryComponent("three", 3);

        Salary salary = TestUtil.buildSalary(10000);
        salary.addSalaryComponent(salaryComponentTwo);
        salary.addSalaryComponent(salaryComponentThree);

        employeeOne.setSalary(salary);

        Employee employeeTwo = TestUtil.buildEmployee("Joe Two");
        employeeOne.setId(4L);

        SalaryComponent salaryComponentFour = TestUtil.buildSalaryComponent("two", 4);
        SalaryComponent salaryComponentFive = TestUtil.buildSalaryComponent("three", 5);

        Salary salaryTwo = TestUtil.buildSalary(20000);
        salaryTwo.addSalaryComponent(salaryComponentFour);
        salaryTwo.addSalaryComponent(salaryComponentFive);

        employeeTwo.setSalary(salaryTwo);

        department.addEmployee(employeeOne);
        department.addEmployee(employeeTwo);

        when(departmentRepository.findById(1L)).thenReturn(java.util.Optional.of(department));

        double average = departmentService.getAverageSalaryForDepartment(1L);
        Assertions.assertEquals(115000, average);
    }

}
