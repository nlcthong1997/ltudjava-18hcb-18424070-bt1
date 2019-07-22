package controllers;

import java.io.IOException;
import java.util.ArrayList;

import handleData.dStudent;
import models.mStudent;

public class cDanhSachLop {
	public static ArrayList<mStudent> getListStudentWithClass (String cLass) throws IOException {
		ArrayList<mStudent> listStudentClass = new ArrayList<mStudent>();
		for (mStudent student : dStudent.getListStudent()) {
			if (student.getNienKhoa().equals(cLass)) {
				listStudentClass.add(student);
			}
		}
		return listStudentClass;
	}
}
