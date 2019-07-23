package controllers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

import handleData.dStudent;
import models.mStudent;
import models.result;

public class cDanhSachLop {
	public static ArrayList<mStudent> getListStudentWithClass(String cLass) throws IOException {
		ArrayList<mStudent> listStudentClass = new ArrayList<mStudent>();

		// format : arrayClass[0] = nien_khoa, arrayClass[1] = ma_mon
		String arrayClass[] = cLass.split("\\-");

		for (mStudent student : dStudent.getListStudent()) {
			String arrayCacMon[] = student.getCacMon().split("\\|");

			// check ma_mon co thuoc cac mon ma sinh vien dang hoc ko
			boolean check = Arrays.stream(arrayCacMon).anyMatch(arrayClass[1]::equals);

			if (student.getNienKhoa().equals(arrayClass[0]) && check) {
				listStudentClass.add(student);
			}
		}
		return listStudentClass;
	}

	// DanhSachLop_Them
	public static result insertStudent(String[] infoStudent) throws IOException {
		result rs = null;
		if (dStudent.insertStudent(infoStudent)) {
			rs = new result(true, "Them thanh cong.", "", "", "");
		} else {
			rs = new result(true, "Them that bai.", "", "", "");
		}
		return rs;
	}
}
