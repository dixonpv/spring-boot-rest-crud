package com.dixon.spring.service;


import com.dixon.spring.entity.Department;
import com.dixon.spring.error.DepartmentNotFoundException;

import java.util.List;

/**
 * @author dixon
 */

public interface DepartmentService {

    public Department saveDepartment(Department department);

    List<Department> fetchDepartmentList();

    Department fetchDepartment(Long departmentId) throws DepartmentNotFoundException;

    void deleteDepartment(Long departmentId);

    Department updateDepartment(Long departmentId, Department department);

    Department fetchDepartmentByName(String departmentName);
}
