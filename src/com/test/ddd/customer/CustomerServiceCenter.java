package com.test.ddd.customer;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;

import com.test.ddd.fileroad.FileRoad;
import com.test.ddd.fileroad.TotalRoad;
import com.test.ddd.rider.Rider;
import com.test.ddd.store.Store;

public class CustomerServiceCenter {
	public static void main(String[] args) {

		//serviceCenter("c_sist0155");
	}

	static Scanner sc = new Scanner(System.in);
	static ArrayList<String> qList = TotalRoad.dataRoad("q");
	static ArrayList<String> nList = TotalRoad.dataRoad("n");
	static ArrayList<String> myQList = new ArrayList<String>();

	public static void serviceCenter(String id) {

		boolean loop = true;

		while (loop) {

			System.out.println(
					"===================================================================================================");
			System.out.println("\t\t\t\t\tService Center                ");
			System.out.println(
					"===================================================================================================");
			System.out.println("\t\t\t\t\t**** 공지사항 ****");
			System.out.println(
					"===================================================================================================");
			System.out.println("\t\t\t\t\t**** 공지내용 ****");

			for (String notice : nList) {
				System.out.printf("▶%s\n", notice);
			}

			System.out.println(
					"===================================================================================================");
			System.out.print("[No.]\t[질문내용]\t\t\t\t\t[관리자 ID]\t[답변내용]\n");

			ArrayList<String> myQ = new ArrayList<String>();

			Customer c = new Customer(id);
			Store s = new Store(id);
			Rider r = new Rider(id);

			// 넘버링
			int index = 1;
			// 해당 고객의 Q&A 출력
			for (String q : qList) {
				String[] questionArray = q.split(",");
				if (questionArray.length == 2) {// 질문만 있는
					myQ.add(q);
					System.out.print(String.format("%4d\t%-30s\n", index, questionArray[1]));
				} else if (questionArray.length == 4) {// 질문과 답변이 같이 있는
					myQ.add(q);
					System.out.print(String.format("%4d\t%-30s\t%s\t%-20s\n", index, questionArray[1], questionArray[2],
							questionArray[3]));
				}
				index++;

			}
			String sel = "";

			System.out.println(
					"---------------------------------------------------------------------------------------------------");
			System.out.println("1. 질문하기");
			System.out.println("2. 내 질문보기");
			System.out.println("0. 이전화면");
			System.out.print("입력 : ");
			sel = sc.nextLine();
			System.out.println(
					"---------------------------------------------------------------------------------------------------");
			if (sel.equals("1")) {
				question(id);
			} else if (sel.equals("2")) {
				myQuestion(id);
			} else if (sel.equals("0")) {
				loop = false;
				break;
			} else {
				System.out.println("번호를 다시 입력해주세요");
			}
		} // while
		loop = false;
	}

	private static void question(String id) {
		Customer c = new Customer(id);
		System.out.print("질문을 입력해주세요(30자 이내):");
		String str = sc.nextLine();

		String newQ = "";

		newQ = String.format("%s,%s", c.getCustomerNum(), str);
		qList.add(newQ);
		try {// 큐엔에이 더미에 저장
			BufferedWriter writer = new BufferedWriter(new FileWriter(FileRoad.QANDA, true));
			writer.newLine();
			writer.write(newQ);

			writer.close();
		} catch (Exception e) {
			System.out.println("CustomerServiceCenter.question()");
			e.printStackTrace();
		}

		// TotalRoad.dataSave(qList,"q");

	}

	private static void myQuestion(String id) {
		boolean loop = true;
		String sel = "";

		// ArrayList<String> pList = TotalRoad.dataRoad("q");
		// ArrayList<String> myQList = new ArrayList<String>();
		Customer c = new Customer(id);

		while (loop) {
			System.out.println(
					"===================================================================================================");
			System.out.println("\t\t\t\t\tMy Question");
			System.out.println(
					"===================================================================================================");
			System.out.print("[No.]\t[질문내용]\t\t\t\t\t[관리자 ID]\t[답변내용]\n");

			ArrayList<String> myQ = new ArrayList<String>();

			// 넘버링
			int index = 1;
			// 해당 고객의 Q&A 출력
			for (String q : qList) {
				String[] questionArray = q.split(",");
				if (questionArray[0].equals(c.getCustomerNum())) {
					if (questionArray.length == 2) {// 질문만 있는
						myQ.add(q);
						System.out.print(String.format("%4d\t%-30s\n", index, questionArray[1]));
						index++;
					} else if (questionArray.length == 4) {// 질문과 답변이 같이 있는
						myQ.add(q);
						System.out.print(String.format("%4d\t%-30s\t%s\t%-20s\n", index, questionArray[1],
								questionArray[2], questionArray[3]));
						index++;
					}
				}

			}
			System.out.println("1. 질문 삭제하기");
			System.out.println("0. 이전화면");
			System.out.print("입력 : ");
			sel = sc.nextLine();
			if (sel.equals("1")) {
				myQuestionDelete(id);
			} else if (sel.equals("0")) {
				System.out.println("이전 화면으로 돌아갑니다.");
				loop = false;
			} else
				System.out.println("번호를 다시 입력해주세요.");

		}
	}

	private static void myQuestionDelete(String id) {

		// 내 큐엔에이 삭제하기
		//*******(미완성)*********
		boolean loop = true;
		String sel = "";

		// ArrayList<String> pList = TotalRoad.dataRoad("q");
		// ArrayList<String> myQList = new ArrayList<String>();
		Customer c = new Customer(id);

		System.out.println(
				"===================================================================================================");
		System.out.println("\t\t\t\t\tMy Question");
		System.out.println(
				"===================================================================================================");
		System.out.print("[No.]\t[질문내용]\t\t\t\t\t[관리자 ID]\t[답변내용]\n");

		System.out.print("삭제할 질문의 번호를 입력하세요: ");
		sel = sc.nextLine();

		int num = Integer.parseInt(sel) - 1;
		for (int i = 0; i < qList.size(); i++) {

		}

	}

}
