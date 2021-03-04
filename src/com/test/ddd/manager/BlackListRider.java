package com.test.ddd.manager;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import com.test.ddd.fileroad.FileRoad;

public class BlackListRider {

	
	public static void main(String[] args) {
		riderBlackListIntro();
	}
	
	
	public static void riderBlackListIntro() {
		ArrayList<BlackListRiderVO> rArrList = new ArrayList<BlackListRiderVO>();
		ArrayList<String> arrBList = new ArrayList<String>();
		ArrayList<String> arrRList = new ArrayList<String>();
		
		File bFile = new File(FileRoad.BLACKLIST);
		File rFile = new File(FileRoad.RIDERFINAL);
		
		try {
			BufferedReader bReader = new BufferedReader(new FileReader(bFile));
			
			String temp = "";
			
			
			while((temp = bReader.readLine())!=null) {
				arrBList.add(temp);
			}
			
			bReader.close();
			
			BufferedReader rReader = new BufferedReader(new FileReader(rFile));
			
			temp = "";
			
			while((temp = rReader.readLine())!=null) {
				arrRList.add(temp);
			}
			
			rReader.close();
			
			
			String[] b = new String[3];
			String[] r = new String[13];
			for(int i=14; i<arrBList.size() ; i++) {
					b = arrBList.get(i).split(",");
				for(int j=0; j<arrRList.size() ; j++) {
					r = arrRList.get(j).split(",");
					if(b[1].equals(r[0])) {
						BlackListRiderVO rb = new BlackListRiderVO();
						rb.setRiderName(r[3]);
						rb.setRiderAddr1(r[7]);
						rb.setRiderAddr2(r[8]);
						rb.setRiderAge(r[4]);
						rb.setRiderAvgPoint(r[10]);
						rb.setRiderBlackListStart(b[0]);
						rb.setRiderBlackListEnd(b[0]);
						
						rArrList.add(rb);
						
					}
					
				}
			}
			

			System.out.println("========================================");
			System.out.println("         라이더 블랙리스트 목록                ");
			System.out.println("========================================");
			System.out.printf("[No.]\t[이름]\t[주소]\t\t\t\t\t[나이]\t[평점]\t[블랙리스트 지정일]\t[블랙리스트 해제일]\n");
			
			int num = 1;
			for (BlackListRiderVO r1 : rArrList) {
				
				System.out.printf("%4d\t%5s\t%s, %-10s\t%3d\t%3s\t\t%s\t%s\n",
						num,
						r1.getRiderName(),
						r1.getRiderAddr1(),
						r1.getRiderAddr2(),
						r1.getRiderAge(),
						r1.getRiderAvgPoint(),
						r1.getRiderBlackListStart(),
						r1.getRiderBlackListEnd());
				num++;
			}
			num = 1;
			
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			System.out.println("1. 이름 내림차순 정렬");
			System.out.println("2. 평점 내림차순 정렬");
			System.out.println("0. 이전 화면");
			System.out.print("번호 입력 : ");
			String sel = reader.readLine();
			
			boolean flag = true;
			while(flag) {
				if(sel.equals("1")) {
					flag = false;
					sortName(rArrList);
				} else if(sel.equals("2")) {
					flag = false;
					sortAvgPoint(rArrList);
				} else if(sel.equals("0")) {
					flag = false;
					BlackList.blackListIntro();
						
				} else {
					flag = true;
					System.out.println("잘못된 입력입니다. 다시 입력하세요.");
					System.out.println("1. 이름 내림차순 정렬");
					System.out.println("2. 평점 내림차순 정렬");
					System.out.println("0. 이전 화면");
					System.out.print("번호 입력 : ");
					sel = reader.readLine();
				}
				
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}


	private static void sortAvgPoint(ArrayList<BlackListRiderVO> rArrList) {
		try {
			Collections.sort(rArrList, new Comparator<BlackListRiderVO>() {
				
				@Override
				public int compare(BlackListRiderVO o1, BlackListRiderVO o2) {
					
					return o2.getRiderAvgPoint().compareTo(o1.getRiderAvgPoint());
				}
			});
			System.out.println("========================================");
			System.out.println("  라이더 블랙리스트(평점 내림차순) 목록 ");
			System.out.println("========================================");
			System.out.printf("[No.]\t[이름]\t[주소]\t\t\t\t\t[나이]\t[평점]\t[블랙리스트 지정일]\t[블랙리스트 해제일]\n");
			
			int num = 1;
			for (BlackListRiderVO r1 : rArrList) {
				
				System.out.printf("%4d\t%5s\t%s, %-10s\t%3d\t%3s\t\t%s\t%s\n",
						num,
						r1.getRiderName(),
						r1.getRiderAddr1(),
						r1.getRiderAddr2(),
						r1.getRiderAge(),
						r1.getRiderAvgPoint(),
						r1.getRiderBlackListStart(),
						r1.getRiderBlackListEnd());
				num++;
			}
			num = 1;
			
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			
			System.out.println("0. 이전 화면");
			System.out.print("번호 입력 : ");

			String sel = reader.readLine();
			
			boolean flag = true;
			while(flag) {
				if(sel.equals("0")) {
					flag = false;
					riderBlackListIntro();
				} else {
					flag = true;
					System.out.println("잘못된 입력 값입니다. 다시 입력하세요.");	
					System.out.println("0. 이전 화면");
					System.out.print("번호 입력 : ");
					sel = reader.readLine();
				}
	
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
	}


	private static void sortName(ArrayList<BlackListRiderVO> rArrList) {
		
		try {
			Collections.sort(rArrList, new Comparator<BlackListRiderVO>() {
	
				@Override
				public int compare(BlackListRiderVO o1, BlackListRiderVO o2) {
					return o2.getRiderName().compareTo(o1.getRiderName());
				}
			});
			System.out.println("========================================");
			System.out.println("  라이더 블랙리스트(이름 내림차순) 목록 ");
			System.out.println("========================================");
			System.out.printf("[No.]\t[이름]\t[주소]\t\t\t\t\t[나이]\t[평점]\t[블랙리스트 지정일]\t[블랙리스트 해제일]\n");
			
			int num = 1;
			for (BlackListRiderVO r1 : rArrList) {
				
				System.out.printf("%4d\t%5s\t%s, %-10s\t%3d\t%3s\t\t%s\t%s\n",
						num,
						r1.getRiderName(),
						r1.getRiderAddr1(),
						r1.getRiderAddr2(),
						r1.getRiderAge(),
						r1.getRiderAvgPoint(),
						r1.getRiderBlackListStart(),
						r1.getRiderBlackListEnd());
				num++;
			}
			num = 1;
			
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			
			System.out.println("1. 정렬 방법 선택");
			System.out.println("0. 이전 화면");
			System.out.print("번호 입력 : ");
	
			String sel;
				sel = reader.readLine();
			
			boolean flag = true;
			while(flag) {
				if(sel.equals("0")) {
					flag = false;
					riderBlackListIntro();
				} else {
					flag = true;
					System.out.println("잘못된 입력 값입니다. 다시 입력하세요.");	
					System.out.println("0. 이전 화면");
					System.out.print("번호 입력 : ");
					sel = reader.readLine();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		
	}


	public BlackListRider() {
		
	}
	
	
	
}
