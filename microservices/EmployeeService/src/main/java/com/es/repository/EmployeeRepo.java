package com.es.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.es.entity.Employee;

public interface EmployeeRepo extends JpaRepository<Employee, Long> {

	List<Employee> findByEmpId(long empId);

}
