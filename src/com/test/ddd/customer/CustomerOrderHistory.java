package com.test.ddd.customer;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;

import com.test.ddd.fileroad.FileRoad;
import com.test.ddd.fileroad.TotalRoad;
import com.test.ddd.intro.Intro;
import com.test.ddd.order.Order;
import com.test.ddd.store.Store;

public class CustomerOrderHistory {
	static Scanner scan = new Scanner(System.in);
	
	 public static void main(String[] args) throws Exception {
		 
		 customerOrderHistoty("C001");

	 }
	 

	
	public static void customerOrderHistoty(String customerNum) throws Exception { 
		
		FileRoad f = new FileRoad();
		Customer c = new Customer(customerNum,0);
		Order o = new Order();

		//오늘주문내역
		//그다음이 이전주문내역들 이런순서로 보여주면 될 듯
		//리뷰 저장을 리뷰.txt와 finishOrder_withReview.txt에 둘 다 들어가야 한다. 앞의 목록순서 리뷰파일에서 점수하나 빠진거니까 참고할 것.
		

		String line = "";

		String orderContent = "";
		String contentResult = "";

		
		
		try {

			BufferedReader plusTotalReader = new BufferedReader(new FileReader(FileRoad.BASKET));

			ArrayList<String> orderList = TotalRoad.dataRoad("review"); //리뷰파일 어레이리스트
			
			ArrayList<String> customerOrderList = new ArrayList<String>();
			
			//해당 고객의 주문 번호 목록
			ArrayList<String> orderNumList = new ArrayList<String>();
			
			String orderLine = null;
			
			for(int i = 0 ; i < orderList.size(); i++) { //리뷰파일 끝까지 읽는중
				
				orderLine = orderList.get(i);
				String[] info = orderLine.split(",");
				
				//System.out.println(info[1]);
				//System.out.println(orderLine);
				
				if(info[1].equals(c.getCustomerNum())) {
					customerOrderList.add(orderLine);
					orderNumList.add(info[0]);
				}
				
			}
			

			
			
//			System.out.println(customerOrderList); //[O0706,C118,S020,R190,5,3,그저그런 무난한 맛]
//			System.out.println(orderNumList); //[O0706]
//			System.out.println(orderNumList.get(0)); //O0706
//			System.out.println(customerOrderList); //[O0706,C118,S020,R190,5,3,그저그런 무난한 맛]
//			System.out.println(orderNumList); //[O0706]
//			System.out.println(orderNumList.get(0)); //O0706
			
//			System.out.println(orderNumList.get(0));
			
			while ((line = plusTotalReader.readLine()) != null) {	
				
				String[] temp = line.split(",");
				
				//주문번호, 음식명, 음식개수, 총 결제 금액
//				String[] order = {temp2[0], temp2[1], temp2[3], temp2[5]};
				
				if (orderNumList.get(0).equals(temp[0])) {
					if (orderContent.length() >=0 && orderContent.length() <= 10)  {
						orderContent += temp[1] + "/";
						contentResult = orderContent;
					} else {
						orderContent = temp[1];
						contentResult = orderContent + "...";
					}
				}

			}
			
			
			System.out.print("------------------------------\n");
			System.out.print("          [주문 내역]         \n");
			System.out.print("------------------------------\n");
			System.out.println("[주문날짜]\t[업체명]\t\t\t[주문내역]\t\t\t[결제금액]\t");	
			
			for(int i = 0 ; i < orderNumList.size(); i++) {
				Order od = new Order(orderNumList.get(i));
				
				Store store = new Store(od.getStoreNum(), 0);
				System.out.printf("%s\t%-15s\t%-25s\t%10s\n", od.getOrderDate(), store.getStoreName(), contentResult , od.getOrderTotalCost());
				
			}
			

			
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			
			System.out.println();
			System.out.print("------------------------------\n");
			
			System.out.print("1. 리뷰 작성\n");
			System.out.print("2. 업체 평가 및 라이더 평가\n");
			System.out.print("0. 이전으로\n");
			
			System.out.print("------------------------------\n");
			System.out.println();
			
	
			boolean loop = true;
			while(loop) {
				System.out.println();
				System.out.print("            번호 입력 : ");
				String numButton = reader.readLine();
				System.out.println();

				if (numButton.equals("1") || numButton.equals("2") || numButton.equals("0")) {
					//1. 리뷰 작성
					if (numButton.equals("1")) {
						reviewAdd(c.getCustomerNum()); 
					}
					
					//2. 업체 평가 및 라이더 평가
					if (numButton.equals("2")) {
//					storeWithRiderReview(c.getCustomerId()); 
						
					}
					
					//이전으로
					if (numButton.equals("0")) {
						System.out.println("이전 화면으로 돌아갑니다.");
						System.out.println();
						loop = false;
						break;
					}
					loop = false;
				} else {
					System.out.println();
					System.out.println("※ 잘못 입력하셨습니다.\n리뷰 작성은 1, 업체 평가 및 라이더 평가는 2, 이전화면으로 가기는 0을 입력해주세요.");
				}	
		}
			plusTotalReader.close();
//			reader.close();
			
			
		
		} catch (Exception e) {
			System.out.println("error.CustomerMyPage.history");
			e.printStackTrace();
		}
	}


		
		
