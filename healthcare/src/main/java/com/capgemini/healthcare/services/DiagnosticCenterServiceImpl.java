package com.capgemini.healthcare.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.healthcare.dao.DiagnosticCenterDao;
import com.capgemini.healthcare.dao.TestDao;
import com.capgemini.healthcare.dto.DiagnosticCenterDto;
import com.capgemini.healthcare.dto.TestDto;
import com.capgemini.healthcare.exception.AdminException;
import com.capgemini.healthcare.exception.DiagnosticCenterException;
import com.capgemini.healthcare.validations.Validations;
@Service
public class DiagnosticCenterServiceImpl implements DiagnosticCenterService{
	@Autowired
	private DiagnosticCenterDao dao;
	@Autowired
	private TestDao tdao;
	
	@Override
	public boolean addCenter(DiagnosticCenterDto dto) {
		
		return dao.addCenter(dto);
		
	}

	@Override
	public boolean deleteCenter(int centerId) {
	
		return dao.deleteCenter(centerId);
	}

	@Override
	public List<DiagnosticCenterDto> viewAllCenters() {
		return dao.viewAllCenters();
	}

	@Override
	public boolean modifyDiagnosticCenter(DiagnosticCenterDto dto) {
		
		return dao.modifyDiagnosticCenter(dto);
	} 

	@Override
	public DiagnosticCenterDto searchCenter(int centerId) {
		return dao.searchCenter(centerId);
	}

}
