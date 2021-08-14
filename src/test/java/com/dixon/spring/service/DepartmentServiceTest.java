package com.dixon.spring.service;

import com.dixon.spring.entity.Department;
import com.dixon.spring.repository.DepartmentRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author dixon
 */

@SpringBootTest
class DepartmentServiceTest {

    @Autowired
    private DepartmentService departmentService;

    @MockBean
    private DepartmentRepository departmentRepository;

    @BeforeEach
    void setUp() {

        Department department = Department.builder().departmentName("IT").departmentAddress("Ohio").departmentCode("IT082").departmentId(1).build();
        Mockito.when(departmentRepository.findByDepartmentNameIgnoreCase("IT")).thenReturn(department);

    }

    @Test
    @DisplayName("Get Data based on valid department")
    public void whenValidDepartmentName_thenDepartmentShouldFound() {

        String departmentName="IT";
        Department found = departmentService.fetchDepartmentByName(departmentName);
        assertEquals(departmentName,found.getDepartmentName());

    }
}