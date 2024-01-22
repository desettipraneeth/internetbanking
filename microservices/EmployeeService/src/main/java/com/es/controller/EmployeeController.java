package com.es.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.es.dto.ApiDto;
import com.es.dto.EmployeeDto;
import com.es.service.EmployeeService;

@RestController
@RequestMapping("/emp")
public class EmployeeController {

    @Autowired
    EmployeeService ds;

    @PostMapping("/saveemp")
    public ResponseEntity<EmployeeDto> saveDept(@RequestBody EmployeeDto ed) {
        EmployeeDto saveDep = ds.saveEmp(ed);

        return new ResponseEntity<EmployeeDto>(saveDep, HttpStatus.CREATED);
    }

    @GetMapping(value = "/getemp/{empId}", headers = "Host=lms.docs.localhost:8081")
    public ResponseEntity<List<EmployeeDto>> getDept(@PathVariable long empId) {
        List<EmployeeDto> saveDep = ds.getEmp(empId);
        return new ResponseEntity<List<EmployeeDto>>(saveDep, HttpStatus.OK);
    }

    @GetMapping("/getempdep/{empId}/{depCode}/{orgCode}")
    public ResponseEntity<ApiDto> getDept(@PathVariable long empId, @PathVariable String depCode, @PathVariable String orgCode) {
        ApiDto saveDep = ds.getEmpDep(empId, depCode, orgCode);
        return new ResponseEntity<ApiDto>(saveDep, HttpStatus.OK);
    }
    
}
