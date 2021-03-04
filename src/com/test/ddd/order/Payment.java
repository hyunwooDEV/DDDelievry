package com.test.ddd.order;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Random;
import java.util.Scanner;

import com.test.ddd.customer.Customer;
import com.test.ddd.customer.MakeForm;
import com.test.ddd.fileroad.TotalRoad;
import com.test.ddd.store.Store;
import com.test.ddd.validation.Validation;

public class Payment {
	
	
	//결제 메인 화면
	public static void paymentMain(Store s, Customer c, ArrayList<String> basket) {
		
		System.out.println();
		System.out.println("------------------------------------------------");
		System.out.println("\t\t결제하기");
		System.out.println("------------------------------------------------");
		Scanner scan = new Scanner(System.in);
		String needs = "";
		boolean loop = true;
		
		//요청사항 입력 화면 20자 이내로 입력. 넘어가면 경고 문구
		while(loop) {
			System.out.print("배달 시, 요청사항을 입력해주세요. : ");
			needs = scan.nextLine();
			if(needs.length() <= 20) {
				loop = false;
				if(needs.length() == 0) {
					needs = "요청사항없음";
				}
				break;
			}else {
				System.out.println("------------------------------------------------");
				System.out.println("20자 내로 입력해주세요.");
			}
		}
		
		//카드 번호 확인
		System.out.println("------------------------------------------------");
		System.out.println();
		System.out.println("\t\t결제수단");
		System.out.println("------------------------------------------------");
		System.out.println("등록카드" + c.getCustomerCardNum());
		System.out.println();
		System.out.println("------------------------------------------------");
		
		boolean loop2 = true;
		boolean loop3 = true;
		while(loop2) {
			System.out.print("카드를 변경하시겠습니까?(y,n) : ");
			String input = scan.nextLine();
			if(input.equals("y") || input.equals("Y")) {
				
				while(loop3) {
					System.out.println("------------------------------------------------");
					System.out.print("카드번호를 입력하세요. : ");
					String cardNum = scan.nextLine();
					if(Validation.cardNumInspection(cardNum) == true) {
						c.setCustomerCardNum(cardNum);
						loop3 = false;
						loop2 = false;
						break;
					}else {
						loop3 = true;
						System.out.println("다시입력해주세요.");
					}
					
				}
				
				
			}else if(input.equals("n") || input.equals("N")){
				
				System.out.println("------------------------------------------------");
				System.out.println("이대로 진행합니다.");
				loop2 = false;
				
			}else {
				System.out.println("y/n를 입력해주세요");
			}
			//결제 확인
			Order o = new Order();
			o.setNeeds(needs);
			Order order = paymentConfirm(s,c,basket, o);
			
			paymentFinish(s, c, basket, order);
		}
		
		
		
	}
	
	//결제확인 창
	public static Order paymentConfirm(Store s, Customer c, ArrayList<String> basket, Order o) {
		
		System.out.println("------------------------------------------------");
		System.out.println("\t\t결제확인");
		System.out.println("------------------------------------------------");
		System.out.println("주소 : " + c.getCustomerAddress() + c.getCustomerAddressDetail());
		Scanner scan = new Scanner(System.in);
		
		boolean loop = true;
		int point = 0;
		while(loop) {
			
			System.out.print("사용할 포인트를 입력해주세요(" + c.getCustomerPoint() + "):");
			//사용할 포인트
			point = scan.nextInt();
			if(point > c.getCustomerPoint()) {
				System.out.println("보유한 포인트가 부족합니다.");
			}else {
				loop = false;
				break;
			}
			
		}
		o.setPoint(point);
		//남은 포인트
		int rest = c.getCustomerPoint() - point;
		c.setCustomerPoint(rest);
		
		//음식 총금액
		int totalFoodCost = 0;
		for(String food : basket) {
			String[] info = food.split(",");
			totalFoodCost += (Integer.parseInt(info[info.length-1]) * Integer.parseInt(info[info.length-2]));
		}
		//배달 비용
		int deliveryCost = Integer.parseInt(s.getDeliveryCost());
		
		//결제 금액
		int totalCost = totalFoodCost - point + deliveryCost;
		o.setTotalCost(totalCost);
		
		System.out.println("------------------------------------------------");
		System.out.println("음식 총 가격: " + totalFoodCost + "원");
		System.out.println("포인트 사용: " + point + "원");
		System.out.println("배달비용: " + deliveryCost + "원");
		System.out.println("결제비용: " + totalCost + "원");
	
		return o;
	}
	
