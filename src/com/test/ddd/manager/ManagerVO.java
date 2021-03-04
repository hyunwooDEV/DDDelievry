package com.test.ddd.manager;

public class ManagerVO {


	private String managerID;
	private String managerPW;

				
	public ManagerVO(String id,String pw) {
		this.managerID = id;
		this.managerPW = pw;
	}
	public ManagerVO(String id) {
		this.managerID = id;
		
	}
	public String getManagerID() {
		return managerID;
	}
	public void setManagerID(String managerID) {
		this.managerID = managerID;
	}
	public String getManagerPW() {
		return managerPW;
	}
	public void setManagerPW(String managerPW) {
		this.managerPW = managerPW;
	}
	
}
