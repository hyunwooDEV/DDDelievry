package com.test.ddd.loginout;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

import com.test.ddd.customer.Customer;
import com.test.ddd.fileroad.FileRoad;
import com.test.ddd.intro.Intro;
import com.test.ddd.manager.Manager;
import com.test.ddd.rider.Rider;
import com.test.ddd.store.Store;

public class Loginout {

//	public static void main(String[] args) {
//		 System.out.println(login("s"));
//	}

	// position은 고객은 "c", 가게는 "s", 라이더 "r", 매니저 "m" 를 넣어주시면 됩니다.
	// 로그인이 안되면 false 로그인이 되면 true
	public static String login(String position) {

		Scanner scan = new Scanner(System.in);

		boolean loop = true;

		String result = null;

		String id = "";
		String pw = "";

		while (loop) {
			System.out.print("아이디 : ");
			id = scan.nextLine();
			if (id.equals("0")) {
				loop = false;
				System.out.println("이전화면으로 돌아갑니다.");
			} else {
				if (existId(id, position) != null) {
					pw = existId(id, position);
					while (loop) {
						System.out.print("비밀번호 : ");
						String inputPw = scan.nextLine();
						if (inputPw.equals("0")) {
							System.out.println("이전화면으로 돌아갑니다.");
							loop = false;
						} else {
							if (pw.equals(inputPw)) {
								if (secession(id, position)) {
									System.out.println("탈퇴한 회원입니다.");
									loop = false;
								} else {
									result = id;
									loop = false;
								}
							} else {
								System.out.println("잘못된 비밀번호입니다. 다시 입력해주세요~");
							}
						}
					}
					loop = false;
				} else {
					System.out.println("없는 아이디입니다. 다시 입력해주세요~");
				}
			}
		}
		// scan.close();

		return result;

	}

	// 탈퇴 여부
	public static boolean secession(String id, String position) {

		boolean result = false;
		if (position == "c") {
			Customer c = new Customer(id);
			if (c.getCustomerDelete().equals("1"))// 탈퇴한 회원이면
				result = true;
			else
				return false;
		} else if (position == "r") {
			Rider r = new Rider(id);
			if (r.getRiderDelete().equals("1"))// 탈퇴한 회원이면

				result = true;

			else
				return false;
		} else if (position == "s") {
			Store s = new Store(id);
			if (s.getStoreDelete().equals("1"))// 탈퇴한 회원이면
				result = true;
			else
				return false;
		}
		return result;
	}

	// position은 고객은 "c", 가게는 "s", 라이더 "r", 매니저 "m"를 넣어주시면 됩니다.
	// 아이디 존재 여부
	public static String existId(String id, String position) {

		ArrayList<String> exist = new ArrayList<String>();
		ArrayList<String> existpw = new ArrayList<String>();

		try {

			String path = "";

			if (position == "c") {
				path = FileRoad.CUSTOMERFINAL;
			} else if (position == "s") {
				path = FileRoad.STOREFINAL;
			} else if (position == "r") {
				path = FileRoad.RIDERFINAL;
			} else if (position == "m") {
				path = FileRoad.MANAGERINFO;
			}
			BufferedReader reader = new BufferedReader(new FileReader(path));
			String line = null;

			while ((line = reader.readLine()) != null) {

				String[] info = line.split(",");
				exist.add(info[1]);
				existpw.add(info[2]);

			}

			reader.close();

		} catch (Exception e) {
			System.out.println("Validation.idInspection()");
			e.printStackTrace();
		}

		String result = null;

		for (int j = 0; j < exist.size(); j++) {

			if (exist.get(j).equals(id)) {
				result = existpw.get(j);
				break;
			} else {
				result = null;
			}

		}

		return result;

	}

	public static Boolean logout() {
		
		Scanner scan = new Scanner(System.in);

		Boolean loop = true;
		Boolean result = true;
		while (loop) {

			System.out.println("로그아웃 하시겠습니까?(Y.네/N.아니요)");
			System.out.print("입력(Y/N) : ");

			String sel = scan.nextLine();
			System.out.println();
			
			if ((sel.equals("Y")) || sel.equals("y")) {
				System.out.println("*****로그아웃 되었습니다.");
				System.out.println();
				loop = false;
				result = true;
				//Intro.intromenu();
				break;
			} else if ((sel.equals("N")) || sel.equals("n")) {
				loop = false;
				result = false;
			} else {
				System.out.println("Y나 N를 입력해주세요.");
			}
			
		}
		System.out.println();
		return result;
	}
}
