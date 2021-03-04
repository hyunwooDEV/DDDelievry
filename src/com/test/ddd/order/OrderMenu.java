package com.test.ddd.order;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

import com.test.ddd.customer.Customer;
import com.test.ddd.fileroad.FileRoad;
import com.test.ddd.store.Store;

public class OrderMenu {
	
	public static void main(String[] args) {
		
		Store s = new Store("S002", 0);
		
		Customer c = new Customer("C000", 0);
		
		orderMenu(s,c);
		
	}
	
	//메뉴 선택화면
	public static void orderMenu(Store s, Customer c) {
		
		System.out.println("\t\t" + s.getStoreName());
		System.out.println("------------------------------------------------");
		System.out.printf("%s\t\t%s\t\t\t%s\n", "[번호]", "[매뉴]", "[가격]");
		
		String path = FileRoad.MENU;
		//basket은 선택한 메뉴와 수량을 string으로 저장한 arraylist
		ArrayList<String> basket = new ArrayList<String>();
		
		try {
			
			BufferedReader reader = new BufferedReader(new FileReader(path));
			
			String line = null;
			ArrayList<String> list = new ArrayList<String>();
			int index = 1;
			
			//해당 업체의 메뉴를 찾아오는 과정
			while((line = reader.readLine()) != null) {
				
				String[] info = line.split(",");
				if(info[0].equals(s.getStoreMemberNum())) {
					System.out.printf("%d\t\t%6s\t\t%s\n", index, info[2], info[3]);
					list.add(line);
					index++;
				}
			}
			
			System.out.println("------------------------------------------------");
			
			Scanner scan = new Scanner(System.in);
			boolean loop = true;
			
			//장바구니에 메뉴를 담는 과정
			while(loop) {
				
				System.out.println("*장바구니를 그만 담기 : 100 입력");
				System.out.println("------------------------------------------------");
				System.out.print("장바구니에 추가할 메뉴를 선택하세요: ");
				int menu = scan.nextInt();
				if(menu == 0) {
					//이전메뉴
					OrderStoreList.showStore(s,c);
					break;
				}else if(menu == 100) {
					System.out.println("장바구니를 닫습니다.");
					System.out.println("------------------------------------------------");
					loop = false;
					break;
				}else {
					//?어디화면으로 돌아가지?					
				}
				System.out.print("수량을 입력해주세요: ");
				int foodNum = scan.nextInt();
				if(foodNum == 0) {
					//이전메뉴
					OrderStoreList.showStore(s,c);
					break;
				}else if(menu == 100) {
					System.out.println("장바구니를 닫습니다.");
					System.out.println("------------------------------------------------");
					loop = false;
					break;
				}else {
					//?어디화면으로 돌아가지?					
				}
				String result = String.format("%s,%d", list.get(menu-1), foodNum);
				basket.add(result);
			}
			if(loop == false) {
				basketInterface(s,c,basket);
			}
			
			reader.close();
			
		} catch (Exception e) {
			System.out.println("orderMenu 에러");
		}
	
	}
	
	//장바구니 화면
	public static void basketInterface(Store s, Customer c, ArrayList<String> basket) {
		
		System.out.println("\t\t 장바구니");
		System.out.println("------------------------------------------------");
		System.out.printf("[번호]\t[메뉴]\t\t[수량]\t[가격]\n");
		
		for(int i = 0 ; i < basket.size(); i++) {
			String[] info = basket.get(i).split(",");
			String result = String.format("%d\t%s\t%s\t%d\n", i+1, info[2], info[4], Integer.parseInt(info[3])*Integer.parseInt(info[4]));
			System.out.println(result);
		}
		
		System.out.println("------------------------------------------------");
		System.out.print("이대로 주문하시겠습니까?(y/n) : ");
		Scanner scan = new Scanner(System.in);
		String input = scan.nextLine();
		if(input.equals("y") || input.equals("Y")) {
			//결제화면
			Payment.paymentMain(s, c, basket);
		}else {
			orderMenu(s,c);
		}
		
	}

}
