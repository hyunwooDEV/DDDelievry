package com.test.ddd.manager;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class ManagerMainMenu {
	
	public static void main(String[] args) {
		managerMainMenuIntro();
	}
	
	public static void managerMainMenuIntro() {
		System.out.println("========================================");
		System.out.println("                관리자 메뉴                  ");
		System.out.println("========================================");
		System.out.println("1. 회원 목록 조회");
		System.out.println("2. 업체 목록 조회");
		System.out.println("3. 라이더 목록 조회");
		System.out.println("4. 광고 관리");
		System.out.println("5. 블랙리스트 관리");
		System.out.println("6. Q & A 게시판 관리");
		System.out.println("7. 리뷰 검수");
		System.out.println("0. 로그아웃");
		System.out.print("번호 선택 : ");
		
		try {
			
			boolean flag = true;
					
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			
			String sel = reader.readLine();
			
			while(flag) {
				
				if (sel.equals("1")) {
					flag = false;
					ManagingCustomer.managingCustomerIntro();
				} else if (sel.equals("2")) {
					flag = false;
					ManagingStore.managingStoreIntro();
					
				} else if (sel.equals("3")) {
					flag = false;
					ManagingRider.managingRiderIntro();
					
				} else if (sel.equals("4")) {
					flag = false;
					ManagingAdvertise.managingAdvertiseIntro();
					
				} else if (sel.equals("5")) {
					flag = false;
					BlackList.blackListIntro();
					
				} else if (sel.equals("6")) {
					flag = false;
					QandA.getQnaList();
					
				} else if (sel.equals("7")) {
					flag = false;
					ReviewCheck.getReviewList();
					
				}else if(sel.equals("0")){
					flag = false;
					System.out.println();
					System.out.println("이전 화면으로 돌아갑니다.");
					System.out.println();
					Manager.managerLoginIntro();
					
				} else {
					flag = true;
					System.out.println("잘못된 번호입니다. 다시 입력하세요.");
					System.out.println("1. 회원 목록 조회");
					System.out.println("2. 업체 목록 조회");
					System.out.println("3. 라이더 목록 조회");
					System.out.println("4. 광고 관리");
					System.out.println("5. 블랙리스트 관리");
					System.out.println("6. Q & A 게시판 관리");
					System.out.println("7. 리뷰 검수");
					System.out.println("0. 이전 화면");
					System.out.print("번호 선택 : ");
					sel = reader.readLine();
				}
			}
		
		} catch (Exception e) {
			e.printStackTrace();
		}
				
	}

	public ManagerMainMenu() {
		
	}
}
