package com.test.ddd.manager;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import com.test.ddd.fileroad.FileRoad;

public class BlackListStore {
	
	public static void main(String[] args) {
		storeBlackListIntro();
	}
	public static void storeBlackListIntro() {
		ArrayList<BlackListStoreVO> sArrList = new ArrayList<BlackListStoreVO>();
		ArrayList<String> arrList1 = new ArrayList<String>();
		ArrayList<String> arrList2 = new ArrayList<String>();
		
		File bFile = new File(FileRoad.BLACKLIST);
		File sFile = new File(FileRoad.STOREFINAL);
		String[] tempList1 = new String[25];
		String[] tempList2 = new String[3];
		try {
			
			BufferedReader bReader = new BufferedReader(new FileReader(bFile));
			String temp = "";
			
			while((temp = bReader.readLine())!=null) {
				arrList1.add(temp);
			}
			bReader.close();
			
			
			BufferedReader sReader = new BufferedReader(new FileReader(sFile));
			temp = "";
			
			while((temp = sReader.readLine())!=null) {
				arrList2.add(temp);
			}
			
			sReader.close();
			
			temp="";
			
			for(int i=11; i<arrList2.size() ; i++) {
				tempList2 = arrList2.get(i).split(",");
				for(int j=0 ; j<arrList1.size() ; j++) {
					tempList1 = arrList1.get(j).split(",");
					if(tempList2[0].equals(tempList1[1])) {
						
						BlackListStoreVO s = new BlackListStoreVO();
						s.setStoreName(tempList2[9]);
						s.setStoreAddr1(tempList2[7]);
						s.setStoreAddr2(tempList2[8]);
						s.setStoreNumber(tempList2[0]);
						s.setsCancelCount(Integer.parseInt(tempList1[2]));
						s.setsBlackListStart(tempList1[0]);
						s.setsBlackListEnd(tempList1[0]);
						
						sArrList.add(s);
					}
					
				}
			}
			

			System.out.println("========================================");
			System.out.println("         업체 블랙리스트 목록                ");
			System.out.println("========================================");
			System.out.printf("[No.]\t[업체명]\t\t\t[주소]\t\t\t\t\t[업체번호]\t[주문 거부 횟수]\t[블랙리스트 지정일]\t[블랙리스트 해제일]\n");
			
			int num=1;
			
			
			for (BlackListStoreVO s : sArrList) {
				System.out.printf("%4d\t%-26s\t%-15s, %-10s\t%5s\t%5d\t\t%10s\t%10s\n",
						num,
						s.getStoreName(),
						s.getStoreAddr1(),
						s.getStoreAddr2(),
						s.getStoreNumber(),
						s.getsCancelCount(),
						s.getsBlackListStart(),
						s.getsBlackListEnd()
						);
				num++;
			}
			num = 1;
			
			boolean flag = true;
			System.out.println("1. 업체명 내림차순 정렬");
			System.out.println("2. 주문 거부 횟수 내림차순 정렬");
			System.out.println("0. 이전 화면");
			System.out.print("번호 입력 : ");
			
			BufferedReader reader2 = new BufferedReader(new InputStreamReader(System.in));
			String sel = reader2.readLine();
			
			while(flag) {
				if(sel.equals("1")) {
					flag = false;
					sortName(sArrList);
				} else if (sel.equals("2")) {
					flag = false;
					sortCancel(sArrList);
				}else if (sel.equals("0")) {
					flag = false;
					BlackList.blackListIntro();
				} else {
					flag = true;
					System.out.println("잘못된 입력 값입니다. 다시 입력하세요.");	
					System.out.println("1. 업체명 내림차순 정렬");
					System.out.println("2. 주문 거부 횟수 내림차순 정렬");
					System.out.println("0. 이전 화면");
					System.out.print("번호 입력 : ");
					sel = reader2.readLine();
				}
				
			}	
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
		
		
				
	}
	private static void sortCancel(ArrayList<BlackListStoreVO> sArrList) {
		try {
			
			Collections.sort(sArrList, new Comparator<BlackListStoreVO>() {
				
				@Override
				public int compare(BlackListStoreVO o1, BlackListStoreVO o2) {
					
					if(o1.getsCancelCount()>o2.getsCancelCount()) {
						return -1;
					} else if(o1.getsCancelCount()>o2.getsCancelCount()) {
						return 1;
					}
					return 0;
				}
			});
			
			System.out.println("========================================");
			System.out.println("    업체 주문 거부 횟수 내림차순 목록                ");
			System.out.println("========================================");
			System.out.printf("[No.]\t[업체명]\t\t\t[주소]\t\t\t\t\t[업체번호]\t[주문 거부 횟수]\t[블랙리스트 지정일]\t[블랙리스트 해제일]\n");
			
			int num=1;
			
			
			for (BlackListStoreVO s1 : sArrList) {
				System.out.printf("%4d\t%-26s\t%-15s, %-10s\t%5s\t%5d\t\t%10s\t%10s\n",
						num,
						s1.getStoreName(),
						s1.getStoreAddr1(),
						s1.getStoreAddr2(),
						s1.getStoreNumber(),
						s1.getsCancelCount(),
						s1.getsBlackListStart(),
						s1.getsBlackListEnd()
						);
				num++;
			}
			num = 1;
			boolean flag = true;
			System.out.println("0. 이전 화면");
			System.out.print("번호 입력 : ");
			
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			String sel;
				sel = reader.readLine();
			while(flag) {
				if(sel.equals("0")) {
					flag = false;
					storeBlackListIntro();
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
	private static void sortName(ArrayList<BlackListStoreVO> sArrList) {
		try {
			Collections.sort(sArrList, new Comparator<BlackListStoreVO>() {
				
				@Override
				public int compare(BlackListStoreVO o1, BlackListStoreVO o2) {
					
					return o2.getStoreName().compareTo(o1.getStoreName());
				}
				
			});
			System.out.println("========================================");
			System.out.println(" 업체 블랙리스트(업체명 내림차순) 목록  ");
			System.out.println("========================================");
			System.out.printf("[No.]\t[업체명]\t\t\t[주소]\t\t\t\t\t[업체번호]\t[주문 거부 횟수]\t[블랙리스트 지정일]\t[블랙리스트 해제일]\n");
			
			int num=1;
			
			
			for (BlackListStoreVO s1 : sArrList) {
				System.out.printf("%4d\t%-26s\t%-15s, %-10s\t%5s\t%5d\t\t%10s\t%10s\n",
						num,
						s1.getStoreName(),
						s1.getStoreAddr1(),
						s1.getStoreAddr2(),
						s1.getStoreNumber(),
						s1.getsCancelCount(),
						s1.getsBlackListStart(),
						s1.getsBlackListEnd()
						);
				num++;
			}
			num = 1;
			boolean flag = true;
			System.out.println("0. 이전 화면");
			System.out.print("번호 입력 : ");
			
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			String sel;
				sel = reader.readLine();
			while(flag) {
				if(sel.equals("0")) {
					flag = false;
					storeBlackListIntro();
				}else {
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
	public BlackListStore() {
		
	}
	

}
