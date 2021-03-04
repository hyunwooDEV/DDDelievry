package com.test.ddd.manager;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;

import com.test.ddd.fileroad.FileRoad;

public class BlackList {
	
	//qPath =Q&A 파일위치
	public static BlackList b = new BlackList();
	public static ManagerVO m = new ManagerVO("id","pw");
	//public static String bPath = "C:\\home\\DDDilivery\\src\\com\\test\\ddd\\dummy\\BlackList.txt";
	public static File bFile = new File(FileRoad.BLACKLIST);
	FileRoad fr = new FileRoad();
	
	public static void main(String[] args) {
		
		BlackList.blackListIntro();
		

	}

	public static void blackListIntro() {
		
		System.out.println("========================================");
		System.out.println("               블랙리스트                  ");
		System.out.println("========================================");
		System.out.println();
		System.out.println("1. 블랙리스트[고객]");
		System.out.println("2. 블랙리스트[업체]");
		System.out.println("3. 블랙리스트[라이더]");
		System.out.println("0. 이전 화면");
		System.out.print("번호 선택 : ");
		
		try {
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			String sel = reader.readLine();
			
			boolean flag = true;
			
			while(flag) {
				if(sel.equals("1")) {
//					BlackListCustomer cb = new BlackListCustomer();
					BlackListCustomer.customerBlackListIntro();

				} else if (sel.equals("2")) {
					flag = false;
					//BlackListStore sb = new BlackListStore();
					BlackListStore.storeBlackListIntro();
					
				} else if (sel.equals("3")) {
					flag = false;
					//BlackListRider rb = new BlackListRider();
					BlackListRider.riderBlackListIntro();
					
				}else if (sel.equals("0")) {
					flag = false;
					//ManagerMainMenu mm = new ManagerMainMenu();
					ManagerMainMenu.managerMainMenuIntro();
					
				} else {
					flag = true;
					System.out.println("잘못된 입력입니다. 다시 입력하세요.");
					System.out.println("1. 블랙리스트[고객]");
					System.out.println("2. 블랙리스트[업체]");
					System.out.println("3. 블랙리스트[라이더]");
					System.out.println("0. 이전 화면");
					System.out.print("번호 선택 : ");
					sel = reader.readLine();
				}
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}



	public BlackList(){
		
	}
}
