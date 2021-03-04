package com.test.ddd.rider;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

import com.test.ddd.fileroad.FileRoad;
import com.test.ddd.fileroad.TotalRoad;
import com.test.ddd.manager.Manager;

public class RiderDeliveryChoice {
	//rList : 라이더 정보 // oList : 진행중인 주문 정보 (todayOrder) // sList : 스토어 정보
	
	static File oFile = new File(FileRoad.TODAYORDERFINISH);
	static ArrayList<RiderDeliveryChoiceVO> rdArrList = new ArrayList<RiderDeliveryChoiceVO>();
	
	

	public static void main(String[] args) {
		riderDeliveryChoiceIntro("r_sist0000");
	}

	public static void riderDeliveryChoiceIntro(String id) {
		
		ArrayList<String> oList = new ArrayList<String>();
		ArrayList<String> sList = TotalRoad.dataRoad("s");
		ArrayList<String> tofList = new ArrayList<String>();
		ArrayList<String> finalList = new ArrayList<String>();
		File tofFile = new File(FileRoad.TODAYORDERFINAL);
		
		ArrayList<String> myList = new ArrayList<String>();
		ArrayList<String> o1List = new ArrayList<String>();
		ArrayList<String> s1List = new ArrayList<String>();
		
		
		File tFile = new File(FileRoad.TODAYORDER);
		ArrayList<String> testList = new ArrayList<String>();
		
		
		
		//oList에 todayOrder 담기
		try {
			
			String key = "";
			
			ArrayList<String> riFList = TotalRoad.dataRoad("r");
			
			String[] temp12 = new String[13];
			for(int i=0 ; i<riFList.size(); i++) {
				temp12 = riFList.get(i).split(",");
				if(id.equals(temp12[1])) {
					key = temp12[0];
				}
				
			}
			
			
			
			
			BufferedReader fReader = new BufferedReader(new FileReader(oFile));
			
			String temp1 = "";
			while ((temp1 = fReader.readLine())!=null) {
				oList.add(temp1);
			}
			
			fReader.close();
			
			temp1 = "";
			fReader = new BufferedReader(new FileReader(tofFile));
			while ((temp1 = fReader.readLine())!=null) {
				tofList.add(temp1);
			}
			fReader.close();

			
			
			String[] rr = new String[11];
			boolean tt = false;
			for(int i=0 ; i<oList.size() ; i++) {
				rr = oList.get(i).split(",");
				if(rr[3].equals(key)&&rr[6].equals("배달대기")) {
					tt = true;
				} 
				
			}
			
			
			if(tt==true) {
			
				/*0 O1501,
				 *1 C269,
				 *2 S079,//
				 *3 R145,//
				 *4 서울특별시 강남구 역삼동 도곡로17길 24-1,//
				 *5 101호,//
				 *6 배달중,//
				 *7 맛잇게 해주세요. 감사합니다~,//
				 *8 2020-11-21,
				 *9 500,
				 *10 2000
				 *
				 *
				 *O1650,
				 *더블블고기버거,//
				 *6000,
				 *2,//
				 *12000,
				 *20000//
				 */
				//myList에 업체번호, 라이더번호, 고객주소1, 고객주소2, 고객요청사항, 주문상품, 갯수, 주문 총액 ////저장
				String[] a = new String[11];
				String[] b = new String[6];
				
				
				
				for(int i=0; i<oList.size() ; i++) {
					a = oList.get(i).split(",");
					for (int j=0; j<tofList.size() ; j++) {
						b = tofList.get(j).split(",");
						if(a[3].equals(key)&&a[6].equals("배달대기")&&a[0].equals(b[0])) {
							myList.add(a[2]+","+a[3]+","+a[4]+","+a[5]+","+a[7]+","+b[1]+","+b[3]+","+b[5]);
							
						}
						
					}
				}
				
				
				
				for(int i=0; i<myList.size() ; i++) {
					String[] c = myList.get(i).split(",");
					for (int j=0; j<sList.size() ; j++) {
						String[] d = sList.get(j).split(",");
						if(c[0].equals(d[0])) {
							s1List.add(d[9]);
						}
					}
				}
				
				//finalList에 합치기
				for(int i=0; i<s1List.size() ; i++) {
					finalList.add(myList.get(i)+","+s1List.get(i));
				}
				
				
				//객체에 정보넣기..
				for(int i=0 ; i<finalList.size() ; i++) {
					String[] e = finalList.get(i).split(",");
					RiderDeliveryChoiceVO r = new RiderDeliveryChoiceVO();
					r.setStoreName(e[8]);
					r.setSelectedMenus(e[5]);
					r.setMenuCount(Integer.parseInt(e[6]));
					r.setPaymentMethod("카드(선결제)");
					r.setPayTotal(e[7]);
					r.setCustomerRequest(e[4]);
					r.setCustomerAddr1(e[2]);
					r.setCustomerAddr2(e[3]);
					
					rdArrList.add(r);
				}
				
				
				System.out.println("=========================");
				System.out.println("  라이더 - 배달하기");
				System.out.println("=========================");
				System.out.print("[업체명] : ");
				System.out.printf("%s\n",rdArrList.get(0).getStoreName());
				System.out.print("[메뉴]\t\t[결제수단]\t[결제총액]\t[요청사항]\n");
				
				
				int printCheck = 0;
				for (RiderDeliveryChoiceVO r:rdArrList) {
					
					if(rdArrList.get(0).getStoreName().equals(r.getStoreName())) {
						
						System.out.printf("%s %d개\t%s\t%s\t%s\n",
								r.getSelectedMenus(),
								r.getMenuCount(),
								r.getPaymentMethod(),
								r.getPayTotal(),
								r.getCustomerRequest()
								);
						printCheck++;
					}
				}
				
				
				
				System.out.println("1. 배달 받기");
				System.out.println("2. 배달 넘기기");
				System.out.println("0. 뒤로가기");
				System.out.print("번호 입력 : ");
				
				BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
				String sel = reader.readLine();
				
				boolean flag = true;
				
				while (flag) {
					if(sel.equals("1")) {
						flag = false;
						riderAccept(rdArrList,key); //rider을 id로 바꾼다
						
					} else if(sel.equals("2")) {
						flag = false;
						riderChange(key);
						
					} else if(sel.equals("0")) {
						flag = false;
						//////////////////////////////////////////////////////////////
						//뒤로가기 ********* 이건 통로 엮어주셔야해요 .. 어디랑 연결되는지는 몰라서..
						//////////////////////////////////////////////////////////////
					
						System.out.println("기본 메뉴로 돌아갑니다.");
						RiderMenu rm = new RiderMenu();
						rm.riderMenu(id);
						break;
					
					} else {
						flag = true;
						System.out.println("잘못 입력하셨습니다. 다시 입력하세요.");
						System.out.println("1. 배달 받기");
						System.out.println("2. 배달 넘기기");
						System.out.println("0. 뒤로가기");
						System.out.print("번호 입력 : ");
						sel = reader.readLine();
					}
					
				}
				
			} else {
				System.out.println();
				System.out.printf("라이더에게 들어온 배달이 없습니다.");
				//Manager.managerLoginIntro();// 여기를 바꿔야해요.
				////////// 유효성 검사 통과 못할시 돌아갈 곳이에요
				
				System.out.println("들어온 배달 건이 없어 기본 메뉴로 돌아갑니다.");
				System.out.println();
				RiderMenu rm = new RiderMenu();
				rm.riderMenu(id);
	
			}
			} catch (Exception e) {
				e.printStackTrace();
			}
			
				
			
			
			
	}

	
	
	
	private static void riderChange(String id) {
		
		try {
			//배달 대기중인 라이더 찾기
			ArrayList<String> wList = new ArrayList<String>();
			ArrayList<String> oList = new ArrayList<String>();
			File tFile = new File(FileRoad.TODAYORDER);
			BufferedReader fReader = new BufferedReader(new FileReader(tFile));
			String temp = "";
			
			while((temp=fReader.readLine())!=null) {
				oList.add(temp);
			}
			
			
			String anotherRider = "";
			String[]temp2 = new String[11];
			for (int i=0 ; i<oList.size(); i++) {
				temp2 = oList.get(i).split(",");
				if(!temp2[3].equals(id)&&temp2[6].equals("배달대기")) {
					anotherRider = temp2[3];
				}
			}
			
			
			int count=0;
			for (int i=0 ; i<oList.size(); i++) {
				String[]temp1 = oList.get(i).split(",");
				
				if(temp1[3].equals(id)&&temp1[6].equals("배달대기")&&count==0){			
					wList.add(temp1[0]+","+temp1[1]+","+temp1[2]+","+anotherRider+","+temp1[4]+","+temp1[5]+","+"배달대기"+","+temp1[7]+","+temp1[8]+","+temp1[9]+","+temp1[10]);
					count++;
			
				}else {
					wList.add(oList.get(i));
					
				}
			}
			BufferedWriter writer = new BufferedWriter(new FileWriter(tFile));
			for (int i=0; i<wList.size() ; i++) {
					writer.write(String.format("%s\n", wList.get(i)));
				
			}
			
			writer.close();
			rdArrList.clear();
			oList.clear();
		} catch (Exception e) {
			e.printStackTrace();
		}
		//돌아가기..
		riderDeliveryChoiceIntro(id);
		
		
	}

