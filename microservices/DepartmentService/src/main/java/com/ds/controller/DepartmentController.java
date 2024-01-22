package com.ds.controller;

import com.ds.dto.DepartmentDto;
import com.ds.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/dep")
public class DepartmentController {

	@Autowired
	DepartmentService ds;


	@PostMapping("/savedep")
	public ResponseEntity<DepartmentDto> saveDept(@RequestBody DepartmentDto dd) {
		DepartmentDto saveDep = ds.saveDep(dd);

		return new ResponseEntity<DepartmentDto>(saveDep, HttpStatus.CREATED);
	}

	@GetMapping("/getdep/{depCode}")
	public ResponseEntity<List<DepartmentDto>> getDept(@PathVariable String depCode) {
		List<DepartmentDto> saveDep = ds.getDep(depCode);
		return new ResponseEntity<List<DepartmentDto>>(saveDep, HttpStatus.OK);
	}

}
