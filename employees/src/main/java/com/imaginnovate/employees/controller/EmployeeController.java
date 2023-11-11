package com.imaginnovate.employees.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.imaginnovate.employees.model.Employee;
import com.imaginnovate.employees.model.EmployeeTax;
import com.imaginnovate.employees.service.EmployeeService;



@RestController
@RequestMapping("/api/emp/")
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;
	
	// get all employees
	@GetMapping("/employees")
	public List<Employee> getAllEmployees(){
		return employeeService.allEmployees();
	}
	
	@PostMapping("/employees")
	public Employee createEmployee(@RequestBody Employee employee) {
		return employeeService.createEmployee(employee);
	}
	
	@GetMapping("/emptax")
	public EmployeeTax getEmployeeTax(Long employeeId) {
		return employeeService.getEmployeeTax(employeeId);
		
		
	}
}
