package com.capgemini.healthcare.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.healthcare.dao.CustomerDao;
import com.capgemini.healthcare.dto.CustomerDto;
import com.capgemini.healthcare.dto.CustomerRequest;


@Service
public class CustomerServiceImpl implements CustomerService{
	
	@Autowired
	private CustomerDao dao;

	@Override
	public boolean register(CustomerRequest customerRequest) {

	CustomerDto dto = new CustomerDto();
	dto.setUserName(customerRequest.getName());
	dto.setPassword(customerRequest.getPassword());
	dto.setPhoneNumber(customerRequest.getPhoneno());
	dto.setRole("user");
				
		return dao.registerUser(dto);
	} 
	

}
