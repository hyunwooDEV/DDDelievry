package com.test.ddd.customer;

import java.util.ArrayList;
import java.util.Scanner;

import com.test.ddd.fileroad.TotalRoad;

public class CustomerFavoriteList {
	public static void main(String[] args) throws Exception {
//		showFavoriteList("C410");
		showFavoriteList("C237");
	}

	static Scanner sc = new Scanner(System.in);

	// 주문 회원의 즐겨찾기 삭제 및 요청사항 관리 페이지 입니다.
	// 주문 회원 번호, 업체 회원 번호, 업체명, 요청사항
	// 출력은 업체명, 요청사항
	public static void showFavoriteList(String customerNum) throws Exception {

		Customer c = new Customer(customerNum, 0);
		ArrayList<String> list = TotalRoad.dataRoad("f");// 토달 즐겨찾기 리스트
		ArrayList<String> customerList = new ArrayList<String>();
		ArrayList<String> storeNumber = new ArrayList<String>();// 업체번호저장
		

		boolean loop = true;

		while (loop) {
			System.out.println("--------------------------------------------------------------");
			System.out.println("\t\t\t     즐겨찾기");
			System.out.println("--------------------------------------------------------------");
			System.out.println("[NO.]\t[업체명]  \t\t\t[요청사항]");

			// String[] requests = new String[4];
			int index = 1;

			for (String s : list) {

				String[] favoriteList = s.split(",");

				if (favoriteList[0].equals(c.getCustomerNum())) {
					customerList.add(s);
					System.out.print(String.format("%2d\t%-15s\t\t%s\n", index, favoriteList[2], favoriteList[3]));
					storeNumber.add(favoriteList[1]);// 업체번호 저장
					index++;// 넘버링
				}

				// FavoriteList.reviseFavoriteList(c);

			}

			System.out.println("--------------------------------------------------------------");
			System.out.println("1. 즐겨찾기 매장 삭제하기(미완성)");
			System.out.println("2. 요청사항 수정,삭제하기");
			System.out.println("0. 이전 화면");
			System.out.println();
			System.out.print("입력 : ");
			String sel = sc.nextLine();
			System.out.println();

			if (sel.equals("1")) {
				favoriteStoreDelete(storeNumber, customerList);
				break;
			} else if (sel.equals("2")) {
				FavoriteList.reviseFavoriteList(c);
			} else if (sel.equals("0")) {
				loop = false;
				CustomerMyPage.customerMyPage(c.getCustomerId());
				break;
			} else {
				System.out.println("번호를 다시 입력해주세요.");
			}
		}

	}


	private static void favoriteStoreDelete(ArrayList<String> storeNumber, ArrayList<String> customerList) throws Exception {

		// CustomerFavoriteListVO c = new CustomerFavoriteListVO(customerNum);

		boolean loop = true;

		// f.get(0) f.get(1)
		// f = 넘버, 업체명, 요청사항|넘버, 업체명, 요청사항|
		// list.get(0)
		// list=회원넘버,업체넘버,업체명,요청사항|
		
		ArrayList<String> list = TotalRoad.dataRoad("f");
		ArrayList<String> saveList = new ArrayList<String>();
		Customer c = new Customer();
		

		while (loop) {
			System.out.println("--------------------------------------------------------------");
			System.out.print("즐겨찾기에서 삭제할 항목 번호를 입력해주세요.(0번 입력 시 이전 화면으로 돌아갑니다.) : ");
			String sel = sc.nextLine();
			System.out.println();
			String storeName = "";

			// 넘버링 입력 유효성 검사
			for (int j = 0; j < sel.length(); j++) {// 입력받은 숫자 길이만큼

				if (sel.charAt(j) >= '0' && sel.charAt(j) <= '9') {// 숫자만

					if (Integer.parseInt(sel) >= 1 && Integer.parseInt(sel) <= customerList.size()) {// 입력받은 숫자가 넘버링과
																										// 같으면
						String line = customerList.get(Integer.parseInt(sel)-1);
						
						String[] info = line.split(",");
						
						storeName = info[2];
						
						c = new Customer(info[0], 0);
						
						for(String s : list) {
							
							String[] temp = s.split(",");
							
							if(!(temp[0].equals(c.getCustomerNum()) && temp[2].equals(storeName))) {
								saveList.add(s);
							}
						}
						
						TotalRoad.dataSave(saveList, "f");
						loop = false;
						break;
						
						
						
					} else if (sel.equals("0")) {
						System.out.println("이전 화면으로 돌아갑니다.\n");
						loop = false;
						break;
					} else {
						System.out.println("번호를 다시 입력해주세요.");
						break;
					}
				} else {
					System.out.println("숫자만 입력해주세요.\n");
					break;
				}
			}
		}
		showFavoriteList(c.getCustomerNum());
		System.out.println();
		// loop = false;
	}
}
