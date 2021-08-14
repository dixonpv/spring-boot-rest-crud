package com.dixon.spring.repository;

import com.dixon.spring.entity.Department;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author dixon
 */
@DataJpaTest
class DepartmentRepositoryTest {

    @Autowired
    private DepartmentRepository departmentRepository;

    @Autowired
    TestEntityManager testEntityManager;

    @BeforeEach
    void setUp() {

        Department department = Department.builder().departmentName("Mechanical").departmentAddress("India").departmentCode("MECH-11").build();
        testEntityManager.merge(department);

    }

    @Test
    @DisplayName("Get Data based on valid department")
    public void  whenValidDepartmentName_ThenDepartmentShouldFound() {

        String DepartmentName ="Mechanical";
        Department department = departmentRepository.findById(1L).get();
        assertEquals(department.getDepartmentName(),"Mechanical");

    }

}