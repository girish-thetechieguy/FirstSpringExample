package com.techstarter.firstspringexample.controller;

import com.techstarter.firstspringexample.entity.Department;
import com.techstarter.firstspringexample.exception.DepartmentNotFoundException;
import com.techstarter.firstspringexample.service.DepartmentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.convert.PeriodUnit;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class DepartmentController {

    private final Logger LOGGER = LoggerFactory.getLogger(DepartmentController.class);
    @Autowired
    private DepartmentService departmentService;

    @PostMapping("/departments")
    public Department saveDepartment(@Valid @RequestBody Department department){
        LOGGER.info("Inside saveDepartment() under DepartmentController");
        return departmentService.saveDepartment(department);
    }

    @GetMapping("/departments")
    public List<Department> fetchDepartmentsList(){
        LOGGER.info("Inside fetchDepartmentsList() under DepartmentController");
        return departmentService.fetchDepartmentList();
    }

    @GetMapping("/departments/{id}")
    public Department fetchDepartmentById(@PathVariable("id") Long departmentId) throws DepartmentNotFoundException {
        LOGGER.info("Inside fetchDepartmentById() under DepartmentController");
        return departmentService.fetchDepartmentById(departmentId);
    }

    @GetMapping("/departments/name/{name}")
    public Department fetchDepartmentByName(@PathVariable("name") String departmentName){
        return departmentService.fetchDepartmentByName(departmentName);
    }

    @DeleteMapping("/departments/{id}")
    public String deleteDepartmentById(@PathVariable("id") Long departmentId){
        LOGGER.info("Inside deleteDepartmentById() under DepartmentController");
        departmentService.deleteDepartmentById(departmentId);
        return "Deleted the department successfully";
    }

    @PutMapping("/departments/{id}")
    public Department updateDepartment(@PathVariable("id") Long id, @Valid @RequestBody Department department){
        LOGGER.info("Inside updateDepartment() under DepartmentController");
        return departmentService.updateDepartment(id, department);
    }


}
