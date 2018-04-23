package com.example.demo.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="Order")
public class Order {

	@Id
	public String orderNumber;
	public String orderName;
	public String issuedBy;
	
	public Order()
	{
		
	}
	
	public Order(String orderNumber,String orderName,String issuedBy)
	{
		this.orderNumber=orderNumber;
		this.orderName=orderName;
		this.issuedBy=issuedBy;
	}

	public String getOrderNumber() {
		return orderNumber;
	}

	public String getOrderName() {
		return orderName;
	}

	public String getIssuedBy() {
		return issuedBy;
	}
	
	
}
