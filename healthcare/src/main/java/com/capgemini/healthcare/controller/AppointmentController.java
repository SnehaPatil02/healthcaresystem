package com.capgemini.healthcare.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.healthcare.dto.AppointmentDto;
import com.capgemini.healthcare.dto.ApproveAppointmentRequest;
import com.capgemini.healthcare.dto.AppointmentResponse;
import com.capgemini.healthcare.services.AppointmentService;


@CrossOrigin(origins = "*", allowedHeaders = "*", allowCredentials = "true")
@RestController
public class AppointmentController {
	@Autowired
	private AppointmentService appointmentService;
	
	
	@GetMapping(path = "/viewAllAppointments", produces = MediaType.APPLICATION_JSON_VALUE)
	public AppointmentResponse viewAllAppointments() {
		AppointmentResponse appointmentResponse = new AppointmentResponse();
		List<AppointmentDto> list = appointmentService.viewAllAppointments();
		if (list.size() != 0) {
			appointmentResponse.setStatusCode(200);
			appointmentResponse.setMessage("Success");
			appointmentResponse.setDiscription("Appointments are found");
			appointmentResponse.setBeans(list);
		} else {
			appointmentResponse.setStatusCode(401);
			appointmentResponse.setMessage("Failure");
			appointmentResponse.setDiscription("No appointments");
		}
		return appointmentResponse;

	}

	@GetMapping(path = "/viewAppointments/{appointmentId}", produces = MediaType.APPLICATION_JSON_VALUE)
	public AppointmentResponse viewAppointments(@PathVariable("appointmentId") String appointmentId) {
		System.out.println(appointmentId);
		AppointmentResponse appointmentResponse = new AppointmentResponse();
		AppointmentDto adto = appointmentService.getAppointment(appointmentId);
		if (adto != null) {
			appointmentResponse.setStatusCode(200);
			appointmentResponse.setMessage("Success");
			appointmentResponse.setDiscription("Appointments are found");
			appointmentResponse.setBeans(List.of(adto));
		} else {
			appointmentResponse.setStatusCode(404);
			appointmentResponse.setMessage("Failure");
			appointmentResponse.setDiscription("No appointments");
		}
		return appointmentResponse;

	}

	@PutMapping(path = "/approveAppointment", produces = MediaType.APPLICATION_JSON_VALUE,consumes =  MediaType.APPLICATION_JSON_VALUE)
	public AppointmentResponse approveAppointment(@RequestBody ApproveAppointmentRequest approveAppointmentRequest ) {
		AppointmentResponse response = new AppointmentResponse();
		if(appointmentService.approveAppointment(approveAppointmentRequest)) {
			response.setStatusCode(201);
			response.setMessage("Success");
			response.setDiscription("Center Deatils Deleted");
			
			}
			return response;

	}


	@PostMapping(path = "/createAppointment", produces = MediaType.APPLICATION_JSON_VALUE,consumes =  MediaType.APPLICATION_JSON_VALUE)
	public AppointmentResponse createAppointment(@RequestBody AppointmentDto appointmentDto ) {
		AppointmentResponse response = new AppointmentResponse();
		AppointmentDto oldappointDTO = appointmentService.getAppointment(appointmentDto.getCenterId(), appointmentDto.getDateTime());
		
		try {
			if(oldappointDTO != null) {
				response.setStatusCode(400);
				response.setMessage("Failed");
				response.setDiscription("Appointment not avaliable");
				
				}
			else if(appointmentService.createAppointment(appointmentDto)) {
				response.setStatusCode(200);
				response.setMessage("Success");
				response.setDiscription("Appointment Created");
				
				}
			else {
				response.setStatusCode(500);
				response.setMessage("Failed");
				response.setDiscription("Appointment already found");
			}
			
		}
		catch (Exception e) {
			e.printStackTrace(System.out);
			response.setStatusCode(500);
			response.setMessage("Failed");
			response.setDiscription(e.toString());
			
		}
		
		return response;
	}

}
