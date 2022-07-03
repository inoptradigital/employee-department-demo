package com.inoptra.employeedepartmentdemo.services;

import com.inoptra.employeedepartmentdemo.TestUtil;
import com.inoptra.employeedepartmentdemo.models.Employee;
import com.inoptra.employeedepartmentdemo.models.Salary;
import com.inoptra.employeedepartmentdemo.models.SalaryComponent;
import com.inoptra.employeedepartmentdemo.repositories.EmployeeRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class EmployeeServiceTest {

    @Mock
    private EmployeeRepository employeeRepository;

    @InjectMocks
    private EmployeeService employeeService;

    @Test
    public void testGetSalary(){
        Employee employee = TestUtil.buildEmployee("Joe TestSalary");
        employee.setId(1L);

        SalaryComponent salaryComponentTwo = TestUtil.buildSalaryComponent("two", 2);
        SalaryComponent salaryComponentThree = TestUtil.buildSalaryComponent("three", 3);

        Salary salary = TestUtil.buildSalary(10000);
        salary.addSalaryComponent(salaryComponentTwo);
        salary.addSalaryComponent(salaryComponentThree);

        employee.setSalary(salary);

        when(employeeRepository.findById(1L)).thenReturn(java.util.Optional.of(employee));

        double total = employeeService.getSalary(1L);
        Assertions.assertEquals(50000, total);
    }

}