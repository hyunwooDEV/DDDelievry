package com.test.ddd.rider;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Scanner;

import com.test.ddd.fileroad.FileRoad;

public class RiderJoin {
	
	public static void main(String[] args) {
		riderJoin();
	} //main
	
	
	public static void riderJoin() {
		
		Scanner sc = new Scanner(System.in);// 라이더 가입 정보를 입력받는 스캐너
		Rider rider = new Rider();
		
		System.out.println("----------------------------------");
		System.out.println("\t회원가입 [라이더]");
		System.out.println("----------------------------------");
		
		boolean loop = true;

		System.out.println("※ 4~16자 영어, 숫자만 입력 가능(첫글자는 소문자로 입력해주세요.)");
		while (loop) {
			System.out.print("▶ ID : ");
			rider.setRiderId(sc.nextLine());// 1아이디 입력

			// 유효성 검사
				
			if (Validation.idInspection(rider.getRiderId(),"r") == true) {
				loop = false;
			} else if(rider.getRiderId().equals("0")){
				//Intro.riderIntro();
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
			rider.setRiderPw(sc.nextLine());// 2비밀번호 입력

			// 유효성 검사
			if (Validation.pwInspection(rider.getRiderPw()) == true) {
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
			rider.setRiderName(sc.nextLine());// 3이름 입력

			// 유효성 검사
			if (Validation.nameInspection(rider.getRiderName()) == true) {
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
			rider.setRiderGender(sc.nextLine());// 4성별 입력

			// 유효성 검사
			if (rider.getRiderGender().equals("1") || rider.getRiderGender().equals("2"))
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
			rider.setRiderBirth(sc.nextLine());// 5생년월일 입력

			// 유효성 검사
			if (Validation.birthInspection(rider.getRiderBirth(), "yyyyMMdd") == true) {
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
			rider.setRiderPhoneNumber(sc.nextLine());// 6핸드폰 번호 입력

			// 유효성 검사
			if (Validation.phoneInspection(rider.getRiderPhoneNumber()) == true) {
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
			rider.setRiderAddress(sc.nextLine());// 7주소 입력

			// 유효성 검사
			if (rider.getRiderAddress() != null) {
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
			rider.setRiderDetailAddress(sc.nextLine());// 8상세주소 입력

			// 유효성 검사
			if (rider.getRiderDetailAddress() != null) {
				loop = false;
			} else {
				System.out.println();
				System.out.println("상세 주소를 입력해주세요.");
			}
		}

		System.out.println("----------------------------------");

		loop = true;
		while (loop) {
			System.out.println("[활동지역]\n" + "예: 서울특별시 강남구 역삼동");
			System.out.println("----------------------------------");
			System.out.print("▶ 활동지역(시, 구, 동) : ");
			rider.setRiderArea(sc.nextLine());

			// 유효성 검사
			//유효성 검사.. 시간 없어서 생략합니다...
		}
		System.out.println("----------------------------------");

	
//		newRider.add(s); //새로운 주문 회원 저장

		System.out.println("----------------------------------");
		System.out.printf("%s님 가입을 축하드립니다.\n", rider.getRiderId());
		System.out.println("----------------------------------");

		//라이더 첫 화면으로 이동하게 하기
		
		Scanner scan = new Scanner(System.in);
		boolean flag = true;
		
		while (flag) {
			
			System.out.println("======================");
			System.out.println("        라이더          ");
			System.out.println("======================");
			System.out.println("라이더 첫 화면으로 가기: 0번");
			System.out.println();
			System.out.print(" 입력 : ");
			
			
			
			String sel =  scan.nextLine();
			
			if (sel.equals("1")) {
				//라이더 첫화면
				RiderFirstScene rf = new RiderFirstScene();
				rf.riderFirstScene();
				flag = false;
				break;
			} else {
				System.out.println("번호를 다시 입력해주세요");
				System.out.println("라이더 첫 화면으로 가기: 0번");
			}
			
		} //while
		
		
		
		// 주문 회원 가입 정보 쓰는 텍스트 파일
		
		String line = null;
		
		try {
			BufferedReader reader = new BufferedReader(new FileReader(FileRoad.RIDERFINAL));
			BufferedWriter writer = new BufferedWriter(new FileWriter(FileRoad.RIDERFINAL, true));
			
			int lineNum = 0;
			
			while((line=reader.readLine())!=null) {
				lineNum++;
			}
			rider.setRiderNum(String.format("R%03d", lineNum)); //번호는 일련이다
			
			// newCustomer.add(s); //새로운 주문 회원 저장
			//회원번호,id,pw,이름,생년월일,성별,핸드폰번호,주소,회원등급,포인트,선호카테고리,카드번호,탈퇴여부
			writer.write(String.format("%s,%s,%s,%s,%s,%s,%s,%s,%s,,%s,0,0,0", rider.getRiderNum(), rider.getRiderId(), //평점, 수익,탈퇴는 그냥 0으료 초기화
					rider.getRiderPw(), rider.getRiderName(), rider.getRiderBirth(),
					rider.getRiderGender(), rider.getRiderPhoneNumber(), rider.getRiderAddress(),
					rider.getRiderDetailAddress(), rider.getRiderArea()
					));
			
			writer.close();
			reader.close();

		} catch (Exception e) {
			System.out.println("에러");
			e.printStackTrace();

		}
		
		
		
		
		
		
	}
	
	

}
