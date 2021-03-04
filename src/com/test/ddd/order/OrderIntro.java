package com.test.ddd.order;

import java.util.Scanner;

import com.test.ddd.customer.Customer;
import com.test.ddd.intro.Intro;

public class OrderIntro {
	
	public static void main(String[] args) {
//		orderIntro("c_sist0000");
	}
	
	//주문 메인 화면
	public static void orderIntro(String id) throws Exception {
		
		boolean loop = true;
		
		while(loop) {
			System.out.println();
			System.out.println("배달받을 주소를 입력하세요");
			System.out.println("-------------------------------------------");
			System.out.println("1. 기본 설정 주소로 하기");
			System.out.println("2. 직접 입력하기");
			System.out.println("-------------------------------------------");
			System.out.print("입력 : ");
			Scanner scan = new Scanner(System.in);
			String input= scan.nextLine();
			
			Customer c;
			
			if(input.equals("1")) {
				c = new Customer(id);
				loop = false;
				OrderCategory.category(c);
				break;
			}else if(input.equals("2")) {
				//새로운 주소를 받아오는 과정
				c = newAddress(id);
				loop = false;
				System.out.println(c.getCustomerAddress());
				System.out.println(c.getCustomerAddressDetail());
				OrderCategory.category(c);
				break;
			}else if(input.equals("0")){
				Intro.memberMenu(id);
				loop = false;
			}else {
				System.out.println("번호를 잘못 입력하셨습니다.");
			}
			
			
		}
		
		
	}
	
	//새로운 주소를 입력하는 화면
	public static Customer newAddress(String id) throws Exception{
		
		Customer c = new Customer(id);
		
		boolean loop = true;
		Scanner scan = new Scanner(System.in);
		
		while(loop) {
			System.out.print("도로명 주소를 입력해 주세요. : ");
			String address = scan.nextLine();
			if(!address.equals("")) {
				c.setCustomerAddress(address);
				loop = false;
			}else if(address.equals("0")) {
				orderIntro(id);
				break;
			}
			if(loop == true) {
				System.out.println("입력을 안하셨습니다.");
			}
		}
		loop = true;
		while(loop) {
			System.out.print("상세 주소를 입력해 주세요. : ");
			String detail = scan.nextLine();
			if(!detail.equals("")) {
				c.setCustomerAddressDetail(detail);
				loop = false;
			}else if(detail.equals("0")) {
				orderIntro(id);
				break;
			}
		
		}
		
		return c;
		
	}
	
}















































