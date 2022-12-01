package com.capgemini.healthcare.dto;

import java.util.List;

public class CustomerResponse {
	private int statusCode;
	private String message;
	private String discription;
	private List<CustomerDto> beans;
	private String role;
	public int getStatusCode() {
		return statusCode;
	}
	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getDiscription() {
		return discription;
	}
	public void setDiscription(String discription) {
		this.discription = discription;
	}
	public List<CustomerDto> getBeans() {
		return beans;
	}
	public void setBeans(List<CustomerDto> beans) {
		this.beans = beans;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	
	
}
