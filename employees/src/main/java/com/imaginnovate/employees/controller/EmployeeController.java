package com.imaginnovate.employees.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.imaginnovate.employees.model.EmployeeDTO;
import com.imaginnovate.employees.model.EmployeeTaxDTO;
import com.imaginnovate.employees.service.EmployeeService;

import jakarta.validation.Valid;


@RequestMapping("/api/emp/")
@RestController
public class EmployeeController implements EmployeeApi{

	@Autowired
	private EmployeeService employeeService;
	
	@PostMapping(value = "/employees", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<EmployeeDTO> createEmployee(@RequestBody @Valid EmployeeDTO employee) {
		return new ResponseEntity<EmployeeDTO>( employeeService.createEmployee(employee), HttpStatus.CREATED);
	}
	
	@GetMapping(value = "/emptax/{employeeId}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<EmployeeTaxDTO> getEmployeeTax(@PathVariable long employeeId) {
		return new ResponseEntity<EmployeeTaxDTO>(employeeService.getEmployeeTax(employeeId),HttpStatus.OK);
	}
}
