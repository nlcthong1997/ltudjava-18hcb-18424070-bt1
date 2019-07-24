package controllers;

import java.io.IOException;
import java.util.ArrayList;

import handleData.dStudent;
import models.mStudent;

public class cDanhSachLopTheoKhoa {
	public static ArrayList<mStudent> getListStudentWithClass(String cLass) throws IOException {
		ArrayList<mStudent> listClass = new ArrayList<mStudent>();
		for (mStudent student: dStudent.getListStudent()) {
			if (student.getNienKhoa().equals(cLass)) {
				listClass.add(student);
			}
		}
		return listClass;
	}
}
