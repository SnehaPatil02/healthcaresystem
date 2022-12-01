package com.capgemini.healthcare.dao;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.capgemini.healthcare.dto.TestDto;

@SpringBootTest
public class TestDaoTest {

	@Autowired
	TestDao testDao;
  @Test
  public void addTest() {
	  TestDto tDto = new TestDto();
	 //tDto.setTestId(14);
	  tDto.setTestName("TB");
	  tDto.setCenterId(101);
		assertTrue(testDao.addTest(tDto));
	
  }

  @Test
  public void deleteTest() {
	  TestDto tDto = new TestDto();
	//  tDto.setTestId(14);
	  tDto.setTestName("TB");
	  tDto.setCenterId(101);
	  testDao.addTest(tDto);
		assertTrue(testDao.deleteTest(01));
	  }

  @Test
  public void modifyTest() {
	  TestDto tDto = new TestDto();
	  tDto.setTestName("TB");
	  tDto.setCenterId(101);
		testDao.addTest(tDto);
		assertTrue(testDao.modifyTest(tDto));
		
		
  }

  @Test
  public void searchTest() {
	  TestDto tDto = new TestDto();
	  tDto.setTestId(14);
	  tDto.setTestName("TB");
	  tDto.setCenterId(101);
		testDao.addTest(tDto);
		assertEquals(testDao.searchTest(14), tDto);
	
		}

  @Test
  public void viewAllTests() {
	  List<TestDto> viewAllTests = testDao.viewAllTests();
		assertNotNull(viewAllTests);
  }
}
