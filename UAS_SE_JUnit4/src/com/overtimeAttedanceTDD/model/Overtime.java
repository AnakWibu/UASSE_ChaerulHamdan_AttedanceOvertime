package com.overtimeAttedanceTDD.model;

/*
 * pada class ini saya mengimport java util map dan hashmap
 * karena saya akan menyimpan pinalty per hour dari setiap posisi
 */
import java.util.HashMap;
import java.util.Map;

public class Overtime {

	/*
	 * didalam class overtime saya membuat method dimana nanti akan menerima pasing
	 * string yang diinput user untuk posisi jabatan employee di class main
	 * lalu nanti apabila user menginputkan kosong maka akan menthrow exception "input shouldnt be empty"
	 * lalu apabila user tidak menginputkan kosong maka program akan mencocokan posisi yang diinput user
	 * dengan posisi yang sudah disimpan pada Map apabila yang diinputkan user tidak ada yang equals dengan posisi yang
	 * disimpan di map maka akan throw exception lagi "Invalid Input"
	 * jika input user ada yang equals dengan psosisi yang disimpan di map maka method akan mereturn
	 * nilai int pay per hour untuk posisi tersebut
	 * contoh Admin 75000, pada posisi admin apabila melakukan overtime, pay 1 jam nya sebesar 75000
	 * maka method akan mereturn 75000
	 */
	public int getOvertimePerHour(String position) {
		// TODO Auto-generated method stub
		Map<String, Integer> overtimeMap = null;
		int overtimeSalary = 0;
		if(position.isEmpty()) {
			throw new NullPointerException("Input Shouldn't be empty");
		}
		overtimeMap = getOvertimeStatistic();
		if(!overtimeMap.containsKey(position)) {
			throw new NullPointerException("Invalid Input");
		} else {
			overtimeSalary = overtimeMap.get(position);
		}
		return overtimeSalary;
	}
	/*
	 * dan saya menyimpan datanya didalam map dengan ketentuan yang sama seperti di soal
	 */
	private Map<String, Integer> getOvertimeStatistic() {
		Map<String, Integer> overtimeMap = new HashMap<>();
		overtimeMap.put("Admin", 75000);
		overtimeMap.put("Officer", 50000);
		overtimeMap.put("Supervisor", 25000);
		return overtimeMap;
	}

}

