package com.test.ddd.store;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

import com.test.ddd.fileroad.FileRoad;

public class Store {

	
		//업체
		
		//업체 회원가입 들어간 요소 :
		// - 아이디, 비밀번호, 오너 이름, 오너 성별, 오너 생년월일, 오너 전화번호, 오너 집주소, 업체명, 업체 카테고리, 메뉴(음식, 가격), 오픈시간, 마감시간, 소개글, 업체 주소, 업체 상세 주소, 업체 전화번호, 사업자등록번호, 위생등급, 평균배달 소요시간, 배달비, 광고 서비스 이용 유무  
		
		private String storeID; //업체 아이디
		private String storePW; //업체 비밀번호
		private String name; //업체 오너 이름
		private String gender; //업체 오너 성별
		private String birth; //업체 오너 생년월일
		private String phoneNum; //업체 오너 전화번호
		private String storeOwnerAddress; //업체 오너 주소
		private String storeOwnerAddressDetail; //업체 오너 상세 주소
		private String storeName; //업체 이름
		private String storeIntroduction; //업체 소개글
		private String storePhoneNum; //업체 전화번호
		private String licenseNum; //업체 사업자 등록번호
		private String sanitationGrade; //업체 위생 등급
		private String address; //업체 주소
		private String addressDetail; //업체 상세주소
		private String category; //업체 음식 카테고리
		private String storeMenu; //업체 메뉴 - 회원가입 말고 다른페이지에서 설정
		private String openTime; //업체 오픈시간
		private String closeTime; //업체 마감시간
		private String deliveryTime; //평균 배달 소요 시간
		private String deliveryCost; //배달비
		private String ad; //업체 광고서비스 이용 유무
		
		
		//로그인에서 추가된 내용 :
		// - 업체 회원번호, 수수료등급, 매출, 리뷰, 평점, 배달이력, 신고, 탈퇴여부
		private String storeMemberNum; //업체 회원번호
		private String chargeGrade; //업체 수수료 등급
		private String sales; //매출액
		private String review; //업체 리뷰
		private String storeScore; //업체 평점
		private String deliveryRecord; //업체 배달 이력
		private String storeReport; //업체 신고
		private String storeDelete; //업체 탈퇴
		
