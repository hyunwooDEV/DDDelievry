package com.test.ddd.customer;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

import com.test.ddd.fileroad.FileRoad;

public class Customer {

	private String customerNum;// 주문 회원 번호
	private String customerId; // 주문 회원 아이디
	private String customerPw; // 주문 회원 비밀번호
	private String customerName; // 주문 회원 이름
	private String customerBirth;// 주문 회원 생년월일
	private String customerGender;// 주문 회원 성별
	private String customerPhoneNum; // 주문 회원 전화번호
	private String customerAddress;// 주문 회원 주소
	private String customerAddressDetail;// 주문 회원 상세 주소

	private String customerGrade;// 주문 회원 등급
	private int customerPoint;// 주문 회원 포인트
	private String customerfavoriteFood;// 주문 회원 선호 음식
	private String customerCardNum;// 카드 정보
	
	private String customerDelete;//주문 회원 탈퇴
	
	private String customerFavoriteStore;//주문 회원 즐겨찾기 매장
	private String customerRequests;//주문 회원 요청사항

	
	
	public Customer(String customerNum, String customerId, String customerPw, String customerName, String customerBirth,
			String customerGender, String customerPhoneNum, String customerAddress, String customerAddressDetail,
			String customerGrade, int customerPoint, String customerfavoriteFood, String customerCardNum,
			String customerDelete, String customerFavoriteStore, String customerRequests) {

		this.customerNum = customerNum;
		this.customerId = customerId;
		this.customerPw = customerPw;
		this.customerName = customerName;
		this.customerBirth = customerBirth;
		this.customerGender = customerGender;
		this.customerPhoneNum = customerPhoneNum;
		this.customerAddress = customerAddress;
		this.customerAddressDetail = customerAddressDetail;
		this.customerGrade = customerGrade;
		this.customerPoint = customerPoint;
		this.customerfavoriteFood = customerfavoriteFood;
		this.customerCardNum = customerCardNum;
		this.customerDelete = customerDelete;
		this.customerFavoriteStore = customerFavoriteStore;
		this.customerRequests = customerRequests;
	}

	public Customer(String customerNum, String customerId, String customerPw, String customerName, String customerBirth,
			String customerGender, String customerPhoneNum, String customerAddress, String customerAddressDetail, String customerGrade, int customerPoint,
			String customerfavoriteFood, String cardNum, String customerDelete) {

		this.customerNum = customerNum;
		this.customerId = customerId;
		this.customerPw = customerPw;
		this.customerName = customerName;
		this.customerBirth = customerBirth;
		this.customerGender = customerGender;
		this.customerPhoneNum = customerPhoneNum;
		this.customerAddress = customerAddress;
		this.customerAddressDetail = customerAddressDetail;
		this.customerGrade = customerGrade;
		this.customerPoint = customerPoint;
		this.customerfavoriteFood = customerfavoriteFood;
		this.customerCardNum = cardNum;
		this.customerDelete = customerDelete;
	}
	
	public Customer(String id) {
		
		String path = FileRoad.CUSTOMERFINAL;
		
		ArrayList<String> list = new ArrayList<String>();
		try {

			BufferedReader reader = new BufferedReader(new FileReader(path));
			
			String line = null;
			
			while((line = reader.readLine()) != null) {
				
				String[] info = line.split(",");
				if(info[1].equals(id)) {
					for(int i=0; i < info.length; i++) {
						list.add(i, info[i]);
					}
				}
				
			}
			
			reader.close();

		} catch (Exception e) {
			System.out.println("Customer.Customer()");
			e.printStackTrace();
		}
		
		this.customerNum = list.get(0);
		this.customerId = list.get(1);
		this.customerPw = list.get(2);
		this.customerName = list.get(3);
		this.customerBirth = list.get(4);
		this.customerGender = list.get(5);
		this.customerPhoneNum = list.get(6);
		this.customerAddress = list.get(7);
		this.customerAddressDetail = list.get(8);
		this.customerGrade = list.get(9);
		this.customerPoint = Integer.parseInt(list.get(10));
		this.customerfavoriteFood = list.get(11);
		this.customerCardNum = list.get(12);
		this.customerDelete = list.get(13);
		
	}
	
