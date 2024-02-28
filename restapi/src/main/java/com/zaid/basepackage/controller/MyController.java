package com.zaid.basepackage.controller;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.zaid.basepackage.request.Product;
import com.zaid.basepackage.response.ProductResponse;
import com.zaid.basepackage.service.Myservice;

@RestController
public class MyController {
	@Autowired
	private Myservice service;
	
	@Autowired
	private ProductResponse response;
	
	@PostMapping("/addproduct")
	public ResponseEntity<ProductResponse> product(@RequestBody Product product){
		System.out.println(product);
		response.setError(false);
		response.setMsg(" success response");
		response.setProducts(Arrays.asList(product));
		return new ResponseEntity<ProductResponse>(response, HttpStatus.OK);
		} 
		
		
	}


