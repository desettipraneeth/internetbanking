package com.ds.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ds.entity.Department;

public interface DepartmentRepo extends JpaRepository<Department, Long> {

	List<Department> findByDepCode(String depCode);

}
