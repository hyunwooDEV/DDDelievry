package com.test.ddd.address;

public class DistanceCalculation {
	
	public static int distance(double x1, double y1, double x2, double y2) {
		
		int result = 0;
		
		
		result = (int) Math.round(Math.sqrt((int)(Math.pow((x1-x2), 2)) + (int)(Math.pow((y1-y2), 2))));
		
		
		return result;
		
	}

}
