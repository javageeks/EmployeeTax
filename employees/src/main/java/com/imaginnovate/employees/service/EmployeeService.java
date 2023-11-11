package com.imaginnovate.employees.service;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.imaginnovate.employees.model.Employee;
import com.imaginnovate.employees.model.EmployeeTax;
import com.imaginnovate.employees.repo.EmployeeRepository;

@Service
public class EmployeeService {

	private EmployeeRepository employeeRepository;
	public Employee createEmployee(Employee employee) {
		
		return employeeRepository.save(employee);
	}
	
	public List<Employee> allEmployees() {
		
		return employeeRepository.findAll();
	}
	
	public EmployeeTax getEmployeeTax(Long empId) {
		EmployeeTax empTax = new EmployeeTax();
		Optional<Employee> employee = employeeRepository.findById(empId);
		if(employee.isPresent()) {
			Employee emp = employee.get();
			double salary = emp.getSalary();
			
			LocalDate today = emp.getDoj();
			int month = today.getMonthValue();

			LocalDate endOfMonth = today.withDayOfMonth(today.lengthOfMonth());
			long daysBetween = ChronoUnit.DAYS.between(today, endOfMonth);
			
			double proratedSalary = daysBetween*(salary/30);
		     
			int totalMonths = 11-month;
			double income = (totalMonths*salary) + proratedSalary;
			double tax=0;
			double cess=0;
			//double income;
	        
	        if(income >= 25000000) {
	        	cess  = cess * 0.02;
	        }
	        if (income <= 250000) {
	        	tax = income *= 0.00;
	        } 
	        if (income>= 250000 && income <= 500000 ) {
	        	income = income-250000;
	        	tax = tax + (income * 0.05);
	        }
	        if (income>= 500000 && income <= 1000000) {
	        	//double t1 = 250000 * 0.05;
	            income = income - 500000;
	            tax  = tax + (income *= 0.10);
	        } if (income>= 1000000) {
	        	income = income - 1000000;
	        	 tax  = tax + (income *= 0.20);
	            
	        } 
		
	        empTax.setId(emp.getId());
	        empTax.setFirstName(emp.getFirstName());
	        empTax.setLastName(emp.getLastName());
	        empTax.setTax(tax);
	        empTax.setCess(cess);
	        empTax.setYearlySalary(income);
		}
		
		
	return empTax;
		
	}
	
	    
}
