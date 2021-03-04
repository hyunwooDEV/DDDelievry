package com.test.ddd.order;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Random;
import java.util.Scanner;

import com.test.ddd.address.Address;
import com.test.ddd.address.DistanceCalculation;
import com.test.ddd.customer.Customer;
import com.test.ddd.fileroad.FileRoad;
import com.test.ddd.fileroad.ObjectArray;
import com.test.ddd.fileroad.TotalRoad;
import com.test.ddd.store.Store;

public class OrderStoreList {
	
	public static void main(String[] args) {
//		
		Customer c = new Customer("C000", 0);
//		
//		orderStoreList("치킨", "별점", c);
		
	}
	
	//filter : 기본, 주문량, 별점, 배달시간
	public static void orderStoreList(String category, String filter, Customer c) throws Exception {
		
		Random random = new Random();
		
		//store객체를 arrayList로 저장(거리 안에 존재하는 업체)
		ArrayList<Store> store = boundaryStore(c);
		
		//해당카테고리의 업체를 저장할 arraylist
		ArrayList<Store> categoryStore = new ArrayList<Store>();
		
		//필터를 통과한 store객체를 담는 arraylist
		ArrayList<Store> tempStore = new ArrayList<Store>();
		
		for(Store s : store) {
			if(s.getCategory().equals(category)) {
				categoryStore.add(s);
			}
		}
		
		//목록에 나타낼 가게의 인덱스를 랜덤으로 저장
		ArrayList<Integer> storeIndex = new ArrayList<Integer>();
		
		if(filter.equals("기본")) {
			//광고포함 가게 수만큼 랜덤으로 업체를 정함
			for(int i=0; i<5; i++) {
				storeIndex.add(random.nextInt(categoryStore.size()));
			}
		//구현 못함....
		}else if(filter.equals("주문량")) {
			
			
		}else if(filter.equals("별점")) {
			categoryStore.stream()
			.sorted((o1, o2) -> Integer.parseInt(o2.getStoreScore()) - Integer.parseInt(o1.getStoreScore()))
			.forEach(s -> tempStore.add(s));
			Collections.copy(categoryStore, tempStore);
			int count = 0;
			//별점이 4점 이상인 업체 중에 랜덤으로 보여줌. - 해당 업체에 index를 랜덤을 생성
			for(Store s : categoryStore) {
				if(Integer.parseInt(s.getStoreScore()) >= 4) {
					count++;
				}
			}

			for(int i=0; i<5; i++) {
				storeIndex.add(random.nextInt(count));
			}
			
		}else if(filter.equals("배달시간")) {
			categoryStore.stream()
				.sorted((o1, o2) -> Integer.parseInt(o1.getDeliveryTime()) - Integer.parseInt(o2.getDeliveryTime()))
				.forEach(s -> tempStore.add(s));
			Collections.copy(categoryStore, tempStore);
			
			//배달시간이 가장 빠른 상위 업체를 보여줌. - 해당 업체에 index를 랜덤을 생성
			for(int i=0; i<5; i++) {
				storeIndex.add(i);
			}
		
		}else if(filter.equals("0")) {
			//이전화면
		}else {
			orderStoreList(category, filter, c);
		}
		
		
		//광고를 하는 store객체를 따로 저장
		ArrayList<Store> storeAd = new ArrayList<Store>();
		
		int index = 0;
		
		for(Store s : categoryStore) {
			if(s.getAd().equals("1")) {
				storeAd.add(s);
				index++;
			}
		}
		
		int randomAd1 = random.nextInt(index);
		int randomAd2 = random.nextInt(index);
		
		System.out.println("\t\t업체목록");
		System.out.println("==========================================================");
		System.out.println("번호\t\t상호명\t\t\t평점\t배달시간");
		System.out.println("----------------------------------------------------------");
		//상위 2개는 광고
		System.out.printf("1.\t\t%s\n", storeAd.get(randomAd1).getStoreName());
		System.out.printf("2.\t\t%s\n", storeAd.get(randomAd2).getStoreName());
		for(int i = 0; i<storeIndex.size(); i++) {
			System.out.printf("%d.\t\t%-10s\t%4s\t%3s\n", i+3, categoryStore.get(storeIndex.get(i)).getStoreName(), categoryStore.get(storeIndex.get(i)).getStoreScore(), categoryStore.get(storeIndex.get(i)).getDeliveryTime());
		}
		System.out.println("----------------------------------------------------------");
		Scanner scan = new Scanner(System.in);
		System.out.print("입력 : ");
		String input = scan.nextLine();
		
		if(input.equals("1")) {
			Store s = storeAd.get(randomAd1);
			showStore(s, c);
		}else if(input.equals("2")) {
			Store s = storeAd.get(randomAd2);
			showStore(s, c);			
		}else if(input.equals("3")) {
			Store s = categoryStore.get(storeIndex.get(0));
			showStore(s, c);			
		}else if(input.equals("4")) {
			Store s = categoryStore.get(storeIndex.get(1));
			showStore(s, c);			
		}else if(input.equals("5")) {
			Store s = categoryStore.get(storeIndex.get(2));
			showStore(s, c);			
		}else if(input.equals("6")) {
			Store s = categoryStore.get(storeIndex.get(3));
			showStore(s, c);			
		}else if(input.equals("7")) {
			Store s = categoryStore.get(storeIndex.get(4));
			showStore(s, c);			
		}else if(input.equals("0")) {
			//이전화면
		}
		
	}
	
