package com.techstarter.firstspringexample.repository;

import com.techstarter.firstspringexample.entity.Department;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class DepartmentRepositoryTest {

    @Autowired
    private DepartmentRepository departmentRepository;

    @Autowired
    private TestEntityManager testEntityManager;

    @BeforeEach
    void setUp() {
        Department department = Department.builder()
                .departmentName("CDS12")
                .departmentCode("IT-001")
                .departmentAddress("Bangalore")
                .build();
        testEntityManager.persist(department);
    }

    @Test
    public void whenValidDepartmentName_thenDepartmentShouldFound(){
        Department dept = departmentRepository.findById(1L).get();
        assertEquals(dept.getDepartmentName(),"CDS12");
    }


}