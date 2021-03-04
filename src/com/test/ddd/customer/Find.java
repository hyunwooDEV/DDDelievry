package com.test.ddd.customer;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Scanner;

import com.test.ddd.fileroad.FileRoad;

public class Find {

	public static void main(String[] args) {

		System.out.println(findId("c"));
//		System.out.println(findPw("c"));

	}

	// return 값이 id입니다. 0을 입력하면 중단이 되고 return 값은 null입니다.
	// 매개변수 값은 고객 "c", 업체 "s", 라이더 "r", 관리자 "m"
	public static String findId(String position) {

		Scanner scan = new Scanner(System.in);
		boolean loop = true;
		String result = null;

		while (loop) {

			System.out.print("이름: ");
			String name = scan.nextLine();
			if (name.equals("0")) {
				loop = false;
				result = "\n이전화면으로 돌아갑니다.\n";
//				System.out.println("이전화면으로 돌아갑니다.");
				break;
			}
			System.out.print("생년월일: ");
			String birth = scan.nextLine();
			if (birth.equals("0")) {
				loop = false;
//				System.out.println("이전화면으로 돌아갑니다.");
				result = "\n이전화면으로 돌아갑니다.\n";
				break;
			}
			System.out.print("핸드폰번호: ");
			String phone = scan.nextLine();
			if (birth.equals("0")) {
				loop = false;
//				System.out.println("이전화면으로 돌아갑니다.");
				result = "\n이전화면으로 돌아갑니다.\n";
				break;
			}

			try {

				String path = "";

				if (position.equals("c")) {
					path = FileRoad.CUSTOMERFINAL;
				} else if (position.equals("s")) {
					path = FileRoad.STOREFINAL;
				} else if (position.equals("r")) {
					path = FileRoad.RIDERFINAL;
				} else if (position.equals("m")) {
					path = FileRoad.MANAGERINFO;
				}

				BufferedReader reader = new BufferedReader(new FileReader(path));
				;

				String line = null;

				while ((line = reader.readLine()) != null) {

					String[] info = line.split(",");

					if (phone.equals(info[6]) && name.equals(info[3]) && birth.equals(info[4])) {
						result = "\n아이디는 <"+info[1]+"> 입니다.\n";
						loop = false;
						break;
					} else {
						result = null;
					}

				}

				if (loop) {
					System.out.println("정보를 잘못입력하셨습니다.");
				}

				reader.close();

			} catch (Exception e) {
				System.out.println("findiId 에러");
			}

		}

		return result;
	}

	// return 값이 pw입니다. 0을 입력하면 중단이 되고 return 값은 null입니다.
	// 매개변수 값은 고객 "c", 업체 "s", 라이더 "r", 관리자 "m"
	public static String findPw(String position) {

		String result = null;
		Scanner scan = new Scanner(System.in);
		boolean loop = true;

		while (loop) {

			System.out.print("아이디: ");
			String id = scan.nextLine();
			if (id.equals("0")) {
				loop = false;
				result="\n이전화면으로 돌아갑니다.\n";
				break;
			}
			System.out.print("핸드폰번호: ");
			String phone = scan.nextLine();
			if (phone.equals("0")) {
				loop = false;
				result = "\n이전화면으로 돌아갑니다.\n";
				break;
			}

			try {

				String path = "";

				if (position.equals("c")) {
					path = FileRoad.CUSTOMERFINAL;
				} else if (position.equals("s")) {
					path = FileRoad.STOREFINAL;
				} else if (position.equals("r")) {
					path = FileRoad.RIDERFINAL;
				} else if (position.equals("m")) {
					path = FileRoad.MANAGERINFO;
				}

				BufferedReader reader = new BufferedReader(new FileReader(path));

				String line = null;

				while ((line = reader.readLine()) != null) {

					String[] info = line.split(",");

					if (phone.equals(info[6]) && id.equals(info[1])) {
						result = "비밀번호는 <"+info[2]+"> 입니다.\n";
						loop = false;
						break;
					} else {
						result = null;
					}

				}

				if (loop) {
					System.out.println("정보를 잘못입력하셨습니다.");
				}

				reader.close();

			} catch (Exception e) {
				System.out.println("findiPw 에러");
			}

		}
		return result;

	}

}
