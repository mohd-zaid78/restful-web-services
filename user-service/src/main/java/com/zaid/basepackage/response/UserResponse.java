package com.zaid.basepackage.response;

import java.util.List;

import org.springframework.stereotype.Component;

import com.zaid.basepackage.request.UserRequest;

import lombok.Data;

@Data
@Component
public class UserResponse {
	
	private boolean error;
	private String message;
	private List<UserRequest> listUsers;
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
	public List<UserRequest> getListUsers() {
		return listUsers;
	}
	public void setListUsers(List<UserRequest> listUsers) {
		this.listUsers = listUsers;
	}
	

}
