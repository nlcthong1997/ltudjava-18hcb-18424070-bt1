package controllers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

import handleData.dStudent;
import models.mStudent;
import models.result;

public class cDanhSachLop {
	
	//getListStudentWithClass
	public static ArrayList<mStudent> getListStudentFollowSubject(String cLass) throws IOException {
		ArrayList<mStudent> listStudentClass = new ArrayList<mStudent>();

		// format : arrayClass[0] = nien_khoa, arrayClass[1] = ma_mon
		String arrayClass[] = cLass.split("\\-");

		for (mStudent student : dStudent.getListStudent()) {
			String arraySubjects[] = student.getSubjects().split("\\|");

			// check ma_mon co thuoc cac mon ma sinh vien dang hoc ko
			boolean checkExistsIdSubject = Arrays.stream(arraySubjects).anyMatch(arrayClass[1]::equals);
			
			// check sv cua khoa khac
			boolean checkStudentOtherClassName = Arrays.stream(arraySubjects).anyMatch(cLass::equals);

			if ((student.getClassName().equals(arrayClass[0]) && checkExistsIdSubject) || checkStudentOtherClassName) {
				listStudentClass.add(student);
			}
		}
		return listStudentClass;
	}

	// DanhSachLop_Them
	// data ["mssv", "ho ten", "gioi tinh", "cmmd", "nienkhoa_lop"]
	
	//insertStudent
	public static result insertStudentOfClassSubject(String[] infoStudent) throws IOException {
		result rs = null;
		String khoa = infoStudent[0].substring(0, 2);
		String lop = infoStudent[4].substring(0, 2);
		if (khoa.equals(lop)) {
			if (dStudent.UpdateStudent(infoStudent, khoa)) {
				rs = new result(true, "Them thanh cong.", "", "", "");
			} else {
				rs = new result(true, "Them that bai.", "", "", "");
			}
		} else {
			if (dStudent.insertStudent(infoStudent)) {
				rs = new result(true, "Them thanh cong.", "", "", "");
			} else {
				rs = new result(true, "Them that bai.", "", "", "");
			}
		}
		return rs;
	}
	//deleteStudent
	public static result deleteStudentOfClassSubject(String[] infoStudent) throws IOException {
		result rs = null;
		if (dStudent.deleteStudentOfClassSubject(infoStudent)) {
			rs = new result(true, "Xoa thanh cong.", "", "", "");
		} else {
			rs = new result(true, "Xoa that bai.", "", "", "");
		}
		return rs;
	}
}
