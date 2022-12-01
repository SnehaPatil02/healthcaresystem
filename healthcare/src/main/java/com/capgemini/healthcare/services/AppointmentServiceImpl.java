package com.capgemini.healthcare.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.healthcare.dao.DiagnosticCenterDao;

import com.capgemini.healthcare.dao.AppointmentDao;
import com.capgemini.healthcare.dto.AppointmentDto;
import com.capgemini.healthcare.dto.ApproveAppointmentRequest;

@Service
public class AppointmentServiceImpl implements AppointmentService{
	@Autowired
	private AppointmentDao dao;
	
	
	@Autowired
	private DiagnosticCenterDao centerDAO;

	@Override
	public List<AppointmentDto> viewAllAppointments() {
		return dao.viewAllAppointments();
	}
	


	@Override
	public boolean createAppointment(AppointmentDto aDto) {
		
		
		return dao.createAppointment(aDto);
	}



	@Override
	public AppointmentDto getAppointment(String centerId, String dateTime) {
		return dao.getAppointment(centerId, dateTime);
	}

	@Override
	public AppointmentDto getAppointment(String appointmentId) {
		return dao.getAppointment(appointmentId);
	}

	@Override
	public boolean approveAppointment(ApproveAppointmentRequest approveAppointmentRequest) {

		AppointmentDto aDto = dao.getAppointment(approveAppointmentRequest.getappointmentId());

		if(aDto != null){
			aDto.setStatus(approveAppointmentRequest.getstatus());

			aDto = dao.updateStatus(aDto);

		}
		if(aDto != null) {
			return true;
		}
		return false;
	}

	

}
