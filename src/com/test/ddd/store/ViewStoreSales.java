package com.test.ddd.store;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

import javax.annotation.processing.SupportedSourceVersion;

import com.test.ddd.fileroad.TotalRoad;
import com.test.ddd.rider.Rider;


public class ViewStoreSales {
	public static void main(String[] args) {
		//1)storeMenu -> 2)mystoreMenu -> 3)date: 매출 조회 날짜 입력
		//-> 4)standardChoice 여기서 각자 다른 필터에 맞춰서 정렬할 기준을 고른다.(성별/연령/메뉴)
	

		
		storeMenu("s_sist0001");		
	} //main

	private static String date(String id, String date) {
				
		System.out.println("----------------------------------------");
		System.out.println("              업체 매출 조회            ");
		System.out.println("----------------------------------------");
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("조회 시작 날짜(예: 20201010)\\n 입력: ");
		String startDate = sc.nextLine();

		
		System.out.println("조회 끝 날짜(예: 20201020)\\n 입력: ");
		String endDate = sc.nextLine();
		
		String dates = startDate + "~" + endDate;
	   
		
		
		/*
		1) 이 안에서 유효성 검사 통과-> 선택한 날짜 출력되게끔 하기
		통과 x -> 다시 입력하기 창이 나오게 하여 다시 값을 입력받기
		
		2) 그 다음 go() 로 이동. 그후 
		 -> standardChoice()에서 필터를 써서 매출액을 출력한다. 
		 - 필터를 쓰려면 date()에서 입력한 값을 불러와야 한다.
		*/
		
		System.out.printf("선택한 날짜는 %s ~ %s입니다.\r\n", startDate, endDate);
	
		go(id, dates);
		return dates;
		
	}
	
	private static String go(String id, String dates) {
		System.out.println("----------------------------------------");
		System.out.println("              업체 매출 조회            ");
		System.out.println("----------------------------------------");
		
		Scanner scan = new Scanner(System.in);
		boolean loop = true;
		
		while (loop) {
			System.out.println("1. 계속하려면 1를 입력하세요");
			System.out.println("2. 날짜를 수정하려면 2를 입력하세요");

			System.out.print("입력: ");
			
			String sel = scan.nextLine();
			
			if (sel.equals("1")) {
				standardChoice(id, dates);
				loop = false;
			} else if (sel.equals("2")) {
				date(sel, sel); //이전 조회선택으로 돌아감
			} 
		}
		return dates;
		
	}

	
	private static String standardChoice(String id, String dates) {
		Scanner scan = new Scanner(System.in);
		boolean loop = true;
		
while (loop) {
		
			System.out.println("----------------------------------------");
			System.out.println("                마이 스토어              ");
			System.out.println("----------------------------------------");
			
			System.out.println("1. 성별             ");
			System.out.println("2. 연령대별          ");
			System.out.println("3. 메뉴별            ");
			System.out.println();
			System.out.println("0. 업체 초기화면으로 이동");
			System.out.println();
			System.out.print("        번호 입력 : ");
			
			String sel =  scan.nextLine();
			
			if (sel.equals("1")) {
				genderStandard(id, dates);
				loop = false;
			} else if (sel.equals("2")) {
				ageStandard(id, dates);
				loop = false;
			} else if (sel.equals("3")) {
				menuStandard(id, dates);
				loop = false;
			} else if (sel.equals("0")) {
				//업체 초기화면으로
				loop = false;
			} 
			
		} //while
		
		return dates;
		
		
	}