	public Customer(String customerNum, int num) {
		
		String path = FileRoad.CUSTOMERFINAL;
		
		ArrayList<String> list = new ArrayList<String>();
		try {

			BufferedReader reader = new BufferedReader(new FileReader(path));
			
			String line = null;
			
			while((line = reader.readLine()) != null) {
				
				String[] info = line.split(",");
				if(info[0].equals(customerNum)) {
					for(int i=0; i < info.length; i++) {
						list.add(i, info[i]);
					}
				}
				
			}
			
			reader.close();

		} catch (Exception e) {
			System.out.println("Customer.Customer()");
			e.printStackTrace();
		}
		
		this.customerNum = list.get(0);
		this.customerId = list.get(1);
		this.customerPw = list.get(2);
		this.customerName = list.get(3);
		this.customerBirth = list.get(4);
		this.customerGender = list.get(5);
		this.customerPhoneNum = list.get(6);
		this.customerAddress = list.get(7);
		this.customerAddressDetail = list.get(8);
		this.customerGrade = list.get(9);
		this.customerPoint = Integer.parseInt(list.get(10));
		this.customerfavoriteFood = list.get(11);
		this.customerCardNum = list.get(12);
		this.customerDelete = list.get(13);
		
	}
	
	
	
	
	
	
	public Customer() {
		
	}


	public String getCustomerNum() {
		return customerNum;
	}

	public void setCustomerNum(String customerNum) {
		this.customerNum = customerNum;
	}

	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	public String getCustomerPw() {
		return customerPw;
	}

	public void setCustomerPw(String customerPw) {
		this.customerPw = customerPw;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getCustomerBirth() {
		return customerBirth;
	}

	public void setCustomerBirth(String customerBirth) {
		this.customerBirth = customerBirth;
	}

	public String getCustomerGender() {
		return customerGender;
	}

	public void setCustomerGender(String customerGender) {
		this.customerGender = customerGender;
	}

	public String getCustomerPhoneNum() {
		return customerPhoneNum;
	}

	public void setCustomerPhoneNum(String customerPhoneNum) {
		this.customerPhoneNum = customerPhoneNum;
	}

	public String getCustomerAddress() {
		return customerAddress;
	}

	public void setCustomerAddress(String customerAddress) {
		this.customerAddress = customerAddress;
	}

	public String getCustomerGrade() {
		return customerGrade;
	}

	public void setCustomerGrade(String customerGrade) {
		this.customerGrade = customerGrade;
	}

	public int getCustomerPoint() {
		return customerPoint;
	}

	public void setCustomerPoint(int customerPoint) {
		this.customerPoint = customerPoint;
	}

	public String getCustomerfavoriteFood() {
		return customerfavoriteFood;
	}

	public void setCustomerfavoriteFood(String customerfavoriteFood) {
		this.customerfavoriteFood = customerfavoriteFood;
	}

	public String getCustomerCardNum() {
		return customerCardNum;
	}

	public void setCustomerCardNum(String customerCardNum) {
		this.customerCardNum = customerCardNum;
	}



	public String getCustomerDelete() {
		return customerDelete;
	}



	public void setCustomerDelete(String customerDelete) {
		this.customerDelete = customerDelete;
	}



	public String getCustomerAddressDetail() {
		return customerAddressDetail;
	}



	public void setCustomerAddressDetail(String customerAddressDetail) {
		this.customerAddressDetail = customerAddressDetail;
	}

	public String getCustomerFavoriteStore() {
		return customerFavoriteStore;
	}

	public void setCustomerFavoriteStore(String customerFavoriteStore) {
		this.customerFavoriteStore = customerFavoriteStore;
	}

	public String getCustomerRequests() {
		return customerRequests;
	}

	public void setCustomerRequests(String customerRequests) {
		this.customerRequests = customerRequests;
	}

}