	//결제완료 화면, 취소확인 화면, 주문데이터/장바구니 데이터 저장
	public static void paymentFinish(Store s, Customer c, ArrayList<String> basket, Order o) {
		
		System.out.println("------------------------------------------------");
		System.out.println();
		System.out.println("\t\t결제완료");
		
		boolean loop = true;
		Scanner scan = new Scanner(System.in);
		String input = null;
		String result = "";
		
		while(loop) {
			System.out.println("------------------------------------------------");
			System.out.println("*취소는 지금 이후에는 불가능합니다.");
			System.out.println("*취소하셔도 취소 기록은 남습니다.");
			System.out.print("취소하시겠습니까?(y/n) : ");
			input = scan.nextLine();
			if(input.equals("y") || input.equals("Y")) {
				//result에 주문정보를 todayOrder에 넣음
				o.setCancel("cancel");
				loop = false;
				break;
			}else if(input.equals("n") || input.equals("N")) {
				//result에 주문 정보를 todayorder에 넣지만 
				//상태는 고객취소로 저장
				o.setCancel("pass");
				loop = false;
				break;
			}else {
				System.out.println("잘못입력하셨습니다.");
			}
			
		}
		
		//장바구니에 데이터 저장
		saveOrder(s,c,basket,o);
		
	}
	
	public static void saveOrder(Store s, Customer c, ArrayList<String> basket, Order o) {
		
		
		String orderState = "배달대기";
		if(o.getCancel().equals("cancel")) {
			orderState = "고객취소";
		}
		
		//주문 수를 세는 과정
		ArrayList<String> list = TotalRoad.dataRoad("o");
		int num = list.size();
		ArrayList<String> orderlist = TotalRoad.dataRoad("todayOrder");
		int num2 = orderlist.size();
		
		
		Calendar calendar = Calendar.getInstance();
		
		String today = String.format("%tF", calendar);
		
		//라이더를 랜덤으로 선정하기 위한 과정
		Random random = new Random();
		ArrayList<String> list2 = TotalRoad.dataRoad("r");
		int count = random.nextInt(list2.size());
		int orderNum = num + num2 + 1;
		
		String result = String.format("O%04d,%s,%s,R%03d,%s,%s,%s,%s,%s,%s,%s,%s", orderNum, c.getCustomerNum(), s.getStoreMemberNum(), count, c.getCustomerAddress(),c.getCustomerAddressDetail()
										, orderState, o.getNeeds(), today, o.getPoint()
										, s.getDeliveryCost(), o.getTotalCost());
		
		//주문을 저장
		
		ArrayList<String> todayList = TotalRoad.dataRoad("todayOrder");
		
		todayList.add(result);
		
		TotalRoad.dataSave(todayList, "todayOrder");
		
		//장바구니 정보 저장
		ArrayList<String> todayBasket = TotalRoad.dataRoad("todayBasket");
		
		for(int i = 0 ; i < basket.size() ; i++) {
			
			String[] info = basket.get(i).split(",");
			result = String.format("O%04d,%s,%s,%s,%d", orderNum, info[2], info[3], info[4], Integer.parseInt(info[info.length-2]) * Integer.parseInt(info[info.length-1])); 
			todayBasket.add(result);
			
		}
		
		TotalRoad.dataSave(todayBasket, "todayBasket");
		
		//고객 포인트를 저장 
		
		ArrayList<String> customerList = TotalRoad.dataRoad("c");
		String line = null;
		int savePoint = 0;
		
		for(int i=0; i<customerList.size() ; i++) {
			
			line = customerList.get(i);
			String info[] = line.split(",");
			if(c.getCustomerNum().equals(info[0])) {
				savePoint = Integer.parseInt(info[info.length-4]) - o.getPoint();
				if(info[info.length - 5].equals("VVIP")) {
					savePoint += (int)(o.getTotalCost() * 0.15);
				}else if(info[info.length - 5].equals("VIP")) {
					System.out.println(info[info.length - 5]);
					savePoint += (int)(o.getTotalCost() * 0.10);
				}else if(info[info.length - 5].equals("일반")) {
					savePoint += (int)(o.getTotalCost() * 0.5);
				}else {
					savePoint = 0;
				}
				info[info.length - 4] = savePoint + "";
				line = MakeForm.makeForm(info);
			}
			customerList.set(i, line);
			
		}
		
		TotalRoad.dataSave(customerList, "c");
		
	}
}
