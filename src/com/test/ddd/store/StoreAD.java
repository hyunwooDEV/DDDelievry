package com.test.ddd.store;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

import com.test.ddd.customer.ShowData;
import com.test.ddd.fileroad.FileRoad;
//import com.test.ddd.fileroad.FileRoad_yiqian;
//import com.test.ddd.store

public class StoreAD {

	public static void main(String[] args) throws Exception {
		
		//광고 관리(마이스토어)
		storeAd("s_sist0000");
//		adRegistration("s_sist0000");
//		adCheck("s_sist0000");
		
	}//main
	
	public static void storeAd(String id) throws Exception {
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		Store s = new Store("s_sist0000");
//		Store s = new Store(s.getStoreID());
		
		
			System.out.print("------------------------------\n");
			System.out.println("         [광고 관리]");
			System.out.print("------------------------------\n");
			
			System.out.print("1. 광고 서비스 상태 조회\n");
			System.out.print("2. 광고 서비스 신청 및 해지\n");
			System.out.print("0. 이전으로 이동\n"); //MyStore 페이지로 이동
			
			
//			System.out.println(s.getStoreID());
			
			boolean loop = true;
			while(loop) {
				System.out.println();
				System.out.print("            번호 입력 : ");
				String adButton = reader.readLine();
				System.out.println();

				
	
				if (adButton.equals("1") || adButton.equals("2") || adButton.equals("0")) {
					//1. 광고 서비스 상태 조회
					if (adButton.equals("1")) {
						adCheck(s.getStoreID()); //업체 아이디로 현재 광고 서비스 이용유무 출력
//						storeAd(id);
					}
					
					
					//2. 광고 서비스 신청 및 해지
					if (adButton.equals("2")) {
						adRegistration(s.getStoreID()); 
					}
					
					
					if (adButton.equals("0")) {
						MyStore ms = new MyStore();
						MyStore.mystoreMenu(s.getStoreID());
						loop = false;
					}
					
					
					loop = false;
					
				} else {
					System.out.println();
					System.out.println("※ 잘못 입력하셨습니다.\n광고 서비스 상태 조회는 1, 광고 서비스 신청 및 해지는 2, 이전화면으로 가기는 0을 입력해주세요.");
				}	
		
			}
		
		
		
		
		
		
	}
	
	
	
	
	
	public static void adRegistration(String id) throws IOException { //질문
		
		FileRoad f = new FileRoad();
		Store s = new Store("s_sist0000");
		
		//광고 서비스 상태 : temp[20]
		try {
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			BufferedReader storeFinalReader = new BufferedReader(new FileReader(f.STOREFINAL));
			
			System.out.print("광고 서비스를 신청하시겠습니까?\n(※신중하게 선택해주세요! 신청 및 해지는 한 달에 한 번만 가능합니다.)\n");
			System.out.print("1. 서비스 신청\n2. 서비스 해지\n");
			
			boolean loop = true;
			
			String line = null;
			String txt = "";
			
			
			while(loop) {
				System.out.println();
				System.out.print("            번호 입력 : ");
				String adNum = reader.readLine();
				
//				if (adNum.equals("1") || adNum.equals("2")) {
					
					//1. 광고 신청
					if (adNum.equals("1")) {
						while ((line = storeFinalReader.readLine()) != null) {
							String[] temp = line.split(",");
							if (!temp[1].equals(s.getStoreID())) {
//								System.out.println(line);								
								txt += line + "\n";
							} else {
								String temptxt = ""; //
								for (int i=0; i<temp.length; i++) { //한 라인의 길이만큼 반복
									if (i == 20) { //temp 20번째 방일때
										temptxt += "1,"; //temp[20]의 단어를 무조건 1로 바꿔서 temptxt에 누적.
									} else {
										if (i<temp.length-1) {
											temptxt += temp[i] + ","; //temp[20]이 아닌방은 그대로 불러와서 temptxt에 누적.
										} else {
											temptxt += temp[i]; //temp[20]이 아닌방은 그대로 불러와서 temptxt에 누적.
											
										}
									}
								}
								//replacement = line.replace(temp[20], "1"); //텍스트파일의 데이터가 통째로 지워진다.. 미리 원본파일(팀플01폴더에있음) 열어놓고 실행하기
								//txt += replacement + "\n";
								//위의 방법은 temp[20]에 속하는 데이터가 해당 라인에서 유일한 단어일때. 여기서는 '0'이나 '1'이 들어있어서 라인에 있는 모든 0(혹은 1)이 같이 바뀌어 적합하지 않다.
								txt += temptxt + "\n";
							}
						}
						loop=false;
					}
					

					//2. 광고 해지
					if (adNum.equals("2")) {
						while ((line = storeFinalReader.readLine()) != null) {
							String[] temp = line.split(",");
							if (!temp[1].equals(s.getStoreID())) {
//								System.out.println(line);								
								txt += line + "\n";
							} else {
								String temptxt = ""; //
								for (int i=0; i<temp.length; i++) { //한 라인의 길이만큼 반복
									if (i == 20) { //temp 20번째 방일때
										temptxt += "0,"; //temp[20]의 단어를 무조건 0으로 바꿔서 temptxt에 누적.
									} else {
										if (i<temp.length-1) {
											temptxt += temp[i] + ","; //temp[20]이 아닌방은 그대로 불러와서 temptxt에 누적.
										} else {
											temptxt += temp[i]; //temp[20]이 아닌방은 그대로 불러와서 temptxt에 누적.
											
										}
									}
								}
								
								txt += temptxt + "\n";
							
							}
						}
						
						loop=false;
					}
					
					reader.close();
					storeFinalReader.close();
					
					
					BufferedWriter writer = new BufferedWriter(new FileWriter(f.STOREFINAL)); //여기선 수정된거 바로 저장이라 덮어쓰기
					writer.write(txt);
					writer.close();
					System.out.println("※ 광고 사용 설정 변경이 완료되었습니다.");
					System.out.println();
//					System.out.println(s.getAd());
					System.out.printf("변경된 광고 사용 여부 : %s", s.getAd().equals("0") ? "사용안함" : "사용중");
					System.out.println();
					loop = false;
					
				} 
//			else {
//					System.out.println();
//					System.out.println("※ 잘못 입력하셨습니다.\n광고 서비스 신청은 1, 서비스 해지는 2를 입력해주세요.");
//				}	
				
			
			
//			writer.close();
//			storeFinalReader.close();
		} catch (IOException e) {
			System.out.println("error.storeAD.adRegistration");
			e.printStackTrace();
		}
		
		
		
	}
	
	
	public static void adCheck(String id) throws IOException {
		
		
		FileRoad f = new FileRoad();
		Store s = new Store("s_sist0000");
		
		try {
			BufferedReader storeFinalReader = new BufferedReader(new FileReader(f.STOREFINAL));
			
			String line = null;

			while ((line = storeFinalReader.readLine()) != null) {

				String[] temp = line.split(",");
				
				if (temp[1].equals(s.getStoreID())) {
					if (temp[20].equals("1")) {
						System.out.println("현재 광고 서비스를 이용중입니다.");
					} else if (temp[20].equals("0")) {
						System.out.println("현재 광고 서비스를 이용하고 있지 않습니다.");
						
					}
					
				}

			}
			
			storeFinalReader.close();
			
		} catch (FileNotFoundException e) {
			System.out.println("error.storeAD.adCheck");
			e.printStackTrace();
		}
		
	
	}
	
	
	
	
	
	
	
	
	
}
