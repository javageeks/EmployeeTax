package com.imaginnovate.employees.exception;

public class EmployeeNotFoundException extends RuntimeException{

	public EmployeeNotFoundException(String message){
        super(message);
    }
}
