package com.capgemini.healthcare.services;

import java.util.List;

import com.capgemini.healthcare.dto.AppointmentDto;
import com.capgemini.healthcare.dto.ApproveAppointmentRequest;

public interface AppointmentService {
	public List<AppointmentDto> viewAllAppointments ();
	public boolean approveAppointment(ApproveAppointmentRequest approveAppointmentRequest);
	public boolean createAppointment(AppointmentDto aDto);
	public AppointmentDto getAppointment(String centerId, String dateTime);
	public AppointmentDto getAppointment(String appointmentId);

}
