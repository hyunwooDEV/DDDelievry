package com.test.ddd.rider;

public class RiderDeliveryChoiceVO {
	String storeName = "";
	String selectedMenus = "";
	int MenuCount = 0;
	String paymentMethod = "";
	String payTotal = "";
	String customerRequest = "";
	String customerAddr1 = "";
	String customerAddr2 = "";
	
	
	public int getMenuCount() {
		return MenuCount;
	}

	public void setMenuCount(int menuCount) {
		MenuCount = menuCount;
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

	public String getStoreName() {
		return storeName;
	}

	public void setStoreName(String storeName) {
		this.storeName = storeName;
	}

	public String getSelectedMenus() {
		return selectedMenus;
	}

	public void setSelectedMenus(String selectedMenus) {
		this.selectedMenus = selectedMenus;
	}

	public String getPaymentMethod() {
		return paymentMethod;
	}

	public void setPaymentMethod(String paymentMethod) {
		this.paymentMethod = paymentMethod;
	}

	public String getPayTotal() {
		return payTotal;
	}

	public void setPayTotal(String payTotal) {
		this.payTotal = payTotal;
	}

	public String getCustomerRequest() {
		return customerRequest;
	}

	public void setCustomerRequest(String customerRequest) {
		this.customerRequest = customerRequest;
	}

	public RiderDeliveryChoiceVO() {
		
	}
	
}
