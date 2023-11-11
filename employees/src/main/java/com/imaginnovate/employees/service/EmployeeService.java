package com.imaginnovate.employees.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.imaginnovate.employees.exception.EmployeeNotFoundException;
import com.imaginnovate.employees.model.EmployeeDTO;
import com.imaginnovate.employees.model.EmployeeTaxDTO;
import com.imaginnovate.employees.repo.EmployeeRepository;

@Service
public class EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;
	
	public EmployeeDTO createEmployee(EmployeeDTO employee) {
		return employee.toEmployeeDTO(employeeRepository.save(employee.toEmployeed(employee)));
	}
	
	public EmployeeTaxDTO getEmployeeTax(Long empId) {
		    return EmployeeTaxDTO.toEmployeeTaxDTO(employeeRepository.findById(empId).orElseThrow(() -> new EmployeeNotFoundException("Employee not found with the given ID.")));		
	}    
}
