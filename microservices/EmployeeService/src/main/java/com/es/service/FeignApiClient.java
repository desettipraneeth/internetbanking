package com.es.service;

import com.es.dto.DepartmentDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "department-service")
public interface FeignApiClient {

	@GetMapping("/dep/getdep/{depCode}")
	List<DepartmentDto> getDept(@PathVariable String depCode);


}
