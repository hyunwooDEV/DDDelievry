package com.test.ddd.store;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

import com.test.ddd.customer.Customer;
import com.test.ddd.fileroad.FileRoad;
import com.test.ddd.fileroad.TotalRoad;
import com.test.ddd.order.Order;

public class StoreReview {

	public static void main(String[] args) throws Exception {
		
		//리뷰관리(마이스토어)
		//1. 리뷰 목록 조회(최근 리뷰순?)
		//	1.1 [번호] [회원번호] [주문날짜] [작성내용]
		//			1.		c001	19:00		안녕하세요 잘먹었습니다.			
		//2. 리뷰 삭제 기능
		//3. 일단 신고 기능 보류
		//	3.1 00000016, 16:05, 리뷰가 신고되었습니다. 관리자 확인 후 삭제 처리하겠습니다.
		//	3.2 신고할 리뷰 번호 입력 :  
		//0. 이전으로 이동
		
		// 번호 입력 : 
		
		
		storeReview("s_sist0000");
		
	}//main
	
	public static void storeReview (String id) throws Exception {
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		Store s = new Store("s_sist0154");
		
//		Store s = new Store(s.getStoreID());
		
		
			System.out.print("------------------------------\n");
			System.out.println("         [리뷰 관리]");
			System.out.print("------------------------------\n");
			
			System.out.print("1. 리뷰 목록 조회\n");
			System.out.print("2. 고객 리뷰 삭제\n");
			System.out.print("0. 이전으로 이동\n"); //MyStore 페이지로 이동
			
//			System.out.println(s.getStoreMemberNum());
			
//			System.out.println(s.getStoreID());
			
			boolean loop = true;
			while(loop) {
				System.out.println();
				System.out.print("            번호 입력 : ");
				String rvButton = reader.readLine();
				System.out.println();

					
	
				if (rvButton.equals("1") || rvButton.equals("2") || rvButton.equals("0"))
					try {
						{
							//1. 리뷰 목록 조회
							if (rvButton.equals("1")) {
								storeReviewCheck(s.getStoreMemberNum()); //업체 회원 번호로 현재 광고 서비스 이용유무 출력
							}
							
							//2. 고객 리뷰 삭제
							//업체가 조회했을 때 나온 회원번호를 제대로 입력하면 제대로 삭제 및 출력이된다.
							//but 잘못입력했을 때 잘못입력했다는 문구 출력 및 다시 입력창으로 돌아가는 로직을 못짰다.. 모르겠다...
							if (rvButton.equals("2")) {
								storeReviewDelete(s.getStoreMemberNum()); //업체 회원 번호로 들어가지고, 리뷰 삭제를 할때는 조회했을 때 목록에서 회원번호를 가져와야한다.
							}
							
							//3. 이전으로
							if (rvButton.equals("0")) {
//								MyStore ms = new MyStore();
//								MyStore.mystoreMenu(s.getStoreID());
//								Store s = new Store();
								MyStore.mystoreMenu(s.getStoreID());
//								loop = false;
							}
							
							
							loop = false;
							
						}
					} catch (Exception e) {
						System.out.println("error.StoreReview.storeReview");
						e.printStackTrace();
					}
				else {
					System.out.println();
					System.out.println("※ 잘못 입력하셨습니다.\n리뷰 목록 조회는 1, 고객 리뷰 삭제는 2, 이전화면으로 가기는 0을 입력해주세요.");
				}	
		
			}
		
		
		
	}
	
	
	
	
	
