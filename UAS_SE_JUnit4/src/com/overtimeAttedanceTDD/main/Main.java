package com.overtimeAttedanceTDD.main;

import java.util.Scanner;
import com.overtimeAttedanceTDD.model.*;

/* 2440040822 - Chaerul Hamdan
 * 
 */

public class Main {
	
	/*
	 * pertama saya set basic salary nya di 10 juta
	 */
	
	Scanner input = new Scanner(System.in);
	int totalSalary = 10000000;

	public Main() {
		// TODO Auto-generated constructor stub
		boolean running = true;
		/*
		 * lalu saya buat 3 menu
		 * dimana menu pertama adalah untuk masalah absensi
		 * dan menu 2 adalah masalah overtime
		 * lalu terakhir adalah exit
		 */
		do {
			System.out.println("1. Attedance");
			System.out.println("2. Overtime");
			System.out.println("3. Exit");
			System.out.print(">> ");
			int option = input.nextInt();
			input.nextLine();
			switch (option) {
			case 1:
				/*
				 * apabila memilih menu 1 maka akan menuju method Attedance yang berada di bawah
				 */
				Attedance();
				break;
			case 2:
				/*
				 * apabila memilih menu 2 maka akan menuju method Overtime yang berada di bawah
				 */
				Overtime();
				break;
			case 3:
				running = !running;
				break;
			}
		}while(running);
	}

	/*
	 * pada method overtime maka nanti user akan menginputkan posisi employee yang ingin mengajukan overtime
	 * lalu nanti akan memanggil class Overtime di package com.overtimeAttedance.model
	 * yang dimana class tersebut berfungsi untuk mengecek pay per hour dari setiap jabatan employee
	 * method di class overtime sebelumnya sudah di Test Drive Develop dan saya menggunakan JUnit 4
	 * yang berada di package com.overtimeAttedance.example di class OvertimeTest
	 * disana saya menggunakan @Test dimana mengecek untuk menyamakan, input empty, dan wrong input
	 */
	private void Overtime() {
		// TODO Auto-generated method stub
		/*
		 * kembali lagi ke method overtime disini user menginputkan posisi atau jabatan dari employee
		 * lalu nanti akan keluar pay per hour untuk posisi yang diinput yang dipasing dari clas Overtime
		 * yang disimpan di variable payPerHour, lalu user akan diminta menginput berapa banyak jam yang diajukan
		 * untuk overtime, dan user tidak boleh menginput lebih dari 10 karena maksimal adalah 10 jam per week
		 * lalu setelah itu maka sistem akan menjumlahkan gaji poko dengan total payPerHour * hour
		 */
		System.out.print("Input posisition that will do overtime :");
		String posisition = input.nextLine();
		Overtime overtime = new Overtime();
		int payPerHour = overtime.getOvertimePerHour(posisition);
		int hour = 0;
		do {
			System.out.print("Input hour [1-10] :");
			hour = input.nextInt();
			input.nextLine();
		}while(hour < 1 || hour > 10);
		totalSalary += (payPerHour * hour);
		System.out.println("Total Salary : "+totalSalary);
		input.nextLine();
	}
	
	/*
	 * pada method attedance maka nanti user akan menginputkan posisi employee yang telat datang
	 * lalu kita akan memanggil class Attedance di package com.overtimeAttedance.model
	 * yang dimana class tersebut berfungsi untuk mengecek pinalty per hour dari setiap jabatan employee
	 * method di class Attedance sebelumnya sudah di Test Drive Develop dan saya menggunakan JUnit 4
	 * yang berada di package com.overtimeAttedance.example di class AttedanceTest
	 * disana saya menggunakan @Test dimana mengecek untuk menyamakan, input empty, dan wrong input
	 * karena semuanya dari merah sudah menjadi hijau jadi step saya lanjutkan
	 */

	private void Attedance() {
		// TODO Auto-generated method stub
		/*
		 * kembali lagi ke method attedance disini user menginputkan posisi lalu nanti akan keluar
		 * pinalti per hour sesuai posisi masing masing yang sudah disimpan dalam sebuah map
		 * lalu nanti user akan menginputkan jumlah jam keterlambatan
		 * setelah itu maka gaji pokok akan dikurangi dengan pinaltyPerHour * Hour
		 */
		System.out.print("Input posisition that is late for work :");
		String posisition = input.nextLine();
		Attedance attedance = new Attedance();
		int pinaltyPerHour = attedance.getAttedancePerHour(posisition);
		System.out.print("Input hour = :");
		int hour = input.nextInt();
		input.nextLine();
		totalSalary -= (pinaltyPerHour*hour);
		System.out.println("Total Salary : "+totalSalary);
		input.nextLine();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Main();
	}

}
