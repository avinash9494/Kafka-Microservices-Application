package com.microservice.addresscontroller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AddressController {

	@RequestMapping("/addressData")
	public String employeeController() {
		return "logic for validation of address xml filed data will be written here";
	}
	
}
