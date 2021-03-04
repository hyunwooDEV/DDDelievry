package com.test.ddd.manager;

public class ManagingCustomerVO {
	String customerName = "";
	String customerNumber = "";
	String customerAddr1 = "";
	String customerAddr2 = "";
	String customerPhone = "";
	String customerLevel = "";
	int customerOrder = 0;
	int customerCancel = 0;
	int customerExpend = 0;
	int customerPoint = 0;
	int orderDate = 0; 
		
	public int getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(int orderDate) {
		this.orderDate = orderDate;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public String getCustomerNumber() {
		return customerNumber;
	}
	public void setCustomerNumber(String customerNumber) {
		this.customerNumber = customerNumber;
	}
	public String getCustomerAddr1() {
		return customerAddr1;
	}
	public void setCustomerAddr1(String customerAddr1) {
		this.customerAddr1 = customerAddr1;
	}
	public String getCustomerAddr2() {
		return customerAddr2;
	}
	public void setCustomerAddr2(String customerAddr2) {
		this.customerAddr2 = customerAddr2;
	}
	public String getCustomerPhone() {
		return customerPhone;
	}
	public void setCustomerPhone(String customerPhone) {
		this.customerPhone = customerPhone;
	}
	public String getCustomerLevel() {
		return customerLevel;
	}
	public void setCustomerLevel(String customerLevel) {
		this.customerLevel = customerLevel;
	}
	public int getCustomerOrder() {
		return customerOrder;
	}
	public void setCustomerOrder(int customerOrder) {
		this.customerOrder = customerOrder;
	}
	public int getCustomerCancel() {
		return customerCancel;
	}
	public void setCustomerCancel(int customerCancel) {
		this.customerCancel = customerCancel;
	}
	public int getCustomerExpend() {
		return customerExpend;
	}
	public void setCustomerExpend(int customerExpend) {
		this.customerExpend = customerExpend;
	}
	public int getCustomerPoint() {
		return customerPoint;
	}
	public void setCustomerPoint(int customerPoint) {
		this.customerPoint = customerPoint;
	}
	
	
	public ManagingCustomerVO() {
		
	}

}
