package com.test.ddd.customer;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Scanner;

import com.test.ddd.fileroad.FileRoad;
import com.test.ddd.intro.Intro;



public class MemberDelete {
public static void main(String[] args) {
	//memberDelete("tnrud5666", "c");
}
	
	public static String memberDelete(String id, String position) {
		Scanner scan = new Scanner(System.in);
		boolean loop = true;
		String result = "";

		while (loop) {
			System.out.println("----------------------------------------");
			System.out.printf("\t회원탈퇴\n");
			System.out.println("----------------------------------------");
			System.out.print("비밀번호를 입력하세요 : ");
			String pw = scan.nextLine();
			if (pw.equals("0")) {
				loop = false;
				System.out.println("이전화면으로 돌아갑니다.");
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
					if (pw.equals(info[2])) {
						System.out.println("탈퇴 후 해당 아이디로 재가입은 불가합니다.");
						System.out.println("탈퇴를 진행하시겠습니까?");
						System.out.println("Y. 예  N. 아니오");
						System.out.print("입력 : ");
						String sel = scan.nextLine();
						
						if ((sel.equals("Y"))||sel.equals("y")) {
							info[info.length - 1] = "1";
							result ="탈퇴가 완료되었습니다.";
							loop = false;
							Intro.memberMenu(id);
							break;
						} else if((sel.equals("N"))||sel.equals("n")){							
							result="탈퇴를 취소합니다.";
							loop = false;
							break;
						}else {
							System.out.println("Y 또는 N를 입력해주세요.");
						}
					} else {
						result = null;					}
				}
				
				reader.close();
			} catch (Exception e) {
				System.out.println("MemberDelete.memberDelete()");
				e.printStackTrace();
			}
		}
return result;
	}

}
