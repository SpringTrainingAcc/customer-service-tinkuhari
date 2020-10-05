package com.customer.ms.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Document(collection="customerms")
@JsonIgnoreProperties(ignoreUnknown=true)
public class CustomerM {
	
	@Id
	private String cusId;
	
	@JsonAlias("customerName")
	private String cusName;
	
	@JsonAlias("customerAddress")
	private String address;
	
	public CustomerM(String cusId,String cusName, String address) {
		this.cusId=cusId;
		this.cusName=cusName;
		this.address=address;
	}

	
	public String getCusId() {
		return cusId;
	}
	public void setCusId(String cusId) {
		this.cusId = cusId;
	}
	public String getCusName() {
		return cusName;
	}
	public void setCusName(String cusName) {
		this.cusName = cusName;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	

}
