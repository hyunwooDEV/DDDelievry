package com.test.ddd.manager;

public class BlackListCustomerVO {
	
	private String customerName = "";
	private String customerAddr1 = "";
	private String customerAddr2 = "";
	private String customerNumber = "";
	private int cancelCount = 0;
	private String blackListStart = "";
	private String blackListEnd = "";
	
	public BlackListCustomerVO() {
		
	}
	
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
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
	public String getCustomerNumber() {
		return customerNumber;
	}
	public void setCustomerNumber(String customerNumber) {
		this.customerNumber = customerNumber;
	}
	public int getCancelCount() {
		return cancelCount;
	}
	public void setCancelCount(int cancelCount) {
		this.cancelCount = cancelCount;
	}
	public String getBlackListStart() {
		return blackListStart;
	}
	public void setBlackListStart(String blackListStart) {
		this.blackListStart = blackListStart;
	}
	public String getBlackListEnd() {
		return blackListEnd;
	}
	public void setBlackListEnd(String blackListStart) {
		String[] temp = blackListStart.split("-");
		String blackListEnd = "";
		int year = Integer.parseInt(temp[0]);
		if (temp[1].equals("01")) {
			blackListEnd = year+"-02-01";
		}else if(temp[1].equals("02")) {
			blackListEnd = year+"-03-01";
		}else if(temp[1].equals("03")) {
			blackListEnd = year+"-04-01";
		}else if(temp[1].equals("04")) {
			blackListEnd = year+"-05-01";
		}else if(temp[1].equals("05")) {
			blackListEnd = year+"-06-01";
		}else if(temp[1].equals("06")) {
			blackListEnd = year+"-07-01";
		}else if(temp[1].equals("07")) {
			blackListEnd = year+"-08-01";
		}else if(temp[1].equals("08")) {
			blackListEnd = year+"-09-01";
		}else if(temp[1].equals("09")) {
			blackListEnd = year+"-10-01";
		}else if(temp[1].equals("10")) {
			blackListEnd = year+"-11-01";
		}else if(temp[1].equals("11")) {
			blackListEnd = year+"-12-01";
		}else if(temp[1].equals("12")) {
			blackListEnd = (year+1)+"-01-01";
		}
		this.blackListEnd = blackListEnd;
	}
	
	
	
}
