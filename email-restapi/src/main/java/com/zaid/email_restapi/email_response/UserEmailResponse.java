package com.zaid.email_restapi.email_response;

import org.springframework.stereotype.Component;

import com.zaid.email_restapi.email_request.EmailUser;

import lombok.Data;

@Data
@Component
public class UserEmailResponse {
	
	private boolean error;
	private String message;
	private EmailUser emailUser;
	public boolean isError() {
		return error;
	}
	public void setError(boolean error) {
		this.error = error;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public EmailUser getEmailUser() {
		return emailUser;
	}
	public void setEmailUser(EmailUser emailUser) {
		this.emailUser = emailUser;
	}
	
	
	
	

}
