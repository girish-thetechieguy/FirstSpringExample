package com.techstarter.firstspringexample.service;

import com.techstarter.firstspringexample.entity.Department;
import com.techstarter.firstspringexample.repository.DepartmentRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class DepartmentServiceTest {

    @Autowired
    private DepartmentService departmentService;

    @MockBean
    private DepartmentRepository departmentRepository;

    @BeforeEach
    void setUp() {
        Department department = Department.builder()
                .departmentName("CDS12")
                .departmentId(1L)
                .departmentCode("IT-001")
                .departmentAddress("Bangalore")
                .build();
        Mockito.when(departmentRepository.findByDepartmentName("CDS12"))
                .thenReturn(department);
    }

    @Test
    @DisplayName("Get data based on Valid Department name")
    public void whenValidDepartmentName_thenDepartmentShouldFound(){
        String departmentName = "CDS12";
        Department foundDepartment = departmentService.fetchDepartmentByName(departmentName);
        assertEquals(departmentName, foundDepartment.getDepartmentName());
    }
}