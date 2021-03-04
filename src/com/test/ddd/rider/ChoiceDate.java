package com.test.ddd.rider;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;
import java.util.TreeSet;

import com.test.ddd.fileroad.TotalRoad;

public class ChoiceDate {

	public static void main(String[] args) {

		choiceDate("r_sist0100");
	}

	public static void choiceDate(String id) {

		Rider rider = new Rider(id);

		System.out.println("   라이더 - 배달내역 조회           ");
		System.out.println("------------------------------     ");

		Scanner sc = new Scanner(System.in);

		boolean flag = true;
		String dates = null;
		String startDate;
		String endDate;

		while (flag) {
			System.out.println("조회 기간의 시작 날짜를 입력해주세요");
			System.out.println(" (예: 20201010)");

			startDate = sc.nextLine();

			System.out.println("조회 기간의 끝 날짜를 입력해주세요");
			System.out.println(" (예: 20201110)");
			System.out.println("*조회는 한달 단위로 가능합니다.");
			endDate = sc.nextLine();

			if (Validation.birthInspection(startDate, "yyyyMMdd")&&(Validation.birthInspection(endDate, "yyyyMMdd"))) {
					dates = startDate + "~" + endDate;
					System.out.printf("선택한 기간은 %s ~ %s입니다.\r\n", startDate, endDate);
					break;
				} else {
					System.out.println("입력 가능한 날짜가 아닙니다. 재입력 해주세요");
		}
		 // while
		}
		flag = false;

		/*
		 * 1) 이 안에서 유효성 검사 통과-> 선택한 날짜 출력되게끔 하기 통과 x -> 다시 입력하기 창이 나오게 하여 다시 값을 입력받기
		 * 
		 * 2) 그 다음 go() 로 이동. 그후 -> standardChoice()에서 필터를 써서 매출액을 출력한다. - 필터를 쓰려면
		 * date()에서 입력한 값을 불러와야 한다.
		 */

		Scanner scan = new Scanner(System.in);
		boolean loop = true;

		while (loop) {
			System.out.println();
			System.out.println("1. 계속하려면 1를 입력하세요");
			System.out.println("2. 날짜를 수정하려면 2를 입력하세요");
			System.out.println("0. 초기 화면");

			System.out.print("입력: ");

			String sel = scan.nextLine();

			if (sel.equals("1")) {
				goView(id, dates);
				loop = false;
				break;
			} else if (sel.equals("2")) {
				choiceDate(id); // 이전 날짜입력단계로 돌아가기
				loop = false;
				break;
			} else if (sel.equals("0")) {
				RiderMenu rm = new RiderMenu();
				rm.riderMenu(id);
				loop = false;
				break;
			} else 
				System.out.println("번호를 다시 입력해주세요.");
			
		}

	}

