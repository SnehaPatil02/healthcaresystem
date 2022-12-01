package com.capgemini.healthcare.controller;


import org.springframework.http.MediaType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.healthcare.dto.CustomerRequest;
import com.capgemini.healthcare.dto.CustomerResponse;
import com.capgemini.healthcare.services.CustomerService;
import com.capgemini.healthcare.validations.Validations;
import com.capgemini.healthcare.dto.AppointmentDto;
import com.capgemini.healthcare.dto.AppointmentResponse;
import com.capgemini.healthcare.services.AppointmentService;


@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*", allowCredentials = "true")
public class CustomerController {
	@Autowired
	private CustomerService customerService;

	@Autowired
	private AppointmentService appointmentService;

	@PostMapping(path = "/customerregister", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public CustomerResponse register(@RequestBody CustomerRequest customerRequest ) {

		CustomerResponse response = new CustomerResponse();
	
	try{
		if(Validations.validateUser(customerRequest))
			{
			response.setStatusCode(400);
			response.setMessage("Failed");
			response.setDiscription("validation failed");
				return response;
			};
		customerService.register(customerRequest);

		response.setStatusCode(201);
		response.setMessage("Success");
		response.setDiscription("Registered successfully");
	}
	catch (Exception e){
		
		System.out.println(e.getMessage());
		response.setStatusCode(400);
		response.setMessage("Failed");
		response.setDiscription("registration failed");
	}
	

	
	return response;

	}

	
}
