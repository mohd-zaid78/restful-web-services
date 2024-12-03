package com.zaid.phonepe.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

@RestController
@RequestMapping("/phonepe")
public class PhonepeController {
	
	@Autowired
	private RestTemplate template;
	
	
	
	@GetMapping
	@CircuitBreaker(name = "rechargeService",fallbackMethod = "rechargeServiceDown")
	public String phonpe() {
		String output = template.getForObject("http://localhost:9001/recharge", String.class);
		return output+" via phonepe";
	}
	
	public String rechargeServiceDown(Exception e) {
		return "Recharge service is down ,phone continue its other services";
	}

}
