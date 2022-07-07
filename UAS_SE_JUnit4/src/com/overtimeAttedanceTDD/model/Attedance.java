package com.overtimeAttedanceTDD.model;

/*
 * pada class ini saya mengimport java util map dan hashmap
 * karena saya akan menyimpan pinalty per hour dari setiap posisi
 */
import java.util.HashMap;
import java.util.Map;

public class Attedance {
	
	/*
	 * didalam class attedance saya membuat method dimana nanti akan menerima pasing
	 * string yang diinput user untuk posisi jabatan employee di class main
	 * lalu nanti apabila user menginputkan kosong maka akan menthrow exception "input shouldnt be empty"
	 * lalu apabila user tidak menginputkan kosong maka program akan mencocokan posisi yang diinput user
	 * dengan posisi yang sudah disimpan pada Map apabila yang diinputkan user tidak ada yang equals dengan posisi yang
	 * disimpan di map maka akan throw exception lagi "Invalid Input"
	 * jika input user ada yang equals dengan psosisi yang disimpan di map maka method akan mereturn
	 * nilai int pinalty per hour untuk posisi tersebut
	 * contoh Admin 25000, pada posisi admin apabila telat absen pinalty 1 jam nya sebesar 25000
	 * maka method akan mereturn 25000
	 */
	public int getAttedancePerHour(String position) {
		// TODO Auto-generated method stub
		Map<String, Integer> attedanceMap = null;
		int attedancePinalty = 0;
		if(position.isEmpty()) {
			throw new NullPointerException("Input Shouldn't be empty");
		}
		attedanceMap = getAttedanceStatistic();
		if(!attedanceMap.containsKey(position)) {
			throw new NullPointerException("Invalid Input");
		} else {
			attedancePinalty = attedanceMap.get(position);
		}
		return attedancePinalty;
	}
	
	/*
	 * dan saya menyimpan datanya didalam map dengan ketentuan yang sama seperti di soal
	 */
	private Map<String, Integer> getAttedanceStatistic() {
		Map<String, Integer> attedanceMap = new HashMap<>();
		attedanceMap.put("Admin", 25000);
		attedanceMap.put("Officer", 50000);
		attedanceMap.put("Supervisor", 75000);
		return attedanceMap;
	}

}

