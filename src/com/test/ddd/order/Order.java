package com.test.ddd.order;

import java.io.BufferedReader;
import java.io.FileReader;

import com.test.ddd.fileroad.FileRoad;

public class Order {
	
	private int totalCost;
	private String needs;
	private int point;
	private String cancel;
	
	//주문 객체
	private String orderNum;
	private String customerNum;
	private String storeNum;
	private String riderNum;
	private String orderAddress;
	private String orderAddressDetail;
	private String deliveryState;
	private String orderNeeds;
	private String orderDate;
	private String usingPoint;
	private String deliveryCost;
	private String orderTotalCost;
	
	
	
	public Order() {
		
	
		
	}
	
	public Order(String orderNum) {
		
		String path = FileRoad.ORDERLIST;
		
		try {
			
			BufferedReader reader = new BufferedReader(new FileReader(path));
			
			String line = null;
			
			while((line=reader.readLine()) != null) {
				
				String[] info = line.split(",");
				
				if(info[0].equals(orderNum)) {
					
					this.orderNum = info[0];
					this.customerNum = info[1];
					this.storeNum = info[2];
					this.riderNum = info[3];
					this.orderAddress = info[4];
					this.orderAddressDetail = info[5];
					this.deliveryState = info[6];
					this.orderNeeds = info[7];
					this.orderDate = info[8];
					this.usingPoint = info[9];
					this.deliveryCost = info[10];
					this.orderTotalCost = info[11];
					
				}
				
			}
			
		} catch (Exception e) {
			System.out.println("order(orderNum) 생성자 오류");
		}
		
		
	}
	
	

	public Order(int totalCost, String needs, int point, String cancel) {
		super();
		this.totalCost = totalCost;
		this.needs = needs;
		this.point = point;
		this.cancel = cancel;
	}



	public int getTotalCost() {
		return totalCost;
	}
	public void setTotalCost(int totalCost) {
		this.totalCost = totalCost;
	}
	public String getNeeds() {
		return needs;
	}
	public void setNeeds(String needs) {
		this.needs = needs;
	}
	public int getPoint() {
		return point;
	}
	public void setPoint(int point) {
		this.point = point;
	}

	public String getCancel() {
		return cancel;
	}

	public void setCancel(String cancel) {
		this.cancel = cancel;
	}

	public String getOrderNum() {
		return orderNum;
	}

	public void setOrderNum(String orderNum) {
		this.orderNum = orderNum;
	}

	public String getCustomerNum() {
		return customerNum;
	}

	public void setCustomerNum(String customerNum) {
		this.customerNum = customerNum;
	}

	public String getStoreNum() {
		return storeNum;
	}

	public void setStoreNum(String storeNum) {
		this.storeNum = storeNum;
	}

	public String getRiderNum() {
		return riderNum;
	}

	public void setRiderNum(String riderNum) {
		this.riderNum = riderNum;
	}

	public String getOrderAddress() {
		return orderAddress;
	}

	public void setOrderAddress(String orderAddress) {
		this.orderAddress = orderAddress;
	}

	public String getOrderAddressDetail() {
		return orderAddressDetail;
	}

	public void setOrderAddressDetail(String orderAddressDetail) {
		this.orderAddressDetail = orderAddressDetail;
	}

	public String getDeliveryState() {
		return deliveryState;
	}

	public void setDeliveryState(String deliveryState) {
		this.deliveryState = deliveryState;
	}

	public String getOrderNeeds() {
		return orderNeeds;
	}

	public void setOrderNeeds(String orderNeeds) {
		this.orderNeeds = orderNeeds;
	}

	public String getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(String orderDate) {
		this.orderDate = orderDate;
	}

	public String getUsingPoint() {
		return usingPoint;
	}

	public void setUsingPoint(String usingPoint) {
		this.usingPoint = usingPoint;
	}

	public String getDeliveryCost() {
		return deliveryCost;
	}

	public void setDeliveryCost(String deliveryCost) {
		this.deliveryCost = deliveryCost;
	}

	public String getOrderTotalCost() {
		return orderTotalCost;
	}

	public void setOrderTotalCost(String orderTotalCost) {
		this.orderTotalCost = orderTotalCost;
	}
	
	

}