	public static void storeReviewCheck(String id) { //업체측에서 리뷰 목록 조회

		
		Store s = new Store("s_sist0000");
		FileRoad f = new FileRoad();
		//Review
		//주문번호,회원번호,업체번호,라이더번호,업체평점,라이더평점,리뷰
		
		int num = 0;
		String line = null;
		String orderNum = "";
		String review = "";
		String result = "";
	
		try {
			BufferedReader finishOrderReader = new BufferedReader(new FileReader(f.FINISHORDER));
			BufferedReader reviewReader = new BufferedReader(new FileReader(f.REVIEWFINAL));
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

					
			String customerNum = "";
				System.out.print("------------------------------\n");
				System.out.print("          [리뷰 목록]         \n");
				System.out.print("------------------------------\n");
				System.out.println("[번호]\t [회원번호]\t [주문날짜]\t [작성내용]\t");	
				
				
				while ((line = reviewReader.readLine()) != null) {	
				
					String[] temp = line.split(",");
					if (temp[2].equals(s.getStoreMemberNum())) {
						num += 1;
						review = temp[6];
						orderNum = temp[0];
						Order o = new Order(orderNum);
						customerNum = temp[1];
						result += String.format("%s\t %s\t\t %s\t %s\t\r\n", num,customerNum,o.getOrderDate(),review);
					}
				}
				
				
				System.out.print(result);
			
			reader.close();
			finishOrderReader.close();
			reviewReader.close();

			
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
	
		
	}
	
	
	
	public static void storeReviewDelete(String id) { //업체측에서 리뷰 삭제
		
		
		
	
		FileRoad f = new FileRoad();
		Store s = new Store("s_sist0000");
		
		int num = 0;
		String line = null;
		String orderNum = "";
		String review = "";
		String result = "";
	
		try {
			BufferedReader finishOrderReader = new BufferedReader(new FileReader(f.FINISHORDER));
			BufferedReader reviewReader = new BufferedReader(new FileReader(f.REVIEWFINAL));
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

					
			String customerNum = "";
				System.out.print("------------------------------\n");
				System.out.print("          [리뷰 목록]         \n");
				System.out.print("------------------------------\n");
				System.out.println("[번호]\t [회원번호]\t [주문날짜]\t [작성내용]\t");	
				
				
				while ((line = reviewReader.readLine()) != null) {	
				
					String[] temp = line.split(",");
					if (temp[2].equals(s.getStoreMemberNum())) {
						num += 1;
						review = temp[6];
						orderNum = temp[0];
						Order o = new Order(orderNum);
						customerNum = temp[1];
						result += String.format("%s\t %s\t\t %s\t %s\t\r\n", num,customerNum,o.getOrderDate(),review);
					}
				}
				
				
				System.out.print(result);
			
//			reader.close();
//			finishOrderReader.close();
//			reviewReader.close();

			
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		///여기까지가 리뷰목록보기
		
		
		
		
		///여기서부터 리뷰 삭제
		String line2 = null;
		try {
			BufferedReader finishOrderReader = new BufferedReader(new FileReader(f.FINISHORDER));
			BufferedReader reviewReader = new BufferedReader(new FileReader(f.REVIEWFINAL));
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			
			System.out.print("삭제할 리뷰의 고객번호를 입력해주세요 : ");
			String cNum = reader.readLine();
			System.out.println();
			
			String txt = "";
			if (cNum != null) {

				while ((line2 = reviewReader.readLine()) != null) {	//리뷰 파일 읽어와서 업체가 삭제를 원하는 고객번호 및 업체번호가 일치하고, 그 중 배달완료나 배달중인 리뷰 삭제하는 로직

					String[] temp = line2.split(",");
					
					if (!((temp[1].equals(cNum)) && temp[2].equals(s.getStoreMemberNum()))) {
			
						txt += line2 + "\n";
					} 	
				}//while
			}	
				
				BufferedWriter writer = new BufferedWriter(new FileWriter(f.REVIEWFINAL));
				writer.write(txt);
				writer.close();
	
			System.out.println();
			System.out.println("삭제가 완료되었습니다.");
			
			finishOrderReader.close();
			reviewReader.close();
			reader.close();
			
		} catch (Exception e) {
			System.out.println("error.StoreReview.delete");
			e.printStackTrace();
		}
		
	
		
	
		
	}
	
//	public static String storeReviewReport(String storeId) { //업체측에서 리뷰 신고?
//		return null;
//		
//	}
	
	
}
