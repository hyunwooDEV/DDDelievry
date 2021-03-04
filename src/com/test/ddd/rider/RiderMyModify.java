package com.test.ddd.rider;

import java.util.ArrayList;
import java.util.Scanner;

import com.test.ddd.fileroad.TotalRoad;

public class RiderMyModify {
	
	public static void main(String[] args) {
		//modifyRider(id);
	}
	
	public static void modifyRider(String id) {
		
		Scanner scan = new Scanner(System.in);
		
		System.out.print("수정항목 번호를 입력해주세요: ");
		
		String input = scan.nextLine();
		
		ArrayList<String> data = TotalRoad.dataRoad("r");
		
		String[] temp = data.get(0).split(",");
		
		String[] info = new String[temp.length];
		
		boolean out = true;
		
		//"0"을 입력하면 이전 화면으로 돌아간다.
		for(int i = 0; i<data.size(); i++) {
			String line = data.get(i);
			info = line.split(",");
			
			if(id.equals(info[1])) {

				if(input.equals("1")) {
					
					boolean loop = true;
					
					while(loop) {

						System.out.println("------------------------------------------------");
						System.out.print("수정할 이름를 입력해주세요: ");
						String tempName = scan.nextLine();
						boolean result = Validation.nameInspection(tempName);
						if(result == true) {
							info[3] = tempName;
							loop = false;
							out = false;
							break;
						}
						if(loop == true) {
							System.out.println("이름을 다시 입력해주세요.");
						}
					}
				}else if(input.equals("2")) {
					
					boolean loop = true;
					
					while(loop) {

						System.out.println("------------------------------------------------");
						System.out.print("수정할 비밀번호를 입력해주세요: ");
						String tempPw = scan.nextLine();
						System.out.print("수정할 비밀번호를 재입력해주세요: ");
						String confirmPw = scan.nextLine();
						if(tempPw.equals(confirmPw)) {
							
							boolean result = Validation.pwInspection(tempPw);
							if(result == true) {
								info[2] = tempPw;
								loop = false;
								out = false;
								break;
							}
						}
						if(loop == true) {
							System.out.println("비밀번호를 다시 입력해주세요.");
						}
					}
					
				}else if(input.equals("3")) {
					boolean loop = true;
					
					while(loop) {
						//수정이 필요
						System.out.println("------------------------------------------------");
						System.out.print("수정할 전화번호를 입력해주세요: ");
						String tempPhone = scan.nextLine();
						boolean result = Validation.storePhoneNumberInspection(tempPhone);
						if(result == true) {
							info[6] = tempPhone;
							loop = false;
							out = false;
							break;
						}
						if(loop == true) {
							System.out.println("전화번호를 다시 입력해주세요.");
						}
					}

				}else if(input.equals("4")) {

					System.out.println("------------------------------------------------");
					System.out.print("수정할 주소를 입력해주세요: ");
					String tempAddress = scan.nextLine();
					info[7] = tempAddress;
					out = false;

				}else if(input.equals("5")) {

					System.out.println("------------------------------------------------");
					System.out.print("수정할 상세주소를 입력해주세요: ");
					String tempDetailAddress = scan.nextLine();
					info[8] = tempDetailAddress;
					out = false;

				}else if(input.equals("6")) {
					System.out.println("------------------------------------------------");
					System.out.print("수정할 활동지역을 입력해주세요: ");
					String tempArea = scan.nextLine();
					info[9] = tempArea;
					out = false;

				}else if(input.equals("0")) {
					System.out.println("------------------------------------------------");
					System.out.println("이전화면으로 돌아갑니다.");
					ShowData.customerInfo(id);
					System.out.println("------------------------------------------------");
				}else {
					System.out.println("------------------------------------------------");
					System.out.println("잘못입력했습니다.");
					System.out.println("------------------------------------------------");
					//modify(id);
				}
				
			}
			
			if(out == false) {
				break;
			}
			
			
		}
		
		String result = MakeForm.makeForm(info);
		
		for(int i = 0; i <data.size(); i++) {
			
			String[] tempLine = data.get(i).split(",");
			if(tempLine[1].equals(id)) {
				data.set(i, result);
			}
			
		}
		
		TotalRoad.dataSave(data, "r");
		ShowData.riderInfo(id);
	}


}
