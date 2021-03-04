package com.test.ddd.rider;

import java.util.Scanner;

import com.test.ddd.customer.CustomerServiceCenter;
import com.test.ddd.customer.MemberDelete;
import com.test.ddd.loginout.Loginout;

public class RiderMenu {
	
	public static void main(String[] args) {

		//riderMenu("r_sist0000");
			
	} //main

	public static void riderMenu(String id) {
		
		
		Rider r = new Rider(id);
		
		Scanner scan = new Scanner(System.in);
		boolean loop = true;
		boolean b = true;
		while (loop) {
			
			System.out.println("===================================================");
			System.out.println("                       RIDER                  ");
			System.out.println("===================================================");

			
			System.out.println("1. 마이페이지             ");
			System.out.println("2. 배달내역 조회     ");
			System.out.println("3. 배달하기                ");
			System.out.println("4. 고객센터");
			System.out.println("5. 탈퇴하기                ");
			System.out.println("0. 로그아웃                ");
			System.out.println();
			System.out.print(" 입력 : ");
			
			String sel =  scan.nextLine();
			System.out.println();
			if (sel.equals("1")) {
				//마이페이지 클래스 내 마이페이지 메서드 호출
				RiderMyPage rmp = new RiderMyPage();
				rmp.riderInfo(id);
				loop = false;
				break;
			} else if (sel.equals("2")) {
				//배달 내역 조회 클래스 내 배달내역 기간 입력 메서드 호출
				ChoiceDate cd = new ChoiceDate();
				cd.choiceDate(id);
				loop = false;
				break;
			} else if (sel.equals("3")) {
				//배달 받기 클래스의 메서드
				RiderDeliveryChoice rdc = new RiderDeliveryChoice();
				rdc.riderDeliveryChoiceIntro(id); //로그인할 때 쓴 id 넘기기
				loop = false;
				break;
			}else if(sel.equals("4")) {
				//CustomerServiceCenter.serviceCenter(id);
			}
			else if (sel.equals("5")) {
				MemberDelete.memberDelete(id, "r");
			}
			else if(sel.equals("0")){
				if (b = Loginout.logout()) {
					loop = false;
					break;
				}
			}
			else {
				System.out.println("번호를 다시 입력해주세요");
				System.out.println();
			}
			
		} //while
	
		
		
	}

}
