package com.prasi.department.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.prasi.department.entity.Department;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long> {

}
