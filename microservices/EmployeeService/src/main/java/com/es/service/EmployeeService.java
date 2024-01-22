package com.es.service;

import java.util.List;

import com.es.dto.ApiDto;
import com.es.dto.EmployeeDto;

public interface EmployeeService {

	EmployeeDto saveEmp(EmployeeDto employeeDto);

	List<EmployeeDto> getEmp(long empId);

	ApiDto getEmpDep(long empId,String depcode,String orgCode);

}
