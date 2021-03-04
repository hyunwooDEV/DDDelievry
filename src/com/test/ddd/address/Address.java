package com.test.ddd.address;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

import com.test.ddd.fileroad.FileRoad;

public class Address {
	
	private double pointX;
	private double pointY;
	
	public Address() {
		
	}
	
	public Address(String address) {
		
		String path = FileRoad.YEOKSAM;
		
		ArrayList<String> list = new ArrayList<String>();
		try {

			BufferedReader reader = new BufferedReader(new FileReader(path));
			
			String line = null;
			
			while((line = reader.readLine()) != null) {
				
				String[] info = line.split(",");
				if(info[0].equals(address)) {
					String[] temp = info[1].split("/");
					this.pointX = Double.parseDouble(temp[0]);
					this.pointY = Double.parseDouble(temp[1]);
				}
				
			}
			
			reader.close();

		} catch (Exception e) {
			System.out.println("Customer.Customer()");
			e.printStackTrace();
		}
		
	}

	public double getPointX() {
		return pointX;
	}

	public void setPointX(double pointX) {
		this.pointX = pointX;
	}

	public double getPointY() {
		return pointY;
	}

	public void setPointY(double pointY) {
		this.pointY = pointY;
	}
	
	
	
	
}
