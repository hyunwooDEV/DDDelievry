package com.test.ddd.manager;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;

import com.test.ddd.fileroad.FileRoad;

public class ReviewCheck {
	
	
	

	public static void main(String[] args) {
		getReviewList();
	}
	
	
	public ReviewCheck() {
		
	}
	
	
	public static void getReviewList() {
		
		File rFile = new File(FileRoad.REVIEWFINAL);
		File bFile = new File(FileRoad.BADWORDS);
		File dFile = new File(FileRoad.FINISHORDER);
		
		ArrayList<String> rList = new ArrayList<String>();
		ArrayList<String> bList = new ArrayList<String>();
		ArrayList<String> dList = new ArrayList<String>();
		
	try {

			//리뷰 파일 읽어오기
			BufferedReader rReader = new BufferedReader(new FileReader(rFile));
		
			String temp = null;
			
			while ((temp = rReader.readLine())!=null) {
			
				rList.add(temp);
			}
			rReader.close();	
			
			
			//주문서 파일 읽어오기			
			BufferedReader dReader = new BufferedReader(new FileReader(dFile));
		
			temp = null;
			
			while ((temp = dReader.readLine())!=null) {
			
				dList.add(temp);
			}
			dReader.close();
			
			
			
			//금지어 파일 읽어오기
			BufferedReader bReader = new BufferedReader(new FileReader(bFile));
			
			temp = null;
			
			while ((temp = bReader.readLine())!=null) {
				
				bList.add(temp);
			}
			bReader.close();
			
			System.out.println("========================================");
			System.out.println("               리뷰 검수         ");
			System.out.println("========================================");
			
			
			System.out.print("[No.]\t\t[리뷰 내용, 게시자]\t\t\t\t\t\t\t\t\t[등록일]\n");
			
			String[] review = new String[7];
			String[] order = new String[9];
			String reviewData = "";
			String date = "";

			//review[6] : 리뷰내용  // review[1] = 고객번호 
			//reviewData = review[6] + review[1] : 리뷰내용, 고객번호
			//review[0] -> order[7] : 등록일..
			
			for (int i=0; i<rList.size() ; i++) {
				
				review = rList.get(i).split(",");
				for (int j=0; j<dList.size() ; j++) {
					
					order = dList.get(j).split(",");
					
					if (review[0].equals(order[0])){
						
						date = order[8];
					}
					
				}
				reviewData = review[6] +", "+review[1];
				System.out.printf(String.format("%4d\t%-80s\t%s\n",i+1,reviewData,date));
				
			}
			//번호 입력받기 (기능 선택)
			boolean flag = true;
			Scanner scan = new Scanner(System.in);
			String sel = "";
			
				System.out.println("1. 리뷰 삭제 하기");
				System.out.println("2. 금지어 추가 하기");
				System.out.println("0. 이전 화면");
				System.out.print("번호 선택 : ");
			
				sel = scan.next();
			
				while(flag) {
					if (sel.equals("1")) {
						flag = false;
						deleteReview(rList);
					}else if (sel.equals("2")) {
						flag = false;
						updateBadWords(bList);
					}else if (sel.equals("0")){	
						flag = false;
						ManagerMainMenu.managerMainMenuIntro();
						
					}else {
						flag = true;
						System.out.println("잘못된 입력 값 입니다.");
						System.out.println("1. 리뷰 삭제 하기");
						System.out.println("2. 금지어 추가 하기");
						System.out.println("0. 이전 화면");
						System.out.print("번호 선택 : ");
						sel = scan.next();
					}
					
				}
			scan.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	
	private static void updateBadWords(ArrayList<String> bList) {
		System.out.println("========================================");
		System.out.println("              금지어 목록               ");
		System.out.println("========================================");
		for(int i=0; i<bList.size() ; i++) {
			System.out.println(bList.get(i));
		}
		
		System.out.println("**** 추가 할 금지어 입력 ****");
		System.out.println("0. 이전 화면");
		System.out.print("입력 : ");
		File bFile = new File(FileRoad.BADWORDS);
		try {
			
			boolean flag = true;
			BufferedReader nReader = new BufferedReader(new InputStreamReader(System.in));
			String input = nReader.readLine();
			
			while (flag) {
				
				if (bList.contains(input)) {
					
					flag = true;
					System.out.println("중복된 금지어 입니다. 다른값을 입력하세요");
					System.out.println("**** 추가 할 금지어 입력 ****");
					System.out.println("0. 이전 화면");
					System.out.print("입력 : ");
					input = nReader.readLine();
					
				} else if(input.equals("0")){
					flag = false;
					getReviewList();
				
				} else {
					
					flag = false;
					bList.add(input);
				}
				
			}
			
			
			//파일 다시쓰기
			FileWriter writer = new FileWriter(bFile);
			
			for (int i=0; i<bList.size() ; i++) {

				writer.write(String.format("%s\n",bList.get(i)));
				
			}
			writer.close();
			
			System.out.println("금지어 업데이트 완료");
			
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		updateBadWords(bList);
	}
	
	private static void deleteReview(ArrayList<String> rList) {
		
		System.out.print("삭제 할 번호 입력 : ");
		File rFile = new File(FileRoad.REVIEWFINAL);
		
		try {
			BufferedReader nReader = new BufferedReader(new InputStreamReader(System.in));
			
			int num = Integer.parseInt(nReader.readLine())-1;
			
			rList.remove(num);
			

			//파일 다시쓰기
			FileWriter writer = new FileWriter(rFile);
			
			for (int i=0; i<rList.size() ; i++) {

				writer.write(String.format("%s\n",rList.get(i)));
				
			}
			writer.close();
			
			System.out.println("리뷰 삭제 완료");
			
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		getReviewList();

		
	}
}
