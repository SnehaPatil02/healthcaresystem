package com.capgemini.healthcare.dao;


import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.capgemini.healthcare.dto.DiagnosticCenterDto;

@SpringBootTest
public class DiagnosticCenterDaoTest {

	@Autowired
	DiagnosticCenterDao dCenter;
	

	
	@Test
	public void addCenter() {
		DiagnosticCenterDto cDto = new DiagnosticCenterDto();
		cDto.setCenterId(101);
		cDto.setCenterName("Bims");

		assertTrue(dCenter.addCenter(cDto));
		dCenter.deleteCenter(101);
	}

	@Test
	public void deleteCenter() {
		DiagnosticCenterDto cDto = new DiagnosticCenterDto();
		cDto.setCenterId(102);
		cDto.setCenterName("Bims");

		dCenter.addCenter(cDto);
		assertTrue(dCenter.deleteCenter(102));
	}

	@Test
	public void modifyDiagnosticCenter() {
		DiagnosticCenterDto cDto = new DiagnosticCenterDto();
		cDto.setCenterId(103);
		cDto.setCenterName("Bims");

		dCenter.addCenter(cDto);
		assertTrue(dCenter.modifyDiagnosticCenter(cDto));
		dCenter.deleteCenter(103);
	}
	

}
