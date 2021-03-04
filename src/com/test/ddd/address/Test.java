package com.test.ddd.address;

public class Test {
	
	public static void main(String[] args) {
		
		Address ad = new Address("서울특별시 강남구 역삼동 강남대로102길 41");
		
		System.out.println(ad.getPointX());
		System.out.println(ad.getPointY());
		
	}

}
