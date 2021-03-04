package com.test.ddd.store;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

import com.test.ddd.fileroad.FileRoad;
//import com.test.ddd.fileroad.FileRoad_yiqian;


public class StoreMenu {
	
	//스토어 메뉴 관리( 등록 / 수정 / 삭제 )

	public static void main(String[] args) throws Exception {
		
		//storeMenu("s_sist0000");
	}//main
	
	
	public static void storeMenu(String id) throws Exception {
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		//메뉴 관리(마이스토어)
		
		Store s = new Store(id);
		
		
			
			
			System.out.print("------------------------------\n");
			System.out.println("       [메뉴 관리]");
			System.out.print("------------------------------\n");
			
			System.out.print("1. 메뉴 조회\n");
			System.out.print("2. 메뉴 추가\n");
			System.out.print("3. 메뉴 삭제\n");
			System.out.print("0. 이전으로 이동\n"); //MyStore 페이지로 이동
			
			boolean loop = true;
			while(loop) {
				System.out.println();
				System.out.print("            번호 입력 : ");
				String menuButton = reader.readLine();
	
				if (menuButton.equals("1") || menuButton.equals("2") || menuButton.equals("3") || menuButton.equals("0")) {
					//1. 메뉴 조회
					if (menuButton.equals("1")) {
						
						menuCheck(s.getStoreID()); //예시
						
					}
					
					
					//2. 메뉴 추가
					if (menuButton.equals("2")) {
					
						menuAdd(s.getStoreID()); //바로 추가되니까 더미파일 확인 잘 해주세요! 원본으로 쓰려면 추가된 거 삭제하셔야 하니까요~~
		
					}
					
					
					//3. 메뉴 삭제 (업체 번호랑 메뉴를 같이 검색해서 삭제할 수 있게)
					if (menuButton.equals("3")) {
						
						menuDelete(s.getStoreID()); //마찬가지로 더미파일에서 삭제되니까 원본파일 잘 확인하고 갖고계셔야 할거에요!
		
					}
					
					
					if (menuButton.equals("0")) {
						MyStore ms = new MyStore();
						MyStore.mystoreMenu(s.getStoreID());
						loop = false;
					}
					
					
					loop = false;
				
				} else {
					System.out.println();
					System.out.println("※ 잘못 입력하셨습니다.\n메뉴 조회는 1, 메뉴 추가는 2, 메뉴 삭제는 3, 이전화면으로 가기는 0을 입력해주세요.");
				}	
			}
		
		
	}
	
	
	
	
	public static void menuDelete(String id) { //메뉴 삭제(업체번호, 메뉴이름)
		
		FileRoad f = new FileRoad();
		Store s = new Store("s_sist0000");
		
		
		int num = 0;		
		File file = new File(f.STOREMENU);		
		String result = "";

		
		try {
			
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			BufferedReader menuReader = new BufferedReader(new FileReader(f.STOREMENU));
			
			System.out.print("삭제할 메뉴명을 입력해주세요 : ");
			String menuName = reader.readLine();

		
			String line = null;
			String txt = ""; //다른곳에 라인을 쌓다가 조건에 해당하는 줄에서 해당하는 작업을 진행하고 다시 쌓기를 반복
			
			while ((line = menuReader.readLine()) != null) {

				String[] temp = line.split(",");

				if (!(temp[0].equals(s.getStoreMemberNum()) && temp[2].equals(menuName))) {
					
					txt += line + "\n"; //이구문이 중요하다. 라인을 한줄 쌓고 엔터. 그 다음 다시 if문으로 돌아가서(while에 걸려있으니까) 조건구문이 아닌애들에 대해 계속 라인을 쌓는다. 그러면 해당 라인만 삭제된 상태로 쌓이는 것.
				}
				
				
			}	
			reader.close();
			menuReader.close();
			
			
			BufferedWriter writer = new BufferedWriter(new FileWriter(f.STOREMENU));
			writer.write(txt);
			writer.close();
			
			System.out.printf("%s메뉴의 삭제가 완료되었습니다.", menuName);

		} catch (IOException e) {
			System.out.println("error.StoreMenu.menuDelete");
			e.printStackTrace();
		}
//		return null;	

	}
	
	
	
	
	public static void menuCheck(String id) { //메뉴 조회(업체번호)
		
		FileRoad f = new FileRoad();
		Store s = new Store("s_sist0000");		
		
		int num = 0;
		
		try {
			
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			BufferedReader menuReader = new BufferedReader(new FileReader(f.STOREMENU));


		
			String line = null;

			while ((line = menuReader.readLine()) != null) {

				String[] temp = line.split(",");
				
				if (temp[0].equals(s.getStoreMemberNum())) {
					System.out.printf("%s\t%s\t%s\t\t%s\t\r\n",temp[0], temp[1], temp[2], temp[3]);

				}

			}
			BufferedWriter writer = new BufferedWriter(new FileWriter(f.STOREMENU, true));																					
			writer.close();
			menuReader.close();
			reader.close();
		} catch (IOException e) {
			System.out.println("error.StoreMenu.menuCheck");
			e.printStackTrace();
		}
		
		
	}
	
	
	
	public static String menuAdd(String id) { //메뉴 추가(업체 아이디)
		
		FileRoad f = new FileRoad();
		Store s = new Store("s_sist0000");	
		
		
	
		int num = 0;
		String storeMemNum = "";
		String storeMenuCategory = "";
		try {
			
			BufferedWriter writer = new BufferedWriter(new FileWriter(f.STOREMENU, true));
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			BufferedReader storeFinalReader = new BufferedReader(new FileReader(f.STOREFINAL));
	
			Store store = new Store();
			ArrayList<String> storeMenu = new ArrayList<String>();
			
			System.out.println();
			System.out.print("등록할 메뉴명을 한가지 입력해주세요 : ");
			String menuName = reader.readLine();
			System.out.print("해당 메뉴의 가격을 입력해주세요 : ");
			String menuCost = reader.readLine();
			
			
			
			
			String line = null;
			String result1 = "";
			
			while ((line = storeFinalReader.readLine()) != null) {
				
				String[] temp = line.split(",");
				num++; //여기말고 다른데서 쓸 때 num 초기값 0인거 잊지 말기
				
				
				if (temp[1].equals(s.getStoreID())) {
					storeMemNum = temp[0];
					storeMenuCategory = temp[23];
					result1 = String.format("%s,%s,%s,%s\r\n", storeMemNum, storeMenuCategory, menuName, menuCost);
					System.out.printf("추가된 메뉴 : %s",result1);
					writer.write(result1);	
					break;				
				} 

			}
		
			writer.close();
			reader.close();
			storeFinalReader.close();
		
		} catch (IOException e) {
			System.out.println("error.StoreMenu.menuAdd");
			e.printStackTrace();
		}
		return null;
	
	}
	
}
