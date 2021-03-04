package com.test.ddd.customer;

import java.util.Scanner;

import com.test.ddd.rider.Rider;
import com.test.ddd.store.Store;

public class ShowData {
	
public static void main(String[] args) {
		
		customerInfo("c_sist0100");
//		storeInfo("s_sist0000");
//		riderInfo("r_sist0000");
		
	}
	
	//고객 마이페이지 화면
	//1번을 선택하면 수정/삭제가 가능함
	//0번을 선택하면 이전화면으로 돌아감
	public static void customerInfo(String id) {
		
		Scanner scan = new Scanner(System.in);
		
		Customer c = new Customer(id);
		
		System.out.println("\t\t마이페이지");
		System.out.println("------------------------------------------------");
		System.out.println("★ 회원번호: " + c.getCustomerNum());
		System.out.println("★ 회원아이디: " + c.getCustomerId());
		System.out.println("1. 이름: " + c.getCustomerName());
		System.out.println("2. 비밀번호: " + c.getCustomerPw());
		System.out.println("3. 생년월일: " + c.getCustomerBirth());
		System.out.println("4. 전화번호: " + c.getCustomerPhoneNum());
		System.out.println("5. 주소: " + c.getCustomerAddress());
		System.out.println("6. 상세주소: " + c.getCustomerAddressDetail());
		System.out.println("7. 카드번호: " + c.getCustomerCardNum());
		System.out.println("8. 선호음식: " + c.getCustomerfavoriteFood());
		
		boolean loop = true;
		while(loop) {
			
			System.out.println("------------------------------------------------");
			System.out.println("1. 수정/삭제하기");
			System.out.println("0. 이전화면");
			
			System.out.println("------------------------------------------------");
			System.out.print("번호입력: ");
			String result = scan.nextLine();
			
			if(result.equals("1")) {
				System.out.println("-----------------------------------------------");
				System.out.println("1. 수정하기/삭제하기");
				loop = false;
				Modify.modify(c.getCustomerId());
				break;
			}else if(result.equals("0")) {
				System.out.println("-----------------------------------------------");
				System.out.println("이전으로 돌아갑니다.");
				//이전화면 추가해야 함
				loop = false;
				break;
			}else {
				System.out.println("-----------------------------------------------");
				System.out.println("값을 잘못 입력하셨습니다.");
			}
		}
		
	}
	
	//스토어 마이페이지 화면
	//1번을 선택하면 수정이 가능함
	//0번을 선택하면 이전화면으로 돌아감
	public static void storeInfo(String id) {
		
		Scanner scan = new Scanner(System.in);
		
		Store s = new Store(id);
		
		System.out.println("\t\t마이페이지");
		System.out.println("------------------------------------------------");
		System.out.println("★ 회원번호: " + s.getStoreMemberNum());
		System.out.println("★ 회원아이디: " + s.getStoreID());
		System.out.println("★ 위생등급: " + s.getSanitationGrade());
		System.out.println("1. 이름: " + s.getStoreName());
		System.out.println("2. 비밀번호: " + s.getStorePW());
		System.out.println("3. 전화번호: " + s.getStorePhoneNum());
		System.out.println("4. 주소: " + s.getAddress());
		System.out.println("5. 운영시간: " + s.getOpenTime() + "~" + s.getCloseTime());
		System.out.println("6. 소개글: " + s.getStoreIntroduction());
		System.out.println("7. 광고사용여부: " + s.getAd());
		
		boolean loop = true;
		while(loop) {
			
			System.out.println("------------------------------------------------");
			System.out.println("1. 수정하기");
			System.out.println("0. 이전화면");
			
			System.out.println("------------------------------------------------");
			System.out.print("번호입력: ");
			String result = scan.nextLine();
		
			if(result.equals("1")) {
				System.out.println("-----------------------------------------------");
				System.out.println("1. 수정하기");
				Modify.modifyStore(id);
				loop = false;
				break;
			}else if(result.equals("0")) {
				System.out.println("-----------------------------------------------");
				System.out.println("이전으로 돌아갑니다.");
				//이전화면 추가해야 함
				loop = false;
				break;
			}else {
				System.out.println("-----------------------------------------------");
				System.out.println("값을 잘못 입력하셨습니다.");
			}
		
		}
	}
	
	//라이더 마이페이지 화면입니다.
	//1번을 선택하면 수정이 가능함
	//0번을 선택하면 이전화면으로 돌아감
	public static void riderInfo(String id) {
		
		Scanner scan = new Scanner(System.in);
		
		Rider r = new Rider(id);
		
		System.out.println("\t\t마이페이지");
		System.out.println("------------------------------------------------");
		System.out.println("★ 회원번호: " + r.getRiderNum());
		System.out.println("★ 회원아이디: " + r.getRiderId());
		System.out.println("1. 이름: " + r.getRiderName());
		System.out.println("2. 비밀번호: " + r.getRiderPw());
		System.out.println("3. 전화번호: " + r.getRiderPhoneNumber());
		System.out.println("4. 주소: " + r.getRiderAddress());
		System.out.println("5. 상세주소: " + r.getRiderDetailAddress());
		System.out.println("6. 활동지역: " + r.getRiderArea());
		
		boolean loop = true;
		while(loop) {
			
			System.out.println("------------------------------------------------");
			System.out.println("1. 수정하기");
			System.out.println("0. 이전화면");
			
			System.out.println("------------------------------------------------");
			System.out.print("번호입력: ");
			String result = scan.nextLine();
		
			if(result.equals("1")) {
				System.out.println("-----------------------------------------------");
				System.out.println("1. 수정하기");
				Modify.modifyRider(id);
				loop = false;
				break;
			}else if(result.equals("0")) {
				System.out.println("-----------------------------------------------");
				System.out.println("이전으로 돌아갑니다.");
				//이전화면 추가해야 함
				loop = false;
				break;
			}else {
				System.out.println("-----------------------------------------------");
				System.out.println("값을 잘못 입력하셨습니다.");
			}
		
		}
		
	}
}
