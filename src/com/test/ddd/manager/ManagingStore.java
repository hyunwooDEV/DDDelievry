package com.test.ddd.manager;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import com.test.ddd.fileroad.FileRoad;

public class ManagingStore {	//업체 관리
	public static FileRoad fr = new FileRoad();
	public static ManagerVO m = new ManagerVO("id","pw");
	
	
	public static void main(String[] args) {
		managingStoreIntro();
	}
	
	
	public ManagingStore() {
		
	}
	
	public static void managingStoreIntro() {

		System.out.println("========================================");
		System.out.println("            업체 목록 조회          ");
		System.out.println("========================================");
		
		
	
		ArrayList<String> sArrList = new ArrayList<String>();
		
		File sFile = new File(FileRoad.STOREFINAL);
		try {
			BufferedReader sReader = new BufferedReader(new FileReader(sFile));
			String temp = null;
			
			while ((temp = sReader.readLine())!= null) {
				sArrList.add(temp);
			}
			
			sReader.close();
			
			String[] sList = new String[25];
			
			System.out.printf("[No.]\t[업체명]\t\t\t\t[업체번호]\t\t[주소지]\t\t\t\t\t[전화번호]\t\t[카테고리]\t\t[매출액]\t\t[위생등급]\t\n");
			//sList[9] = 업체명 // sList[0] = 업체번호  // sList[7]+sList[8] = 주소지 // 
			//sList[6] = 전화번호 // sList[23] = 카테고리 // sList[21] = 매출액 // sList[16] = 위생등급
			for (int i=0 ; i< sArrList.size() ; i++) {
				sList = sArrList.get(i).split(",");
				
				System.out.printf(String.format("%4d\t%-42s\t%-10s\t%-38s\t%-15s\t%-15s\t%-20s\t%-15s\n",
						i+1,sList[9],sList[0],(sList[7]+", "+sList[8]),sList[6],sList[23],sList[21],sList[16]));
				
			}
			
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			boolean flag = true;
			System.out.println("1. 매출액 내림차순 정렬");
			System.out.println("2. 위생등급 내림차순 정렬");
			System.out.println("3. 업체번호 내림차순 정렬");
			System.out.println("4. 카테고리 내림차순 정렬");
			System.out.println("0. 이전 화면");
			System.out.print("번호 입력 : ");
			
			String sel = reader.readLine();
			
			while(flag) {
				if(sel.equals("1")) {
					sortSales(sArrList);
				} else if (sel.equals("2")) {
					flag = false;
					sortClean(sArrList);
				} else if (sel.equals("3")) {
					flag = false;
					sortStoreNumber(sArrList);
				} else if (sel.equals("4")) {
					flag = false;
					sortCategory(sArrList);

				} else if (sel.equals("0")) {
					flag = false;
					ManagerMainMenu.managerMainMenuIntro();

				} else {
					flag = true;
					System.out.println("잘못된 입력 값입니다. 다시 입력하세요.");
					System.out.println("1. 매출액 내림차순 정렬");
					System.out.println("2. 위생등급 내림차순 정렬");
					System.out.println("3. 업체번호 내림차순 정렬");
					System.out.println("4. 카테고리 내림차순 정렬");
					System.out.println("0. 이전 화면");
					System.out.print("번호 입력 : ");
					sel = reader.readLine();
				}
			}
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
			
		
		
		
		
	}


	private static void sortCategory(ArrayList<String> sArrList) {
		
		String[] sList = new String[25];
		
		System.out.println("========================================");
		System.out.println("       업체 카테고리 내림차순 정렬          ");
		System.out.println("========================================");
		//sList[9] = 업체명 // sList[0] = 업체번호  // sList[7]+sList[8] = 주소지 // 
		//sList[6] = 전화번호 // sList[23] = 카테고리 // sList[21] = 매출액 // sList[16] = 위생등급
		System.out.printf("[No.]\t[업체명]\t\t\t\t[업체번호]\t\t[주소지]\t\t\t\t\t[전화번호]\t\t[카테고리]\t\t[매출액]\t\t[위생등급]\t\n");
		
		int num = 1;
		for (int i=0 ; i< sArrList.size() ; i++) {
			sList = sArrList.get(i).split(",");
			
			if (sList[23].equals("한식")) {
				System.out.printf(String.format("%4d\t%-42s\t%-10s\t%-38s\t%-15s\t%-15s\t%-20s\t%-15s\n",
						num,sList[9],sList[0],(sList[7]+", "+sList[8]),sList[6],sList[23],sList[21],sList[16]));
				num++;
			}
		}
		
		for (int i=0 ; i< sArrList.size() ; i++) {
			sList = sArrList.get(i).split(",");
			
			if (sList[23].equals("패스트푸드")) {
				System.out.printf(String.format("%4d\t%-42s\t%-10s\t%-38s\t%-15s\t%-15s\t%-20s\t%-15s\n",
						num,sList[9],sList[0],(sList[7]+", "+sList[8]),sList[6],sList[23],sList[21],sList[16]));
				num++;
			}
		}
		
		for (int i=0 ; i< sArrList.size() ; i++) {
			sList = sArrList.get(i).split(",");
			
			if (sList[23].equals("치킨")) {
				System.out.printf(String.format("%4d\t%-42s\t%-10s\t%-38s\t%-15s\t%-15s\t%-20s\t%-15s\n",
						num,sList[9],sList[0],(sList[7]+", "+sList[8]),sList[6],sList[23],sList[21],sList[16]));
				num++;
			}
		}
		for (int i=0 ; i< sArrList.size() ; i++) {
			sList = sArrList.get(i).split(",");
			
			if (sList[23].equals("중식")) {
				System.out.printf(String.format("%4d\t%-42s\t%-10s\t%-38s\t%-15s\t%-15s\t%-20s\t%-15s\n",
						num,sList[9],sList[0],(sList[7]+", "+sList[8]),sList[6],sList[23],sList[21],sList[16]));
				num++;
			}
		}
		for (int i=0 ; i< sArrList.size() ; i++) {
			sList = sArrList.get(i).split(",");
			
			if (sList[23].equals("일식")) {
				System.out.printf(String.format("%4d\t%-42s\t%-10s\t%-38s\t%-15s\t%-15s\t%-20s\t%-15s\n",
						num,sList[9],sList[0],(sList[7]+", "+sList[8]),sList[6],sList[23],sList[21],sList[16]));
				num++;
			}
		}
		for (int i=0 ; i< sArrList.size() ; i++) {
			sList = sArrList.get(i).split(",");
			
			if (sList[23].equals("양식")) {
				System.out.printf(String.format("%4d\t%-42s\t%-10s\t%-38s\t%-15s\t%-15s\t%-20s\t%-15s\n",
						num,sList[9],sList[0],(sList[7]+", "+sList[8]),sList[6],sList[23],sList[21],sList[16]));
				num++;
			}
		}
		for (int i=0 ; i< sArrList.size() ; i++) {
			sList = sArrList.get(i).split(",");
			
			if (sList[23].equals("분식")) {
				System.out.printf(String.format("%4d\t%-42s\t%-10s\t%-38s\t%-15s\t%-15s\t%-20s\t%-15s\n",
						num,sList[9],sList[0],(sList[7]+", "+sList[8]),sList[6],sList[23],sList[21],sList[16]));
				num++;
			}
		}
		for (int i=0 ; i< sArrList.size() ; i++) {
			sList = sArrList.get(i).split(",");
			
			if (sList[23].equals("디저트")) {
				System.out.printf(String.format("%4d\t%-42s\t%-10s\t%-38s\t%-15s\t%-15s\t%-20s\t%-15s\n",
						num,sList[9],sList[0],(sList[7]+", "+sList[8]),sList[6],sList[23],sList[21],sList[16]));
				num++;
			}
		}
		num =0;
		
		System.out.println("*** 정렬 완료! ***");
		
		try {
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			System.out.println("0. 이전 화면");
			System.out.print("번호 입력 : ");
			
			String sel = reader.readLine();
			boolean flag = true;
			while(flag) {
				if(sel.equals("0")) {
					flag = false;
					managingStoreIntro();
				
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


	private static void sortStoreNumber(ArrayList<String> sArrList) {
		String[] sList = new String[25];
				
		System.out.println("========================================");
		System.out.println("         업체번호 내림차순 정렬        ");
		System.out.println("========================================");
		//sList[9] = 업체명 // sList[0] = 업체번호  // sList[7]+sList[8] = 주소지 // 
		//sList[6] = 전화번호 // sList[23] = 카테고리 // sList[21] = 매출액 // sList[16] = 위생등급
		System.out.printf("[No.]\t[업체명]\t\t\t\t[업체번호]\t\t[주소지]\t\t\t\t\t[전화번호]\t\t[카테고리]\t\t[매출액]\t\t[위생등급]\t\n");
		Collections.sort(sArrList);
		Collections.reverse(sArrList);
		int num = 1;
		
		
		for(int i=0 ; i<sArrList.size() ; i++) {
			sList = sArrList.get(i).split(",");
			System.out.printf(String.format("%4d\t%-42s\t%-10s\t%-38s\t%-15s\t%-15s\t%-20s\t%-15s\n",
					num,sList[9],sList[0],(sList[7]+", "+sList[8]),sList[6],sList[23],sList[21],sList[16]));
			num++;
		}
		
		num = 0;
		System.out.println("*** 정렬 완료! ***");
		try {
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			System.out.println("0. 이전 화면");
			System.out.print("번호 입력 : ");
			
			String sel = reader.readLine();
			boolean flag = true;
			while(flag) {
				if(sel.equals("0")) {
					flag = false;
					managingStoreIntro();
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
		
	
			


	private static void sortClean(ArrayList<String> sArrList) {
		String[] sList = new String[25];
		
		System.out.println("========================================");
		System.out.println("        업체 위생상태 내림차순 정렬        ");
		System.out.println("========================================");
		//sList[9] = 업체명 // sList[0] = 업체번호  // sList[7]+sList[8] = 주소지 // 
		//sList[6] = 전화번호 // sList[23] = 카테고리 // sList[21] = 매출액 // sList[16] = 위생등급
		System.out.printf("[No.]\t[업체명]\t\t\t\t[업체번호]\t\t[주소지]\t\t\t\t\t[전화번호]\t\t[카테고리]\t\t[매출액]\t\t[위생등급]\t\n");
		int num = 1;
		for (int i=0 ; i< sArrList.size() ; i++) {
			sList = sArrList.get(i).split(",");
			
			if (sList[16].equals("매우우수")) {
				System.out.printf(String.format("%4d\t%-42s\t%-10s\t%-38s\t%-15s\t%-15s\t%-20s\t%-15s\n",
						num,sList[9],sList[0],(sList[7]+", "+sList[8]),sList[6],sList[23],sList[21],sList[16]));
				num++;
			}
		}
		for (int i=0 ; i< sArrList.size() ; i++) {
			sList = sArrList.get(i).split(",");
			
			if (sList[16].equals("우수")) {
				System.out.printf(String.format("%4d\t%-42s\t%-10s\t%-38s\t%-15s\t%-15s\t%-20s\t%-15s\n",
						num,sList[9],sList[0],(sList[7]+", "+sList[8]),sList[6],sList[23],sList[21],sList[16]));
				num++;
			}
		}
		for (int i=0 ; i< sArrList.size() ; i++) {
			sList = sArrList.get(i).split(",");
			
			if (sList[16].equals("좋음")) {
				System.out.printf(String.format("%4d\t%-42s\t%-10s\t%-38s\t%-15s\t%-15s\t%-20s\t%-15s\n",
						num,sList[9],sList[0],(sList[7]+", "+sList[8]),sList[6],sList[23],sList[21],sList[16]));
				num++;
			}
		}
		
		num = 0;
		
		System.out.println("*** 정렬 완료! ***");
		
		try {
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			System.out.println("0. 이전 화면");
			System.out.print("번호 입력 : ");
			
			String sel = reader.readLine();
			boolean flag = true;
			while(flag) {
				if(sel.equals("0")) {
					flag = false;
					managingStoreIntro();
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


	private static void sortSales(ArrayList<String> sArrList) {
		String[] sList = new String[25];
		System.out.println("========================================");
		System.out.println("         업체 매출 내림차순 정렬        ");
		System.out.println("========================================");
		//sList[9] = 업체명 // sList[0] = 업체번호  // sList[7]+sList[8] = 주소지 // 
		//sList[6] = 전화번호 // sList[23] = 카테고리 // sList[21] = 매출액 // sList[16] = 위생등급
		System.out.printf("[No.]\t[업체명]\t\t\t\t[업체번호]\t\t[주소지]\t\t\t\t\t[전화번호]\t\t[카테고리]\t\t[매출액]\t\t[위생등급]\t\n");
		
		
		ArrayList<String> sortArrayList = new ArrayList<String>();
		ArrayList<Integer> intArrayList = new ArrayList<Integer>();
		//매출 속성 뽑기
		for (int i=0 ; i< sArrList.size() ; i++) {
			sList = sArrList.get(i).split(",");
				sortArrayList.add(sList[21]);
		}
		for (int i=0 ; i< sortArrayList.size() ; i++) {
			sortArrayList.set(i, sortArrayList.get(i).replaceAll("원", ""));
		}
		for (int i=0 ; i< sortArrayList.size() ; i++) {
			intArrayList.add(Integer.parseInt(sortArrayList.get(i)));
		}
		
		sortArrayList.clear();
		//매출만 오름 -> 내림차순 정렬
		Collections.sort(intArrayList, new SortingAsc());
		
		
		for (int i=0; i< intArrayList.size() ; i++) {
			sortArrayList.add(intArrayList.get(i)+"원");
		}
		
		
		int num = 1;
		//매출 내림차순 한 배열 출력
//		while(num<sortArrayList.size()) {
			
			for (int i=0 ; i<sortArrayList.size() ; i++) {
				for (int j=0; j<sArrList.size() ; j++) {
					if(sArrList.get(j).indexOf(sortArrayList.get(i))!=-1) {
						sList = sArrList.get(j).split(",");
						System.out.printf(String.format("%4d\t%-42s\t%-10s\t%-38s\t%-15s\t%-15s\t%-20s\t%-15s\n",
								num,sList[9],sList[0],(sList[7]+", "+sList[8]),sList[6],sList[23],sList[21],sList[16]));
						num++;
						break;
						
						
					}
					
				}
				if (num>=200) {
					break;
				}
			}
			num = 0;
			System.out.println("*** 정렬 완료! ***");
			try {
				BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
				System.out.println("0. 이전 화면");
				System.out.print("번호 입력 : ");
				
				String sel = reader.readLine();
				boolean flag = true;
				while(flag) {
					if(sel.equals("0")) {
						flag = false;
						managingStoreIntro();
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
			
		
//		}
		
	}
	
	
}//class
	
class SortingAsc implements Comparator<Integer>{

	@Override
	public int compare(Integer arg0, Integer arg1) {
		if (arg0 < arg1)
			return 1;
		else if (arg0 > arg1)
			return -1;
		else {
			return arg0.compareTo(arg1);
			}

	}
	
	
}



	


