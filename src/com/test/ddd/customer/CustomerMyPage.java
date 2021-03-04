package com.test.ddd.customer;

import java.util.Scanner;

public class CustomerMyPage {
	static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) throws Exception {
		 customerMyPage("c_sist0000");
	}

	public static void customerMyPage(String id) throws Exception {

		Customer c = new Customer(id);

		System.out.println("===================================================");
		System.out.println("\t\t      MY PAGE");
		System.out.println("===================================================");
		System.out.println(String.format("ID : %s  등급 : %s  적립금 : %5s원", c.getCustomerId(), c.getCustomerGrade(),
				c.getCustomerPoint()));
		System.out.println("===================================================");
		System.out.println("1. 회원 정보");
		System.out.println("2. 배달 내역");
		System.out.println("3. 즐겨찾기");
		System.out.println("0. 이전 화면");
		System.out.println("---------------------------------------------------");
		System.out.print("입력 : ");
		String sel = scan.nextLine();
		System.out.println();
		boolean loop = true;
		while (loop) {
			if (sel.equals("1")) {
				ShowData.customerInfo(id);
			} else if (sel.equals("2")) {
				CustomerOrderHistory.customerOrderHistoty(c.getCustomerNum());
			} else if (sel.equals("3")) {
				CustomerFavoriteList.showFavoriteList(c.getCustomerNum());
				loop = false;
				break;
			} else if (sel.equals("0")) {
				System.out.println("이전 화면으로 돌아갑니다.");
				System.out.println();
				loop = false;
				break;

			} else
				System.out.println("번호를 다시 입력해주세요.");
		}
	}
}
