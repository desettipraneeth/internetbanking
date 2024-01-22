package com.ds.service;

import java.util.List;

import com.ds.dto.DepartmentDto;

public interface DepartmentService {

	DepartmentDto saveDep(DepartmentDto departmentDto);

	List<DepartmentDto> getDep(String depCode);

}