	private static void riderAccept(ArrayList<RiderDeliveryChoiceVO> rdArrList, String id) {
		//todayorder 재작성.
		try {
			File tFile = new File(FileRoad.TODAYORDER);
			ArrayList<String> wList = new ArrayList<String>();
			ArrayList<String> oList = new ArrayList<String>();
			BufferedReader fReader = new BufferedReader(new FileReader(tFile));
			
			String temp1 = "";
			while ((temp1 = fReader.readLine())!=null) {
				oList.add(temp1);
			}
			fReader.close();
			int count = 0;
			String[] temp = new String[11];
			for (int i=0 ; i<oList.size(); i++) {
				temp = oList.get(i).split(",");
				if(temp[3].equals(id)&&temp[6].equals("배달대기")&&count==0){
					
					wList.add(temp[0]+","+temp[1]+","+temp[2]+","+temp[3]+","+temp[4]+","+temp[5]+","+"배달중"+","+temp[7]+","+temp[8]+","+temp[9]+","+temp[10]);
					count++;
				}else {
					wList.add(oList.get(i));
					
				}
			}
			BufferedWriter writer = new BufferedWriter(new FileWriter(tFile));
			for (int i=0; i<wList.size() ; i++) {
				writer.write(String.format("%s\n", wList.get(i)));
				
			}
			
			writer.close();
			
			System.out.println("배달이 수락 되었습니다!");
			
			System.out.println();
			System.out.println("=========================");
			System.out.print("[업체명] : ");
			System.out.printf("%s\n",rdArrList.get(0).getStoreName());
			System.out.print("[메뉴]\t\t[결제수단]\t[결제총액]\t[요청사항]\n");
			for (RiderDeliveryChoiceVO r:rdArrList) {
				if(rdArrList.get(0).getStoreName().equals(r.getStoreName())) {
					System.out.printf("%s %d개\t%s\t%s\t%s\n",
							r.getSelectedMenus(),
							r.getMenuCount(),
							r.getPaymentMethod(),
							r.getPayTotal(),
							r.getCustomerRequest()
							);
					
				}
					
			}
			
			
			System.out.println("1. 배달 완료 (배달 완료시 \"1\" 입력)");
			System.out.print("번호 입력 : ");
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			String sel = reader.readLine();
			
			boolean flag = true;
			
			while (flag) {
				if(sel.equals("1")) {
					flag = false;
					rdArrList.clear();
				} else {
					flag = true;
					System.out.println("잘못 입력하셨습니다. 다시 입력하세요.");
					System.out.println("1. 배달 완료");
					System.out.print("번호 입력 : ");
					sel = reader.readLine();
				}
				
			}
			wList.clear();
			oList.clear();
			File yFile = new File(FileRoad.TODAYORDER);
			// 라이더가 "1.배달완료" 입력 시 배달완료로 문구 바꿔서 재작성
			
			fReader = new BufferedReader(new FileReader(yFile));
			
			temp1 = "";
			while ((temp1 = fReader.readLine())!=null) {
				oList.add(temp1);
			}
			fReader.close();
			
			count = 0;
		String[] temp5 = new String[12];
			for (int i=0 ; i<oList.size(); i++) {
				temp5 = oList.get(i).split(",");
				if(temp5[3].equals(id)&&temp5[6].equals("배달중")&&count==0){
					wList.add(temp5[0]+","+temp5[1]+","+temp5[2]+","+temp5[3]+","+temp5[4]+","+temp5[5]+","+"배달완료"+","+temp5[7]+","+temp5[8]+","+temp5[9]+","+temp5[10]);
					count++;
				}else {
					wList.add(oList.get(i));
					
				}
			}
		
		
			writer = new BufferedWriter(new FileWriter(oFile));
			for (int i=0; i<wList.size() ; i++) {
				writer.write(String.format("%s\n", wList.get(i)));
				
			}
			
			writer.close();
			System.out.println("***********");
			System.out.println(" 배달완료! ");
			System.out.println("***********");
			
			reader = new BufferedReader(new InputStreamReader(System.in));
			System.out.println("0. 뒤로가기");
			System.out.print("번호 입력 : ");
			sel = reader.readLine();
			
			
			flag = true;
			
			while (flag) {
				if(sel.equals("0")) {
					flag = false;
					riderDeliveryChoiceIntro(id);
					
				} else {
					flag = true;
					System.out.println("잘못 입력하셨습니다. 다시 입력하세요.");
					System.out.println("0. 뒤로가기");
					System.out.print("번호 입력 : ");
					sel = reader.readLine();
				}
				
			}
			
			rdArrList.clear();
			
			
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
		

		
