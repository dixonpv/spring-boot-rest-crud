package com.dixon.spring.repository;

import com.dixon.spring.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author dixon
 */

@Repository
public interface DepartmentRepository extends JpaRepository<Department,Long> {
    public Department findByDepartmentName(String departmentName);
    public Department findByDepartmentNameIgnoreCase(String departmentName);
}