	//업체에 대한 정보/주문/즐겨찾기 추가를 할 수 있는 화면
	public static void showStore(Store s, Customer c) throws Exception {
		
		System.out.printf("\t\t%s\n", s.getStoreName());
		System.out.println("---------------------------------------");
		System.out.println("1.\t\t업체정보보기");
		System.out.println("2.\t\t메뉴보기");
		System.out.println("3.\t\t리뷰보기");
		System.out.println("4.\t\t내 즐겨찾기에 추가");
		System.out.println("0.\t\t이전화면");
		System.out.println("---------------------------------------");
		System.out.print("번호입력 : ");

		Scanner scan = new Scanner(System.in);
		String input = scan.nextLine();
		
		if(input.equals("1")) {
			showStoreData(s, c);
		}else if(input.equals("2")) {
			OrderMenu.orderMenu(s, c);
		}else if(input.equals("3")) {
			showStoreReview(s, c);
		}else if(input.equals("4")) {
			addFavoriteStore(s, c);
		}else if(input.equals("0")) {
			//이전화면으로 이동
			OrderCategory.category(c);
		}
		
	}
	
	//가게의 정보를 보여주는 화면
	public static void showStoreData(Store s, Customer c) throws Exception {
		
		System.out.printf("\t\t%s\n", s.getStoreName());
		System.out.println("--------------------------------------------------------");
		System.out.println("가게주소 : \t" + s.getAddress());
		System.out.println("가게전화번호 : \t" + s.getStorePhoneNum());
		System.out.println("소개 : \t\t" + s.getStoreIntroduction());
		System.out.println("별점 : \t\t" + s.getStoreScore());
		System.out.println("위생등급 : \t" + s.getSanitationGrade());
		System.out.println("예상배달시간 : \t" + s.getDeliveryTime() + "분");
		System.out.println("배달비용 : \t" + s.getDeliveryCost() + "원");
		
		Scanner scan = new Scanner(System.in);
		boolean loop = true;
		
		while(loop) {
			System.out.println("***enter를 입력하시면 이전화면으로 돌아갑니다.");
			String input = scan.nextLine();
			if(input.length() == 0) {
				showStore(s, c);
				loop = false;
				break;
			}else {
				System.out.println("enter를 누르세요");
			}
			
		}
		
	}
	
