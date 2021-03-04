package com.test.ddd.manager;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import com.test.ddd.fileroad.FileRoad;

public class BlackListCustomer {
	public static FileRoad fr = new FileRoad();
	//public static String bPath = "C:\\home\\DDDilivery\\src\\com\\test\\ddd\\dummy\\BlackList.txt";
	public static ManagerVO m = new ManagerVO("id","pw");
	
	public static void main(String[] args) {
		customerBlackListIntro();
	}

	public static void customerBlackListIntro() {
		ArrayList<BlackListCustomerVO> cArrList = new ArrayList<BlackListCustomerVO>();
		ArrayList<String> arrList1 = new ArrayList<String>();
		ArrayList<String> arrList2 = new ArrayList<String>();
		String[] tempList1 = new String[14];
		String[] tempList2 = new String[3];
		File cFile = new File(FileRoad.CUSTOMERFINAL);
		File bFile = new File(FileRoad.BLACKLIST);
		try {
			BufferedReader reader = new BufferedReader(new FileReader(cFile));
			String temp = "";
			while((temp = reader.readLine())!=null) {
				arrList1.add(temp);
			}
			reader.close();
			reader = new BufferedReader(new FileReader(bFile));
			temp = "";
			while ((temp = reader.readLine())!=null) {
				arrList2.add(temp);
			}
			reader.close();
			temp = "";
			
			for(int i=0; i<arrList2.size() ; i++) {
				tempList2 = arrList2.get(i).split(",");
				for(int j=0 ; j<arrList1.size() ; j++) {
					tempList1 = arrList1.get(j).split(",");
					if(tempList2[1].equals(tempList1[0])) {
						
						BlackListCustomerVO c = new BlackListCustomerVO();
						c.setCustomerName(tempList1[3]);
						c.setCustomerAddr1(tempList1[7]);
						c.setCustomerAddr2(tempList1[8]);
						c.setCustomerNumber(tempList1[0]);
						c.setCancelCount(Integer.parseInt(tempList2[2]));
						c.setBlackListStart(tempList2[0]);
						c.setBlackListEnd(tempList2[0]);
						
						cArrList.add(c);
					}
					
				}
			}
			System.out.println("=== 고객 블랙리스트 목록 ===");
			System.out.printf("[No.]\t[이름]\t[주소]\t\t\t\t\t[회원번호]\t[N월 취소횟수]\t[블랙리스트 지정일]\t[블랙리스트 해제일]\n");
			
			int num=1;
			
			
			for (BlackListCustomerVO c : cArrList) {
				System.out.printf("%4d\t%s\t%10s, %-10s\t%5s\t%5d\t\t%10s\t%10s\n",
						num,
						c.getCustomerName(),
						c.getCustomerAddr1(),
						c.getCustomerAddr2(),
						c.getCustomerNumber(),
						c.getCancelCount(),
						c.getBlackListStart(),
						c.getBlackListEnd()
						);
				num++;
			}
			num = 1;
			
			boolean flag = true;
			System.out.println("1. 이름 내림차순 정렬");
			System.out.println("2. 취소 횟수 내림차순 정렬");
			System.out.println("0. 이전 화면");
			System.out.print("번호 입력 : ");
			
			BufferedReader reader2 = new BufferedReader(new InputStreamReader(System.in));
			String sel = reader2.readLine();
			
			while(flag) {
				if(sel.equals("1")) {
					flag = false;
					sortName(cArrList);
					
				} else if (sel.equals("2")) {
					flag = false;
					sortCancel(cArrList);
				}else if (sel.equals("0")) {
					flag = false;
					System.out.println();
					System.out.println("이전 화면으로 돌아갑니다.");
					System.out.println();
//					BlackList b = new BlackList();
					BlackList.blackListIntro();
					
				} else {
					flag = true;
					System.out.println("잘못된 입력 값입니다. 다시 입력하세요.");	
					System.out.println("1. 이름 내림차순 정렬");
					System.out.println("2. 취소 횟수 내림차순 정렬");
					System.out.println("0. 이전 화면");
					System.out.print("번호 입력 : ");
					sel = reader2.readLine();
				}
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	private static void sortCancel(ArrayList<BlackListCustomerVO> cArrList) {
		try {
			//BlackListCustomerVO c = new BlackListCustomerVO();
			Collections.sort(cArrList, new Comparator<BlackListCustomerVO>() {
	
				@Override
				public int compare(BlackListCustomerVO o1, BlackListCustomerVO o2) {
					
					if(o1.getCancelCount()>o2.getCancelCount()) {
						return -1;
					}else if(o1.getCancelCount()<o2.getCancelCount()){
						return 1;
					}
					return 0;
				}
				
			});
			System.out.println("=== 업체 블랙리스트(취소 횟수 내림차순) 목록 ===");
			System.out.printf("[No.]\t[이름]\t[주소]\t\t\t\t\t[회원번호]\t[N월 취소횟수]\t[블랙리스트 지정일]\t[블랙리스트 해제일]\n");
			
			int num=1;
			
			
			for (BlackListCustomerVO c1 : cArrList) {
				System.out.printf("%4d\t%s\t%10s, %-10s\t%5s\t%5d\t\t%10s\t%10s\n",
						num,
						c1.getCustomerName(),
						c1.getCustomerAddr1(),
						c1.getCustomerAddr2(),
						c1.getCustomerNumber(),
						c1.getCancelCount(),
						c1.getBlackListStart(),
						c1.getBlackListEnd()
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
					customerBlackListIntro();
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

	private static void sortName(ArrayList<BlackListCustomerVO> cArrList) {
		try {
			//BlackListCustomerVO c = new BlackListCustomerVO();
			Collections.sort(cArrList, new Comparator<BlackListCustomerVO>() {
				
				@Override
				public int compare(BlackListCustomerVO o1, BlackListCustomerVO o2) {
					
					return o2.getCustomerName().compareTo(o1.getCustomerName());
				}	
				
			});
			
			System.out.println("=== 고객 블랙리스트(이름 내림차순) 목록 ===");
			System.out.printf("[No.]\t[이름]\t[주소]\t\t\t\t\t[회원번호]\t[N월 취소횟수]\t[블랙리스트 지정일]\t[블랙리스트 해제일]\n");
			
			int num=1;
			
			
			for (BlackListCustomerVO c1 : cArrList) {
				System.out.printf("%4d\t%s\t%10s, %-10s\t%5s\t%5d\t\t%10s\t%10s\n",
						num,
						c1.getCustomerName(),
						c1.getCustomerAddr1(),
						c1.getCustomerAddr2(),
						c1.getCustomerNumber(),
						c1.getCancelCount(),
						c1.getBlackListStart(),
						c1.getBlackListEnd()
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
				if(sel.equals("1")) {
					flag = false;
					customerBlackListIntro();
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
	
	
}
