package com.dixon.spring.controller;

import com.dixon.spring.entity.Department;
import com.dixon.spring.error.DepartmentNotFoundException;
import com.dixon.spring.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * @author dixon
 */

@RestController

public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;



    @PostMapping("/departments")
    public Department saveDepartment(@Valid @RequestBody Department department){
        return departmentService.saveDepartment(department);
    }

    @GetMapping("/departments")
    public List<Department> fetchDepartmentList() {
        return departmentService.fetchDepartmentList();
    }

    @GetMapping("/departments/{id}")
    public Department fetchDepartmentById(@PathVariable("id") Long departmentId) throws DepartmentNotFoundException {
        return departmentService.fetchDepartment(departmentId);
    }

    @DeleteMapping("/departments/{id}")
    public String deleteDepartmentById(@PathVariable("id") Long departmentId) {
        departmentService.deleteDepartment(departmentId);
        return "department delete successfully";
    }

    @PutMapping("/departments/{id}")
    public Department updateDepartment(@PathVariable("id") Long departmentId, @RequestBody Department department) {
        return departmentService.updateDepartment(departmentId,department);
    }

    @GetMapping("/departments/name/{name}")
    public Department fetchDepartmentByName(@PathVariable("name") String departmentName) {
        return departmentService.fetchDepartmentByName(departmentName);
    }
}