	//가게의 리뷰를 보여주는 화면
	public static void showStoreReview(Store s, Customer c) throws Exception {
		
		System.out.printf("\t\t%s\n", s.getStoreName());
		System.out.println("--------------------------------------------------------");
		System.out.println("[ID]\t\t[별점]\t\t[내용]");
		
		String path = FileRoad.REVIEW;
		
		try {
			
			BufferedReader reader= new BufferedReader(new FileReader(path));
			
			String line = null;
			
			while((line = reader.readLine()) != null) {
				
				String[] info = line.split(",");
				
				if(s.getStoreMemberNum().equals(info[2])) {
					Customer customer = new Customer(info[1], 0);
					System.out.printf("%s\t%s\t\t%s\n", customer.getCustomerId(), info[4], info[6]);
				}
				
			}
			
			reader.close();
			
		} catch (Exception e) {
			System.out.println("showStoreReview 에러");
		}
		
		Scanner scan = new Scanner(System.in);
		boolean loop = true;
		
		while(loop) {
			
			System.out.println("--------------------------------------------------------");
			System.out.println("뒤로가려면 enter를 입력하세요.");
			String input = scan.nextLine();
			
			if(input.length() == 0) {
				loop = false;
				showStore(s, c);
				break;
				
			}	
		}
	}
	
	//즐겨찾기 등록과 출력
	public static void addFavoriteStore(Store s, Customer c) throws Exception {
		
		
		Scanner scan = new Scanner(System.in);
		System.out.println("--------------------------------------------------------");
		System.out.print(s.getStoreName()+"을 ");
		System.out.print("즐겨찾기에 추가하시겠습니까?(y/n) :");
		System.out.println();
		System.out.println("--------------------------------------------------------");
		String input = scan.nextLine();
		System.out.print("요구사항을 입력해주세요: ");
		String needs = scan.nextLine();
		
		if(needs.length() == 0) {
			needs = "요구사항 없음";
		}
		
		if(input.equals("y") || input.equals("Y")) {
			ArrayList<String> list = TotalRoad.dataRoad("f");
			String result = String.format("%s,%s,%s,%s", c.getCustomerNum(), s.getStoreMemberNum(), s.getStoreName(), needs);
			System.out.println(result);
			list.add(result);
			try {
				
				BufferedWriter writer = new BufferedWriter(new FileWriter(FileRoad.FAVORITEINFO));
				
				for(String line : list) {
					writer.write(line);
					writer.newLine();
				}
				writer.close();
				
				System.out.println();
				System.out.println("\t\t<즐겨찾기>");
				System.out.println("--------------------------------------------------------");
				System.out.println("[등록된 업체]");
				
				String path = FileRoad.FAVORITEINFO;
				int index = 1;
				
				try {
				
					BufferedReader reader = new BufferedReader(new FileReader(path));
					
					String line = null;
					
					while((line = reader.readLine()) != null) {
						String info[] = line.split(",");
						if(info[0].equals(c.getCustomerNum())) {
							index++;
						}
					}
					
				} catch (Exception e) {
					System.out.println("addFavoriteStore 오류");
				}
				System.out.println();
				System.out.println("==========================================");
				showStore(s,c);
				
				
			} catch (Exception e) {
				System.out.println("addFavoriteStore 에러");
			}
		}else {
			showStore(s,c);
		}
		

	}
	
	//등록된 업체들과 로그인한 회원의 주소의 거리를 계산하여 특정 거리 안에 있는 업체를 arraylist로 반환
	public static ArrayList<Store> boundaryStore(Customer c){
		
		ArrayList<Store> store = ObjectArray.storeArray();
		
		ArrayList<Store> boundaryStore = new ArrayList<Store>();
		
		for(Store s : store) {
			
			Address storeAddress = new Address(s.getAddress());
			
			Address customerAddress = new Address(c.getCustomerAddress());
			
			int distance = DistanceCalculation.distance(storeAddress.getPointX(), storeAddress.getPointY(), customerAddress.getPointX(), customerAddress.getPointY());
			
			if(distance < 1000) {
				
				boundaryStore.add(s);
			}
			
		}
		
		
		return boundaryStore;
		
	}

}
