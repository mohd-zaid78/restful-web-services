package com.zaid.basepackage.controller;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zaid.basepackage.exception.UserNotFoundException;
import com.zaid.basepackage.request.UserRequest;
import com.zaid.basepackage.response.UserResponse;
import com.zaid.basepackage.service.UserService;

@RestController
public class UserController {
	@Autowired
	private UserService userService;
	
	
	
	@PostMapping("/")
	public ResponseEntity<UserResponse> createUser(@RequestBody UserRequest request){
		UserRequest createdUser = userService.createUser(request);
		UserResponse response = new UserResponse(); 
		if(createdUser!=null) {
			response.setError(false);
			response.setMessage("User created successfully");
			response.setListUsers(Arrays.asList(createdUser));
			
			
		}
		
//		return new ResponseEntity<UserResponse>(response,HttpStatus.OK);
		return ResponseEntity.ok(response);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<UserResponse> getUser(@PathVariable("id") Integer id){
		UserRequest findUser = userService.getUser(id);
		if(findUser==null) {
			throw new UserNotFoundException("User Not Found");
			
		}
		UserResponse response = new UserResponse();
		response.setError(false);
		response.setMessage("User fetched successfully");
		response.setListUsers(Arrays.asList(findUser));
		return ResponseEntity.ok(response);
		
//		if(findUser!=null) {
//			response.setError(false);
//			response.setMessage("User fetched successfully");
//			response.setListUsers(Arrays.asList(findUser));
//			return ResponseEntity.ok(response);
//			
//		}else {
//			response.setError(true);
//			response.setMessage("user not fetched");
//			return new ResponseEntity<UserResponse>(response,HttpStatus.NOT_FOUND);
//		}
//		
	}

}
