package com.test.ddd.manager;

public class ManagingAdvertiseVO {
	
	String storeName = "";
	String storeNumber = "";
	String storeLocation = "";
	String storeAvgPoint = "";
	String storeOrderedCount = "";
	String storeCleanLevel = "";
	String storeFeesLevel = "";
	String storeAdsEnd = "";

	public String getStoreName() {
		return storeName;
	}

	public void setStoreName(String storeName) {
		this.storeName = storeName;
	}

	public String getStoreNumber() {
		return storeNumber;
	}

	public void setStoreNumber(String storeNumber) {
		this.storeNumber = storeNumber;
	}

	public String getStoreLocation() {
		return storeLocation;
	}

	public void setStoreLocation(String storeLocation) {
		this.storeLocation = storeLocation;
	}

	public String getStoreAvgPoint() {
		return storeAvgPoint;
	}

	public void setStoreAvgPoint(String storeAvgPoint) {
		this.storeAvgPoint = storeAvgPoint;
	}

	public String getStoreOrderedCount() {
		return storeOrderedCount;
	}

	public void setStoreOrderedCount(String storeOrderedCount) {
		this.storeOrderedCount = storeOrderedCount;
	}

	public String getStoreCleanLevel() {
		return storeCleanLevel;
	}

	public void setStoreCleanLevel(String storeCleanLevel) {
		this.storeCleanLevel = storeCleanLevel;
	}

	public String getStoreFeesLevel() {
		return storeFeesLevel;
	}

	public void setStoreFeesLevel(String storeFeesLevel) {
		
		String result = "";
		
		if (storeFeesLevel.equals("0.05")) {
			result = "VIP";
		} else if(storeFeesLevel.equals("0.03"))
			result = "일반";
			
			
		this.storeFeesLevel = result;
	}


	public String getStoreAdsEnd() {
		return storeAdsEnd;
	}

	public void setStoreAdsEnd(String storeAdsEnd) {
		int year = Integer.parseInt(storeAdsEnd.substring(0,4));
		String month = storeAdsEnd.substring(4, 6);
		
		String result = "";
		if(month.equals("01")) {
			result = year+"-02-01";
		}else if(month.equals("02")) {
			result = year+"-03-01";
			
		}else if(month.equals("03")) {
			result = year+"-04-01";
			
		}else if(month.equals("04")) {
			result = year+"-05-01";
			
		}else if(month.equals("05")) {
			result = year+"-06-01";
			
		}else if(month.equals("06")) {
			result = year+"-07-01";
			
		}else if(month.equals("07")) {
			result = year+"-08-01";
			
		}else if(month.equals("08")) {
			result = year+"-09-01";
			
		}else if(month.equals("09")) {
			result = year+"-10-01";
			
		}else if(month.equals("10")) {
			result = year+"-11-01";
			
		}else if(month.equals("11")) {
			result = year+"-12-01";
			
		}else if(month.equals("12")) {
			result = (year+1)+"-01-01";
			
		}
		
		this.storeAdsEnd = result;
	}

	public ManagingAdvertiseVO() {
		
	}
}
