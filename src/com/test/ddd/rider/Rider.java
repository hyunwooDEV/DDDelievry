package com.test.ddd.rider;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

import com.test.ddd.fileroad.FileRoad;

public class Rider {

	private String riderNum; //라이더 회원번호
	private String riderId; // 로그인 아이디
	private String riderPw; // 로그인 패스워드
	private String riderName; // 회원정보 이름
	private String riderBirth; // 회원정보 생년월일
	private String riderGender; // 회원정보 성별
	private String riderPhoneNumber; // 회원정보 휴대폰번호
	private String riderAddress; // 회원정보 주소
	private String riderDetailAddress; //회원 상세주소
	private String riderArea; // 회원정보 활동지역
	private String riderScore; // 라이더 평점
	private String riderFee; // 라이더 임금
	private String riderDelete; //라이더 탈퇴
	
	
	public Rider(String riderNum, String riderId, String riderPw, String riderName, String riderBirth,
			String riderGender, String riderPhoneNumber, String riderAddress, String riderDetailAddress,
			String riderArea, String riderScore, String riderFee, String riderDelete) {
		this.riderNum = riderNum;
		this.riderId = riderId;
		this.riderPw = riderPw;
		this.riderName = riderName;
		this.riderBirth = riderBirth;
		this.riderGender = riderGender;
		this.riderPhoneNumber = riderPhoneNumber;
		this.riderAddress = riderAddress;
		this.riderDetailAddress = riderDetailAddress;
		this.riderArea = riderArea;
		this.riderScore = riderScore;
		this.riderFee = riderFee;
		this.riderDelete = riderDelete;
	}

	public Rider(String riderId) {
		
		String path = FileRoad.RIDERFINAL;
		
		ArrayList<String> list = new ArrayList<String>();
		try {

			BufferedReader reader = new BufferedReader(new FileReader(path));
			
			String line = null;
			
			while((line = reader.readLine()) != null) {
				
				String[] info = line.split(",");
				if(info[1].equals(riderId)) {
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
		
		this.riderNum = list.get(0);
		this.riderId = list.get(1);
		this.riderPw = list.get(2);
		this.riderName = list.get(3);
		this.riderBirth = list.get(4);
		this.riderGender = list.get(5);
		this.riderPhoneNumber = list.get(6);
		this.riderAddress = list.get(7);
		this.riderDetailAddress = list.get(8);
		this.riderArea = list.get(9);
		this.riderScore = list.get(10);
		this.riderFee = list.get(11);
		this.riderDelete = list.get(12);
		
	}
	
	public Rider(String riderNum, int num) {
		
		String path = FileRoad.RIDERFINAL;
		
		ArrayList<String> list = new ArrayList<String>();
		try {

			BufferedReader reader = new BufferedReader(new FileReader(path));
			
			String line = null;
			
			while((line = reader.readLine()) != null) {
				
				String[] info = line.split(",");
				if(info[0].equals(riderNum)) {
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
		
		this.riderNum = list.get(0);
		this.riderId = list.get(1);
		this.riderPw = list.get(2);
		this.riderName = list.get(3);
		this.riderBirth = list.get(4);
		this.riderGender = list.get(5);
		this.riderPhoneNumber = list.get(6);
		this.riderAddress = list.get(7);
		this.riderDetailAddress = list.get(8);
		this.riderArea = list.get(9);
		this.riderScore = list.get(10);
		this.riderFee = list.get(11);
		this.riderDelete = list.get(12);
		
	}
	
	
	public Rider() {
		
	}

	
	public String getRiderNum() {
		return riderNum;
	}
	public void setRiderNum(String riderNum) {
		this.riderNum = riderNum;
	}
	public String getRiderId() {
		return riderId;
	}
	public void setRiderId(String riderId) {
		this.riderId = riderId;
	}
	public String getRiderPw() {
		return riderPw;
	}
	public void setRiderPw(String riderPw) {
		this.riderPw = riderPw;
	}
	public String getRiderName() {
		return riderName;
	}
	public void setRiderName(String riderName) {
		this.riderName = riderName;
	}
	public String getRiderBirth() {
		return riderBirth;
	}
	public void setRiderBirth(String riderBirth) {
		this.riderBirth = riderBirth;
	}
	public String getRiderGender() {
		return riderGender;
	}
	public void setRiderGender(String riderGender) {
		this.riderGender = riderGender;
	}
	public String getRiderPhoneNumber() {
		return riderPhoneNumber;
	}
	public void setRiderPhoneNumber(String riderPhoneNumber) {
		this.riderPhoneNumber = riderPhoneNumber;
	}
	public String getRiderAddress() {
		return riderAddress;
	}
	public void setRiderAddress(String riderAddress) {
		this.riderAddress = riderAddress;
	}
	public String getRiderDetailAddress() {
		return riderDetailAddress;
	}
	public void setRiderDetailAddress(String riderDetailAddress) {
		this.riderDetailAddress = riderDetailAddress;
	}
	public String getRiderArea() {
		return riderArea;
	}
	public void setRiderArea(String riderArea) {
		this.riderArea = riderArea;
	}
	public String getRiderScore() {
		return riderScore;
	}
	public void setRiderScore(String riderScore) {
		this.riderScore = riderScore;
	}
	public String getRiderFee() {
		return riderFee;
	}
	public void setRiderFee(String riderFee) {
		this.riderFee = riderFee;
	}
	public String getRiderDelete() {
		return riderDelete;
	}
	public void setRiderDelete(String riderDelete) {
		this.riderDelete = riderDelete;
	}
	
	
	
}
