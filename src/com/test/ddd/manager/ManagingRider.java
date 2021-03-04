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

public class ManagingRider {
	
	public static void main(String[] args) {
		managingRiderIntro();
	}
	
	public static void managingRiderIntro() {
		
		try {
			ArrayList<ManagingRiderVO> mrArrList = new ArrayList<ManagingRiderVO>();
			
			File oFile = new File(FileRoad.FINISHORDER);
			
			ArrayList<String> rList = TotalRoad.dataRoad("r");
			ArrayList<String> oList = new ArrayList<String>();
			ArrayList<String> dataList1 = new ArrayList<String>();
			
			
			ArrayList<Integer> countList = new ArrayList<Integer>();
			
			
			
			BufferedReader fReader = new BufferedReader(new FileReader(oFile));
			String aa = "";
			while((aa=fReader.readLine())!=null) {
				oList.add(aa);
			}
			
			fReader.close();
			
			
			
			int count = 0;
			
			String[] rider = new String[13];
			String[] order = new String[11];
			for (int i=0; i<rList.size() ; i++) {
				rider = rList.get(i).split(",");
				for (int j=0 ; j<oList.size(); j++) {
					order = oList.get(j).split(",");
					if(order[3].equals(rider[0])){
						if(order[5].equals("배달완료")) {
							count++;
						}else {
							
						}
					}
				}
				countList.add(count);
				count = 0;
			}
			
			
			for (int i=0; i<rList.size() ; i++) {
				rider = rList.get(i).split(",");
				for (int j=0 ; j<oList.size(); j++) {
					order = oList.get(j).split(",");
					if(order[3].equals(rider[0])){
						dataList1.add(rider[3]+","+rider[4]+","+rider[6]+","+rider[7]+","+rider[8]+","+rider[9]+","+rider[10]);
						break;
					}
				}
			}
			
			ArrayList<String> finalArrList = new ArrayList<String>();
			
			String[] dtemp = new String[7];
			for (int i=0 ; i<dataList1.size() ; i++) {
				
				dtemp = dataList1.get(i).split(",");
				
				finalArrList.add(dtemp[0]+","+dtemp[1]+","+dtemp[2]+","+dtemp[3]+","+dtemp[4]+","+dtemp[5]+","+countList.get(i)+","+dtemp[6]);
				
			}
			
			String[] fntemp = new String[8];
			for (int i=0 ; i<finalArrList.size() ; i++) {
				
				fntemp = finalArrList.get(i).split(",");
				
				ManagingRiderVO mr = new ManagingRiderVO();
				mr.setRiderName(fntemp[0]);
				mr.setRiderAge(fntemp[1]);
				mr.setRiderPhone(fntemp[2]);
				mr.setRiderAddr1(fntemp[3]);
				mr.setRiderAddr2(fntemp[4]);
				mr.setRiderWorkingArea(fntemp[5]);
				mr.setRiderDeliveredCount(fntemp[6]);
				mr.setRiderAvgPoint(fntemp[7]);
				
				mrArrList.add(mr);
				
			}
			
			System.out.println("========================================");
			System.out.println("            라이더 목록 조회            ");
			System.out.println("========================================");
			
			System.out.printf("[No.]\t[이름]\t[나이]\t[전화번호]\t\t[주소]\t\t\t\t\t\t[활동지역]\t\t\t[배달건수][평점]\n");
			
			
			int num = 1;
			
			for(ManagingRiderVO mr : mrArrList) {
				
				System.out.printf("%d\t%s\t%s\t%s\t%s, %-11s\t\t%10s\t\t%s\t%s\n",
						num,
						mr.getRiderName(),
						mr.getRiderAge(),
						mr.getRiderPhone(),
						mr.getRiderAddr1(),
						mr.getRiderAddr2(),
						mr.getRiderWorkingArea(),
						mr.getRiderDeliveredCount(),
						mr.getRiderAvgPoint());
				num++;
			}
			num = 1;
			
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			
			boolean flag = true;
			
			
			System.out.println("1. 이름 내림차순 정렬");
			System.out.println("2. 배달건수 내림차순 정렬");
			System.out.println("3. 평점 내림차순 정렬");
			System.out.println("0. 이전 화면");
			System.out.print("번호 입력 : ");
			String sel = reader.readLine();
			
			
			while(flag) {

				if (sel.equals("1")) {
					flag = false;
					sortByName(mrArrList);
					
				} else if(sel.equals("2")) {
					flag = false;
					sortByRiderDeliveredCount(mrArrList);
					
				} else if(sel.equals("3")) {
					flag = false;
					sortByAvgPoint(mrArrList);
					
				} else if(sel.equals("0")) {
					flag = false;
					ManagerMainMenu.managerMainMenuIntro();

				} else {
					flag = true;
					System.out.println("잘못 입력 하셨습니다. 다시 입력하세요.");
					System.out.println("1. 이름 내림차순 정렬");
					System.out.println("2. 배달건수 내림차순 정렬");
					System.out.println("3. 평점 내림차순 정렬");
					System.out.println("0. 이전 화면");
					System.out.print("번호 입력 : ");
					sel = reader.readLine();
				}
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	
	
	
	
	
	public static void sortByAvgPoint(ArrayList<ManagingRiderVO> mrArrList) {
		try {
			Collections.sort(mrArrList, new Comparator<ManagingRiderVO>() {
	
				@Override
				public int compare(ManagingRiderVO o1, ManagingRiderVO o2) {
					
					return o2.getRiderAvgPoint().compareTo(o1.getRiderAvgPoint());
				}
			});
			
			System.out.println("========================================");
			System.out.println("          평점 내림차순 정렬           ");
			System.out.println("========================================");
			System.out.printf("[No.]\t[이름]\t[나이]\t[전화번호]\t\t[주소]\t\t\t\t\t\t[활동지역]\t\t[배달건수][평점]\n");
			
			int num = 1;
			
			for(ManagingRiderVO mr : mrArrList) {
				
				System.out.printf("%d\t%s\t%s\t%s\t%s\t%s\t%s\t%s\t%s\n",
						num,
						mr.getRiderName(),
						mr.getRiderAge(),
						mr.getRiderPhone(),
						mr.getRiderAddr1(),
						mr.getRiderAddr2(),
						mr.getRiderWorkingArea(),
						mr.getRiderDeliveredCount(),
						mr.getRiderAvgPoint());
				num++;
			}
			num = 1;
			
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			
			boolean flag = true;
			
			
			System.out.println("0. 이전 화면");
			System.out.print("번호 입력 : ");
			String sel = reader.readLine();
			
			
			while(flag) {
	
				if (sel.equals("0")) {
					flag = false;
					managingRiderIntro();
					
				} else {
					flag = true;
					System.out.println("0. 이전 화면");
					System.out.print("번호 입력 : ");
					sel = reader.readLine();
				}
				
			}
		
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	public static void sortByRiderDeliveredCount(ArrayList<ManagingRiderVO> mrArrList) {
		try {
			Collections.sort(mrArrList, new Comparator<ManagingRiderVO>() {
	
				@Override
				public int compare(ManagingRiderVO o1, ManagingRiderVO o2) {
					return o2.getRiderDeliveredCount().compareTo(o1.getRiderDeliveredCount());
				}
			});
			
			System.out.println("========================================");
			System.out.println("         배달건수 내림차순 정렬         ");
			System.out.println("========================================");
			System.out.printf("[No.]\t[이름]\t[나이]\t[전화번호]\t\t[주소]\t\t\t\t\t\t[활동지역]\t\t[배달건수][평점]\n");
			
			int num = 1;
			
			for(ManagingRiderVO mr : mrArrList) {
				
				System.out.printf("%d\t%s\t%s\t%s\t%s\t%s\t%s\t%s\t%s\n",
						num,
						mr.getRiderName(),
						mr.getRiderAge(),
						mr.getRiderPhone(),
						mr.getRiderAddr1(),
						mr.getRiderAddr2(),
						mr.getRiderWorkingArea(),
						mr.getRiderDeliveredCount(),
						mr.getRiderAvgPoint());
				num++;
			}
			num = 1;
			
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			
			boolean flag = true;
			
			
			System.out.println("0. 이전 화면");
			System.out.print("번호 입력 : ");
			String sel = reader.readLine();
			
			
			while(flag) {
	
				if (sel.equals("0")) {
					flag = false;
					managingRiderIntro();
					
				} else {
					flag = true;
					System.out.println("0. 이전 화면");
					System.out.print("번호 입력 : ");
					sel = reader.readLine();
				}
				
			}
		
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	public static void sortByName(ArrayList<ManagingRiderVO> mrArrList) {
		try {
			Collections.sort(mrArrList, new Comparator<ManagingRiderVO>() {
	
				@Override
				public int compare(ManagingRiderVO o1, ManagingRiderVO o2) {
					return o2.getRiderName().compareTo(o1.getRiderName());
				}
			});
			
			System.out.println("****** 이름 내림차순 정렬******");
			System.out.printf("[No.]\t[이름]\t[나이]\t[전화번호]\t\t[주소]\t\t\t\t\t\t[활동지역]\t\t[배달건수][평점]\n");
			
			int num = 1;
			
			for(ManagingRiderVO mr : mrArrList) {
				
				System.out.printf("%d\t%s\t%s\t%s\t%s\t%s\t%s\t%s\t%s\n",
						num,
						mr.getRiderName(),
						mr.getRiderAge(),
						mr.getRiderPhone(),
						mr.getRiderAddr1(),
						mr.getRiderAddr2(),
						mr.getRiderWorkingArea(),
						mr.getRiderDeliveredCount(),
						mr.getRiderAvgPoint());
				num++;
			}
			num = 1;
			
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			
			boolean flag = true;
			
			
			System.out.println("0. 이전 화면");
			System.out.print("번호 입력 : ");
			String sel = reader.readLine();
			
			
			while(flag) {
	
				if (sel.equals("0")) {
					flag = false;
					managingRiderIntro();
					
				} else {
					flag = true;
					System.out.println("0. 이전 화면");
					System.out.print("번호 입력 : ");
					sel = reader.readLine();
				}
				
			}
		
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	public ManagingRider() {
		
	}
}
