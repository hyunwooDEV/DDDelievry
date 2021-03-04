package com.test.ddd.store;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Random;

import com.test.ddd.fileroad.FileRoad;
//import com.test.ddd.fileroad.FileRoad_yiqian;
import com.test.ddd.validation.Validation;

//import com.test.ddd.validation.Validation;



public class StoreJoin {

	
	public static void main(String[] args) throws IOException {
		
		
		
	
	}
	public static void storeJoin() {
		Validation v1 = new Validation();
		FileRoad f = new FileRoad();
		int num = 0;
		try {
			
			BufferedWriter writer = new BufferedWriter(new FileWriter(f.STOREFINAL, true));
																	
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			
			BufferedReader storeMemNum = new BufferedReader(new FileReader(f.STOREFINAL));//행개수 구하기 위한 버퍼드리더

			Store store = new Store();
			ArrayList<String> newStore = new ArrayList<String>();
			
			
			String line = null;
			
			while((line = storeMemNum.readLine()) != null) {
				num++;
			}
			store.setStoreMemberNum(String.format("C%03d",num));
//			System.out.println(num);
			
//			writer.write(store.getStoreMemberNum());
			
			
			//업체 회원가입
				
			//업체 회원가입 들어갈 요소 :
			// - 아이디, 비밀번호, 오너 이름, 오너 성별, 오너 생년월일, 오너 전화번호, 오너 집주소, 업체명, 업체 카테고리, [메뉴(음식, 가격) - 다른페이지에서 설정], 오픈시간, 마감시간, 소개글, 업체 주소, 업체 상세 주소, 업체 전화번호, 사업자등록번호, 위생등급, 평균배달 소요시간, 배달비, 광고 서비스 이용 유무  
			// - 수정 : [회원번호], ID, PW, 오너이름, 오너생년월일, 오너성별, 오너 핸드폰번호, 주소, 상세주소, 업체명, 영업시작시간, 영업종료시간, 소개글, 업체주소, 업체전화번호, 사업자번호, [청결등급- 내가입력하기], 배달시간, 배달비용, [수수료], 광고사용여부, [매출액], [평점], 카테고리, [탈퇴여부]

			
			
			
			System.out.print("------------------------------\n");
			System.out.println("       회원가입[업체]");
			System.out.print("------------------------------\n");

				
			System.out.print("※ 4~16자 영어, 숫자만 입력 가능(소문자로만 입력해주세요. 첫글자는 영소문자로 입력해주세요.)");//질문
			System.out.println();
			
			
			boolean loop = true;
			while(loop) {
				System.out.print("▶ ID : ");
				String sStoreID = reader.readLine();
				if (v1.idInspection(sStoreID,"s") == true) {
					store.setStoreID(sStoreID);	
					loop = false;
				} else {
					System.out.println("※ ID 형식에 맞지 않습니다. 다시 입력해주세요.");
				}
			}
//			System.out.println(store.getStoreID());
			
//			reader.readLine();
			

			
			System.out.print("------------------------------\n");
			System.out.print("※ 10~16자 영어 대(소)문자, 숫자만 입력 가능\n");
			
			loop = true;
			while(loop) {
				System.out.print("▶ PW : ");
				String sStorePW = reader.readLine();
				if (v1.pwInspection(sStorePW) == true) {
					store.setStorePW(sStorePW);
					loop = false;				
				} else {
					System.out.println("※ 패스워드 형식에 맞지 않습니다. 다시 입력해주세요.");
				}
			}
			
			
			
			
			
			System.out.print("------------------------------\n");
			System.out.print("※ 2~5자 한글 입력 가능\n");
			
			loop = true;
			while(loop) {
				System.out.print("▶ 사용자 이름 : ");
				String sName = reader.readLine();
				if (v1.nameInspection(sName) == true) {
					store.setName(sName);
					loop = false;
				} else {
					System.out.println("※ 이름 형식에 맞지 않습니다. 다시 입력해주세요.");
				}
			}
			
			
			
			System.out.print("------------------------------\n");
			System.out.print("※ yyyymmdd 형식으로 입력해주세요.\n");
			
			loop = true;
			while(loop) {
				System.out.print("▶ 생년월일 : ");
				String sBirth = reader.readLine();
				if (v1.birthInspection(sBirth, "yyyyMMdd") == true) {
					store.setBirth(sBirth);
					loop = false;
				} else {
					System.out.println("※ yyyymmdd 형식으로 다시 입력해주세요.");
				}
			}
			
			
			
			
			System.out.print("------------------------------\n");
			System.out.print("※ 남자는 1을 입력, 여자는 2를 입력해주세요.\n");
			
			loop = true;
			while(loop) {
				System.out.print("▶ 성별 : ");
				String sGender = reader.readLine();
				if (sGender.equals("1") || sGender.equals("2")) {
					store.setGender(sGender);
					loop = false;
				} else {
					System.out.println("※ 성별 형식에 맞지 않습니다. 다시 입력해주세요.");
				}
			}
			
			
			
			
			System.out.print("------------------------------\n");
			
			loop = true;
			while(loop) {
				System.out.print("▶ 사용자 휴대폰 번호 : ");
				String sPhoneNum = reader.readLine();
				if (v1.phoneInspection(sPhoneNum) == true) {
					store.setPhoneNum(sPhoneNum);
					loop = false;
				} else {
					System.out.println("※ 휴대폰 번호를 다시 입력해주세요.");
				}
			}
			
			
			
			System.out.print("------------------------------\n");
			System.out.print("※ 주소를 도로번호까지 입력해주세요(자택)\n");
			System.out.print("▶ 주소 : ");
			store.setStoreOwnerAddress(reader.readLine());
			
			
			System.out.print("------------------------------\n");
			System.out.print("※ 상세주소를 입력해주세요(자택)\n");
			System.out.print("▶ 상세 주소 : ");
			store.setStoreOwnerAddressDetail(reader.readLine());
			
			
			System.out.print("------------------------------\n");
			System.out.print("▶ 업체명 : ");
			store.setStoreName(reader.readLine());
			
			
			System.out.print("------------------------------\n");
			System.out.print("※ 매장 오픈 시간을 적어주세요.\n");
			System.out.print("※ 형식 예시 : 11:00\n");
			loop = true;
			while(loop) {
				System.out.print("▶ 운영 시간(오픈) : ");
				String sOpenTime = reader.readLine();
				if (sOpenTime.length()>=3 && sOpenTime.length()<=5) {
					store.setOpenTime(sOpenTime);
					loop = false;
				} else {
					System.out.println("※ 시간 형식에 맞지 않습니다. 다시 입력해주세요.");
				}
			}
			
			
			
			System.out.print("------------------------------\n");
			System.out.print("※ 매장 운영 마감 시간을 적어주세요.\n");
			System.out.print("※ 형식 예시 : 20:00\n");
			loop = true;
			while(loop) {
				System.out.print("▶ 운영 시간(마감) : ");
				String sCloseTime = reader.readLine();
				if (sCloseTime.length()>=3 && sCloseTime.length()<=5) {
					store.setCloseTime(sCloseTime);
					loop = false;
				} else {
					System.out.println("※ 시간 형식에 맞지 않습니다. 다시 입력해주세요.");
				}
			}
			
			
			
			
			System.out.print("------------------------------\n");
			System.out.print("※ 매장 소개글을 20자 이하로 적어주세요.\n");
			loop = true;
			while(loop) {
				System.out.print("▶ 소개글 : ");
				String sIntroduction = reader.readLine();
				if (sIntroduction.length()>=0 && sIntroduction.length()<=20) {
					store.setStoreIntroduction(sIntroduction);
					loop = false;
				} else {
					System.out.println("※ 매장 소개글을 20자 이하로 다시 입력해주세요.");
				}
			}
			
			
			
			
			System.out.print("------------------------------\n");
			System.out.print("※ 매장 주소를 입력해주세요(매장)\n");
			System.out.print("▶ 주소 : ");
			store.setAddress(reader.readLine());

			
			
			
			System.out.print("------------------------------\n");
			System.out.print("※ 지역번호를 포함한 매장 전화번호를 입력해주세요.\n");
			loop = true;
			while(loop) {
				System.out.print("▶ 매장 전화 번호 : ");
				String sStorePhoneNum = reader.readLine();
				if (v1.storePhoneNumberInspection(sStorePhoneNum) == true) {
					store.setStorePhoneNum(sStorePhoneNum);
					loop = false;
				} else {
					System.out.println("※ 지역번호를 포함한 매장 전화번호를 다시 입력해주세요.");
				}
			}
			
			
						
			
			System.out.print("------------------------------\n");
			System.out.print("※ '-'없이 10자리로 입력해주세요.\n");
			loop = true;
			while(loop) {
				System.out.print("▶ 사업자 등록번호 : ");
				String sLicense = reader.readLine();
				if (v1.registrationNumInspection(sLicense) == true) {
					store.setLicenseNum(sLicense);
					loop = false;
				} else {
					System.out.println("※ 사업자 등록번호를 형식에 맞게 다시 입력해주세요.");
				}
			}
			
			
		
			System.out.print("------------------------------\n");

			String RandomSanitationGrade[] = { "매우우수","우수","우수","우수","좋음" };
			 
		    Random oRandom = new Random();
		    int randSan = oRandom.nextInt(RandomSanitationGrade.length);
		    store.setSanitationGrade(RandomSanitationGrade[randSan]);
//		    System.out.printf("▶ 위생등급 : %s\n", RandomSanitationGrade[randSan]);

			
		    
			
			System.out.print("------------------------------\n");
			System.out.print("※ 평균 배달 소요시간을 분단위로 입력해주세요.\n");
			System.out.print("※ 형식 예시 : 70\n");
			System.out.print("▶ 평균 배달 소요시간(분) : ");
			store.setDeliveryTime(reader.readLine());
//			System.out.println(store.getDeliveryTime());
			
			
			
			System.out.print("------------------------------\n");
			System.out.print("※ 매장의 배달비를 입력해주세요.\n");
			System.out.print("※ 형식 예시 : 3000\n");
			System.out.print("▶ 배달비(원) : ");
			store.setDeliveryCost(reader.readLine());
//			System.out.println(store.getDeliveryCost());
			
			
			
			System.out.print("------------------------------\n");
			System.out.print("※ 광고 사용 여부를 알려주세요.\n");
			System.out.print("※ 사용을 원하면 1, 원하지 않으면 2를 입력해주세요\n");
			loop = true;//
			while(loop) {
				System.out.print("▶ 광고 사용 여부 : ");
				String sAD = reader.readLine();
				if (sAD.equals("1") || sAD.equals("2")) {
					store.setAd(sAD);
					loop = false;
				} else {
					System.out.println("※ 사용을 원하면 1, 원하지 않으면 2를 입력해주세요.");
				}
			}
//			System.out.println(store.getAd());
			
		    
		    
			//수수료 (광고 사용여부가 1이면 0.05, 2이면 0.03으로 계산)
			if (store.getAd() == "1") {
				store.setChargeGrade("0.05");
			} else {
				store.setChargeGrade("0.03");
			}
		    
		    
			
			//매출액 0원 넣기 String
			store.setSales("0");
			
			
			//평점 3점 넣기
			store.setStoreScore("3");
			
			System.out.print("------------------------------\n");
			loop = true;
			while(loop) {
				System.out.print("[음식 카테고리]\n 한식 \\\t일식 \\\t중식 \\\t양식 \\\t분식 \r 치킨 \\\t패스트푸드 \\ 디저트\n");
				System.out.print("▶ 판매 음식의 카테고리를 한가지만 입력해주세요 : ");
				String sCategory = reader.readLine();
				if (v1.foodInspection(sCategory) == true) {
					store.setCategory(sCategory);
					loop = false;
				} else {
					System.out.println("※ 음식 카테고리에 맞지 않습니다. 다시 입력해주세요.");
				}
			}
//			
//			
//			//탈퇴여부 0으로 넣기
			store.setStoreDelete("0");
			System.out.print("------------------------------\n");
	

			
			//[회원번호], ID, PW, 오너이름, 오너생년월일, 오너성별, 오너 핸드폰번호, 주소, 상세주소,
			//업체명, 영업시작시간, 영업종료시간, 소개글, 업체주소, 업체전화번호, 사업자번호, 
			//[청결등급- 내가입력하기], 배달시간, 배달비용, [수수료], 광고사용여부, [매출액], [평점],
			//카테고리, [탈퇴여부]
			String result = String.format("%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s\n"
					,store.getStoreMemberNum(),store.getStoreID(),store.getStorePW(),store.getName(),store.getBirth()
					,store.getGender(),store.getPhoneNum(),store.getStoreOwnerAddress(),store.getStoreOwnerAddressDetail()
					,store.getStoreName(),store.getOpenTime(),store.getCloseTime(),store.getStoreIntroduction(),store.getAddress()
					,store.getStorePhoneNum(),store.getLicenseNum(),store.getSanitationGrade(),store.getDeliveryTime(),store.getDeliveryCost()
					,store.getChargeGrade(),store.getAd(),store.getSales(),store.getStoreScore()
					,store.getCategory(),store.getStoreDelete());
			
			
			newStore.add(result);
			
			
			writer.write(result);
//			
			writer.close();
			
			System.out.println("저장 완료");

			
			
			
			
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
	
	}//main
	
}//StoreJoin_class
