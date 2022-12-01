package com.capgemini.healthcare.dto;

import java.util.List;

public class ApproveAppointmentRequest {
	private String appointmentId;
    private String status;
    
	public String getappointmentId() {
		return appointmentId;
	}
	public void setappointmentId(String appointmentId) {
		this.appointmentId = appointmentId;
	}
	public String getstatus() {
		return status;
	}
	public void setstatus(String status) {
		this.status = status;
	}
}
