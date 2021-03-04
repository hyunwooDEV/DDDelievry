package com.test.ddd.rider;

import java.util.Scanner;

import com.test.ddd.customer.Find;

public class RiderFirstScene {
	public static void main(String[] args) {

		riderFirstScene();

	} // main

	public static void riderFirstScene() {

		Scanner scan = new Scanner(System.in);
		boolean loop = true;

		while (loop) {

			System.out.println("===================================================");
			System.out.println("                       RIDER                  ");
			System.out.println("===================================================");


			System.out.println("1. 로그인             ");
			System.out.println("2. 회원가입            ");
			System.out.println("3. 아이디 찾기             ");
			System.out.println("4. 비밀번호 찾기            ");
			System.out.println("0. 이전화면            ");
			System.out.println();
			System.out.print(" 입력 : ");

			String sel = scan.nextLine();

			if (sel.equals("1")) {
				// 라이더 로그인
				RiderIntro.riderLoginIntro();
				loop = false;
				break;
			} else if (sel.equals("2")) {
				// 라이더 회원가입
				RiderJoin.riderJoin();
				loop = false;
				break;
			} else if (sel.equals("3")) {
				System.out.println(Find.findId("r"));

			} else if (sel.equals("4")) {
				System.out.println(Find.findPw("r"));
			} else if (sel.equals("0")) {
				System.out.println("이전 화면으로 돌아갑니다.");
				System.out.println();
				loop = false;
				break;
			} else {
				System.out.println("번호를 다시 입력해주세요");
				System.out.println();
			}

		} // while

		// 라이더 첫 화면-> 여기서 로그인할지 회원 가입할지 선택

	}

}
