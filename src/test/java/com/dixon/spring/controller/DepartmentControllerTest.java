package com.dixon.spring.controller;

import com.dixon.spring.entity.Department;
import com.dixon.spring.error.DepartmentNotFoundException;
import com.dixon.spring.service.DepartmentService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 * @author dixon
 */

@WebMvcTest(DepartmentController.class)
class DepartmentControllerTest {

    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private DepartmentService departmentService;
    private Department department;

    @BeforeEach
    void setUp() {

        department = Department.builder().departmentAddress("Bangalore").departmentName("IT").departmentCode("IT001").departmentId(1L).build();

    }

    @Test
    void saveDepartment() throws Exception {

        Department departmentInput = Department.builder().departmentAddress("Bangalore").departmentName("IT").departmentCode("IT001").build();

        Mockito.when(departmentService.saveDepartment(departmentInput)).thenReturn(department);

        mockMvc.perform(post("/departments")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\n" +
                        "  \"departmentName\": \"IT\",\n" +
                        "  \"departmentAddress\": \"Bangalore\",\n" +
                        "  \"departmentCode\": \"IT001\"\n" +
                        "}")).andExpect(status().isOk());
    }

    @Test
    void fetchDepartmentById() throws Exception {

        Mockito.when(departmentService.fetchDepartment(1L)).thenReturn(department);

        mockMvc.perform(get("/departments/1")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.departmentName").value(department.getDepartmentName()));

    }
}