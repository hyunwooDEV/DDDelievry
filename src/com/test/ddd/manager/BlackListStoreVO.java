package com.test.ddd.manager;

public class BlackListStoreVO {

	private String storeName = "";
	private String storeAddr1 = "";
	private String storeAddr2 = "";
	private String storeNumber = "";
	private int sCancelCount = 0;
	private String sBlackListStart = "";
	private String sBlackListEnd = "";
	public String getStoreName() {
		return storeName;
	}
	public void setStoreName(String storeName) {
		this.storeName = storeName;
	}
	public String getStoreAddr1() {
		return storeAddr1;
	}
	public void setStoreAddr1(String storeAddr1) {
		this.storeAddr1 = storeAddr1;
	}
	public String getStoreAddr2() {
		return storeAddr2;
	}
	public void setStoreAddr2(String storeAddr2) {
		this.storeAddr2 = storeAddr2;
	}
	public String getStoreNumber() {
		return storeNumber;
	}
	public void setStoreNumber(String storeNumber) {
		this.storeNumber = storeNumber;
	}
	public int getsCancelCount() {
		return sCancelCount;
	}
	public void setsCancelCount(int sCancelCount) {
		this.sCancelCount = sCancelCount;
	}
	public String getsBlackListStart() {
		return sBlackListStart;
	}
	public void setsBlackListStart(String sBlackListStart) {
		this.sBlackListStart = sBlackListStart;
	}
	public String getsBlackListEnd() {
		return sBlackListEnd;
	}
	public void setsBlackListEnd(String sBlackListStart) {
		String[] temp = sBlackListStart.split("-");
		String sBlackListEnd = "";
		int year = Integer.parseInt(temp[0]);
		if (temp[1].equals("01")) {
			sBlackListEnd = year+"-02-01";
		}else if(temp[1].equals("02")) {
			sBlackListEnd = year+"-03-01";
		}else if(temp[1].equals("03")) {
			sBlackListEnd = year+"-04-01";
		}else if(temp[1].equals("04")) {
			sBlackListEnd = year+"-05-01";
		}else if(temp[1].equals("05")) {
			sBlackListEnd = year+"-06-01";
		}else if(temp[1].equals("06")) {
			sBlackListEnd = year+"-07-01";
		}else if(temp[1].equals("07")) {
			sBlackListEnd = year+"-08-01";
		}else if(temp[1].equals("08")) {
			sBlackListEnd = year+"-09-01";
		}else if(temp[1].equals("09")) {
			sBlackListEnd = year+"-10-01";
		}else if(temp[1].equals("10")) {
			sBlackListEnd = year+"-11-01";
		}else if(temp[1].equals("11")) {
			sBlackListEnd = year+"-12-01";
		}else if(temp[1].equals("12")) {
			sBlackListEnd = (year+1)+"-01-01";
		}
		this.sBlackListEnd = sBlackListEnd;
	}
	
}