	private static void goView(String id, String dates) {
		Rider r = new Rider(id);
		System.out.println("   라이더 - 배달 내역 조회           ");
		System.out.println("------------------------------     ");
		System.out.print("  <평점 평균> ");

		// 평점 평균 -> 라이더 정보에서 가져오기

		String datesList[] = dates.split("~"); // 입력한 조회날짜
		int startDate = Integer.parseInt(datesList[0]);// 조회할 날짜 첫번
		int endDate = Integer.parseInt(datesList[1]);// 조회할 날짜 끝

		// 읽어올 파일(riderFinal) -> 라이더 총정보 파일
		ArrayList<String> rider = TotalRoad.dataRoad("r");
		String riderNum = "";
		String riderGrade = "";

		for (int i = 0; i < rider.size(); i++) { // 라이더 총정보 파일 크기만큼 돌며
			String[] infoR = rider.get(i).split(",");
			if (infoR[1].equals(id)) { // 라이더 파일의 id가 로그인한 라이더의 아이디와 같다면
				riderNum = infoR[0]; // 해당 라이더 번호 가져오기
				riderGrade = infoR[10]; // 해당 라이더 평점 가져오기
			}
		}
		System.out.println(riderGrade + "점"); // 평점 출력

		System.out.println("  <조회 기간> " + dates);

		// 날짜, 배달건수, 수익 조회

		// 읽어올 파일(finishOrder) -> 주문 정보 파일
		ArrayList<String> list = TotalRoad.dataRoad("o");

		// 읽어올 파일(storeFinal) ->업체 총정보 파일
		ArrayList<String> store = TotalRoad.dataRoad("s");

		String storeName = ""; // 업체명
		String orderArea = ""; // 배달 주소
		int money = 0; // 배달료(라이더 수익)
		String orderDate = ""; // 배달 날짜(완료 한정)
		int allRevenue = 0; // 기간 동안의 총 수익

		ArrayList<Integer> revenue = new ArrayList<Integer>(); // 배달료를 담을 배열
		ArrayList<Integer> orderDates = new ArrayList<Integer>(); // 배달날짜를 담을 배열
		ArrayList<String> storeNames = new ArrayList<String>(); // 업체명을 담을 배열
		ArrayList<String> orderAreas = new ArrayList<String>(); // 배달주소를 담을 배열
		TreeSet<String> orderInfo = new TreeSet<String>();

		// HashMap<String, String> infoList = new HashMap<String, String>();

		for (int i = 0; i < list.size(); i++) { // 주문정보파일 정보가 담긴 배열 크기만큼 돌며
			String[] infoO = list.get(i).split(",");

			if (riderNum.equals(infoO[3])) { // 로그인한 라이더 번호 = 주문목록 라이더번호라면
				orderArea = infoO[4]; // 배달주소
				money = Integer.parseInt(infoO[10]); // 라이더 수익
				orderDate = infoO[8];
				orderDate = orderDate.replace("-", ""); // 더미파일 속 날짜의 하이폰 빼기
				int orderDateNum = Integer.parseInt(orderDate); // int 형변환

				// storeName = infoO[8]; //업체명
				String state = infoO[6]; // 배달상황

				if (startDate <= orderDateNum && endDate >= orderDateNum) {// 설정한 조회기간 날짜 안에 포함된다면

					if (state.equals("배달완료")) { // 배달이 완료되었다면

						orderInfo.add(orderDate + "     " + orderArea + "     " + money); // 날짜 정렬을 위해 트리셋에 출력될 문자열 담기
						orderDates.add(orderDateNum); // 1.날짜배열에 날짜를 담기
						orderAreas.add(orderArea);// 2.배달주소 배열에 배달주소 담기
						// 3.업체명 배열에 업체명 담기
						revenue.add(money); // 4. 배달료 배열에 배달료(라이더 수익) 담기
					}

				}
			}

		}

		System.out.println();
		System.out.println("[날짜]" + "           " + "[배달지역]" + "                              " + "[수익 (원)]");
		// orderDate + " "+ orderArea + " " + money
		Iterator<String> iter = orderInfo.iterator();
		while (iter.hasNext()) { // iterator에 다음 값이 있다면
			System.out.println(iter.next()); // iter 값꺼내 출력
		}
		// System.out.println(orderInfo);

		// 총 합계라인 값 구하기
		System.out.println("==================================");
		for (int i = 0; i < revenue.size(); i++) {
			allRevenue += revenue.get(i);
		} // 총수익 구하는 for문

		System.out.println("합계:         " + revenue.size() + "건            ");
		System.out.println("조회기간 총 수익  " + allRevenue + "원");

		// 마이스토어 초기화면 이동
		System.out.println();
		System.out.println("0. 라이더 초기화면 이동");
		Scanner scan = new Scanner(System.in);
		boolean loop = true;

		String sel = scan.nextLine();

		while (loop) {

			if (sel.equals("0")) {
				RiderMenu rm = new RiderMenu();
				rm.riderMenu(id);
				loop = false;
				break;
			} else {
				System.out.println("초기화면으로 돌아가려면 0을 입력하세요");
			}

		} // while

	}

}
