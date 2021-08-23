package com.serdar.microservices.limitsservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.serdar.microservices.limitsservice.bean.Limits;
import com.serdar.microservices.limitsservice.configuration.Configuration;

@RestController
public class LimitsController {

	@Autowired
	private Configuration configuration;
	
	@GetMapping("/limits")
	public Limits retriveLimits () {
		
		return new Limits(configuration.getMinimum(),configuration.getMaximum());
	}
	
}
