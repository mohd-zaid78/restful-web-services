package com.zaid.basepackage.response;

import java.util.List;

import org.springframework.stereotype.Component;

import com.zaid.basepackage.request.Employee;

@Component
public class EmployeeResponse {
	private Boolean error;
	private String msg;
	private List<Employee> employees;
	public Boolean getError() {
		return error;
	}
	public void setError(Boolean error) {
		this.error = error;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public List<Employee> getEmployees() {
		return employees;
	}
	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}
	
}
