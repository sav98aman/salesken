package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import com.app.exception.StudentException;
import com.app.service.StudentServiceImpl;

@Controller
public class StudentUiController {
	@Autowired
	private StudentServiceImpl studentserviceimpl;
	
	@PostMapping("/addstudent")
	public String registerUser() throws StudentException {
		
		return "welcome";
	}
	
}
