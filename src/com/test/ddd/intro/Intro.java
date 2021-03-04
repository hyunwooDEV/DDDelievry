package com.test.ddd.intro;

import java.util.Scanner;

import com.test.ddd.customer.CustomerJoin;
import com.test.ddd.customer.CustomerMyPage;
import com.test.ddd.customer.CustomerServiceCenter;
import com.test.ddd.customer.Find;
import com.test.ddd.customer.MemberDelete;
import com.test.ddd.customer.ShowData;
import com.test.ddd.loginout.Loginout;
import com.test.ddd.manager.Manager;
import com.test.ddd.order.OrderIntro;
import com.test.ddd.rider.RiderFirstScene;
import com.test.ddd.store.MyStore;
import com.test.ddd.store.StoreJoin;
import com.test.ddd.store.StoreMenu;

public class Intro {

	static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) throws Exception {
		System.out.print("                                                     \r\n"
				+ "88888888ba,        88888888ba,        88888888ba,    \r\n"
				+ "88      `\"8b       88      `\"8b       88      `\"8b   \r\n"
				+ "88        `8b      88        `8b      88        `8b  \r\n"
				+ "88         88      88         88      88         88  \r\n"
				+ "88         88      88         88      88         88  \r\n"
				+ "88         8P      88         8P      88         8P  \r\n"
				+ "88      .a8P       88      .a8P       88      .a8P   \r\n"
				+ "88888888Y\"'        88888888Y\"'        88888888Y\"'    \r\n"
				+ "                                                     \r\n"
				+ "               Double Dragon Delivery                 \n\n\n     ");
		System.out.println();
		System.out.println();
		intromenu(); // 인트로 처음 화면
	} // main

	public static void intromenu() throws Exception {

		// 인트로 화면

		// Scanner scan = new Scanner(System.in);
		boolean loop = true;

		while (loop) {

			System.out.println("===================================================");
			System.out.println("                       INTRO                  ");
			System.out.println("===================================================");
			System.out.println("                        DDD                   ");

			System.out.println("1. 비회원 로그인"); // nomember
			System.out.println("2. 회원 로그인 / 회원 가입"); // member
			System.out.println("3. 업체 로그인 / 회원 가입"); // store
			System.out.println("4. 라이더 로그인 / 회원 가입"); // rider
			System.out.println("5. 관리자 로그인"); // manager
			System.out.println("0. 프로그램 종료"); // exit
			System.out.println();
			System.out.print("번호 입력 : ");

			String sel = scan.nextLine();
			System.out.println();

			if (sel.equals("1")) {
				nomemberIntro();
			} else if (sel.equals("2")) {
				memberIntro();
				// break;
			} else if (sel.equals("3")) {
				storeIntro();
			} else if (sel.equals("4")) {
				// riderIntro();
				RiderFirstScene.riderFirstScene();
			} else if (sel.equals("5")) {
				managerIntro();
			} else if (sel.equals("0")) {
				loop = false;
				break;
			} else {
				System.out.println("번호를 다시 입력해주세요");
				System.out.println();
			}

		} // while
		System.out.println();
		System.out.println("****************************************************");
		System.out.println("\t  Double Dragon Delivery를 종료합니다.");
		System.out.println("****************************************************");
	}

	private static void nomemberIntro() {
		// 비회원 인트로 화면
		boolean loop = true;

		while (loop) {
			System.out.println("===================================================");
			System.out.println("                      NOMEMBER                  ");
			System.out.println("===================================================");
			System.out.println("                        DDD                   ");

			System.out.println("1. 주문하기");
			System.out.println("0. 이전화면");

			String sel = scan.nextLine();
			System.out.println();
			if (sel.equals("1")) {
				// 비회원 주문란
			} else if (sel.equals("0")) {
				loop = false;
			} else
				System.out.println("번호를 다시 입력해주세요.");
			System.out.println();

		}
	}// nomemberIntro

	public static void memberIntro() throws Exception {
		// 회원 인트로 화면
		String id = null;

		// BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		// Scanner scan = new Scanner(System.in);
		boolean loop = true;

		while (loop) {
			System.out.println("===================================================");
			System.out.println("                   MEMBER LOGIN                 ");
			System.out.println("===================================================");
			System.out.println("                        DDD                   ");

			System.out.println("1. 로그인");
			System.out.println("2. 회원가입"); // nomember
			System.out.println("3. 아이디 찾기"); // store
			System.out.println("4. 비밀번호 찾기"); // rider
			System.out.println("0. 이전화면"); // exit
			System.out.println();
			System.out.print("번호 입력 : ");

			String sel = scan.nextLine();
			System.out.println();
			if (sel.equals("1")) {
				id = Loginout.login("c");
				if (id != null) {
					System.out.println();
					System.out.println("*****로그인 완료");
					System.out.println();
					memberMenu(id);
				} else {
					memberIntro();
					break;
				}
			} else if (sel.equals("2")) {
				CustomerJoin.customerJoin();
			} else if (sel.equals("3")) {
				System.out.println(Find.findId("c"));
			} else if (sel.equals("4")) {
				System.out.println(Find.findPw("c"));
			} else if (sel.equals("0")) {
				loop = false;
				break;
			} else {

				System.out.println("번호를 다시 입력해주세요");
				System.out.println();
			}
			// loop = false;
		} // while
			// scan.close();

	} // memberIntro

	public static void memberMenu(String id) throws Exception {
		// Scanner scan = new Scanner(System.in);

		boolean loop = true;
		boolean b = false;
		while (loop) {
			System.out.println("===================================================");
			System.out.println("                      MEMBER                  ");
			System.out.println("===================================================");
			System.out.println("                        DDD                   ");

			System.out.println("1. 주문하기");
			System.out.println("2. 마이페이지");
			System.out.println("3. 고객센터");
			System.out.println("4. 탈퇴하기");
			System.out.println("0. 로그아웃");
			System.out.println();
			System.out.print("번호 입력 : ");
			String sel = scan.nextLine();
			System.out.println();

			if (sel.equals("1")) {
				OrderIntro.orderIntro(id);
			} else if (sel.equals("2")) {
				CustomerMyPage.customerMyPage(id);
			} else if (sel.equals("3")) {
				CustomerServiceCenter.serviceCenter(id);
			} else if (sel.equals("4")) {
				MemberDelete.memberDelete(id, "c");
			} else if (sel.equals("0")) {
				if (b = Loginout.logout()) {
					loop = false;
					break;
				}
			} else {
				System.out.println("번호를 다시 입력해주세요");
				System.out.println();
			}
		}
		// scan.close();
		// loop = false;

	}

	public static void storeIntro() throws Exception {
		String id = null;
		// 업체 인트로 화면

		// Scanner scan = new Scanner(System.in);
		boolean loop = true;

		while (loop) {
			System.out.println("===================================================");
			System.out.println("                    STORE LOGIN                  ");
			System.out.println("===================================================");
			System.out.println("                        DDD                   ");

			System.out.println("1. 로그인");
			System.out.println("2. 회원가입");
			System.out.println("3. 아이디 찾기");
			System.out.println("4. 비밀번호 찾기");
			System.out.println("0. 이전화면");
			System.out.println();
			System.out.print("입력 : ");

			String sel = scan.nextLine();
			System.out.println();
			if (sel.equals("1")) {
				id = Loginout.login("s");
				if (id != null) {
					System.out.println();
					System.out.println("*****로그인 완료");
					System.out.println();
					storeMenu(id);
				} else {
					StoreMenu.storeMenu(id);
					break;
				}
			} else if (sel.equals("2")) {
				StoreJoin.storeJoin();
			} else if (sel.equals("3")) {
				System.out.println(Find.findId("s"));
			} else if (sel.equals("4")) {
				System.out.println(Find.findPw("s"));
			} else if (sel.equals("0")) {
				loop = false;
				break;
			} else {
				System.out.println("번호를 다시 입력해주세요");
				System.out.println();
			}

		}

		// intromenu();
		// scan.close();

	}

	public static void storeMenu(String id) throws Exception {

		boolean loop = true;
		boolean b = true;
		while (loop) {

			System.out.println("===================================================");
			System.out.println("                       STORE                  ");
			System.out.println("===================================================");
			System.out.println("                        DDD                   ");

			System.out.println("1. 마이페이지");
			System.out.println("2. 마이스토어");
			System.out.println("3. 실시간 현황 관리");
			System.out.println("4. 고객센터");
			System.out.println("5. 탈퇴하기");
			System.out.println("0. 로그아웃");
			System.out.println();
			System.out.print("번호 입력 : ");

			String sel = scan.nextLine();

			if (sel.equals("1")) {
				// 마이페이지 메서드 호출
				ShowData.customerInfo(id);
			} else if (sel.equals("2")) {
				MyStore.mystoreMenu(id);
			} else if (sel.equals("3")) {
				// 실시간 현황 메서드 호출
			} else if(sel.equals("4")) {
				//CustomerServiceCenter.serviceCenter(id);
			}
			else if (sel.equals("5")) {
				MemberDelete.memberDelete(id, "c");
			} else if (sel.equals("0")) {
				if (b = Loginout.logout()) {
					loop = false;
					break;
				}
			} else {
				System.out.println("번호를 다시 입력해주세요");
				System.out.println();
			}

		}
		// loop = false;
	}

//라이더 메뉴는 rider패키지 RiderFirstScene에 있음

	public static void managerIntro() {
		// 관리자 인트로 화면
		String id = null;
		// Scanner scan = new Scanner(System.in);
		boolean loop = true;

		while (loop) {
			System.out.println("===================================================");
			System.out.println("                   MANAGER LOGIN                  ");
			System.out.println("===================================================");
			System.out.println("                        DDD                   ");

			System.out.println("1. 로그인");
			System.out.println("2. 아이디 찾기");
			System.out.println("3. 비밀번호 찾기");
			System.out.println("0. 이전화면");
			System.out.print("번호 입력 : ");

			String sel = scan.nextLine();
			System.out.println();
			if (sel.equals("1")) {
				Manager.managerLoginIntro();
			} else if (sel.equals("2")) {
				System.out.println(Find.findId("m"));
			} else if (sel.equals("3")) {
				System.out.println(Find.findPw("m"));
			} else if (sel.equals("0")) {
				loop = false;
			} else {
				System.out.println("번호를 다시 입력해주세요");
				System.out.println();
			}

		} // while

		loop = false;
	}
}
