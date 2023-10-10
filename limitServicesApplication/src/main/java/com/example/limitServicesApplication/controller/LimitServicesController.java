package com.example.limitServicesApplication.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.limitServicesApplication.bean.Limits;
import com.example.limitServicesApplication.config.Configuration;

@RestController
public class LimitServicesController {

	@Autowired
	private Configuration config;
	
	
	@GetMapping("/limits")
	public Limits getvalues()
	{
		return new Limits(config.getMin(),config.getMax());
	}
	
}
