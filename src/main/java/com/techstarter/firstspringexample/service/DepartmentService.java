package com.techstarter.firstspringexample.service;

import com.techstarter.firstspringexample.entity.Department;
import com.techstarter.firstspringexample.exception.DepartmentNotFoundException;

import java.util.List;

public interface DepartmentService {
    public Department saveDepartment(Department department);

    public List<Department> fetchDepartmentList();

    public Department fetchDepartmentById(Long departmentId) throws DepartmentNotFoundException;

    public void deleteDepartmentById(Long departmentId);

    public Department updateDepartment(Long id, Department department);

    public Department fetchDepartmentByName(String departmentName);
}
