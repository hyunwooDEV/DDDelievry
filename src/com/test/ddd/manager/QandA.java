package com.test.ddd.manager;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;

import com.test.ddd.fileroad.FileRoad;

public class QandA {
	//qPath =Q&A 파일위치
	//private static String qPath = "C:\\home\\DDDilivery\\src\\com\\test\\ddd\\dummy\\Q&A.txt";
	//private static String nPath = "C:\\home\\DDDilivery\\src\\com\\test\\ddd\\dummy\\notice.txt";
	
	//private static QandA a = new QandA();
	
	//private static ManagerVO b = new ManagerVO("id","pw");
	
	public static void main(String[] args) {
		QandA.getQnaList();
		

	}
	
	//기능별 함수생성
	public QandA() {
		
	}
	
	
	public static void getQnaList() {
		//qFile = Q&A 불러오기
		
		ArrayList<String> qList = new ArrayList<String>();
	
		
		try {
			String temp = null;
			BufferedReader qReader = new BufferedReader(new FileReader(FileRoad.QANDA));
			
			while((temp = qReader.readLine())!=null) {
				qList.add(temp);
			}
		qReader.close();
		
		
		//qList 출력 
		System.out.println("========================================");
		System.out.println("               Q and A                ");
		System.out.println("========================================");
		System.out.println();
		System.out.println("    **** 공지사항 ****");
		
		ArrayList<String> nList = new ArrayList<String>();
		
		temp = null;
		BufferedReader nReader = new BufferedReader(new FileReader(FileRoad.NOTICE));
		
		while((temp = nReader.readLine())!=null) {
			nList.add(temp);
		}
		nReader.close();
		System.out.println("========================================");
		System.out.println("    **** 공지내용 ****");
		String notice = "";
		for(int i=0 ; i<nList.size(); i++) {
			notice = nList.get(i);
			System.out.printf(String.format("*** %-30s\n ",notice));

			
		}
		System.out.println("========================================");
		
		
		
		
		
		System.out.print("[No.]\t[회원번호]\t\t[질문내용]\t\t\t\t[답변내용]\n");
		
		String question = "";
		String[] questionArray = new String[4];
		for(int i=0 ; i<qList.size() ; i++) {
			question = qList.get(i);
			questionArray = question.split(",");
			if(questionArray.length==3) {
				System.out.printf(String.format("%d\t%s\t%-30s\n",
						i+1,
						questionArray[1],
						questionArray[2]
						));
				
			} else if(questionArray.length==4) {
				System.out.printf(String.format("%d\t%s\t%-30s\t%-20s\n",
						i+1,
						questionArray[1],
						questionArray[2],
						questionArray[3]
						));
				
			}
						
		}
		
		boolean flag = true;
		Scanner scan = new Scanner(System.in);
		String sel = "";
		
			System.out.println("1. 답변하기");
			System.out.println("2. 삭제하기");
			System.out.println("3. 공지사항 수정하기");
			System.out.println("0. 이전 화면");
			System.out.print("번호 선택 : ");
		
			sel = scan.next();
		
			while(flag) {
				if (sel.equals("1")) {
					flag = false;
					createAnswer(qList);
				}else if (sel.equals("2")) {
					flag = false;
					delete(qList);
				}else if (sel.equals("3")) {
					flag = false;
					createNotice();
				}else if (sel.equals("0")){		//밖으로 나가기.
					flag = false;
					ManagerMainMenu.managerMainMenuIntro();
				}else {
					flag = true;
					System.out.println("잘못된 입력 값 입니다.");
					System.out.println("1. 답변하기");
					System.out.println("2. 삭제하기");
					System.out.println("3. 공지사항 작성하기");
					System.out.println("0. 이전 화면");
					System.out.print("번호 선택 : ");
					sel = scan.next();
				}
				
			}
			scan.close();
		
		
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	
	}

	private static void createNotice() {

		System.out.print("공지사항 입력 : ");
		try {
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			
			String input = reader.readLine();
			
			BufferedWriter writer = new BufferedWriter(new FileWriter(FileRoad.NOTICE));
			
			
			//File nFile = new File(FileRoad.);
			
			
			writer.write(String.format("%s\n",input));
			
			writer.close();
			
			System.out.println("공지사항 추가완료");
			
			
		} catch (Exception e) {
			e.printStackTrace();
		} 

		QandA.getQnaList();
		
	}

	private static void delete(ArrayList<String> qList) {
		
		System.out.print("삭제할 No. 입력 : ");

		try {
			BufferedReader nReader = new BufferedReader(new InputStreamReader(System.in));
			
			String sel = nReader.readLine();
			int num = Integer.parseInt(sel)-1;
			boolean flag = true;
			while(flag) {
				if (num<qList.size()) {
					flag = false;
					
					qList.remove(num);
					
					BufferedWriter nWriter = new BufferedWriter(new FileWriter(FileRoad.QANDA));
					
					for (int i=0; i<qList.size() ; i++) {
						
						nWriter.write(String.format("%s\n",qList.get(i)));
						
					}
					System.out.println("글 삭제 완료");

					nWriter.close();
					
				} else {
					flag = true;
					System.out.println("잘못 입력 하셨습니다. 다시 입력하세요.");
					System.out.print("삭제할 No. 입력 : ");
					sel = nReader.readLine();
					num = Integer.parseInt(sel)-1;
				}
				
			}
			
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		QandA.getQnaList();

	}
	
	public static void createAnswer(ArrayList<String> qList) {
		System.out.print("답변할 No. 입력 : ");
		//답변할 qList의 한 줄 불러오기
		//답변 추가하여 qList 최신화.
		try {
			
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int num = Integer.parseInt(reader.readLine())-1;
		boolean flag = true;
		while(flag) {
			if (num<qList.size()) {
				flag = false;
				String question = qList.get(num);
				System.out.print("답변 입력 : ");//aaaaa 엔터
				
				reader = new BufferedReader(new InputStreamReader(System.in));
				String answer = reader.readLine();
				
				String[] str = qList.get(num).split(",");//Q001,C155,비밀번호는 어떻게 바꾸나요?,qqq
				
				qList.remove(num);
				if(str.length == 4) {
					qList.add(num, (str[0]+","+str[1]+","+str[2]+","+answer) );
				}else {
					qList.add(num, question +","+answer);
				}
				
				//변경된 qList를 기준으로 파일 재작성
				
				FileWriter writer = new FileWriter(FileRoad.QANDA);
				for (int i=0; i<qList.size() ; i++) {
					
					writer.write(String.format("%s\n",qList.get(i)));
					
				}
				writer.close();
				System.out.println("답변 완료");
			} else {
				flag = true;
				System.out.println("잘못 입력 하셨습니다. 다시 입력하세요.");
				System.out.print("답변할 No. 입력 : ");
				num = Integer.parseInt(reader.readLine())-1;
			}
		}
		
		
		QandA.getQnaList();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		

		
		
	}
	

}









