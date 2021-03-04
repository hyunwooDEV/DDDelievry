package com.test.ddd.rider;

import java.util.Scanner;

public class RiderMyPage {

	public static void main(String[] args) {
		
		
		riderInfo("r_sist0000");
		
	} //main
	
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
				RiderMenu rm = new RiderMenu();
				rm.riderMenu(id);
				loop = false;
				break;
			}else {
				System.out.println("-----------------------------------------------");
				System.out.println("값을 잘못 입력하셨습니다.");
			}
		
		}
		
	}
	
	
}
