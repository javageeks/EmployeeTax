package com.imaginnovate.employees.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;
	
	@PostMapping("/employees")
	public ResponseEntity<EmployeeDTO> createEmployee(@RequestBody @Valid EmployeeDTO employee) {
		return new ResponseEntity<EmployeeDTO>( employeeService.createEmployee(employee), HttpStatus.CREATED);
	}
	
	@GetMapping("/emptax/{employeeId}")
	public EmployeeTaxDTO getEmployeeTax(@PathVariable long employeeId) {
		return employeeService.getEmployeeTax(employeeId);
	}
}
