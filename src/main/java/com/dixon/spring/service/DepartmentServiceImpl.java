package com.dixon.spring.service;

import com.dixon.spring.entity.Department;
import com.dixon.spring.error.DepartmentNotFoundException;
import com.dixon.spring.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.stereotype.Service;

/**
 * @author dixon
 */

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class DepartmentServiceImpl implements DepartmentService{

    @Autowired
    private DepartmentRepository departmentRepository;

    @Override
    public Department saveDepartment(Department department) {
        return departmentRepository.save(department);
    }

    @Override
    public List<Department> fetchDepartmentList() {
        return departmentRepository.findAll();
    }

    @Override
    public Department fetchDepartment(Long departmentId) throws DepartmentNotFoundException {

        Optional<Department> department = departmentRepository.findById(departmentId);

        if(!department.isPresent()) {

            throw new DepartmentNotFoundException("Department not available");
        }

        return department.get();
    }

    @Override
    public void deleteDepartment(Long departmentId) {
        departmentRepository.deleteById(departmentId);
    }

    @Override
    public Department updateDepartment(Long departmentId, Department department) {

        Department departmentFromDB = departmentRepository.findById(departmentId).get();

        if(Objects.nonNull(department.getDepartmentName()) && !"".equalsIgnoreCase(department.getDepartmentName())) {
            departmentFromDB.setDepartmentName(department.getDepartmentName());
        }
        if(Objects.nonNull(department.getDepartmentAddress()) && !"".equalsIgnoreCase(department.getDepartmentAddress())) {
            departmentFromDB.setDepartmentAddress(department.getDepartmentAddress());
        }
        if(Objects.nonNull(department.getDepartmentCode()) && !"".equalsIgnoreCase(department.getDepartmentCode())) {
            departmentFromDB.setDepartmentCode(department.getDepartmentCode());
        }
        return departmentRepository.save(departmentFromDB);
    }

    @Override
    public Department fetchDepartmentByName(String departmentName) {

        return departmentRepository.findByDepartmentNameIgnoreCase(departmentName);
    }


}