	private static String menuStandard(String id, String dates) {
		
		Store s = new Store();
		
		String datesList[] = dates.split("~"); //입력한 조회날짜
		int startDate = Integer.parseInt(datesList[0]);//조회할 날짜 첫번
		int endDate = Integer.parseInt(datesList[1]);//조회할 날짜 끝
		
		System.out.println("----------------------------------------");
		System.out.println("              업체 매출 조회(메뉴별)      ");
		System.out.println("----------------------------------------");
		System.out.printf("조회기간: %s",dates);
		System.out.println();
		System.out.printf("조회기간 총 주문건수: ");
		
		//읽어올 파일(storeFinal) -> 업체 총정보 파일
		ArrayList<String> store = TotalRoad.dataRoad("s");
		String storeNum = "";
		
		for (int i =0; i<store.size(); i++) {
			String[] infoS = store.get(i).split(",");
			if (infoS[1].equals(id)) {
				storeNum = infoS[0];
			}
		}

		//읽어올 파일(OrderPlus) -> 주문 정보 파일
		ArrayList<String> list = TotalRoad.dataRoad("o");
		String orderNum = "";
		String money = "";
		String orderDate = "";
		int sales = 0;
		
		HashMap<String, String> orderCount = new HashMap<String, String>();
		//해당 업체의 주문 정보를 담아줄 해시맵(key: 고객번호. value: 가격)
		
		ArrayList<Integer> allSales = new ArrayList<Integer>();
		//가격(HashMap value)만 담을 배열
		
		ArrayList<String> allOrders = new ArrayList<String>();
		//고객 번호만 담을 배열
		
		for (int i=0; i<list.size(); i++) { //주문 목록 수만큼 돌며
			String[] infoO = list.get(i).split(","); 
			if (infoO[2].equals(storeNum)) {
				orderNum = infoO[0]; //주문번호
				money = infoO[11]; //주문 금액
				
				orderDate = infoO[8]; //날짜
				orderDate = orderDate.replace("-", ""); //더미파일속 날짜의 하이폰 빼기
				int orderDateNum = Integer.parseInt(orderDate); //날짜 int 형변환
				
				String state = infoO[6]; // 배달상황 (매출액 표시이므로 배달완료로 떠야 함)
				
				if (startDate <= orderDateNum && endDate >= orderDateNum) {
					
					if (state.equals("배달완료")) {
						orderCount.put(orderNum, money); 
						//조회 날짜에 맞는 주문 목록 속에 있는 "주문번호-금액" 쌍 넣기.
						
						allSales.add(Integer.parseInt(money));
						//매출 저장 배열에 금액(int) 넣기
						
						allOrders.add(orderNum);
						// 고객 저장 배열에 고객번호 넣기
					}
				} 
				
			}
		}
		System.out.println(orderCount.size() + "건"); 
		//해시맵의 크기 = 날짜에 맞는 해당 업체 주문 건수
		
		//메뉴별로 건수 나누기
		
		
		ArrayList<String> basket = TotalRoad.dataRoad("b");
		//읽어올 파일 -> 장바구니 총정보 파일(plusTotal)
		
		ArrayList<String> menus = new ArrayList<String>();
		//해당 업체의 주문받은 메뉴만 담을 배열
		
		
		for (int i=0; i<basket.size(); i++) { //장바구니 사이즈 만큼 돌며
			String[] infoB = basket.get(i).split(","); //장바구니 파일의 한줄씩 문자열로 가져오며
			
			for (int j=0; j<allOrders.size(); j++) { //조회기간에 맞는 주문들의 숫자만큼 돌며
				if (infoB[0].equals(allOrders.get(j))) { //주문번호(장바구니 내)와 조회기간에 맞는 주문들의 번호가 맞으면
					menus.add(infoB[1]); //주문받은 메뉴 모은 집합에 해당 메뉴 정보를 넣는다.
				}
			}
		}
		
		
		//중복된 메뉴 개수를 세어줄 해시맵 만들기
		HashMap<String, Integer> duplicate_count = new HashMap<String, Integer>();
		
		for(int i=0; i<menus.size() ; i++){ //menu 담은 배열만큼 돌며
			if ((duplicate_count.containsKey(menus.get(i)))) { //중복된 메뉴를 키로 가지는지 확인하며
				duplicate_count.put(menus.get(i), duplicate_count.get(menus.get(i))  + 1);
			} else {
				duplicate_count.put(menus.get(i), 1);
			}
		}
			
	
		//향상된for문으로 한줄씩 메뉴 - 메뉴 개수 출력
		for(String key : duplicate_count.keySet()) { 
			int value = duplicate_count.get(key);
			System.out.println(key + " : " + value + "개"); }
	
		
		System.out.println();
		System.out.print("조회기간 총 매출액: ");
		
		//총매출액 구하기: allSales 배열 요소 모두 더하기
		for (int i=0; i<allSales.size(); i++) {
			sales += allSales.get(i);
		}
		System.out.println(sales + "원");
		
		
		//마이스토어 초기화면 이동
		System.out.println();
		System.out.println("0. 마이스토어 초기화면 이동");
		Scanner scan = new Scanner(System.in);
		boolean loop = true;
		
		String sel =  scan.nextLine();
		
		while (loop) {
			
			if (sel.equals("0")) {
				mystoreMenu(id);
				loop = false;
			} else {
				System.out.println("마이스토어으로 돌아가려면 0을 입력하세요");
			} 
			
		} //while
		return id;
		
		
}

