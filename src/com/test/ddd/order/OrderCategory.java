package com.test.ddd.order;

import java.util.Scanner;

import com.test.ddd.customer.Customer;
import com.test.ddd.intro.Intro;

public class OrderCategory {
	
	
	//카테고리 선택 화면
	public static Customer category(Customer c) throws Exception {
		
		
		System.out.println("----------------------------------------");
		System.out.println("카테고리 선택");
		System.out.println("----------------------------------------");
		System.out.println("1. 한식");
		System.out.println("2. 일식");
		System.out.println("3. 중식");
		System.out.println("4. 양식");
		System.out.println("5. 분식");
		System.out.println("6. 치킨");
		System.out.println("7. 패스트푸드");
		System.out.println("8. 디저트");
		System.out.println("----------------------------------------");
		System.out.print("입력 : ");
		
		Scanner scan = new Scanner(System.in);
		String input = scan.nextLine();
		String filter = "";
		
		if(input.equals("1")) {
			filter = OrderFilter.orderFilter(c);
			OrderStoreList.orderStoreList("한식", filter, c);
		}else if(input.equals("2")) {
			filter = OrderFilter.orderFilter(c);
			OrderStoreList.orderStoreList("일식", filter, c);
		}else if(input.equals("3")) {
			filter = OrderFilter.orderFilter(c);
			OrderStoreList.orderStoreList("중식", filter, c);
		}else if(input.equals("4")) {
			filter = OrderFilter.orderFilter(c);
			OrderStoreList.orderStoreList("양식", filter, c);
		}else if(input.equals("5")) {
			filter = OrderFilter.orderFilter(c);
			OrderStoreList.orderStoreList("분식", filter, c);
		}else if(input.equals("6")) {
			filter = OrderFilter.orderFilter(c);
			OrderStoreList.orderStoreList("치킨", filter, c);
		}else if(input.equals("7")) {
			filter = OrderFilter.orderFilter(c);
			OrderStoreList.orderStoreList("패스트푸드", filter, c);
		}else if(input.equals("8")) {
			filter = OrderFilter.orderFilter(c);
			OrderStoreList.orderStoreList("디저트", filter, c);
		}else if(input.equals("0")) {
			//이전화면
			Intro.memberMenu(c.getCustomerId());
			
		}
		
		return c;
	}

}
