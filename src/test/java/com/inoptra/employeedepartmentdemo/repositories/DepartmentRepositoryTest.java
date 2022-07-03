package com.inoptra.employeedepartmentdemo.repositories;

import com.inoptra.employeedepartmentdemo.TestUtil;
import com.inoptra.employeedepartmentdemo.models.Department;
import com.inoptra.employeedepartmentdemo.models.Employee;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
public class DepartmentRepositoryTest {

    @Autowired
    private TestEntityManager testEntityManager;

    @Autowired
    private DepartmentRepository departmentRepository;

    @Test
    public void testFindById(){
        Department department = TestUtil.buildDepartment("HR");
        Employee employee = TestUtil.buildEmployee("John Doe");
        department.addEmployee(employee);
        Department dbDepartment = testEntityManager.persist(department);

        Assertions.assertEquals(department.getId(), dbDepartment.getId());
        Assertions.assertEquals(department.getName(), dbDepartment.getName());

        Department foundDepartment = departmentRepository.findById(dbDepartment.getId()).get();
        Assertions.assertEquals(dbDepartment.getName(), foundDepartment.getName());
        Assertions.assertEquals(dbDepartment.getEmployees().get(0).getName(), employee.getName());
    }

    @Test
    public void testFindByName(){
        Department department = TestUtil.buildDepartment("IT");
        Employee employee = TestUtil.buildEmployee("Jane Doe");
        department.addEmployee(employee);
        Department dbDepartment = testEntityManager.persist(department);

        Assertions.assertEquals(department.getId(), dbDepartment.getId());
        Assertions.assertEquals(department.getName(), dbDepartment.getName());

        List<Department> departments = departmentRepository.findByName(department.getName());
        assertThat(departments).extracting(Department::getName).containsOnly(department.getName());
        Assertions.assertEquals(dbDepartment.getEmployees().get(0).getName(), employee.getName());
    }

}