	private static String ageStandard(String id, String dates) {
		
		Store s = new Store();
		
		String datesList[] = dates.split("~"); //입력한 조회날짜
		int startDate = Integer.parseInt(datesList[0]);//조회할 날짜 첫번
		int endDate = Integer.parseInt(datesList[1]);//조회할 날짜 끝
		
		System.out.println("----------------------------------------");
		System.out.println("              업체 매출 조회(연령대별)      ");
		System.out.println("----------------------------------------");
		System.out.printf("조회기간: %s",dates);
		System.out.println();
		System.out.printf("조회기간 총 주문건수: ");
		
		
		//읽어올 파일(storeFinal) -> 업체 총정보 파일
		ArrayList<String> store = TotalRoad.dataRoad("s");
		String storeNum = "";
		
		for (int i =0; i<store.size(); i++) {
			String[] infoS = store.get(i).split(",");
			if (infoS[1].equals(id)) {
				storeNum = infoS[0];
			}
		}
				
		//읽어올 파일(OrderPlus) -> 주문 정보 파일
		ArrayList<String> list = TotalRoad.dataRoad("o");
		String customerNum = "";
		String money = "";
		String orderDate = "";
		int sales = 0;
		
		HashMap<String, String> orderCount = new HashMap<String, String>();
		//해당 업체의 주문 정보를 담아줄 해시맵(key: 고객번호. value: 가격)
		
		ArrayList<Integer> allSales = new ArrayList<Integer>();
		//가격(HashMap value)만 담을 배열
		
		ArrayList<String> people = new ArrayList<String>();
		//고객 번호만 담을 배열
		
		for (int i=0; i<list.size(); i++) { //주문 목록 수만큼 돌며
			String[] infoO = list.get(i).split(","); 
			if (infoO[2].equals(storeNum)) {
				customerNum = infoO[1]; //고객번호
				money = infoO[11]; //주문 금액
				
				orderDate = infoO[8]; //날짜
				orderDate = orderDate.replace("-", ""); //더미파일속 날짜의 하이폰 빼기
				int orderDateNum = Integer.parseInt(orderDate); //날짜 int 형변환
				
				String state = infoO[6]; // 배달상황 (매출액 표시이므로 배달완료로 떠야 함)
				
				if (startDate <= orderDateNum && endDate >= orderDateNum) {
					
					if (state.equals("배달완료")) {
					
						orderCount.put(customerNum, money);
						allSales.add(Integer.parseInt(money));
						//매출 저장 배열에 금액(int) 넣기
						
						people.add(customerNum);
						// 고객 저장 배열에 고객번호 넣기
					}
				} 
				
			}
		}
		System.out.println(orderCount.size() + "건"); 
		//해시맵 크기: 날짜에 맞는 해당 업체 주문 건수
		
		//연령대별로 건수 나누기
		
		//읽어올 파일 -> 고객 총정보 파일
		ArrayList<String> customer = TotalRoad.dataRoad("c");
		
		ArrayList<Integer> customerAge = new ArrayList<Integer>();
		//조회기간에 맞는 고객의 연령대 정보만 담을 배열
		
		int count10 = 0; //10대 고객 수
		int count20 = 0; //20대 고객 수
		int count30 = 0; 
		int count40 = 0; 
		int count50 = 0; 
		int count60 = 0; 
		int count70 = 0; 
		
		for (int i=0; i<customer.size(); i++) {
			String[] infoC = customer.get(i).split(","); //고객 파일의 한줄씩 문자열로 가져오며
			for (int j=0; j<people.size(); j++) { //조회기간에 맞는 고객들의 숫자만큼 돌며
			
				if (infoC[0].equals(people.get(j))) { //고객번호(고객파일 내)와 조회기간에 맞는 고객들의 번호가 맞으면
					customerAge.add(Integer.parseInt(infoC[4].substring(0, 4))); //생년월일 모아놓는 집합에 해당 고객 생년 정보를 넣는다.
				}
				
			}
		}
		
		Calendar cal = Calendar.getInstance();
		int year = cal.get(Calendar.YEAR);
	
		
		
		for (int i=0; i<customerAge.size(); i++) {
	
			int old = year - customerAge.get(i) + 1; //한국 나이 기준
			
			if (old >= 10 && old <20) {
				count10++;
			} else if (old >= 20 && old < 30) {
				count20++;
			} else if (old >= 30 && old < 40) {
				count30++;
			} else if (old >= 40 && old < 50) {
				count40++;
			} else if (old >= 50 && old < 60) {
				count50++;
			} else if (old >= 60 && old < 70) {
				count60++;
			} else if (old >= 70 && old < 80) {
				count70++;
			} else {
				break;
			}
			
		} //고객 연령대 구하는 for문
		
		System.out.println();
		System.out.println("연령대 별 주문건수");
		System.out.println("10대 : " + count10 + "명");
		System.out.println("20대 : " + count20 + "명");
		System.out.println("30대 : " + count30 + "명");
		System.out.println("40대 : " + count40 + "명");
		System.out.println("50대 : " + count50 + "명");
		System.out.println("60대 : " + count60 + "명");
		System.out.println("70대 : " + count70 + "명");
		System.out.println();
	
		System.out.print("조회기간 총 매출액: ");
		
		//총매출액 구하기: allSales 배열 요소 모두 더하기
		for (int i=0; i<allSales.size(); i++) {
			sales += allSales.get(i);
		}
		System.out.println(sales + "원");
		
		//마이스토어 초기화면 이동
		
		System.out.println("0. 마이스토어 초기화면 이동");
		Scanner scan = new Scanner(System.in);
		boolean loop = true;
		
		String sel =  scan.nextLine();
		
		while (loop) {
			
			if (sel.equals("0")) {
				mystoreMenu(id);
				loop = false;
			} else {
				System.out.println("마이스토어으로 돌아가려면 0을 입력하세요");
			} 
			
		} //while
		return id;
	}

	
	private static String genderStandard(String id, String dates) {
		
		
		 Store s = new Store();
		/* 1)로그인한 업체 -> 2)조회 원하는 날짜만 데이터 가져오기
		 3) 해당업체에서 주문한 고객의 성별에 맞춰서 주문건수 보여주기
		 4) 총 매출액 계산	
		*/

		String datesList[] = dates.split("~"); //입력한 조회날짜
		int startDate = Integer.parseInt(datesList[0]);//조회할 날짜 첫번
		int endDate = Integer.parseInt(datesList[1]);//조회할 날짜 끝
		

		
		System.out.println("----------------------------------------");
		System.out.println("              업체 매출 조회(성별)          ");
		System.out.println("----------------------------------------");
		System.out.printf("조회기간: %s",dates);
		System.out.println();
		System.out.print("조회기간 총 주문건수: ");
		
		
		
		//읽어올 파일(storeFinal) -> 업체 총정보 파일
		ArrayList<String> store = TotalRoad.dataRoad("s");
		String storeNum = "";
		
		for (int i =0; i<store.size(); i++) {
			String[] infoS = store.get(i).split(",");
			if (infoS[1].equals(id)) {
				storeNum = infoS[0];
			}
		}
		
		//읽어올 파일(finishOrder) -> 주문 정보 파일
		ArrayList<String> list = TotalRoad.dataRoad("o");
		String customerNum = "";
		String money = "";
		String orderDate = "";
		int sales = 0;
		
		HashMap<String, String> orderCount = new HashMap<String, String>();
		//해당 업체의 주문 정보를 담아줄 해시맵(key: 고객번호. value: 가격)
		
		ArrayList<Integer> allSales = new ArrayList<Integer>();
		//가격(HashMap value)만 담을 배열
		
		ArrayList<String> people = new ArrayList<String>();
		//고객 번호만 담을 배열
		
		for (int i=0; i<list.size(); i++) { //주문 목록 수만큼 돌며
			String[] infoO = list.get(i).split(","); 
			if (infoO[2].equals(storeNum)) {
				customerNum = infoO[1]; //고객번호
				money = infoO[11]; //주문 금액
				
				orderDate = infoO[8]; //날짜
				orderDate = orderDate.replace("-", ""); //더미파일속 날짜의 하이폰 빼기
				int orderDateNum = Integer.parseInt(orderDate); //날짜 int 형변환
				
				String state = infoO[6]; // 배달상황 (매출액 표시이므로 배달완료로 떠야 함)
				
				if (startDate <= orderDateNum && endDate >= orderDateNum) {
					
					if (state.equals("배달완료")) {
						
						orderCount.put(customerNum, money); 
						//조회 날짜에 맞는 주문 목록 속에 있는 "고객번호-금액" 쌍 넣기.
						
						allSales.add(Integer.parseInt(money));
						//매출 저장 배열에 금액(int) 넣기
						
						people.add(customerNum);
						// 고객 저장 배열에 고객번호 넣기
					}
				} 
				
			}
		}
		System.out.println(orderCount.size() + "건"); 
		//해시맵의 크기 = 날짜에 맞는 해당 업체 주문 건수
		
		
		//성별 분류로 건수 나누기
		
		//읽어올 파일 -> 고객 총정보 파일
		ArrayList<String> customer = TotalRoad.dataRoad("c");
		
		ArrayList<String> customerGender = new ArrayList<String>();
		//조회기간에 맞는 고객의 성별정보만 담을 배열
		
		int countF = 0; //여자 고객 수
		int countM = 0; //남자 고객 수
		
		for (int i=0; i<customer.size(); i++) {
			String[] infoC = customer.get(i).split(","); //고객 파일의 한줄씩 문자열로 가져오며
			for (int j=0; j<people.size(); j++) { //조회기간에 맞는 고객들의 숫자만큼 돌며
			
				if (infoC[0].equals(people.get(j))) { //고객번호(고객파일 내)와 조회기간에 맞는 고객들의 번호가 맞으면
					customerGender.add(infoC[5]); //성별만 모아놓는 집합에 해당 고객 성별 정보를 넣는다.
				}
				
			}
		}
		
		
		

		for (int i=0; i<customerGender.size(); i++) {
			if (customerGender.get(i).equals("1")) {
				countM++;
			}
		} //남자고객 수 구하기
		
		for (int i=0; i<customerGender.size(); i++) {
			if (customerGender.get(i).equals("2")) {
				countF++;
			}
		} //여자고객 수 구하기
		
		System.out.println("성별 별 주문건수: ");
		System.out.println("남: " + countM + "건");
		System.out.println("여: " + countF + "건");
	
		
		System.out.print("조회기간 총 매출액: ");
		
		//총매출액 구하기: allSales 배열 요소 모두 더하기
		for (int i=0; i<allSales.size(); i++) {
			sales += allSales.get(i);
		}
		System.out.println(sales + "원");
		
		
		//마이스토어 초기화면 이동
		System.out.println();
		System.out.println("0. 마이스토어 초기화면 이동");
		Scanner scan = new Scanner(System.in);
		boolean loop = true;
		
		String sel =  scan.nextLine();
		
		while (loop) {
			
			if (sel.equals("0")) {
				mystoreMenu(id);
				loop = false;
			} else {
				System.out.println("마이스토어으로 돌아가려면 0을 입력하세요");
			} 
			
		} //while
		return id;
		
	}

