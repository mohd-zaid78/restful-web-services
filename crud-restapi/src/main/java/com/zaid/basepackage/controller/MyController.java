package com.zaid.basepackage.controller;

import java.awt.image.RescaleOp;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.zaid.basepackage.request.Employee;
import com.zaid.basepackage.response.EmployeeResponse;
import com.zaid.basepackage.service.MyService;

@RestController
public class MyController {
	@Autowired
	private MyService service;
	@Autowired
	private EmployeeResponse response;
	
	@PostMapping("/employee")
	public ResponseEntity<EmployeeResponse> add(@RequestBody Employee employee){
		Employee emp = service.create(employee);
		if(emp!=null) {
			response.setError(false);
			response.setMsg("data added succesfully");
			response.setEmployees(Arrays.asList(emp));
			return new ResponseEntity<EmployeeResponse>(response, HttpStatus.OK);
		}else {
			response.setError(true);
			response.setMsg("failed to add");
			response.setEmployees(null);
			return new ResponseEntity<EmployeeResponse>(response, HttpStatus.NOT_FOUND);
		}
		//
	}
	
	
   @GetMapping("/getById/{id}")
   public ResponseEntity<EmployeeResponse> getById(@PathVariable("id") int id){
	   Employee fetch = service.fetch(id);
	   if(fetch!=null) {
		   response.setError(false);
		   response.setMsg("fetch successfully");
		   response.setEmployees(Arrays.asList(fetch));
		   return new ResponseEntity<EmployeeResponse>(response, HttpStatus.OK);
		   
	   }else {
		   response.setError(true);
			response.setMsg("failed to fetch");
			response.setEmployees(null);
			return new ResponseEntity<EmployeeResponse>(response, HttpStatus.NOT_FOUND);  
	   }
   }
   
   @PutMapping("/update/{id}")
   public ResponseEntity<EmployeeResponse> update(@PathVariable int id,@RequestBody Employee employee){
	   Employee updated = service.update(id,employee);
	   if(updated!=null) {
		   response.setError(false);
		   response.setMsg("updated successfully");
		   response.setEmployees(Arrays.asList(updated));
		   return new ResponseEntity<EmployeeResponse>(response, HttpStatus.OK);
		   
	   }else {
		   response.setError(true);
			response.setMsg("failed to update");
			response.setEmployees(null);
			return new ResponseEntity<EmployeeResponse>(response, HttpStatus.NOT_FOUND);  
	   }
   }
   
   @DeleteMapping("/delete/{id}")
   public  ResponseEntity<EmployeeResponse> delete(@PathVariable int id){
	   Employee deleted = service.delete(id);
	   if(deleted==null) {
		   response.setError(false);
		   response.setMsg("deleted successfully");
		   response.setEmployees(null);
		   return new ResponseEntity<EmployeeResponse>(response, HttpStatus.OK);
	   }else {
		   response.setError(true);
		   response.setMsg("failed to delete");
		   response.setEmployees(Arrays.asList(deleted));
		   return new ResponseEntity<EmployeeResponse>(response, HttpStatus.OK);
		   
	   }
	   
   }
   
   
}
