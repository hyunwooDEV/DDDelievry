package com.test.ddd.manager;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

import com.test.ddd.fileroad.TotalRoad;
import com.test.ddd.intro.Intro;

public class Manager {

	
	
	
	public static void main(String[] args) {
		managerLoginIntro();
	}
	
	
	public static void managerLoginIntro() {
		System.out.println("========================================");
		System.out.println("              관리자 로그인                 ");
		System.out.println("========================================");
		System.out.println();
		System.out.println();
		System.out.println("** '0' 입력 시 이전 화면 이동");
			
		try {
			ArrayList<String> managerID = TotalRoad.dataRoad("m");

			ArrayList<String> mIDList = new ArrayList<String>();
			ArrayList<String> mPWList = new ArrayList<String>();
			ArrayList<String> mNameList = new ArrayList<String>();
			
			String[] temp = new String[9];
			for(int i=0 ; i<managerID.size() ; i++) {
				temp = managerID.get(i).split(",");
				mIDList.add(temp[1]);
				mPWList.add(temp[2]);
				mNameList.add(temp[3]);
			}
			
			
			
			boolean accept = false;

			
			BufferedReader input1 = new BufferedReader(new InputStreamReader(System.in));
			
			System.out.print("ID : ");
			String id = input1.readLine();
			
			if(id.equals("0")) {
			Intro.intromenu();
			}
			
			input1 = new BufferedReader(new InputStreamReader(System.in));
			System.out.print("PW : ");
			String pw = input1.readLine();
			
			if(id.equals("0")) {
			Intro.intromenu();
			}
			
			
			for (int i=0; i<mIDList.size() ; i++) {
				if(id.equals(mIDList.get(i))&&pw.equals(mPWList.get(i))){
					accept = true;
				}
				
			}
			
			if(accept==true) {
				System.out.println();
				System.out.println("*****로그인 완료");
				System.out.println();
				
				ManagerMainMenu.managerMainMenuIntro();
			} else {
				System.out.println("관리자의 아이디와 비밀번호가 일치하지 않습니다.");
				System.out.println("다시 입력하세요.");
				managerLoginIntro();
			}
		
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}


	public Manager(){
		
	}
}
