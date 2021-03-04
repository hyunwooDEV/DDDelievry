package com.test.ddd.rider;

public class MakeForm {
	
	//배열을 입력하면 요소 사이에 ','를 추가
	public static String makeForm(String[] info) {
		
		String result = "";
		
		for(int i=0; i<info.length; i++) {
			
			result += info[i] + ",";
			
		}
		
		result = result.substring(0, result.length()-1);
		
		return result;
		
		
	}

}
