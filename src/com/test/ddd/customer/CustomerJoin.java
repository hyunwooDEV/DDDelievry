package com.test.ddd.customer;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Scanner;

import com.test.ddd.fileroad.FileRoad;
import com.test.ddd.intro.Intro;
import com.test.ddd.validation.Validation;

public class CustomerJoin {

	// 주문 회원 가입 클래스입니다.

//	static Scanner sc = new Scanner(System.in);// 회원 가입 정보를 입력받는 스캐너
//	private static ArrayList<String> newCustomer = new ArrayList<String>();// 회원 가입 정보를 저장하는 리스트
//	private static ArrayList<Customer> addCustomer = new ArrayList<Customer>();// 회원 가입 정보를 저장하는 리스트
//	private static Customer customer = new Customer();

	 public static void main(String[] args) throws Exception {
		customerJoin();
	}
	public static void customerJoin() throws Exception {
		Scanner sc = new Scanner(System.in);// 회원 가입 정보를 입력받는 스캐너
		Customer customer = new Customer();
		// ArrayList<String> newCustomer = new ArrayList<String>();// 회원 가입 정보를 저장하는 리스트
		// ArrayList<String> addCustomer = new ArrayList<String>();// 회원 가입 정보를 저장하는 리스트

		//Validation validation = new Validation();// 유효성 검사 패키지
		//ArrayList<Customer> customerInfo = new ArrayList<Customer>();

		// 주문회원 회원 가입
		// 아이디, 비밀번호, 이름, 생년월일, 성별, 전화번호, 주소, 상세주소, 선호음식, 카드번호

		System.out.println("----------------------------------");
		System.out.println("\t회원가입 [주문 고객]");
		System.out.println("----------------------------------");

		boolean loop = true;

		System.out.println("※ 4~16자 영어, 숫자만 입력 가능(첫글자는 소문자로 입력해주세요.)");
		while (loop) {
			System.out.print("▶ ID : ");
			customer.setCustomerId(sc.nextLine());// 1아이디 입력

			// 유효성 검사
				
			if (Validation.idInspection(customer.getCustomerId(),"c") == true) {
				loop = false;
			} else if(customer.getCustomerId().equals("0")){
				Intro.memberIntro();
			}else {
				System.out.println();
				System.out.println("조건에 맞지 않거나 중복된 아이디입니다. 재입력해주세요.");
			}
		}
		System.out.println("----------------------------------");

		loop = true;

		System.out.println("※ 10~16자 영어대(소)문자, 숫자만 입력 가능");
		while (loop) {
			System.out.print("▶ Password : ");
			customer.setCustomerPw(sc.nextLine());// 2비밀번호 입력

			// 유효성 검사
			if (Validation.pwInspection(customer.getCustomerPw()) == true) {
				loop = false;
			} 
			
			else {
				System.out.println();
				System.out.println("조건에 맞지 않는 비밀번호입니다. 재입력해주세요");
			}
		}

		System.out.println("----------------------------------");

		loop = true;

		System.out.println("※ 2~5자 한글");
		while (loop) {
			System.out.print("▶ 이름 : ");
			customer.setCustomerName(sc.nextLine());// 3이름 입력

			// 유효성 검사
			if (Validation.nameInspection(customer.getCustomerName()) == true) {
				loop = false;
			} else {
				System.out.println();
				System.out.println("조건에 맞지 않는 이름입니다. 재입력해주세요");
			}
		}

		System.out.println("----------------------------------");

		loop = true;

		System.out.println("※ 1.남/2.여");
		while (loop) {
			System.out.print("▶ 성별 : ");
			customer.setCustomerGender(sc.nextLine());// 4성별 입력

			// 유효성 검사
			if (customer.getCustomerGender().equals("1") || customer.getCustomerGender().equals("2"))
				loop = false;
			else {
				System.out.println();
				System.out.println("'1'아니면 '2'를 입력해주세요.");
			}
		}

		System.out.println("----------------------------------");

		loop = true;

		System.out.println("※ YYYYMMDD");
		while (loop) {
			System.out.print("▶ 생년월일 : ");
			customer.setCustomerBirth(sc.nextLine());// 5생년월일 입력

			// 유효성 검사
			if (Validation.birthInspection(customer.getCustomerBirth(), "yyyyMMdd") == true) {
				loop = false;
			} else {
				System.out.println();
				System.out.println("조건에 맞지 않는 생년월일 입니다. 재입력해주세요.");
			}
		}
		System.out.println("----------------------------------");

		loop = true;

		System.out.println("※ 15~16자리 숫자");
		while (loop) {
			System.out.print("▶ 전화번호 : ");
			customer.setCustomerPhoneNum(sc.nextLine());// 6핸드폰 번호 입력

			// 유효성 검사
			if (Validation.phoneInspection(customer.getCustomerPhoneNum()) == true) {
				loop = false;
			} else {
				System.out.println();
				System.out.println("조건에 맞지 않는 핸드폰번호 입니다. 재입력해주세요.");
			}
		}

		System.out.println("----------------------------------");

		loop = true;
		while (loop) {
			System.out.print("▶ 주소(번지) : ");
			customer.setCustomerAddress(sc.nextLine());// 7주소 입력

			// 유효성 검사
			if (customer.getCustomerAddress() != null) {
				loop = false;
			} else {
				System.out.println();
				System.out.println("주소를 입력해주세요.");
			}
		}

		System.out.println("----------------------------------");

		loop = true;
		while (loop) {
			System.out.print("▶ 상세 주소 : ");
			customer.setCustomerAddressDetail(sc.nextLine());// 8상세주소 입력

			// 유효성 검사
			if (customer.getCustomerAddressDetail() != null) {
				loop = false;
			} else {
				System.out.println();
				System.out.println("상세 주소를 입력해주세요.");
			}
		}

		System.out.println("----------------------------------");

		loop = true;
		while (loop) {
			System.out.println("[선호음식]\n" + "한식 일식 중식 양식 분식\n" + "치킨 패스트푸드 디저트\n" + "입력안함");
			System.out.println("----------------------------------");
			System.out.print("▶ 선호음식(한가지만 입력해주세요) : ");// 9음식 입력
			customer.setCustomerfavoriteFood(sc.nextLine());

			// 유효성 검사
			if (Validation.foodInspection(customer.getCustomerfavoriteFood()) == true) {
				loop = false;
			} else {
				System.out.println();
				System.out.println("위 카테고리 중 한가지만 입력해주세요.");

			}
		}
		System.out.println("----------------------------------");

		loop = true;
		while (loop) {
			System.out.println("[카드정보](선택사항)\n" + "*15~16자 숫자 ex)1234-5678-9012-3456, 입력을 원하지 않을 시 1을 입력해주세요");
			System.out.print("▶ 카드번호 : ");// 10카드 번호 입력
			customer.setCustomerCardNum(sc.nextLine());

			// 유효성 검사
			if (Validation.cardNumInspection(customer.getCustomerCardNum()) == true) {
					
				loop = false;
			} else {
				System.out.println();
				System.out.println("잘못된 카드번호 입니다. 재입력해주세요.");

			}
		}

		//
		// 아이디, 비밀번호, 이름, 생년월일, 성별, 전화번호, 주소, 상세주소, 선호음식, 카드번호
//		String s = String.format("%s,%s,%s,%s,%s,%s,%s,%s,%s,%s", customer.getCustomerId(), customer.getCustomerPw(),
//				customer.getCustomerName(), customer.getCustomerBirth(), customer.getCustomerGender(),
//				customer.getCustomerPhoneNum(), customer.getCustomerAddress(), customer.getCustomerAddressDetail(),
//				customer.getCustomerfavoriteFood(), customer.getCustomerCardNum());
//
//		newCustomer.add(s); //새로운 주문 회원 저장

		System.out.println("----------------------------------");
		System.out.printf("%s님 가입을 축하드립니다.\n", customer.getCustomerId());
		System.out.println("----------------------------------");

		// 주문 회원 가입 정보 쓰는 텍스트 파일
		
		String line = null;
		
		try {
			BufferedReader reader = new BufferedReader(new FileReader(FileRoad.CUSTOMERFINAL));
			BufferedWriter writer = new BufferedWriter(new FileWriter(FileRoad.CUSTOMERFINAL, true));
			
			int lineNum = 0;
			
			while((line=reader.readLine())!=null) {
				lineNum++;
			}
			customer.setCustomerNum(String.format("C%03d", lineNum));
			
			// newCustomer.add(s); //새로운 주문 회원 저장
			//회원번호,id,pw,이름,생년월일,성별,핸드폰번호,주소,상세주소,회원등급,포인트,선호카테고리,카드번호,탈퇴여부
			writer.write(String.format("%s,%s,%s,%s,%s,%s,%s,%s,%s,일반,0,%s,%s,0", customer.getCustomerNum(), customer.getCustomerId(),
					customer.getCustomerPw(), customer.getCustomerName(), customer.getCustomerBirth(),
					customer.getCustomerGender(), customer.getCustomerPhoneNum(), customer.getCustomerAddress(),
					customer.getCustomerAddressDetail(), customer.getCustomerfavoriteFood(),
					customer.getCustomerCardNum()));
			
			writer.close();
			reader.close();

		} catch (Exception e) {
			System.out.println("CustomerJoin.main()");
			e.printStackTrace();

		}

	}
}
