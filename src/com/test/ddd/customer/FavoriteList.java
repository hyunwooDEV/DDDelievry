package com.test.ddd.customer;

import java.util.ArrayList;
import java.util.Scanner;

import com.test.ddd.fileroad.TotalRoad;

public class FavoriteList {

	public static void main(String[] args) throws Exception {

		Customer c = new Customer("C081", 0);
		reviseFavoriteList(c);

	}

	public static void reviseFavoriteList(Customer c) throws Exception {
		ArrayList<String> list = TotalRoad.dataRoad("f");
		ArrayList<String> customerList = new ArrayList<String>();
		ArrayList<String> store = new ArrayList<String>();
		ArrayList<String> needs = new ArrayList<String>();

		System.out.println("--------------------------------------------------------------");
		System.out.println("\t\t\t     즐겨찾기");
		System.out.println("--------------------------------------------------------------");
		System.out.println("[NO.]\t[업체명]  \t\t\t[요청사항]");

		int index = 1;
		// 해당 고객의 즐겨찾기를 출력
		for (String s : list) {

			String[] info = s.split(",");

			if (info[0].equals(c.getCustomerNum())) {
				customerList.add(s);
				System.out.printf("%2d\t%-15s\t\t%s\n", index, info[2], info[3]);
				store.add(info[2]);
				needs.add(info[3]);
				index++;
			}

		}
		boolean loop = true;

		while (loop) {
			// 수정 업체를 선택하는 화면
			System.out.println("--------------------------------------------------------------");
			System.out.println();
			System.out.print("수정할 요청사항 번호를 입력해주세요.(0번 입력시 이전 화면으로 돌아갑니다.) : ");
			Scanner scan = new Scanner(System.in);
			String input = scan.nextLine();
			System.out.println();

			// 넘버링 유효성 검사
			for (int j = 0; j < input.length(); j++) {

				if (input.charAt(j) >= '0' && input.charAt(j) <= '9') {

					if (Integer.parseInt(input) >= 1 && Integer.parseInt(input) <= index - 1) {
						System.out.println("--------------------------------------------------------------");
						System.out.println();
						System.out.println("**Enter키 입력 시 삭제됩니다.**");
						System.out.println("요청사항을 입력해주세요.(0번 입력 시 이전 화면으로 돌아갑니다.)");
						System.out.print("-> ");
						String newNeeds = scan.nextLine();
						System.out.println();
						if (newNeeds.length() == 0) {
							newNeeds = "요청사항 없음";
							System.out.println();
						} else if (newNeeds.equals("0")) {
							System.out.println("이전 화면으로 돌아갑니다.");
							loop = false;
							break;
						}

						needs.set(Integer.parseInt(input) - 1, newNeeds);

						for (int i = 0; i < customerList.size(); i++) {

							String info[] = customerList.get(i).split(",");
							if (info[2].equals(store.get(i))) {
								info[3] = needs.get(i);
								String result = MakeForm.makeForm(info);
								customerList.set(i, result);
							}

						}
						int count = 0;
						// 요구사항이 바뀐 걸 list에 다시 저장
						for (String s : list) {
							String[] info = s.split(",");
							for (String s2 : customerList) {
								String[] info2 = s2.split(",");
								if (info[0].equals(info2[0]) && info[1].equals(info2[1])) {
									info[3] = info2[3];
									String result = MakeForm.makeForm(info);
									list.set(count, result);
								}
							}
							count++;
						}
						// list를 파일에 저장
						TotalRoad.dataSave(list, "f");
						loop = false;
						break;
					} else if (input.equals("0")) {
						System.out.println("이전 화면으로 돌아갑니다.");
						CustomerFavoriteList.showFavoriteList(c.getCustomerNum());
						loop=false;
					} else {
						System.out.println("번호를 다시 입력해주세요.");
						break;
					}
				} else {
					System.out.println("숫자만 입력해주세요.");
					break;
				}

			}
		}
		
	}

}
