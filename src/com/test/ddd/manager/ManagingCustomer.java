package com.test.ddd.manager;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import com.test.ddd.fileroad.FileRoad;
import com.test.ddd.fileroad.TotalRoad;

public class ManagingCustomer {
	
	static int iStart = 0;
	static int iEnd = 0;
	
	public static void main(String[] args) {
		
		
		managingCustomerIntro();
	}

	public static void managingCustomerIntro() {
		try {
			ArrayList<ManagingCustomerVO> mcArrList = new ArrayList<ManagingCustomerVO>();
			
			
			ArrayList<String> customerList = TotalRoad.dataRoad("c");
			ArrayList<String> orderList = new ArrayList<String>();
			
			File oFile = new File(FileRoad.FINISHORDER);
			BufferedReader fReader = new BufferedReader(new FileReader(oFile));
			String aa = "";
			while((aa=fReader.readLine())!=null) {
				orderList.add(aa);
			}
			fReader.close();
			String[] oList = new String[11]; 
			String[] cList = new String[13];
			
			String start = "";
			String end = "";
			String temp = "";
			
			System.out.println("========================================");
			System.out.println("              회원 목록 조회            ");
			System.out.println("========================================");
			
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			
			System.out.print("조회 시작 일 (ex: YYYY-MM-DD) : ");
			
			start = reader.readLine();
			temp = start;
			start = temp.replace("-","");
			iStart = Integer.parseInt(start);
			
			System.out.print("조회 마지막 일 (ex: YYYY-MM-DD) : ");
			
			end = reader.readLine();
			temp = end;
			end = temp.replace("-","");
			iEnd = Integer.parseInt(end);
			
		
			
		
		
		
			
//			System.out.printf("조회기간 : %s ~ %s\n",start,end);
			
			System.out.printf("[No.]\t[이름]\t[회원번호]\t[주소]\t\t\t\t\t\t\t[휴대폰번호]\t[등급]\t[주문수] [주문취소] [주문액] [포인트]\n");
			
			
			
			ArrayList<String> dataList1 = new ArrayList<String>();
			ArrayList<String> dataList2 = new ArrayList<String>();
			ArrayList<String> dataList3 = new ArrayList<String>();
			
			
			ArrayList<Integer> countList = new ArrayList<Integer>();
			ArrayList<Integer> ExpendList = new ArrayList<Integer>();
			ArrayList<Integer> cancelList = new ArrayList<Integer>();
			
			
			int count = 0;
			int cancelCount =0;
			int cExpend = 0;
			
			for(int i=0 ; i<customerList.size() ; i++) {
				cList = customerList.get(i).split(",");
				for (int j=0 ; j<orderList.size() ; j++) {
					oList = orderList.get(j).split(",");
					if(cList[0].equals(oList[1])) {
						count = count+1;
						if(oList[6].equals("고객취소")) {
							cancelCount = cancelCount+1;
						} else if(oList[6].equals("배달완료")){
							cExpend = cExpend+ Integer.parseInt(oList[10]);
						} 
					
				}
				
				}
				if (count != 0) {
					countList.add(count);
					ExpendList.add(cExpend);
					cancelList.add(cancelCount);
					
				}
				count = 0;
				cExpend = 0;
				cancelCount = 0;
			}
			
			for(int i=0 ; i<customerList.size() ; i++) {
				cList = customerList.get(i).split(",");
				for (int j=0 ; j<orderList.size() ; j++) {
					oList = orderList.get(j).split(",");
				if(cList[0].equals(oList[1])) {
					
						dataList1.add(cList[3]+","+cList[0]+","+cList[7]+","+cList[8]+","+cList[6]+","+cList[9]+","+cList[10]);
						dataList2.add(cList[10]);
						dataList3.add(oList[8].replace("-", ""));
						break;
				}
				
				}
				
			}
							
			//***
			//1. reader
			//2. loop
			//3. cList[0] -> reader + line
			//4. count++;
							
			ArrayList<String> finalCustomerList = new ArrayList<String>();
			for (int i=0; i<dataList1.size();i++) {
				finalCustomerList.add(dataList1.get(i)+","+countList.get(i)+","+cancelList.get(i)+","+ExpendList.get(i)+","+dataList2.get(i)+","+dataList3.get(i));
			}
			
			
			String[] str = new String[12];
			for(int i=0; i<finalCustomerList.size() ; i++) {
				str = finalCustomerList.get(i).split(",");
				ManagingCustomerVO mc = new ManagingCustomerVO();
				mc.setCustomerName(str[0]);
				mc.setCustomerNumber(str[1]);
				mc.setCustomerAddr1(str[2]);
				mc.setCustomerAddr2(str[3]);
				mc.setCustomerPhone(str[4]);
				mc.setCustomerLevel(str[5]);
				mc.setCustomerOrder(Integer.parseInt(str[7]));
				mc.setCustomerCancel(Integer.parseInt(str[8]));
				mc.setCustomerExpend(Integer.parseInt(str[9]));
				mc.setCustomerPoint(Integer.parseInt(str[6]));
				mc.setOrderDate(Integer.parseInt(str[11]));
				
				mcArrList.add(mc);
				
			}
			
			
//			System.out.printf("[No.]\t[이름]\t[회원번호]\t[주소]\t[휴대폰번호]\t[등급]\t[주문수]\t[주문취소]\t[주문액]\t[포인트]\n");
			int num = 1;
			for (ManagingCustomerVO r1 : mcArrList) {
				if(r1.getOrderDate()>=iStart && r1.getOrderDate()<=iEnd) {
					
				System.out.printf("%3d\t%s\t\t%s\t%s, %-10s\t%10s\t%4s\t%d\t\t%d\t%d\t%d\n",
						num,
						r1.getCustomerName(),
						r1.getCustomerNumber(),
						r1.getCustomerAddr1(),
						r1.getCustomerAddr2(),
						r1.getCustomerPhone(),
						r1.getCustomerLevel(),
						r1.getCustomerOrder(),
						r1.getCustomerCancel(),
						r1.getCustomerExpend(),
						r1.getCustomerPoint()
						);
						
				num++;
				}
			}
			num = 1;
			
			System.out.println("1. 휴대폰 번호 검색");
			System.out.println("2. 이름 검색");
			System.out.println("3. 회원 번호 검색");
			System.out.println("4. 주문수 내림차순 정렬");
			System.out.println("5. 주문취소 내림차순 정렬");
			System.out.println("6. 주문액 내림차순 정렬");
			System.out.println("0. 이전 화면");
			System.out.print("번호 입력 : ");
			
			BufferedReader reader1 = new BufferedReader(new InputStreamReader(System.in));
			
			String sel = reader1.readLine();
			
			
			boolean flag = true;
			while (flag) {
				
				if (sel.equals("1")) {
					flag = false;
					phoneSearch(mcArrList);
				} else if (sel.equals("2")) {
					flag = false;
					nameSearch(mcArrList);
					
				} else if (sel.equals("3")) {
					flag = false;
					numberSearch(mcArrList);
					
				} else if (sel.equals("4")) {
					flag = false;
					sortByOrder(mcArrList);
				} else if (sel.equals("5")) {
					flag = false;
					sortByCancel(mcArrList);
				} else if (sel.equals("6")) {
					flag = false;
					sortByExpend(mcArrList);
				}else if (sel.equals("0")) {
					flag = false;
					ManagerMainMenu.managerMainMenuIntro();

				} else {
					flag = true;
					System.out.println("잘못된 입력입니다. 다시 입력하세요.");
					System.out.println("1. 휴대폰 번호 검색");
					System.out.println("2. 이름 검색");
					System.out.println("3. 회원 번호 검색");
					System.out.println("4. 주문수 내림차순 정렬");
					System.out.println("5. 주문취소 내림차순 정렬");
					System.out.println("6. 주문액 내림차순 정렬");
					System.out.println("0. 이전 화면");
					System.out.print("번호 입력 : ");
					sel = reader1.readLine();
				}
				
			}
			
			
		
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public static void phoneSearch(ArrayList<ManagingCustomerVO> mcArrList) {
		System.out.println("*** 휴대폰 번호 검색 ***");
		System.out.print("휴대폰 번호 입력(-빼고 숫자만 입력하시오.) : ");
		try {
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
				String input = reader.readLine();
			
			int num = 1;
			for (int i=0 ; i<mcArrList.size() ; i++) {
				String number = mcArrList.get(i).getCustomerPhone();
				if(number.equals(input)) {
					System.out.println("입력하신 번호와 일치하는 회원을 찾았습니다.");
					System.out.printf("[No.]\t[이름]\t[회원번호]\t[주소]\t\t\t\t\t\t[휴대폰번호]\t[등급][포인트][주문수][주문취소][주문액]\n");
					System.out.printf("%d\t%s\t%s\t\t%s, %s\t%10s\t%s\t%d\t%d\t%d\t%d\n",
							num,
							mcArrList.get(i).getCustomerName(),
							mcArrList.get(i).getCustomerNumber(),
							mcArrList.get(i).getCustomerAddr1(),
							mcArrList.get(i).getCustomerAddr2(),
							mcArrList.get(i).getCustomerPhone(),
							mcArrList.get(i).getCustomerLevel(),
							mcArrList.get(i).getCustomerOrder(),
							mcArrList.get(i).getCustomerCancel(),
							mcArrList.get(i).getCustomerExpend(),
							mcArrList.get(i).getCustomerPoint()
							);
					
					
				} else {
					
				}
			}
			System.out.println();
			
			
			BufferedReader reader1 = new BufferedReader(new InputStreamReader(System.in));
			System.out.println("0. 이전 화면");
			System.out.print("번호 입력 : ");
			String sel = reader1.readLine();
			
			
			boolean flag = true;
			while (flag) {
				
				if (sel.equals("0")) {
					flag = false;
					managingCustomerIntro();
				} else {
					flag = true;
					System.out.println("잘못된 입력입니다. 다시 입력하세요.");
					System.out.println("0. 이전 화면");
					System.out.print("번호 입력 : ");
					sel = reader1.readLine();
				}
			
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void nameSearch(ArrayList<ManagingCustomerVO> mcArrList) {
		System.out.println("*** 이름 검색 ***");
		System.out.print("이름 입력 : ");
		try {
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
				String input = reader.readLine();
			
			int num = 1;
			for (int i=0 ; i<mcArrList.size() ; i++) {
				String name = mcArrList.get(i).getCustomerName();
				if(name.equals(input)) {
					System.out.println("입력하신 이름과 일치하는 회원을 찾았습니다.");
					System.out.printf("[No.]\t[이름]\t[회원번호]\t[주소]\t\t\t\t\t\t[휴대폰번호]\t[등급][포인트][주문수][주문취소][주문액]\n");
					System.out.printf("%d\t%s\t%s\t\t%s, %s\t%10s\t%s\t%d\t%d\t%d\t%d\n",
							num,
							mcArrList.get(i).getCustomerName(),
							mcArrList.get(i).getCustomerNumber(),
							mcArrList.get(i).getCustomerAddr1(),
							mcArrList.get(i).getCustomerAddr2(),
							mcArrList.get(i).getCustomerPhone(),
							mcArrList.get(i).getCustomerLevel(),
							mcArrList.get(i).getCustomerOrder(),
							mcArrList.get(i).getCustomerCancel(),
							mcArrList.get(i).getCustomerExpend(),
							mcArrList.get(i).getCustomerPoint()
							);
				} else {
					
				}
			}
			System.out.println();
			System.out.println("0. 이전 화면");
			System.out.print("번호 입력 : ");
			
			BufferedReader reader1 = new BufferedReader(new InputStreamReader(System.in));
			
			String sel = reader1.readLine();
			
			
			boolean flag = true;
			while (flag) {
				
				if (sel.equals("0")) {
					flag = false;
					managingCustomerIntro();
				} else {
					flag = true;
					System.out.println("잘못된 입력입니다. 다시 입력하세요.");
					System.out.println("0. 이전 화면");
					System.out.print("번호 입력 : ");
					sel = reader1.readLine();
				}
			
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	

	public static void numberSearch(ArrayList<ManagingCustomerVO> mcArrList) {
		System.out.println("*** 회원 번호 검색 ***");
		System.out.print("회원 번호 입력 : ");
		try {
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
				String input = reader.readLine();
			
			int num = 1;
			for (int i=0 ; i<mcArrList.size() ; i++) {
				String number = mcArrList.get(i).getCustomerNumber();
				if(number.equals(input)) {
					System.out.println("입력하신 회원 번호와 일치하는 회원을 찾았습니다.");
					System.out.printf("[No.]\t[이름]\t[회원번호]\t[주소]\t\t\t\t\t\t[휴대폰번호]\t[등급][포인트][주문수][주문취소][주문액]\n");
					System.out.printf("%d\t%s\t%s\t\t%s, %s\t%10s\t%s\t%d\t%d\t%d\t%d\n",
							num,
							mcArrList.get(i).getCustomerName(),
							mcArrList.get(i).getCustomerNumber(),
							mcArrList.get(i).getCustomerAddr1(),
							mcArrList.get(i).getCustomerAddr2(),
							mcArrList.get(i).getCustomerPhone(),
							mcArrList.get(i).getCustomerLevel(),
							mcArrList.get(i).getCustomerOrder(),
							mcArrList.get(i).getCustomerCancel(),
							mcArrList.get(i).getCustomerExpend(),
							mcArrList.get(i).getCustomerPoint()
							);
				} else {
					
				}
			}
			System.out.println();
			System.out.println("0. 이전 화면");
			System.out.print("번호 입력 : ");
			
			BufferedReader reader1 = new BufferedReader(new InputStreamReader(System.in));
			
			String sel = reader1.readLine();
			
			
			boolean flag = true;
			while (flag) {
				
				if (sel.equals("0")) {
					flag = false;
					managingCustomerIntro();
				
				} else {
					flag = true;
					System.out.println("잘못된 입력입니다. 다시 입력하세요.");
					System.out.println("0. 이전 화면");
					System.out.print("번호 입력 : ");
					sel = reader1.readLine();
				}
			
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void sortByOrder(ArrayList<ManagingCustomerVO> mcArrList) {
		Collections.sort(mcArrList, new Comparator<ManagingCustomerVO>() {

			@Override
			public int compare(ManagingCustomerVO o1, ManagingCustomerVO o2) {
				
				if(o1.getCustomerOrder()>o2.getCustomerOrder()) {
					return -1;
				} else if (o1.getCustomerOrder()<o2.getCustomerOrder()) {
					return 1;
				}
				return 0;
			}
		});
		System.out.println("========================================");
		System.out.println("         주문수 내림차순 정렬           ");
		System.out.println("========================================");
		System.out.printf("[No.]\t[이름]\t[회원번호]\t[주소]\t\t\t\t\t\t\t[휴대폰번호]\t[등급]\t[주문수] [주문취소] [주문액] [포인트]\n");
		
		int num = 1;
		for (ManagingCustomerVO r1 : mcArrList) {
			if(r1.getOrderDate()>=iStart && r1.getOrderDate()<=iEnd) {
				System.out.printf("%3d\t%s\t\t%s\t%s, %-10s\t%10s\t%4s\t%d\t\t%d\t%d\t%d\n",
						num,
						r1.getCustomerName(),
						r1.getCustomerNumber(),
						r1.getCustomerAddr1(),
						r1.getCustomerAddr2(),
						r1.getCustomerPhone(),
						r1.getCustomerLevel(),
						r1.getCustomerOrder(),
						r1.getCustomerCancel(),
						r1.getCustomerExpend(),
						r1.getCustomerPoint()
						);
						
				num++;
			}
		}
		num = 1;
		
		try {
			BufferedReader reader1 = new BufferedReader(new InputStreamReader(System.in));
			System.out.println("0. 이전 화면");
			System.out.print("번호 입력 : ");
			
			String sel = reader1.readLine();
			
			
			boolean flag = true;
			while (flag) {
				
				if (sel.equals("0")) {
					flag = false;
					managingCustomerIntro();
				} else {
					flag = true;
					System.out.println("잘못된 입력입니다. 다시 입력하세요.");
					System.out.println("0. 이전 화면");
					System.out.print("번호 입력 : ");
					sel = reader1.readLine();
				}
			
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
		
	}

	public static void sortByCancel(ArrayList<ManagingCustomerVO> mcArrList) {
		Collections.sort(mcArrList, new Comparator<ManagingCustomerVO>() {

			@Override
			public int compare(ManagingCustomerVO o1, ManagingCustomerVO o2) {
				
				if(o1.getCustomerCancel()>o2.getCustomerCancel()) {
					return -1;
				} else if (o1.getCustomerCancel()<o2.getCustomerCancel()) {
					return 1;
				}
				return 0;
			}
		});
		
		System.out.println("========================================");
		System.out.println("         주문취소 내림차순 정렬         ");
		System.out.println("========================================");
		System.out.printf("[No.]\t[이름]\t[회원번호]\t[주소]\t\t\t\t\t\t\t[휴대폰번호]\t[등급]\t[주문수] [주문취소] [주문액] [포인트]\n");
		int num = 1;
		for (ManagingCustomerVO r1 : mcArrList) {
			if(r1.getOrderDate()>=iStart && r1.getOrderDate()<=iEnd) {
				System.out.printf("%3d\t%s\t\t%s\t%s, %-10s\t%10s\t%4s\t%d\t\t%d\t%d\t%d\n",
						num,
						r1.getCustomerName(),
						r1.getCustomerNumber(),
						r1.getCustomerAddr1(),
						r1.getCustomerAddr2(),
						r1.getCustomerPhone(),
						r1.getCustomerLevel(),
						r1.getCustomerOrder(),
						r1.getCustomerCancel(),
						r1.getCustomerExpend(),
						r1.getCustomerPoint()
						);
						
				num++;
			}
		}
		num = 1;
		
		try {
			BufferedReader reader1 = new BufferedReader(new InputStreamReader(System.in));
			System.out.println("0. 이전 화면");
			System.out.print("번호 입력 : ");
			String sel = reader1.readLine();
			
			
			boolean flag = true;
			while (flag) {
				
				if (sel.equals("0")) {
					flag = false;
					managingCustomerIntro();
				} else {
					flag = true;
					System.out.println("잘못된 입력입니다. 다시 입력하세요.");
					System.out.println("0. 이전 화면");
					System.out.print("번호 입력 : ");
					sel = reader1.readLine();
				}
			
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
	}

	public static void sortByExpend(ArrayList<ManagingCustomerVO> mcArrList) {
		Collections.sort(mcArrList, new Comparator<ManagingCustomerVO>() {

			@Override
			public int compare(ManagingCustomerVO o1, ManagingCustomerVO o2) {
				
				if(o1.getCustomerExpend()> o2.getCustomerExpend()) {
					return -1;
				} else if(o1.getCustomerExpend()< o2.getCustomerExpend()) {
					return 1;
				}
				return 0;
			}
			
		});
		
		
		int num = 1;
		System.out.println("========================================");
		System.out.println("         주문액 내림차순 정렬           ");
		System.out.println("========================================");
		System.out.printf("[No.]\t[이름]\t[회원번호]\t[주소]\t\t\t\t\t\t\t[휴대폰번호]\t[등급]\t[주문수] [주문취소] [주문액] [포인트]\n");
		for (ManagingCustomerVO r1 : mcArrList) {
			if(r1.getOrderDate()>=iStart && r1.getOrderDate()<=iEnd) {
				System.out.printf("%3d\t%s\t\t%s\t%s, %-10s\t%10s\t%4s\t%d\t\t%d\t%d\t%d\n",
						num,
						r1.getCustomerName(),
						r1.getCustomerNumber(),
						r1.getCustomerAddr1(),
						r1.getCustomerAddr2(),
						r1.getCustomerPhone(),
						r1.getCustomerLevel(),
						r1.getCustomerOrder(),
						r1.getCustomerCancel(),
						r1.getCustomerExpend(),
						r1.getCustomerPoint()
						);
						
				num++;
			}
		}
		num = 1;
		
		try {
			System.out.println("0. 이전 화면");
			System.out.print("번호 입력 : ");
			BufferedReader reader1 = new BufferedReader(new InputStreamReader(System.in));
			
			String sel = reader1.readLine();
			
			
			boolean flag = true;
			while (flag) {
				
				if (sel.equals("0")) {
					flag = false;
					managingCustomerIntro();
				} else {
					flag = true;
					System.out.println("잘못된 입력입니다. 다시 입력하세요.");
					System.out.println("0. 이전화면");
					System.out.print("번호 입력 : ");
					sel = reader1.readLine();
				}
			
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	public ManagingCustomer() {
		
	}
	
}


