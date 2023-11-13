package com.imaginnovate.employees.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.imaginnovate.employees.model.EmployeeDTO;
import com.imaginnovate.employees.model.EmployeeTaxDTO;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

@Tag(name = "Employee", description = "the Employee Api")
public interface EmployeeApi {

	@Operation(summary = "Create Employee", description = "API endpoint to store employee details")
	@ApiResponses(value = { @ApiResponse(responseCode = "201", description = "successful operation") })
	ResponseEntity<EmployeeDTO> createEmployee(EmployeeDTO employee);
    
    @Operation(summary = "Fetch Employee Tax", description = "API endpoint to return employees' tax deduction for the current financial year(April to March)")
    @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "successful operation")})
	ResponseEntity<EmployeeTaxDTO> getEmployeeTax(long employeeId);
}