	private static String mystoreMenu(String id) {
		
		Scanner scan = new Scanner(System.in);
		boolean loop = true;
		
while (loop) {
			
			System.out.println("----------------------------------------");
			System.out.println("                마이 스토어              ");
			System.out.println("----------------------------------------");
			
			System.out.println("1. 매출 조회             ");
			System.out.println("2. 프리미엄 광고             ");
			System.out.println("3. 메뉴관리      ");
			System.out.println("4. 고객관리      ");
			System.out.println("5. 리뷰관리      ");
			System.out.println();
			System.out.println("0. 업체 초기화면으로 이동");
			System.out.println();
			System.out.print("        번호 입력 : ");
			
			String sel =  scan.nextLine();
			
			if (sel.equals("1")) {
				//storeSalesView();
				date(id, sel);
				loop = false;
			} else if (sel.equals("2")) {
				//프리미엄 광고 메서드
			} else if (sel.equals("3")) {
				//메뉴관리 메서드
			} else if (sel.equals("4")) {
				//고객관리 메서드
			} else if (sel.equals("5")) {
				//리뷰관리 메서드
			} else if (sel.equals("0")) {
				loop = false; // 업체 초기 화면으로 이동
			} else {
				System.out.println("번호를 다시 입력해주세요");
			}
			
		} //while
		
		return id;
	}
		
		
		
	

	private static String storeMenu(String id) {
		//업체 메뉴 화면 ppt 71p
		
		Store s = new Store();
		
		Scanner scan = new Scanner(System.in);
		boolean loop = true;
		
		while (loop) {
			
			System.out.println("   업체                                     ");
			System.out.println("---------------------                      ");
			
			System.out.println("1. 마이페이지             ");
			System.out.println("2. 마이스토어             ");
			System.out.println("3. 실시간 현황 관리      ");
			System.out.println();
			System.out.println("0. 로그아웃      ");
			System.out.println();
			System.out.print("            입력 : ");
			
			String sel =  scan.nextLine();
			
			if (sel.equals("1")) {
				//마이페이지 메서드 호출
			} else if (sel.equals("2")) {
				mystoreMenu(id);
				loop = false;
			} else if (sel.equals("3")) {
				//실시간 현황 메서드 호출
			} else if (sel.equals("0")) {
				//intromenu(); //로그아웃이므로 이전 인트로 화면으로 돌아간다.
			} else {
				System.out.println("번호를 다시 입력해주세요");
			}
			
		} //while

		return id;
	}
	

	
	
}
