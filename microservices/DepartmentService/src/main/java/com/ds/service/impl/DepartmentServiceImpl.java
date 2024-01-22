package com.ds.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ds.dto.DepartmentDto;
import com.ds.entity.Department;
import com.ds.repository.DepartmentRepo;
import com.ds.service.DepartmentService;

@Service
public class DepartmentServiceImpl implements DepartmentService {

	@Autowired
	DepartmentRepo dr;

	@Override
	public DepartmentDto saveDep(DepartmentDto departmentDto) {

		Department dp = Department.builder().depName(departmentDto.getDepName()).depDes(departmentDto.getDepDes())
				.depCode(departmentDto.getDepCode()).build();

		Department department = dr.save(dp);

		DepartmentDto dpdto = new DepartmentDto(department.getDepId(), department.getDepName(), department.getDepDes(),
				department.getDepCode());

		return dpdto;
	}

	@Override
	public List<DepartmentDto> getDep(String depcode) {

		List<Department> findByDepCode = dr.findByDepCode(depcode);

		List<DepartmentDto> deplist = findByDepCode.stream()
				.map(x -> new DepartmentDto(x.getDepId(), x.getDepName(), x.getDepDes(), x.getDepCode()))
				.collect(Collectors.toList());

		return deplist;
	}

}