		public Store(String storeID) {
			
			String path = FileRoad.STOREFINAL;
			
			ArrayList<String> list = new ArrayList<String>();
			try {

				BufferedReader reader = new BufferedReader(new FileReader(path));
				
				String line = null;
				
				while((line = reader.readLine()) != null) {
					
					String[] info = line.split(",");
					if(info[1].equals(storeID)) {
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
			
			
			this.storeMemberNum = list.get(0);
			this.storeID = list.get(1);
			this.storePW = list.get(2);
			this.name = list.get(3);
			this.birth = list.get(4);
			this.gender = list.get(5);
			this.phoneNum = list.get(6);
			this.storeOwnerAddress = list.get(7);
			this.addressDetail = list.get(8);
			this.storeName = list.get(9);
			this.openTime = list.get(10);
			this.closeTime = list.get(11);
			this.storeIntroduction = list.get(12);
			this.address = list.get(13);
			this.storePhoneNum = list.get(14);
			this.licenseNum = list.get(15);
			this.sanitationGrade = list.get(16);
			this.deliveryTime = list.get(17);
			this.deliveryCost = list.get(18);
			this.chargeGrade = list.get(19);
			this.ad = list.get(20);
			this.sales = list.get(21);
			this.storeScore = list.get(22);
			this.category = list.get(23);
			this.storeDelete = list.get(24);
			
		}
		
		public Store(String storeNo, int number) {
			
			String path = FileRoad.STOREFINAL;
			
			ArrayList<String> list = new ArrayList<String>();
			try {

				BufferedReader reader = new BufferedReader(new FileReader(path));
				
				String line = null;
				
				while((line = reader.readLine()) != null) {
					
					String[] info = line.split(",");
					if(info[0].equals(storeNo)) {
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
			
			
			this.storeMemberNum = list.get(0);
			this.storeID = list.get(1);
			this.storePW = list.get(2);
			this.name = list.get(3);
			this.birth = list.get(4);
			this.gender = list.get(5);
			this.phoneNum = list.get(6);
			this.storeOwnerAddress = list.get(7);
			this.addressDetail = list.get(8);
			this.storeName = list.get(9);
			this.openTime = list.get(10);
			this.closeTime = list.get(11);
			this.storeIntroduction = list.get(12);
			this.address = list.get(13);
			this.storePhoneNum = list.get(14);
			this.licenseNum = list.get(15);
			this.sanitationGrade = list.get(16);
			this.deliveryTime = list.get(17);
			this.deliveryCost = list.get(18);
			this.chargeGrade = list.get(19);
			this.ad = list.get(20);
			this.sales = list.get(21);
			this.storeScore = list.get(22);
			this.category = list.get(23);
			this.storeDelete = list.get(24);
			
		}
		
		
		public Store(String storeID, String storePW, String name, String gender, String birth, String phoneNum,
				String storeOwnerAddress, String storeName, String storeIntroduction, String storePhoneNum,
				String licenseNum, String sanitationGrade, String address, String addressDetail, String category,
				String openTime, String closeTime, String deliveryTime, String deliveryCost, String ad, String storeMemberNum,
				String chargeGrade, String sales, String storeScore, String storeDelete, String storeOwnerAddressDetail) {
			
			this.storeID = storeID;
			this.storePW = storePW;
			this.name = name;
			this.gender = gender;
			this.birth = birth;
			this.phoneNum = phoneNum;
			this.storeOwnerAddress = storeOwnerAddress;
			this.storeName = storeName;
			this.storeIntroduction = storeIntroduction;
			this.storePhoneNum = storePhoneNum;
			this.licenseNum = licenseNum;
			this.sanitationGrade = sanitationGrade;
			this.address = address;
			this.addressDetail = addressDetail;
			this.category = category;
			this.openTime = openTime;
			this.closeTime = closeTime;
			this.deliveryTime = deliveryTime;
			this.deliveryCost = deliveryCost;
			this.ad = ad;
			this.storeMemberNum = storeMemberNum;
			this.chargeGrade = chargeGrade;
			this.sales = sales;
			this.storeScore = storeScore;
			this.storeDelete = storeDelete;
			this.storeOwnerAddressDetail = storeOwnerAddressDetail;
		}




		public Store(String storeID, String storePW) { //업체 id, pw 생성자
			super();
			this.storeID = storeID;
			this.storePW = storePW;
		}

		
		
		public Store() { //업체 기본 생성자
			
			
		}
		



		//여기서부터 업체 getter, setter
		public String getStoreID() {
			return storeID;
		}




		public void setStoreID(String storeID) {
			this.storeID = storeID;
		}




		public String getStorePW() {
			return storePW;
		}




		public void setStorePW(String storePW) {
			this.storePW = storePW;
		}




		public String getName() {
			return name;
		}




		public void setName(String name) {
			this.name = name;
		}




		public String getGender() {
			return gender;
		}




		public void setGender(String gender) {
			this.gender = gender;
		}




		public String getBirth() {
			return birth;
		}




		public void setBirth(String birth) {
			this.birth = birth;
		}




		public String getPhoneNum() {
			return phoneNum;
		}




		public void setPhoneNum(String phoneNum) {
			this.phoneNum = phoneNum;
		}




		public String getStoreOwnerAddress() {
			return storeOwnerAddress;
		}




		public void setStoreOwnerAddress(String storeOwnerAddress) {
			this.storeOwnerAddress = storeOwnerAddress;
		}




		public String getStoreName() {
			return storeName;
		}




		public void setStoreName(String storeName) {
			this.storeName = storeName;
		}




		public String getStoreIntroduction() {
			return storeIntroduction;
		}




		public void setStoreIntroduction(String storeIntroduction) {
			this.storeIntroduction = storeIntroduction;
		}




		public String getStorePhoneNum() {
			return storePhoneNum;
		}




		public void setStorePhoneNum(String storePhoneNum) {
			this.storePhoneNum = storePhoneNum;
		}




		public String getLicenseNum() {
			return licenseNum;
		}




		public void setLicenseNum(String licenseNum) {
			this.licenseNum = licenseNum;
		}




		public String getSanitationGrade() {
			return sanitationGrade;
		}




		public void setSanitationGrade(String sanitationGrade) {
			this.sanitationGrade = sanitationGrade;
		}




		public String getAddress() {
			return address;
		}




		public void setAddress(String address) {
			this.address = address;
		}




		public String getAddressDetail() {
			return addressDetail;
		}




		public void setAddressDetail(String addressDetail) {
			this.addressDetail = addressDetail;
		}




		public String getCategory() {
			return category;
		}




		public void setCategory(String category) {
			this.category = category;
		}




		public String getOpenTime() {
			return openTime;
		}




		public void setOpenTime(String openTime) {
			this.openTime = openTime;
		}




		public String getCloseTime() {
			return closeTime;
		}




		public void setCloseTime(String closeTime) {
			this.closeTime = closeTime;
		}




		public String getDeliveryTime() {
			return deliveryTime;
		}




		public void setDeliveryTime(String deliveryTime) {
			this.deliveryTime = deliveryTime;
		}




		public String getDeliveryCost() {
			return deliveryCost;
		}




		public void setDeliveryCost(String deliveryCost) {
			this.deliveryCost = deliveryCost;
		}




		public String getAd() {
			return ad;
		}




		public void setAd(String ad) {
			this.ad = ad;
		}




		public String getStoreMemberNum() {
			return storeMemberNum;
		}




		public void setStoreMemberNum(String storeMemberNum) {
			this.storeMemberNum = storeMemberNum;
		}




		public String getChargeGrade() {
			return chargeGrade;
		}




		public void setChargeGrade(String chargeGrade) {
			this.chargeGrade = chargeGrade;
		}




		public String getSales() {
			return sales;
		}




		public void setSales(String sales) {
			this.sales = sales;
		}




		public String getStoreScore() {
			return storeScore;
		}




		public void setStoreScore(String storeScore) {
			this.storeScore = storeScore;
		}




		public String getStoreDelete() {
			return storeDelete;
		}




		public void setStoreDelete(String storeDelete) {
			this.storeDelete = storeDelete;
		}




		public String getStoreOwnerAddressDetail() {
			return storeOwnerAddressDetail;
		}




		public void setStoreOwnerAddressDetail(String storeOwnerAddressDetail) {
			this.storeOwnerAddressDetail = storeOwnerAddressDetail;
		}




		public String getStoreMenu() {
			return storeMenu;
		}




		public void setStoreMenu(String storeMenu) {
			this.storeMenu = storeMenu;
		}




		public String getReview() {
			return review;
		}




		public void setReview(String review) {
			this.review = review;
		}




		public String getDeliveryRecord() {
			return deliveryRecord;
		}




		public void setDeliveryRecord(String deliveryRecord) {
			this.deliveryRecord = deliveryRecord;
		}




		public String getStoreReport() {
			return storeReport;
		}




		public void setStoreReport(String storeReport) {
			this.storeReport = storeReport;
		}
		
		
		

	
}
