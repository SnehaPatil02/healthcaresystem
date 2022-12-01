package com.capgemini.healthcare.dto;

public class CustomerRequest {
	private String name;
	private String password;
	private Long phoneno;

	public String getName() {
	return name;
	}
	public void setName(String name) {
	this.name = name;
	}
	public String getPassword() {
	return password;
	}
	public void setPassword(String password) {
	this.password = password;
	}
	public Long getPhoneno() {
	return phoneno;
	}
	public void setPhoneno(Long phoneno) {
	this.phoneno = phoneno;
	}

}
