package com.imaginnovate.employees.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

import com.imaginnovate.employees.entity.Employee;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeTaxDTO implements Serializable{

	private static final long serialVersionUID = 1L;
	private long id;
	private String firstName;
	private String lastName;
	private double yearlySalary;
	private double tax;
	private double cess;
	
	
	public static EmployeeTaxDTO toEmployeeTaxDTO(Employee employee) {
		
		return new EmployeeTaxDTO(employee.getId(),employee.getFirstName(), employee.getLastName(),calculateIncome(employee.getSalary(), employee.getDoj()), calculateTax(employee.getSalary(), employee.getDoj()),calculateCess(employee.getSalary(), employee.getDoj()));
	}
	
	public static double calculateTax(double salary, LocalDate doj) {
		double tax=0;
		double income = calculateIncome(salary,doj);	
        if (income <= 250000) {
        	tax = income * 0.00;
        } 
        if (income>= 250000 && income <= 500000 ) {
        	double incomet1 = income-250000;
        	tax = incomet1 * 0.05;
        }
        if (income>= 500000 && income <= 1000000) {
        	double t1 = 250000 * 0.05;
            double incomet2 = income - 500000;
            tax  = t1 + (incomet2 * 0.10);
        } if (income>= 1000000) {
        	double t1 = 250000 * 0.05;  //12500
        	double t2 = 500000 * 0.10; //50000
        	
        	double incomet3 = income - 1000000; 
        	double t3  = incomet3 * 0.20;
        	 tax  = t1+ t2 + t3;
        }
		return tax;	
	}
	
	public static double calculateCess(double salary, LocalDate doj) {
		return calculateIncome(salary,doj) >= 2500000 ? (calculateIncome(salary,doj) - 2500000) * 0.02 : 0.0;
	}
	
	public static double calculateIncome(double salary, LocalDate doj) {
		int month = doj.getMonthValue();
		LocalDate endOfMonth = doj.withDayOfMonth(doj.lengthOfMonth());
		long daysBetween = ChronoUnit.DAYS.between(doj, endOfMonth);
		double proratedSalary = (daysBetween+1)*(salary/30);
		int totalMonths = 15-month;
		return (totalMonths*salary) + proratedSalary;
	}
	
}
