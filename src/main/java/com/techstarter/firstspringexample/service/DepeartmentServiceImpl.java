package com.techstarter.firstspringexample.service;

import com.techstarter.firstspringexample.entity.Department;
import com.techstarter.firstspringexample.exception.DepartmentNotFoundException;
import com.techstarter.firstspringexample.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class DepeartmentServiceImpl implements DepartmentService{
    /**
     * @return
     */

    @Autowired
    private DepartmentRepository departmentRepository;
    @Override
    public Department saveDepartment(Department department) {
        return departmentRepository.save(department);
    }

    /**
     * @return
     */
    @Override
    public List<Department> fetchDepartmentList() {
        return departmentRepository.findAll();
    }

    /**
     * @param departmentId
     * @return
     */
    @Override
    public Department fetchDepartmentById(Long departmentId) throws DepartmentNotFoundException {
        Optional<Department> department = departmentRepository.findById(departmentId);
        if (!department.isPresent()){
            throw new DepartmentNotFoundException("Department not Available!");
        }
        return department.get();
    }

    /**
     * @param departmentId
     * @return
     */
    @Override
    public void deleteDepartmentById(Long departmentId) {
        departmentRepository.deleteById(departmentId);
    }

    /**
     * @param id
     * @param department
     * @return
     */
    @Override
    public Department updateDepartment(Long id, Department department) {
        Department receivedDepartment = (Department)departmentRepository.findById(id).get();
        if(Objects.nonNull(department.getDepartmentName()) && !"".equalsIgnoreCase(department.getDepartmentName())){
            receivedDepartment.setDepartmentName(department.getDepartmentName());
        }
        if(Objects.nonNull(department.getDepartmentAddress())&& !"".equalsIgnoreCase(department.getDepartmentAddress())){
            receivedDepartment.setDepartmentAddress(department.getDepartmentAddress());
        }
        if(Objects.nonNull(department.getDepartmentCode())&& !"".equalsIgnoreCase(department.getDepartmentAddress())){
            receivedDepartment.setDepartmentCode(department.getDepartmentCode());
        }
        return departmentRepository.save(receivedDepartment);
    }

    /**
     * @param departmentName
     * @return
     */
    @Override
    public Department fetchDepartmentByName(String departmentName) {
        return departmentRepository.findByDepartmentName(departmentName);
    }


}
