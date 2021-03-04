package com.test.ddd.rider;

import java.util.ArrayList;
import java.util.Scanner;

import com.test.ddd.customer.Customer;
import com.test.ddd.fileroad.TotalRoad;
import com.test.ddd.store.Store;
import com.test.ddd.validation.Validation;

public class Modify {
	
	public static void main(String[] args) {
		
//		modifyStore("s_sist0000");
		//modifyRider(id);
		
	}
	
	//수정화면
	//고객 수정화면
	//1. 이름 2.비밀번호 3.생년월일 4.전화번호 5.주소 6.상세주소 7.카드번호 8.선호음식
	public static void modify(String id) {
		
		Scanner scan = new Scanner(System.in);
		

		System.out.println("*삭제는 카드번호와 선호음식만 가능합니다.");
		System.out.print("수정/삭제할 항목 번호를 입력해주세요: ");
		
		String input = scan.nextLine();
		
		Customer c = new Customer(id);
		
		ArrayList<String> data = TotalRoad.dataRoad("c");
		
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
						System.out.print("수정할 생년월일을 입력해주세요(yyyyMMdd): ");
						String tempBirth = scan.nextLine();
						boolean result = Validation.birthInspection(tempBirth, "yyyyMMdd");
						if(result == true) {
							info[4] = tempBirth;
							loop = false;
							out = false;
							break;
						}
						if(loop == true) {
							System.out.println("생년월일를 다시 입력해주세요.");
						}
					}
				}else if(input.equals("4")) {
					boolean loop = true;
					
					while(loop) {

						System.out.println("------------------------------------------------");
						System.out.print("수정할 전화번호를 입력해주세요: ");
						String tempPhone = scan.nextLine();
						boolean result = Validation.phoneInspection(tempPhone);
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

					System.out.println(info[6]);
				}else if(input.equals("5")) {

					System.out.println("------------------------------------------------");
					System.out.print("수정할 주소를 입력해주세요: ");
					String tempAddress = scan.nextLine();
					info[7] = tempAddress;
					out = false;
				}else if(input.equals("6")) {

					System.out.println("------------------------------------------------");
					System.out.print("수정할 주소를 입력해주세요: ");
					String tempAddress = scan.nextLine();
					System.out.println(info[8]);
					info[8] = tempAddress;
					out = false;
				}else if(input.equals("7")) {
					boolean loop = true;
					
					while(loop) {

						System.out.println("------------------------------------------------");
						System.out.println("*삭제할 경우에는 '삭제'라고 입력해주세요.");
						System.out.print("수정할 카드번호를 입력해주세요: ");
						String tempCard = scan.nextLine();
						boolean result = Validation.cardNumInspection(tempCard);
						if(result == true) {

							info[12] = tempCard;
							loop = false;
							out = false;
							break;
						}
						if(tempCard.equals("삭제")) {
							info[12] = "1";
							loop = false;
							out = false;
							break;
						}
						if(loop == true) {
							System.out.println("카드번호를 다시 입력해주세요.");
						}
					}

				}else if(input.equals("8")) {
					boolean loop = true;
					
					while(loop) {

						System.out.println("------------------------------------------------");
						System.out.println("*삭제할 경우에는 '삭제'라고 입력해주세요.");
						System.out.print("수정할 선호카테고리를 입력해주세요: ");
						String tempFood = scan.nextLine();
						boolean result = Validation.foodInspection(tempFood);
						if(result == true) {
							info[11] = tempFood;
							loop = false;
							out = false;
							break;
						}
						if(tempFood.equals("삭제")) {
							info[11] = "선택안함";
							loop = false;
							out = false;
							break;
						}
						if(loop == true) {
							System.out.println("선호카테고리를 다시 입력해주세요.");
						}
					}

				}else if(input.equals("0")) {
					System.out.println("------------------------------------------------");
					System.out.println("이전화면으로 돌아갑니다.");
					ShowData.customerInfo(id);
					System.out.println("------------------------------------------------");
				}else {
					System.out.println("------------------------------------------------");
					System.out.println("잘못입력했습니다.");
					System.out.println("------------------------------------------------");
					modify(id);
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
		
		TotalRoad.dataSave(data, "c");
		ShowData.customerInfo(id);
		
	}
	
	//스토어 수정화면
	//1. 이름 2.비밀번호 3.전화번호 4.주소 6.소개글
	public static void modifyStore(String id) {
		
		Scanner scan = new Scanner(System.in);
		

		System.out.print("수정항목 번호를 입력해주세요: ");
		
		String input = scan.nextLine();
		
		Store s = new Store(id);
		
		ArrayList<String> data = TotalRoad.dataRoad("s");
		
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
						if(tempName.length() < 15) {
							info[9] = tempName;
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
							info[14] = tempPhone;
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
					info[13] = tempAddress;
					out = false;

				}else if(input.equals("5")) {

					System.out.println("------------------------------------------------");
					System.out.print("운영시간을 입력해주세요(00:00~00:00): ");
					String tempTime = scan.nextLine();
					String[] tempSplit = tempTime.split("~");
					info[10] = tempSplit[0];
					info[11] = tempSplit[1];
					out = false;

				}else if(input.equals("6")) {
					boolean loop = true;
					
					while(loop) {

						System.out.println("------------------------------------------------");
						System.out.print("수정할 소개글을 입력해주세요(20자 이내): ");
						String tempIntroduce = scan.nextLine();
						if(tempIntroduce.length() < 20) {

							info[12] = tempIntroduce;
							loop = false;
							out = false;
							break;
						}
						if(loop == true) {
							System.out.println("소개글을 다시 입력해주세요.");
						}
					}

				}else if(input.equals("7")) {
					boolean loop = true;
					
					while(loop) {

						System.out.println("------------------------------------------------");
						System.out.print("광고여부를 입력하세요(탈퇴-0,가입-1): ");
						String tempAd = scan.nextLine();
						
						if(tempAd.equals("1")) {
							info[20] = "1";
							info[19] = "0.05";
						}else {
							info[20] = "0";
							info[19] = "0.03";
						}
						loop = false;
						out = false;
						
					}

				}else if(input.equals("0")) {
					System.out.println("------------------------------------------------");
					System.out.println("이전화면으로 돌아갑니다.");
					ShowData.customerInfo(id);
					System.out.println("------------------------------------------------");
				}else {
					System.out.println("------------------------------------------------");
					System.out.println("잘못입력했습니다.");
					System.out.println("------------------------------------------------");
					modify(id);
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
		
		TotalRoad.dataSave(data, "s");
		ShowData.storeInfo(id);
	}
	
	//라이더 수정화면
	//1. 이름 2.비밀번호 3.전화번호 4.주소 5.상세주소 6.활동지역
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
					RiderMenu rm = new RiderMenu();
					rm.riderMenu(id);
					System.out.println("------------------------------------------------");
				}else {
					System.out.println("------------------------------------------------");
					System.out.println("잘못입력했습니다.");
					System.out.println("------------------------------------------------");
					modify(id);
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
