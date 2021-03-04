package com.test.ddd.order;

import java.util.Scanner;

import com.test.ddd.customer.Customer;

public class OrderFilter {
	
	public static String orderFilter(Customer c) throws Exception {
		//filter : 기본, 주문량, 별점, 배달시간
		System.out.println("------------------------------------------");
		System.out.println("필터 선택 (택1)");
		System.out.println("------------------------------------------");
		System.out.println("1. 기본모드");
		System.out.println("2. 주문량(미완성XXX)");
		System.out.println("3. 별점순");
		System.out.println("4. 거리순");
		System.out.println("0. 이전화면");
		System.out.println("------------------------------------------");
		System.out.print("입력 : ");
		Scanner scan = new Scanner(System.in);
		String input = scan.nextLine();
		String result = "";
		
		if(input.equals("1")) {
			result = "기본";
		}else if(input.equals("2")) {
			result = "주문량";
			
		}else if(input.equals("3")) {
			result = "별점";
			
		}else if(input.equals("4")) {
			result = "배달시간";
			
		}else if(input.equals("0")) {
			//이전 화면 추가
			OrderCategory.category(c);
		}else {
			orderFilter(c);
		}
		
		
		return result;
	}

}
