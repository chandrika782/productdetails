package com.analytics.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice

public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

	/*
	 * @ExceptionHandler(EmployeeException.class)
	 * 
	 * public ResponseEntity<ResponseDto> ecomorseExceptionHandler(EmployeeException
	 * ex, WebRequest request) {
	 * 
	 * ResponseDto ResponseDto = new ResponseDto();
	 * 
	 * ResponseDto.setMessage(ex.getMessage());
	 * 
	 * return new ResponseEntity<>(ResponseDto, HttpStatus.NOT_FOUND);
	 * 
	 * }
	 */

	@ExceptionHandler(Exception.class)

	public ResponseEntity<ResponseDto> globalExceptionHandler(Exception exception/* , WebRequest request */) {

		ResponseDto ResponseDto = new ResponseDto();

		ResponseDto.setMessage(exception.getMessage());

		return new ResponseEntity<>(ResponseDto, HttpStatus.NOT_FOUND);

	}

}