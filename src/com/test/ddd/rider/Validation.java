package com.test.ddd.rider;

import java.io.BufferedReader;
import java.io.FileReader;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Locale;

import com.test.ddd.fileroad.FileRoad;

public class Validation {

	// idInspection(String id) : id
	// pwInspection(String pw) : pw
	// nameInspection(String name) : 이름
	// birthInspection(Stirng birth, String format) : 생년월일
	// phoneInspection(String phoneNumber) : 핸드폰번호
	// cardNumInspection(String cardNumber) : 카드번호
	// registrationNumInspection(String number) : 사업자등록 번호
	// cleanInspection(String clean) : 위생등급
	// foodInspection(String food) : 선호음식
	// storePhoneNumberInspection(String storePhone) : 업체 전화번호

	// id 유효성 검사 - 중복 검사도 포함
	
	public static void main(String[] args) {
		
	}
	
	//position은 고객은 "c", 가게는 "s", 라이더 "r" 를 넣어주시면 됩니다.
	public static boolean idInspection(String id, String position) {

		boolean result = false;

		if (id.length() >= 4 && id.length() <= 16) {

			for (int i = 0; i < id.length(); i++) {
				if (id.charAt(0) >= 'a' && id.charAt(0) <= 'z') {
					if ((id.charAt(i) >= '0' && id.charAt(i) <= '9') || (id.charAt(i) >= 'a' && id.charAt(i) <= 'z')
							|| id.charAt(i) == '_') {

						result = true;

						ArrayList<String> exist = new ArrayList<String>();
						try {
							
							String path = "";
							
							if(position == "c") {
								path = FileRoad.CUSTOMERFINAL;
							}else if(position == "s") {								
								path = FileRoad.STOREFINAL;
							}else if(position == "r") {														
								path = FileRoad.RIDERFINAL;
							}
							BufferedReader reader = new BufferedReader(new FileReader(path));
							String line = null;

							while ((line = reader.readLine()) != null) {

								String[] info = line.split(",");
								exist.add(info[1]);

							}

							reader.close();

						} catch (Exception e) {
							System.out.println("Validation.idInspection()");
							e.printStackTrace();
						}

						for (int j = 0; j < exist.size(); j++) {

							if (exist.get(j).equals(id)) {
								result = false;
								break;
							} else {
								result = true;
							}

						}

					} else {
						result = false;
						break;
					}
				} else {
					result = false;
					break;
				}
			}
		} else {

			result = false;
		}

		return result;
	}

	// pw 유효성 검사
	public static boolean pwInspection(String pw) {

		boolean result = false;

		if (pw.length() >= 10 && pw.length() <= 16) {

			for (int i = 0; i < pw.length(); i++) {

				if ((pw.charAt(i) >= '0' && pw.charAt(i) <= '9') || (pw.charAt(i) >= 'a' && pw.charAt(i) <= 'z')
						|| (pw.charAt(i) >= 'A' && pw.charAt(i) <= 'Z')) {

					result = true;

				} else {
					result = false;
					break;
				}

			}
		} else {
			result = false;
		}

		return result;
	}

	// 이름 유효성 검사
	public static boolean nameInspection(String name) {

		boolean result = false;

		if (name.length() >= 2 && name.length() <= 5) {

			for (int i = 0; i < name.length(); i++) {

				if ((name.charAt(i) >= '가' && name.charAt(i) <= '힣')) {

					result = true;

				} else {
					result = false;
					break;
				}

			}

		}

		return result;

	}

	// 생년월일 유효성 검사
	public static boolean birthInspection(String birth, String format) {

		SimpleDateFormat dateFormatParser = new SimpleDateFormat(format, Locale.KOREA);
		dateFormatParser.setLenient(false);

		// 현재 날짜를 format형식(yyyyMMdd)으로 변경
		LocalDateTime current = LocalDateTime.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern(format);

		String today = current.format(formatter);

		// 현재 날짜와 입력받은 생년월일 빼기
		int diff = Integer.parseInt(today) - Integer.parseInt(birth);

		if (diff >= 0) {// 생년월일이 현재 날짜 이전인가

			try {// 유효한 날짜인가
				dateFormatParser.parse(birth);
				return true;
			} catch (Exception Ex) {
				return false;
			}
		} else
			return false;

	}

