package com.overtimeAttedanceTDD.example;

/*
 * disini saya menggunakan JUnit 4 untuk TDD
 * lalu saya mengimport assert untuk mengecek
 * dan test untuk mengetest
 */
import org.junit.Assert;
import org.junit.Test;

import com.overtimeAttedanceTDD.model.Overtime;

public class OvertimeTest {

	/*
	 * pada test pertama saya mencoba untuk menyamakan dengan assertEqual untuk mengecek
	 * apakah input yang diinput user akan menghasilkan jawaban yang benar
	 */
	@Test
	public void testCalculateOvertime() {
		String position = "Admin";
		int expectedOvertime = 75000;
		Overtime overtime = new Overtime();
		int count = overtime.getOvertimePerHour(position);
		Assert.assertEquals(expectedOvertime, count);
		/*
		 * dan pada akhirnya hasilnya equals pada map yang saya simpan dan contoh di posisi admin
		 * mendapatkan jawaban yang sama dan test pertama berwarna hijau maka saya melanjutkanya
		 */
	}

	/*
	 * lalu pada test kedua saya mencoba dengan mengetes apabila user menginput empty 
	 * atau user tidak menginputkan apapun
	 */
	@Test(expected=NullPointerException.class)
	public void testCalculateOvertimeWithEmptyInput() {
		String position = "";
		int expectedOvertime = 0;
		Overtime overtime = new Overtime();
		int count = overtime.getOvertimePerHour(position);
		Assert.assertEquals(expectedOvertime, count);
		/*
		 * pada awalnya test akan berwarna merah karena tidak bisa, lalu saya menggunakan
		 * (expected=NullPointerException.class) yang dimana nanti apabila user menginputkan kosong 
		 * sistem akan mentrow exeption error dengan massage yang sudah saya buat
		 * kemuan test menjadi hijau maka saya lanjutkan
		 */
	}
	
	/*
	 * lalu kemungkinan terakhir adalah saya mengetes abila user menginputkan wrong input
	 * atau jawaban yang salah yang tidak tersedia di pilihan
	 */
	@Test(expected=NullPointerException.class)
	public void testCalculateOvertimeWithWrongInput() {
		String position = "XYZ";
		int expectedOvertime = 10000;
		Overtime overtime = new Overtime();
		int count = overtime.getOvertimePerHour(position);
		Assert.assertEquals(expectedOvertime, count);
		/*
		 * pada awalnya test akan berwarna merah karena tidak bisa, lalu saya menggunakan
		 * (expected=NullPointerException.class) yang dimana nanti apabila user menginputkan jawaban yang salah
		 * sistem akan mentrow exeption error dengan massage yang sudah saya buat
		 * kemuan test menjadi hijau maka saya lanjutkan
		 */
	}
}

