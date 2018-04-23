package com.example.demo.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="Customer")
public class Customer {
	@Id
	private String customerId;
	private String customerName;
	private String customerAge;
	private String customerAddress;

	public Customer()
	{

	}
	public Customer(String customerId,String customerName,String customerAge,String customerAddress)
	{
		this.customerId=customerId;
		this.customerName=customerName;
		this.customerAge=customerAge;
		this.customerAddress=customerAddress;
	}
	public String getCustomerId() {
		return customerId;
	}
	public String getCustomerName() {
		return customerName;
	}
	public String getCustomerAge() {
		return customerAge;
	}
	public String getCustomerAddress() {
		return customerAddress;
	}


}