	//주문내역 조회
		
		
		
		
	//리뷰 작성
	public static void reviewAdd(String id) {
		
		FileRoad f = new FileRoad();
		Customer c = new Customer(id);
		Order o = new Order();
		
		String line = "";

		String orderContent = "";
		String contentResult = "";

		
		try {

			BufferedReader plusTotalReader = new BufferedReader(new FileReader(f.BASKET));
			ArrayList<String> orderList = TotalRoad.dataRoad("review"); //리뷰파일 어레이리스트
			ArrayList<String> customerOrderList = new ArrayList<String>();
			
			//해당 고객의 주문 번호 목록
			ArrayList<String> orderNumList = new ArrayList<String>();
			
			String orderLine = null;
			for(int i = 0 ; i < orderList.size(); i++) { //리뷰파일 끝까지 읽는중
				
				orderLine = orderList.get(i);
				String[] info = orderLine.split(",");
				if(info[1].equals(c.getCustomerNum())) {
					customerOrderList.add(orderLine);
					orderNumList.add(info[0]);
					
				}
				
			}
			
			
			while ((line = plusTotalReader.readLine()) != null) {	
				
				String[] temp = line.split(",");

				
				if (orderNumList.get(0).equals(temp[0])) {
					if (orderContent.length() >=0 && orderContent.length() <= 10)  {
						orderContent += temp[1] + "/";
						contentResult = orderContent;
					} else {
						orderContent += temp[1];
						contentResult = orderContent + "...";
					}
				}

			}
			
			
			System.out.print("------------------------------\n");
			System.out.print("          [주문 내역]         \n");
			System.out.print("------------------------------\n");
			System.out.println("[주문날짜]\t[업체명]\t\t\t[주문내역]\t\t\t[결제금액]\t");	
			
	
			String oDate = "";
			String sName = "";
			for(int i = 0 ; i < orderNumList.size(); i++) {
				Order od = new Order(orderNumList.get(i));
				
				Store store = new Store(od.getStoreNum(), 0);
				//주문날짜, 업체명, 주문내역, 결제금액 순으로 출력해서 보여줌
				System.out.printf("%s\t%-15s\t%-25s\t%10s\n", od.getOrderDate(), store.getStoreName(), contentResult , od.getOrderTotalCost());
				oDate = od.getOrderDate(); //이 오더번호의 주문날짜
				sName = store.getStoreName(); //이 오더번호 업체의 업체명
			}
			

			
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			
			System.out.println();
			System.out.print("------------------------------\n");
			System.out.print("※ 리뷰를 작성할 주문내역의 주문날짜와 업체명을 입력해주세요.\n");
			System.out.print("주문날짜 : ");
			String date = reader.readLine();
			System.out.print("업체명 : ");
			String storeName = reader.readLine();
			
//			System.out.println(customerOrderList); //[O0706,C118,S020,R190,5,3,그저그런 무난한 맛]
//			System.out.println(orderNumList); //[O0706]
//			System.out.println(orderNumList.get(0)); //O0706
			
			
			String orderLine2 = null;
			
			//각각의 bang는 오더번호, 고객번호, 업체번호, 라이더번호, 업체평점, 라이더평점, 리뷰내용의 순이다.
			String bang1 = "";
			String bang2 = "";
			String bang3 = "";
			String bang4 = "";
			String bang5 = "";
			String bang6 = "";
			String bang7 = "";
			
			
			for(int i = 0 ; i < orderList.size(); i++) { //리뷰파일 끝까지 읽는중
				
				orderLine2 = orderList.get(i);
				String[] info = orderLine.split(",");
				bang1 = info[0];
				bang2 = info[1];
				bang3 = info[2];
				bang4 = info[3];
				bang5 = info[4];
				bang6 = info[5];
				bang7 = info[6];
			
			}
			
//			if (date.equals(oDate) && storeName.equals(sName)) {
//				System.out.printf("%s,%s,%s,%s,%s,%s",bang1,bang2,bang3,bang4,bang5,bang6);
//			}
			
			System.out.println();
			System.out.print("※ 20자 이하로 입력해주세요.\n");
			System.out.print("작성할 내용 : ");
			String reviewContent = reader.readLine();
			
			
			
			
			
			
			String newReview = "";
			if (date.equals(oDate) && storeName.equals(sName)) {
				newReview = String.format("%s,%s,%s,%s,%s,%s,%s", bang1,bang2,bang3,bang4,bang5,bang6,reviewContent); //기존 리뷰파일형식으로 들어가도록
			}
			
			System.out.print("------------------------------\n");
			System.out.print(newReview);
			System.out.println();
			
			
			
			BufferedWriter writer = new BufferedWriter(new FileWriter(f.REVIEWFINAL,true));//기존 리뷰파일에 이어서 새 리뷰가 붙는다.
			writer.write(newReview);
			writer.close();
			
			
			
			
			System.out.println();
			System.out.println("정상적으로 추가되었습니다.");
			plusTotalReader.close();
//			reader.close();
			
			
			System.out.println();
			
			System.out.print("------------------------------\n");
			System.out.print("        [추가된 리뷰]         \n");
			System.out.print("------------------------------\n");
			System.out.println("[주문날짜]\t [업체명]\t\t\t[주문내역]\t\t\t[작성내용]");	
			
	
			
				Order od = new Order(bang1);
				Store store = new Store(bang3, 0);
				System.out.printf("%s\t%-15s\t%-25s\t%10s\n", oDate, sName, contentResult , reviewContent);
				
			
		
		} catch (Exception e) {
			System.out.println("error.CustomerMyPage.history");
			e.printStackTrace();
		}
		
		
		
		
	}
		
		
	
	
	
	
	
		
		
		
	public static void reviewCheck(String customerNum) throws IOException { //리뷰 삭제 - 일단 빼자..
//		
//		FileRoad f = new FileRoad();
//		Customer c = new Customer("c_sist0118");
//		Order o = new Order();
//		Review r = new Review();
//	
//		
//		String line = null;
//
////		
//		String contentResult = "";
//		String orderContent = "";
//		
//		String result = "";
//
//		
//		try {
//			
//			
//			BufferedReader plusTotalReader = new BufferedReader(new FileReader(f.BASKET));
//
//			ArrayList<String> orderList = TotalRoad.dataRoad("review"); //리뷰파일 어레이리스트
//			
//			ArrayList<String> customerOrderList = new ArrayList<String>();
//			
//			//해당 고객의 주문 번호 목록
//			ArrayList<String> orderNumList = new ArrayList<String>();
//			ArrayList<String> reviewList = new ArrayList<String>();
////			System.out.println(customerOrderList); //[O0706,C118,S020,R190,5,3,그저그런 무난한 맛]
////			System.out.println(orderNumList); //[O0706]
////			System.out.println(orderNumList.get(0)); //O0706
//			
//			
//			String orderLine = null;
//			String cNum = "";
//			for(int i = 0 ; i < orderList.size(); i++) { //리뷰파일 끝까지 읽는중
//				
//				orderLine = orderList.get(i);
//				String[] info = orderLine.split(",");
//				if(info[1].equals(customerNum)) {
//					customerOrderList.add(orderLine);
//					orderNumList.add(info[0]);
//					reviewList.add(info[6]);
//					cNum = info[1];
//				}
//			}
//			
//			while ((line = plusTotalReader.readLine()) != null) {	
//				
//				String[] temp = line.split(",");
//				
//			
//				if (orderNumList.get(0).equals(temp[0])) {
//					if (orderContent.length() >=0 && orderContent.length() <= 10)  {
//						orderContent += temp[1] + "/";
//						contentResult = orderContent;
//					} else {
//						orderContent += temp[1];
//						contentResult = orderContent + "등";
//					}
//				}
//			}
//				
//			
//				System.out.print("------------------------------\n");
//				System.out.print("          [리뷰 목록]         \n");
//				System.out.print("------------------------------\n");
//				System.out.println("[주문날짜]\t [업체명]\t\t\t[주문내역]\t\t\t[작성내용]");	
//				
//		
//				for(int i = 0 ; i < orderNumList.size(); i++) {
//					Order od = new Order(orderNumList.get(i));
//					
//					Store store = new Store(od.getStoreNum(), 0);
//					System.out.printf("%s\t%-15s\t%-25s\t%10s\n", od.getOrderDate(), store.getStoreName(), contentResult , reviewList.get(0));
//					
//				}
	
	
				
				//////////////여기까지가 리뷰목록조회
				
				
				
				
				
//				String oDate = "";
//				String sName = "";
//				for(int i = 0 ; i < orderNumList.size(); i++) {
//					Order od = new Order(orderNumList.get(i));
//					Store store = new Store(od.getStoreNum(), 0);
//					oDate = od.getOrderDate(); //이 오더번호의 주문날짜
//					sName = store.getStoreName(); //이 오더번호 업체의 업체명
//				}
//				
//
//				
//				BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
//				BufferedReader reviewReader = new BufferedReader(new FileReader(f.REVIEWFINAL));
//				
//				System.out.println();
//				System.out.print("------------------------------\n");
//				System.out.print("※ 리뷰를 작성할 주문내역의 주문날짜와 업체명을 입력해주세요.\n");
//				System.out.print("주문날짜 : ");
//				String date = reader.readLine();
//				System.out.print("업체명 : ");
//				String storeName = reader.readLine();
//				
////				if (!(cNum.equals(customerNum) && date.equals(oDate) && storeName.equals(sName))) {
//				
//				String txt = "";
//				String line2 = null;
//				while ((line2 = reviewReader.readLine()) != null) {	//리뷰 파일 읽어와서 업체가 삭제를 원하는 고객번호 및 업체번호가 일치하고, 그 중 배달완료나 배달중인 리뷰 삭제하는 로직
//
//					String[] temp = line2.split(",");
//			
////					if (temp[1].equals(customerNum) && )
//					
////					
////					if (!(temp[1].equals(customerNum) && date.equals(orderNumList.get(0)) && storeName.equals(sName))) {
////			
////						txt += line + "\n";
////					
////					} 
////					
//				}//while
//					
//					
//				System.out.println(cNum);
//				System.out.println(customerNum);
//				System.out.println(oDate);
//				System.out.println(sName);
//					
//					
//					plusTotalReader.close();
//					reviewReader.close();
//					reader.close();
//					
//					System.out.println(txt);
//					System.out.println();
//					System.out.println("삭제가 완료되었습니다.");
					
//					BufferedWriter writer = new BufferedWriter(new FileWriter(f.REVIEWFINAL));
//					writer.write(txt);
//					writer.close();
//				
//			
//			
//			
//		} catch (Exception e) {
//			
//			e.printStackTrace();
//		}

		
	}//reviewCheck
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public static void reviewModify(String id) {
		
//		FileRoad f = new FileRoad();
//		Customer c = new Customer("c_sist0000");
//		Order o = new Order();
//		
//		
//		
//		try {
//			BufferedReader plusTotalReader = new BufferedReader(new FileReader(f.BASKET));
//		
//
//		
//		
//		ArrayList<String> orderList = TotalRoad.dataRoad("review"); //리뷰파일 어레이리스트
//		
//		ArrayList<String> customerOrderList = new ArrayList<String>();
//		
//		//해당 고객의 주문 번호 목록
//		ArrayList<String> orderNumList = new ArrayList<String>();
//		
//		
//		
//		String orderLine = null;
//		for(int i = 0 ; i < orderList.size(); i++) { //리뷰파일 끝까지 읽는중
//			
//			orderLine = orderList.get(i);
//			String[] info = orderLine.split(",");
//			if(info[1].equals(c.getCustomerId())) {
//				customerOrderList.add(orderLine);
//				orderNumList.add(info[0]);
//			}
//			
//		}
//		
//		
//		
////		System.out.println(customerOrderList); //[O0706,C118,S020,R190,5,3,그저그런 무난한 맛]
////		System.out.println(orderNumList); //[O0706]
////		System.out.println(orderNumList.get(0)); //O0706
//		
//		
//		
//		
//		} catch (FileNotFoundException e) {
//			System.out.println("error.CustomerMyPage.modify");
//			e.printStackTrace();
//		}
//		
//		
//		
//		
		
		
		
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	public static void storeWithRiderReview(String id) {
		
		
	}
	
	
	
}
