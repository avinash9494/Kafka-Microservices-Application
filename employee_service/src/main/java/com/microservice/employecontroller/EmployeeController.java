package com.microservice.employecontroller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeController {

	@RequestMapping("/employeeData")
	public String employeeController() {
		return "logic for validation of employee xml filed data will be written here";
	}
	
}
