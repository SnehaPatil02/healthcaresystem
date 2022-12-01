package com.capgemini.healthcare.dao;

import java.util.List;

import com.capgemini.healthcare.dto.AppointmentDto;

public interface AppointmentDao {
	List<AppointmentDto> viewAllAppointments();
	public boolean createAppointment(AppointmentDto aDto);
	AppointmentDto getAppointment(String centerId, String dateTime);
	AppointmentDto getAppointment(String appointmentId);
	AppointmentDto updateStatus(AppointmentDto aDto);

}
