package com.imaginnovate.employees.model;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Date;
import java.util.Objects;

import org.hibernate.validator.constraints.NotBlank;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "employees")
public class Employee {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@SuppressWarnings("deprecation")
	@NotBlank(message = "Name is mandatory")
	private String firstName;
	@NotBlank(message = "Email is mandatory")
	private String lastName;
	@NotBlank(message = "Email is mandatory")
	private String emailId;
	@NotBlank(message = "Email is mandatory")
	private int [] phone;
	@NotBlank(message = "Email is mandatory")
	private double salary;
	@NotBlank(message = "Email is mandatory")
	private LocalDate   doj;

	public Employee(){
		
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public int[] getPhone() {
		return phone;
	}
	public void setPhone(int[] phone) {
		this.phone = phone;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	public LocalDate getDoj() {
		return doj;
	}
	public void setDoj(@NotBlank(message = "Email is mandatory") LocalDate doj) {
		this.doj = doj;
	}
	public Employee(long id, @NotBlank(message = "Name is mandatory") String firstName,
			@NotBlank(message = "Email is mandatory") String lastName,
			@NotBlank(message = "Email is mandatory") String emailId,
			@NotBlank(message = "Email is mandatory") int[] phone,
			@NotBlank(message = "Email is mandatory") double salary,
			@NotBlank(message = "Email is mandatory") @NotBlank(message = "Email is mandatory") LocalDate doj) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.emailId = emailId;
		this.phone = phone;
		this.salary = salary;
		this.doj = doj;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Arrays.hashCode(phone);
		result = prime * result + Objects.hash(doj, emailId, firstName, id, lastName, salary);
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee other = (Employee) obj;
		return Objects.equals(doj, other.doj) && Objects.equals(emailId, other.emailId)
				&& Objects.equals(firstName, other.firstName) && id == other.id
				&& Objects.equals(lastName, other.lastName) && Arrays.equals(phone, other.phone)
				&& Double.doubleToLongBits(salary) == Double.doubleToLongBits(other.salary);
	}

	
}
