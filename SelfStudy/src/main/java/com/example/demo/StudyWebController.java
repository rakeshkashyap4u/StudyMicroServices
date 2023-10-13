package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudyWebController {
	
	
	@GetMapping("testweb")
	public String firstweb()
	{
		return "Hi from Docker";
	}

}
