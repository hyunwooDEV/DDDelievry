package com.test.ddd.store;

import java.util.Scanner;

import com.test.ddd.intro.Intro;

public class MyStore {
	
	public static void main(String[] args) throws Exception {
		mystoreMenu("s_sist0000");
		
		
	} //main

	
	//마이스토어 화면
	public static void mystoreMenu(String id) throws Exception {
		
		Scanner scan = new Scanner(System.in);
		boolean loop = true;
		
		while (loop) {
			
			System.out.println("===================================================");
			System.out.println("                     MY  STORE                  ");
			System.out.println("===================================================");
			System.out.println("1. 매출 조회             ");
			System.out.println("2. 프리미엄 광고             ");
			System.out.println("3. 메뉴관리      ");
			System.out.println("4. 고객관리      ");
			System.out.println("5. 리뷰관리      ");
			System.out.println();
			System.out.println("0. 업체 초기화면으로 이동");
			System.out.println();
			System.out.print("        번호 입력 : ");
			
			String sel =  scan.nextLine();
			
			if (sel.equals("1")) {
				//storeSalesView();
				//putDate();
				loop = false;
				break;
			} else if (sel.equals("2")) {
				//프리미엄 광고 메서드
				StoreAD.storeAd(id);
				loop = false;
				break;
			} else if (sel.equals("3")) {
				//메뉴관리 메서드
				StoreMenu.storeMenu(id);
				//loop = false;
				//break;
			} else if (sel.equals("4")) {
				//고객관리 메서드
				loop = false;
				break;
			} else if (sel.equals("5")) {
				//리뷰관리 메서드
				StoreReview.storeReview(id);
				loop = false;
				break;
			} else if (sel.equals("0")) {
//				loop = false; // 업체 초기 화면으로 이동
				Intro.storeMenu(id);
			} else {
				System.out.println("번호를 다시 입력해주세요");
			}
			
		} //while
		
		
	}
		
	
	
	
//	private static void storeMenu(String id) throws IOException {
//		//업체 메뉴 화면 ppt 71p
//		
//		Scanner scan = new Scanner(System.in);
//		boolean loop = true;
//		
//		while (loop) {
//			
//			System.out.println("   업체                                     ");
//			System.out.println("---------------------                      ");
//			
//			System.out.println("1. 마이페이지             ");
//			System.out.println("2. 마이스토어             ");
////			System.out.println("3. 실시간 현황 관리      ");
////			System.out.println();
//			System.out.println("0. 로그아웃      ");
//			System.out.println();
//			System.out.print("            입력 : ");
//			
//			String sel =  scan.nextLine();
//			
//			if (sel.equals("1")) {
//				//마이페이지 메서드 호출
//			} else if (sel.equals("2")) {
//				mystoreMenu(id);				
//			} else if (sel.equals("0")) {
//				//intromenu(); //로그아웃이므로 이전 인트로 화면으로 돌아간다.
//			} else {
//				System.out.println("번호를 다시 입력해주세요");
//			}
//			
//		} //while
//		loop = false;
//		
//		System.out.println("프로그램 종료");
//	}
	
	
	
	
	
	
	
}