	// 핸드폰 유효성 검사 - 중복검사 포함
	public static boolean phoneInspection(String phoneNumber) {

		boolean result = false;

		String phone = phoneNumber.replace("-", "");

		if (phone.length() >= 10 && phone.length() <= 11) {

			for (int i = 0; i < phone.length(); i++) {

				if ((phone.charAt(i) >= '0' && phone.charAt(i) <= '9')) {

					result = true;

//					String path ="D:\\class\\java\\DDDelivery\\src\\com\\test\\ddd\\dummy\\memberXY_customer.txt";
//
//					ArrayList<String> exist = new ArrayList<String>();
//					try {
//
//						BufferedReader reader = new BufferedReader(new FileReader(FileRoad.CUSTOMERINFO));
//
//						String line = null;
//
//						while ((line = reader.readLine()) != null) {
//
//							String[] info = line.split(",");
//							exist.add(info[6]);
//
//						}
//
//						reader.close();
//
//					} catch (Exception e) {
//						System.out.println("Validation.idInspection()");
//						e.printStackTrace();
//					}
//
//					for (int j = 0; j < exist.size(); j++) {
//
//						if (exist.get(j).equals(phone)) {
//							result = false;
//							break;
//						} else {
//							result = true;
//						}
//
//					}

				} else {
					result = false;
					break;
				}
			}

		}

		return result;
	}

	// 업체 전화번호 유효성 검사 - 중복 검사 포함
	public static boolean storePhoneNumberInspection(String storePhone) {

		boolean result = false;

		String phone = storePhone.replace("-", "");

		if (phone.length() >= 9 && phone.length() <= 11) {

			for (int i = 0; i < phone.length(); i++) {

				if ((phone.charAt(i) >= '0' && phone.charAt(i) <= '9')) {

					result = true;

					// String path =
					// "D:\\class\\java\\DDDelivery\\src\\com\\test\\ddd\\dummy\\store.txt";

					ArrayList<String> exist = new ArrayList<String>();
					try {

						BufferedReader reader = new BufferedReader(new FileReader(FileRoad.STOREINFO));

						String line = null;

						while ((line = reader.readLine()) != null) {

							String[] info = line.split(",");
							exist.add(info[5]);

						}

						reader.close();

					} catch (Exception e) {
						System.out.println("Validation.idInspection()");
						e.printStackTrace();
					}

					for (int j = 0; j < exist.size(); j++) {

						if (exist.get(j).equals(phone)) {
							result = false;
							break;
						} else {
							result = true;
						}

					}

				} else {
					result = false;
					break;
				}
			}

		}

		return result;
	}

	// 카드번호 유효성 검사
	public static boolean cardNumInspection(String cardNumber) {

		boolean result = false;

		String card = cardNumber.replace("-", "");

		if ((card.length() >= 15 && card.length() <= 16) || card.length() == 1) {

			for (int i = 0; i < card.length(); i++) {
				if ((card.charAt(i)) == '1') {
					result = true;
				} else if ((card.charAt(i) >= '0' && card.charAt(i) <= '9')) {

					result = true;
				} else {
					result = false;
					break;
				}
			}

		}

		return result;
	}

	// 사업자 등록 번호 유효성 검사 - 중복검사
	public boolean registrationNumInspection(String number) {

		boolean result = false;

		String companyNum = number.replace("-", "");

		if (companyNum.length() == 10) {

			for (int i = 0; i < companyNum.length(); i++) {
				if ((companyNum.charAt(i) >= '0' && companyNum.charAt(i) <= '9')) {

					result = true;

					// String path =
					// "D:\\class\\java\\DDDelivery\\src\\com\\test\\ddd\\dummy\\store.txt";

					ArrayList<String> exist = new ArrayList<String>();
					try {

						BufferedReader reader = new BufferedReader(new FileReader(FileRoad.STOREINFO));

						String line = null;

						while ((line = reader.readLine()) != null) {

							String[] info = line.split(",");
							exist.add(info[6]);

						}
						reader.close();

					} catch (Exception e) {
						System.out.println("Validation.idInspection()");
						e.printStackTrace();
					}

					for (int j = 0; j < exist.size(); j++) {

						if (exist.get(j).equals(number)) {
							result = false;
							break;
						} else {
							result = true;
						}

					}

				} else {
					result = false;
					break;
				}
			}

		} else {
			result = false;
		}

		return result;

	}

	// 위생등급 유효성 검사
	public boolean cleanInspection(String clean) {

		boolean result = false;

		if (clean.equals("매우우수") || clean.equals("우수") || clean.equals("좋음")) {
			result = true;
		} else {
			result = false;
		}

		return result;
	}

	// 선호음식 유효성 검사
	public static boolean foodInspection(String food) {

		boolean result = false;

		if (food.equals("한식") || food.equals("일식") || food.equals("중식") || food.equals("양식") || food.equals("분식")
				|| food.equals("치킨") || food.equals("패스트푸드") || food.equals("디저트") || food.equals("입력안함")) {
			result = true;
		} else {
			result = false;
		}

		return result;
	}

}
