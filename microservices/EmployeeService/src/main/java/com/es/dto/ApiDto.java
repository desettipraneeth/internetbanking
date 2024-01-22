package com.es.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ApiDto {

	private List<EmployeeDto> employeeDto;
	private List<DepartmentDto> departmentDto;
	private List<OrganizationDto> organizationDto;

}
