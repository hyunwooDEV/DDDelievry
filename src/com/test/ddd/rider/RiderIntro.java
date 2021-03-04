package com.test.ddd.rider;

import java.util.ArrayList;
import java.util.Scanner;

import com.test.ddd.fileroad.TotalRoad;

public class RiderIntro {

	public static void main(String[] args) {
		riderLoginIntro();
	}

	public static void riderLoginIntro() {

		Rider r = new Rider();

		System.out.println("===================================================");
		System.out.println("                       RIDER                  ");
		System.out.println("===================================================");

		// 파일읽기 -> riderFinal 라이더 총정보 파일
		ArrayList<String> rider = TotalRoad.dataRoad("r");

		ArrayList<String> rIDList = new ArrayList<String>();
		ArrayList<String> rPWList = new ArrayList<String>();
		ArrayList<String> rNameList = new ArrayList<String>();

		for (int i = 0; i < rider.size(); i++) { // 라이더 총정보 파일 크기 만큼 돌며
			String[] infoR = rider.get(i).split(",");
			rIDList.add(infoR[1]); // ID 담는 배열에 ID 담기
			rPWList.add(infoR[2]); // PW 담는 배열에 PW 담기
			rNameList.add(infoR[3]); // 이름 담기
		}

		boolean accept = false;

		Scanner scan = new Scanner(System.in);

		System.out.print("ID : ");
		String id = scan.nextLine(); // 입력받은 ID

		System.out.print("PW : ");
		String pw = scan.nextLine(); // 입력받은 PW
		System.out.println();
		for (int i = 0; i < rIDList.size(); i++) {
			if (id.equals(rIDList.get(i)) && pw.equals(rPWList.get(i))) {
				accept = true;
				break;
			}

		} // for

		if (accept == true) {
			RiderMenu.riderMenu(id);
		} else if (id.equals("0") || pw.equals("0")) {
			RiderFirstScene.riderFirstScene();

		} else {
			System.out.println("입력한 라이더 ID와 비밀번호가 일치하지 않습니다.");
			System.out.println("다시 입력하세요.");
			System.out.println();
			riderLoginIntro();
		}

	}

	public void r() {
		String id;
		String pw;
	}
}
