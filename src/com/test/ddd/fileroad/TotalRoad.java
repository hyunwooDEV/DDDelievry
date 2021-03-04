package com.test.ddd.fileroad;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;

public class TotalRoad {
	

	
	//position에 고객은 "c", 업체는 "s", 라이더는 "r", 관리자는 "m", 주문 "o", 장바구니 "b"를 입력
	//반환값은 arraylist로 데이터의 모든 값이 저장
	//한 줄이 하나의 요소로 들어감.
	public static ArrayList<String> dataRoad(String position){
		
		
		String path = "";
		ArrayList<String> list = new ArrayList<String>();
		
		try {
			
			if(position.equals("c")) {
				path = FileRoad.CUSTOMERFINAL;
			}else if(position.equals("s")) {
				path = FileRoad.STOREFINAL;
			}else if(position.equals("r")) {
				path = FileRoad.RIDERFINAL;
			}else if(position.equals("m")) {
				path = FileRoad.MANAGERINFO;
			}else if(position.equals("o")) {
				path = FileRoad.FINISHORDER;
			}else if(position.equals("b")) {
				path = FileRoad.BASKET;
			}else if(position.equals("review")) {
				path = FileRoad.REVIEWFINAL;
			}else if(position.equals("f")) {
				path = FileRoad.FAVORITEINFO;
			}else if(position.equals("todayBasket")) {
				path = FileRoad.TODAYBASKET;
			}else if(position.equals("todayOrder")) {
				path = FileRoad.TODAYORDERFINISH;
			}else if(position.equals("t")) {//오늘들어온 배달(배달대기, 배달중)
				path = FileRoad.TODAYORDER;
			}else if(position.equals("q")) {
				path = FileRoad.QANDA;//큐앤에이 더미
			}else if(position.equals("n")) {
				path = FileRoad.NOTICE;//공지사항 더미
			}
			
			BufferedReader reader= new BufferedReader(new FileReader(path));
			
			String line = null;
			
			while((line = reader.readLine()) != null) {
				
				list.add(line);
				
			}
			
			reader.close();
			
		} catch (Exception e) {
			System.out.println("dataRoad 에러");
		}
		
		return list;
		
	}
	
	
	//position에 고객은 "c", 업체는 "s", 라이더는 "r", 관리자는 "m"를 입력
	//arraylist를 입력하면 해당 arraylist가 txt로 저장
	//한 요소에 한줄을 만들어 저장하면 됩니다.
	public static void dataSave(ArrayList<String> list, String position) {
		
		String path = "";
		
		try {
			
			if(position.equals("c")) {
				path = FileRoad.CUSTOMERFINAL;
			}else if(position.equals("s")) {
				path = FileRoad.STOREFINAL;
			}else if(position.equals("r")) {
				path = FileRoad.RIDERFINAL;
			}else if(position.equals("m")) {
				path = FileRoad.MANAGERINFO;
			}else if(position.equals("o")) {
				path = FileRoad.FINISHORDER;
			}else if(position.equals("b")) {
				path = FileRoad.BASKET;
			}else if(position.equals("review")) {
				path = FileRoad.REVIEWFINAL;
			}else if(position.equals("f")) {
				path = FileRoad.FAVORITEINFO;
			}else if(position.equals("todayBasket")) {
				path = FileRoad.TODAYBASKET;
			}else if(position.equals("todayOrder")) {
				path = FileRoad.TODAYORDERFINISH;
			}else if(position.equals("t")) {//오늘들어온 배달(배달대기, 배달중)
				path = FileRoad.TODAYORDER;
			}else if(position.equals("q")) {
				path = FileRoad.QANDA;//큐앤에이 더미
			}else if(position.equals("n")) {
				path = FileRoad.NOTICE;//공지사항 더미
			}
			
			BufferedWriter writer = new BufferedWriter(new FileWriter(path));
			
			for(int i=0; i < list.size(); i++) {
				writer.write(list.get(i));
				writer.newLine();
			}
			
			writer.close();
			
			
		} catch (Exception e) {
			
			System.out.println("saveData 에러");
			
		}
		
	}
	
	public static ArrayList<String> dataRoad(String position, String path){
		
		
		ArrayList<String> list = new ArrayList<String>();
		
		try {
			
			
			BufferedReader reader= new BufferedReader(new FileReader(path));
			
			String line = null;
			
			while((line = reader.readLine()) != null) {
				
				list.add(line);
				
			}
			
			reader.close();
			
		} catch (Exception e) {
			System.out.println("dataRoad 에러");
		}
		
		return list;
		
	}

}
