package com.es.service.impl;

import com.es.constants.CustomErrorCodes;
import com.es.dto.ApiDto;
import com.es.dto.DepartmentDto;
import com.es.dto.EmployeeDto;
import com.es.dto.OrganizationDto;
import com.es.entity.Employee;
import com.es.exception.ResourceNotFoundException;
import com.es.repository.EmployeeRepo;
import com.es.service.EmployeeService;
import com.es.service.FeignApiClient;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    EmployeeRepo er;

    @Autowired
    FeignApiClient fac;

    @Autowired
    ModelMapper mm;


    @Autowired
    private WebClient webClient;


    @Override
    public EmployeeDto saveEmp(EmployeeDto employeeDto) {

        Employee emp = Employee.builder().firstName(employeeDto.getFirstName()).lastName(employeeDto.getLastName())
                .empEmail(employeeDto.getEmpEmail()).build();

        Employee employee = er.save(emp);

        EmployeeDto ed = mm.map(employee, EmployeeDto.class);

        return ed;
    }

    @Override
    public List<EmployeeDto> getEmp(long empId) {

        List<Employee> findByEmpId = er.findByEmpId(empId);

        List<EmployeeDto> emplist = findByEmpId.stream().map(x -> mm.map(x, EmployeeDto.class))
                .collect(Collectors.toList());

        if (!findByEmpId.isEmpty()) {
            return emplist;
        } else {

            throw new ResourceNotFoundException(CustomErrorCodes.EMPID_NOT_FOUND.getErrorMessage(),
                    CustomErrorCodes.EMPID_NOT_FOUND.getErrorCode());
        }

    }

    @Override
    public ApiDto getEmpDep(long empId, String depCode, String orgCode) {

        List<Employee> findByEmpId = er.findByEmpId(empId);

        List<EmployeeDto> emplist = findByEmpId.stream().map(x -> mm.map(x, EmployeeDto.class))
                .collect(Collectors.toList());

        List<DepartmentDto> dept = fac.getDept(depCode);

        OrganizationDto organizationDto = webClient.get()
                .uri("http://localhost:8083/org/getorg/" + orgCode)
                .retrieve()
                .bodyToMono(OrganizationDto.class)
                .block();


        ApiDto ad = ApiDto.builder().departmentDto(dept).employeeDto(emplist).organizationDto(List.of(organizationDto)).build();

        return ad;

    }

    public ApiDto getDefaultDept(long empId, String depCode, Exception ex) {

        List<Employee> findByEmpId = er.findByEmpId(empId);

        List<EmployeeDto> emplist = findByEmpId.stream().map(x -> mm.map(x, EmployeeDto.class))
                .collect(Collectors.toList());

        DepartmentDto dept1 = new DepartmentDto(0l, "def-name", "def-des", "def-depcode");
        List<DepartmentDto> dept = List.of(dept1);

        ApiDto ad = ApiDto.builder().departmentDto(dept).employeeDto(emplist).build();

        return ad;
    }

}
