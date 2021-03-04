package com.test.ddd.manager;

public class ManagingRiderVO {

	private String riderName = "";
	private String riderAge = "";
	private String riderPhone = "";
	private String riderAddr1 = "";
	private String riderAddr2 = "";
	private String riderWorkingArea = "";
	private String riderDeliveredCount = "";
	private String riderAvgPoint = "";
	
	
	
	
	public String getRiderName() {
		return riderName;
	}

	public void setRiderName(String riderName) {
		this.riderName = riderName;
	}

	public String getRiderAge() {
		return riderAge;
	}

	public void setRiderAge(String riderAge) {
		int year = 2020;
		String temp = riderAge.substring(0,4);
		int num = Integer.parseInt(temp);
		int result = year-num;
		
		this.riderAge = result+"";
	}

	public String getRiderPhone() {
		return riderPhone;
	}

	public void setRiderPhone(String riderPhone) {
		this.riderPhone = riderPhone;
	}

	public String getRiderAddr1() {
		return riderAddr1;
	}

	public void setRiderAddr1(String riderAddr1) {
		this.riderAddr1 = riderAddr1;
	}

	public String getRiderAddr2() {
		return riderAddr2;
	}

	public void setRiderAddr2(String riderAddr2) {
		this.riderAddr2 = riderAddr2;
	}

	public String getRiderWorkingArea() {
		return riderWorkingArea;
	}

	public void setRiderWorkingArea(String riderWorkingArea) {
		this.riderWorkingArea = riderWorkingArea;
	}

	public String getRiderDeliveredCount() {
		return riderDeliveredCount;
	}

	public void setRiderDeliveredCount(String riderDeliveredCount) {
		this.riderDeliveredCount = riderDeliveredCount;
	}

	public String getRiderAvgPoint() {
		return riderAvgPoint;
	}

	public void setRiderAvgPoint(String riderAvgPoint) {
		this.riderAvgPoint = riderAvgPoint;
	}

	public ManagingRiderVO() {
		
	}
}
