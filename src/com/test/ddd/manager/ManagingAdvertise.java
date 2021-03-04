package com.test.ddd.manager;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;

import com.test.ddd.fileroad.FileRoad;
import com.test.ddd.fileroad.TotalRoad;

public class ManagingAdvertise {
	
	public static void main(String[] args) {
		managingAdvertiseIntro();
	}
	
	
	
	
	public static void managingAdvertiseIntro() {
		System.out.println("========================================");
		System.out.println("              광고 관리                ");
		System.out.println("========================================");
		
		ArrayList<ManagingAdvertiseVO> maArrList = new ArrayList<ManagingAdvertiseVO>();
		
		File oFile = new File(FileRoad.FINISHORDER);
		ArrayList<String> sArrList = TotalRoad.dataRoad("s");
		ArrayList<String> oArrList = new ArrayList<String>(); 
		ArrayList<String> dataList1 = new ArrayList<String>(); 
		ArrayList<String> finalList = new ArrayList<String>(); 
		
		ArrayList<Integer> countList = new ArrayList<Integer>();
//		ArrayList<Integer> TopcountList = new ArrayList<Integer>();
		
		try {
				BufferedReader fReader = new BufferedReader(new FileReader(oFile));
				String aa = "";
				while((aa=fReader.readLine())!=null) {
					oArrList.add(aa);
				}
			
				fReader.close();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		
		
		
		
		String[] stemp = new String[24];
		String[] otemp = new String[11];
		int count = 0;
		//[업체명]\t[업체번호]\t[주소]\t[리뷰점수]t[위생등급]\t[수수료등급]\t[주문수]\n");
		for(int i=0 ; i<sArrList.size() ; i++) {
			
			stemp = sArrList.get(i).split(",");
			dataList1.add(stemp[9]+","+stemp[0]+","+stemp[13]+","+stemp[22]+","+stemp[16]+","+stemp[19]);
			
			for(int j=0 ; j<oArrList.size() ; j++) {
			
				otemp = oArrList.get(j).split(",");
				
				if (stemp[0].equals(otemp[2])) {
					count++;
				}
			
			}
			countList.add(count);
//			TopcountList.add(count);
			count = 0;
		}
//		//storeTopOrderedCount 뽑기
//		int storeTopOrderedCount = 0;
//		Collections.sort(TopcountList, new Comparator<Integer>() {
//
//			@Override
//			public int compare(Integer o1, Integer o2) {
//				if(o1 > o2) {
//					return -1;
//				} else if (o1 < o2) {
//					return 1;
//				}
//				return 0;
//			}
//			
//		});
//		
//		System.out.println(TopcountList.get(0));
//		storeTopOrderedCount = TopcountList.get(0);
		
		//광고만료일
		//현재 시각
		Date today = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat ("YYYYMMdd");
		
		String date = formatter.format(today);

		
		for(int i=0 ; i<dataList1.size() ; i++) {
			String[] ftemp = dataList1.get(i).split(",");
			int gtemp = countList.get(i);
			finalList.add(ftemp[0]+","+ftemp[1]+","+ftemp[2]+","+ftemp[3]+","+gtemp+","+ftemp[4]+","+ftemp[5]+","+date);
		}
		
		
		
		for(int i=0; i<finalList.size() ; i++) {
			String htemp[] = finalList.get(i).split(",");
			
			ManagingAdvertiseVO ma = new ManagingAdvertiseVO();
			ma.setStoreName(htemp[0]);
			ma.setStoreNumber(htemp[1]);
			ma.setStoreLocation(htemp[2]);
			ma.setStoreAvgPoint(htemp[3]);
			ma.setStoreOrderedCount(htemp[4]);
			ma.setStoreCleanLevel(htemp[5]);
			ma.setStoreFeesLevel(htemp[6]);
			ma.setStoreAdsEnd(htemp[7]);
			
			maArrList.add(ma);
		}
		
		
		//[업체명]\t[업체번호]\t[주소]\t[리뷰점수]t[위생등급]\t[수수료등급]\t[주문수]\n");
		
		
		
		System.out.println("1.업체명 내림차순 정렬");
		System.out.println("2.등급별 내림차순 정렬");
		System.out.println("3.평점별 내림차순 정렬");
		System.out.println("4.지역별 내림차순 정렬");
		System.out.println("0.이전 화면");
		System.out.print("번호 입력 : ");
		
		try {
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			String sel = reader.readLine();
			boolean flag = true;
			while(flag)
			if(sel.equals("1")) {
				flag = false;
				sortByName(maArrList);
			}else if(sel.equals("2")) {
				flag = false;
				sortByLevel(maArrList);
			}else if(sel.equals("3")) {
				flag = false;
				sortByPoint(maArrList);
			}else if(sel.equals("4")) {
				flag = false;
				sortByLocation(maArrList);
				
			}else if(sel.equals("0")) {
				flag = false;
				ManagerMainMenu.managerMainMenuIntro();
			}else {
				flag = true;
				System.out.println("잘못된 입력입니다. 다시 입력하세요.");
				System.out.println("1.업체명 내림차순 정렬");
				System.out.println("2.등급별 내림차순 정렬");
				System.out.println("3.평점별 내림차순 정렬");
				System.out.println("4.지역별 내림차순 정렬");
				System.out.println("0.이전 화면");
				System.out.print("번호 입력 : ");
				sel = reader.readLine();
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	
		
		
	}
	

	public static void sortByName(ArrayList<ManagingAdvertiseVO> maArrList) {
		System.out.println("========================================");
		System.out.println("         업체명 내림차순 정렬           ");
		System.out.println("========================================");
		System.out.printf("[No.]\t[업체명]\t\t\t\t[업체번호]\t\t[주소]\t\t\t\t\t\t[평점]\t[주문수]\t[위생등급]\t[수수료등급]\t[광고만료일]\n");
		Collections.sort(maArrList, new Comparator<ManagingAdvertiseVO>() {

			@Override
			public int compare(ManagingAdvertiseVO o1, ManagingAdvertiseVO o2) {
				
				return o2.getStoreName().compareTo(o1.getStoreName());
			}
		});
		
		int num = 1;
		for(ManagingAdvertiseVO ma : maArrList) {
			System.out.printf("%4d\t%-18s\t\t%-8s\t\t%-15s\t%s\t\t%s\t\t%s\t%s\t\t%s\n",
					num,
					ma.getStoreName(),
					ma.getStoreNumber(),
					ma.getStoreLocation(),
					ma.getStoreAvgPoint(),
					ma.getStoreOrderedCount(),
					ma.getStoreCleanLevel(),
					ma.getStoreFeesLevel(),
					ma.getStoreAdsEnd()
					);
			num++;
		}
		num = 1;
		
		System.out.println("0.이전 화면");
		System.out.print("번호 입력 : ");
		try {
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			String sel = reader.readLine();
			boolean flag = true;
			
			while(flag) {
				if(sel.equals("0")) {
					flag = false;
					managingAdvertiseIntro();
				} else {
					flag = true;
					System.out.println("잘못된 입력입니다. 다시 입력하세요.");
					System.out.println("0.이전 화면");
					System.out.print("번호 입력 : ");
					sel = reader.readLine();
					
				}
				
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
	}




	public static void sortByLevel(ArrayList<ManagingAdvertiseVO> maArrList) {
		System.out.println("========================================");
		System.out.println("         등급별 내림차순 정렬           ");
		System.out.println("========================================");	
		System.out.printf("[No.]\t[업체명]\t\t\t\t[업체번호]\t\t[주소]\t\t\t\t\t\t[평점]\t[주문수]\t[위생등급]\t[수수료등급]\t[광고만료일]\n");
		Collections.sort(maArrList, new Comparator<ManagingAdvertiseVO>() {

			@Override
			public int compare(ManagingAdvertiseVO o1, ManagingAdvertiseVO o2) {

				return o2.getStoreFeesLevel().compareTo(o1.getStoreFeesLevel());
			}
		});
		
		int num = 1;
		for(ManagingAdvertiseVO ma : maArrList) {
			System.out.printf("%4d\t%-18s\t\t%-8s\t\t%-15s\t%s\t\t%s\t\t%s\t%s\t\t%s\n",
					num,
					ma.getStoreName(),
					ma.getStoreNumber(),
					ma.getStoreLocation(),
					ma.getStoreAvgPoint(),
					ma.getStoreOrderedCount(),
					ma.getStoreCleanLevel(),
					ma.getStoreFeesLevel(),
					ma.getStoreAdsEnd()
					);
			num++;
		}
		num = 1;
		
		System.out.println("0.이전 화면");
		System.out.print("번호 입력 : ");
		try {
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			String sel = reader.readLine();
			boolean flag = true;
			
			while(flag) {
				if(sel.equals("0")) {
					flag = false;
					managingAdvertiseIntro();
				} else {
					flag = true;
					System.out.println("잘못된 입력입니다. 다시 입력하세요.");
					System.out.println("0.이전 화면");
					System.out.print("번호 입력 : ");
					sel = reader.readLine();
					
				}
				
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}




	public static void sortByPoint(ArrayList<ManagingAdvertiseVO> maArrList) {
		System.out.println("========================================");
		System.out.println("         평점별 내림차순 정렬           ");
		System.out.println("========================================");
		System.out.printf("[No.]\t[업체명]\t\t\t\t[업체번호]\t\t[주소]\t\t\t\t\t\t[평점]\t[주문수]\t[위생등급]\t[수수료등급]\t[광고만료일]\n");
		Collections.sort(maArrList, new Comparator<ManagingAdvertiseVO>() {

			@Override
			public int compare(ManagingAdvertiseVO o1, ManagingAdvertiseVO o2) {
				
				return o2.getStoreAvgPoint().compareTo(o1.getStoreAvgPoint());
			}
		});
		

		int num = 1;
		for(ManagingAdvertiseVO ma : maArrList) {
			System.out.printf("%4d\t%-18s\t\t%-8s\t\t%-15s\t%s\t\t%s\t\t%s\t%s\t\t%s\n",
					num,
					ma.getStoreName(),
					ma.getStoreNumber(),
					ma.getStoreLocation(),
					ma.getStoreAvgPoint(),
					ma.getStoreOrderedCount(),
					ma.getStoreCleanLevel(),
					ma.getStoreFeesLevel(),
					ma.getStoreAdsEnd()
					);
			num++;
		}
		num = 1;
		
		System.out.println("0.이전 화면");
		System.out.print("번호 입력 : ");
		try {
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			String sel = reader.readLine();
			boolean flag = true;
			
			while(flag) {
				if(sel.equals("0")) {
					flag = false;
					managingAdvertiseIntro();
				} else {
					flag = true;
					System.out.println("잘못된 입력입니다. 다시 입력하세요.");
					System.out.println("0.이전 화면");
					System.out.print("번호 입력 : ");
					sel = reader.readLine();
					
				}
				
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}




	public static void sortByLocation(ArrayList<ManagingAdvertiseVO> maArrList) {
		System.out.println("========================================");
		System.out.println("         지역별 내림차순 정렬           ");
		System.out.println("========================================");
		System.out.printf("[No.]\t[업체명]\t\t\t\t[업체번호]\t\t[주소]\t\t\t\t\t\t[평점]\t[주문수]\t[위생등급]\t[수수료등급]\t[광고만료일]\n");
		Collections.sort(maArrList, new Comparator<ManagingAdvertiseVO>() {

			@Override
			public int compare(ManagingAdvertiseVO o1, ManagingAdvertiseVO o2) {
				return o2.getStoreLocation().compareTo(o1.getStoreLocation()) ;
			}
		});
		

		int num = 1;
		for(ManagingAdvertiseVO ma : maArrList) {
			System.out.printf("%4d\t%-18s\t\t%-8s\t\t%-15s\t%s\t\t%s\t\t%s\t%s\t\t%s\n",
					num,
					ma.getStoreName(),
					ma.getStoreNumber(),
					ma.getStoreLocation(),
					ma.getStoreAvgPoint(),
					ma.getStoreOrderedCount(),
					ma.getStoreCleanLevel(),
					ma.getStoreFeesLevel(),
					ma.getStoreAdsEnd()
					);
			num++;
		}
		num = 1;
		
		System.out.println("0.이전 화면");
		System.out.print("번호 입력 : ");
		try {
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			String sel = reader.readLine();
			boolean flag = true;
			
			while(flag) {
				if(sel.equals("0")) {
					flag = false;
					managingAdvertiseIntro();
				} else {
					flag = true;
					System.out.println("잘못된 입력입니다. 다시 입력하세요.");
					System.out.println("0.이전 화면");
					System.out.print("번호 입력 : ");
					sel = reader.readLine();
					
				}
				
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}




	public ManagingAdvertise() {
		
	}
}
