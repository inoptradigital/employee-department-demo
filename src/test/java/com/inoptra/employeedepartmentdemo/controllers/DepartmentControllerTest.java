package com.inoptra.employeedepartmentdemo.controllers;

import com.inoptra.employeedepartmentdemo.TestUtil;
import com.inoptra.employeedepartmentdemo.exceptions.DepartmentNotFound;
import com.inoptra.employeedepartmentdemo.models.Department;
import com.inoptra.employeedepartmentdemo.services.DepartmentService;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.internal.verification.VerificationModeFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(DepartmentController.class)
public class DepartmentControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private DepartmentService departmentService;

    @Test
    public void testGetDepartmentById() throws Exception{
        final String name = "Test department";
        Department department = TestUtil.buildDepartment(name);
        department.setId(1L);

        given(departmentService.getDepartmentById(1L)).willReturn(department);

        mvc.perform(MockMvcRequestBuilders
                .get("/departments/{departmentId}", 1L)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.id").value(department.getId()))
                .andExpect(MockMvcResultMatchers.jsonPath("$.name").value(name));

        verify(departmentService, VerificationModeFactory.times(1)).getDepartmentById(1L);
    }

    @Test
    public void testGetDepartmentByIdNotFound() throws Exception{

        given(departmentService.getDepartmentById(1L)).willThrow(new DepartmentNotFound(1L));

        mvc.perform(MockMvcRequestBuilders
                .get("/departments/{departmentId}", 1L)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound())
                .andExpect(result ->
                        Assertions.assertEquals("Could not find department 1",
                                result.getResolvedException().getMessage())
                );

        verify(departmentService, VerificationModeFactory.times(1)).getDepartmentById(1L);
    }

    @Test
    public void testAddDepartmentPost() throws Exception{
        final String name = "Test department";
        Department department = TestUtil.buildDepartment(name);
        department.setId(1L);

        given(departmentService.addDepartment(Mockito.any())).willReturn(department);

        mvc.perform(MockMvcRequestBuilders
                .post("/departments/add")
                .content(TestUtil.asJsonString(department))
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.id").value(1))
                .andExpect(MockMvcResultMatchers.jsonPath("$.name").value(name));

        verify(departmentService, VerificationModeFactory.times(1)).addDepartment(Mockito.any());
    }

}