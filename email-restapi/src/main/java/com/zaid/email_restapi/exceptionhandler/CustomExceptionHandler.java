package com.zaid.email_restapi.exceptionhandler;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;


@ControllerAdvice
public class CustomExceptionHandler extends ResponseEntityExceptionHandler {

	@Autowired
	ErrorDetails errorDetails;
	
	@ExceptionHandler(UserNotFoundException.class)
	public final ResponseEntity<ErrorDetails> userNotFound(Exception ex, WebRequest request) throws Exception {
		errorDetails.setTimestamp(LocalDateTime.now());
		errorDetails.setMessage(ex.getMessage());
		errorDetails.setPath(request.getDescription(false));
		errorDetails.setError("RESOURCE NOT FOUND");
		errorDetails.setStatus(HttpStatus.NOT_FOUND.value());
		return new ResponseEntity<ErrorDetails>(errorDetails,HttpStatus.NOT_FOUND);
	
		
	}
	
	@ExceptionHandler(MailNotDeletedException.class)
	public final ResponseEntity<ErrorDetails> mailNotDeleted(Exception ex, WebRequest request) throws Exception {
		errorDetails.setTimestamp(LocalDateTime.now());
		errorDetails.setMessage(ex.getMessage());
		errorDetails.setPath(request.getDescription(false));
		errorDetails.setError("MAIL NOT DELETED");
		errorDetails.setStatus(HttpStatus.CONFLICT.value());
		return new ResponseEntity<ErrorDetails>(errorDetails,HttpStatus.CONFLICT);
		
		
	}
	
	
}
