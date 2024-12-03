package com.zaid.email_restapi.exceptionhandler;

public class MailNotDeletedException extends RuntimeException {
	
	public MailNotDeletedException(String message) {
		super(message);
	}
}
