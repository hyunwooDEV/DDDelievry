package com.test.ddd.fileroad;

import java.util.ArrayList;

import com.test.ddd.store.Store;

public class ObjectArray {
	
	public static void main(String[] args) {
		
		ArrayList<Store> store = storeArray();
		
	}
	
	public static ArrayList<Store> storeArray() {
		
		ArrayList<String> list = TotalRoad.dataRoad("s");
		
		ArrayList<String> store = new ArrayList<String>();
		
		for(int i=0 ; i<list.size(); i++) {
			
			String[] info = list.get(i).split(",");
			
			store.add(info[1]);
			
		}
		
		ArrayList<Store> storeArrays = new ArrayList<Store>();
		
		for(int i=0 ; i < store.size(); i++) {
			storeArrays.add(new Store(store.get(i)));
		}
		
		return storeArrays;
	}

}
