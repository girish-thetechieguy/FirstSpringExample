package com.techstarter.firstspringexample.repository;

import com.techstarter.firstspringexample.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepository extends JpaRepository<Department,Long> {

    public Department findByDepartmentName(String departmentName);

}
