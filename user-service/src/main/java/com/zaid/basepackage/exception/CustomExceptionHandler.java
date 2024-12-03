package com.zaid.basepackage.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class CustomExceptionHandler extends ResponseEntityExceptionHandler {
	
	@ExceptionHandler(UserNotFoundException.class)
	public final ResponseEntity<ErrorDetails> resourceNotFoundException(Exception ex, WebRequest request) throws Exception {
	
				ErrorDetails details = new ErrorDetails();
				details.setTimestamp(LocalDateTime.now());
				details.setStatus(HttpStatus.NOT_FOUND.value());
				details.setError("resource not found");
				details.setMessage(ex.getMessage());
				details.setPath(request.getDescription(false));
				return new ResponseEntity<ErrorDetails>(details,HttpStatus.NOT_FOUND);
	}
	

}
