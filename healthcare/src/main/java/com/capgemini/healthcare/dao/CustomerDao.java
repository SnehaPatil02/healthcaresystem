package com.capgemini.healthcare.dao;

import com.capgemini.healthcare.dto.CustomerDto;

public interface CustomerDao {
	
	public boolean registerUser(CustomerDto dto);
}
