package com.imaginnovate.employees.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

import com.imaginnovate.employees.entity.Employee;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EmployeeDTO implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private long id;
	@NotBlank(message = "Invalid Name: Empty First Name")
    @NotNull(message = "Invalid Name: First Name is NULL")
    @Size(min = 3, max = 30, message = "Invalid First Name: Must be of 3 - 30 characters")
	private String firstName;
	@NotBlank(message = "Invalid Name: Empty Last Name")
    @NotNull(message = "Invalid Name: Last Name is NULL")
    @Size(min = 3, max = 30, message = "Invalid First Name: Must be of 3 - 30 characters")
	private String lastName;
	@Email(message = "Invalid email")
	@NotBlank(message = "Email Required")
	private String emailId;
    @Size(min = 1, max = 2, message = "Invalid Phone : No Phone Numbers ")
	private List<Long> phone;
	@Min(value = 1, message = "Invalid Salary: Equals to zero or Less than zero")
	private double salary;
	@NotNull(message = "The date of join is required.")
	@Past(message = "The date of join must be in the past.")
	private LocalDate   doj;
	
	public Employee toEmployeed(EmployeeDTO employee) {
		return Employee.builder().id(employee.getId()).firstName(employee.getFirstName()).lastName(employee.getLastName()).emailId(employee.getEmailId()).phone(employee.getPhone()).salary(employee.getSalary()).doj(employee.getDoj()).build();
	}
	
	public EmployeeDTO toEmployeeDTO(Employee employee) {
		return EmployeeDTO.builder().id(employee.getId()).firstName(employee.getFirstName()).lastName(employee.getLastName()).emailId(employee.getEmailId()).phone(employee.getPhone()).salary(employee.getSalary()).doj(employee.getDoj()).build();
	}


}
