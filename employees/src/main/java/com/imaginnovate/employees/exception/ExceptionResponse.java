package com.imaginnovate.employees.exception;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class ExceptionResponse {

    public static final String HttpStatus = null;
	private String message;
    private LocalDateTime dateTime;
}
