package com.test.ddd.manager;

public class BlackListRiderVO {
	private String riderName = "";
	private String riderAddr1 = "";
	private String riderAddr2 = "";
	private int riderAge = 0;
	private String riderAvgPoint = "";
	private String riderBlackListStart = "";
	private String riderBlackListEnd = "";
	public String getRiderName() {
		return riderName;
	}
	public void setRiderName(String riderName) {
		this.riderName = riderName;
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
	public int getRiderAge() {
		return riderAge;
	}
	public void setRiderAge(String r) {
		String temp = r.substring(0,4);
		int year = 2020;
		int num = Integer.parseInt(temp);
		int result = year - num +1; 
		
		this.riderAge = result;
	}
	public String getRiderAvgPoint() {
		return riderAvgPoint;
	}
	public void setRiderAvgPoint(String riderAvgPoint) {
		this.riderAvgPoint = riderAvgPoint;
	}
	public String getRiderBlackListStart() {
		return riderBlackListStart;
	}
	public void setRiderBlackListStart(String riderBlackListStart) {
		this.riderBlackListStart = riderBlackListStart;
	}
	public String getRiderBlackListEnd() {
		return riderBlackListEnd;
	}
	public void setRiderBlackListEnd(String riderBlackListStart) {
		String[] temp = riderBlackListStart.split("-");
		int year = Integer.parseInt(temp[0]);
		String riderBlackListEnd = "";
		if(temp[1].equals("01")) {
			riderBlackListEnd = year+"-02-01";
		} else if(temp[1].equals("02")) {
			riderBlackListEnd = year+"-03-01";
		} else if(temp[1].equals("03")) {
			riderBlackListEnd = year+"-04-01";
		} else if(temp[1].equals("04")) {
			riderBlackListEnd = year+"-05-01";
		} else if(temp[1].equals("05")) {
			riderBlackListEnd = year+"-06-01";
		} else if(temp[1].equals("06")) {
			riderBlackListEnd = year+"-07-01";
		} else if(temp[1].equals("07")) {
			riderBlackListEnd = year+"-08-01";
		} else if(temp[1].equals("08")) {
			riderBlackListEnd = year+"-09-01";
		} else if(temp[1].equals("09")) {
			riderBlackListEnd = year+"-10-01";
		} else if(temp[1].equals("10")) {
			riderBlackListEnd = year+"-11-01";
		} else if(temp[1].equals("11")) {
			riderBlackListEnd = year+"-12-01";
		} else if(temp[1].equals("12")) {
			riderBlackListEnd = (year+1)+"-01-01";
		}
		
		
		this.riderBlackListEnd = riderBlackListEnd;
	}
	
}
