package controllers;

import java.io.IOException;
import java.util.ArrayList;

import handleData.dStudent;
import models.mStudent;
import models.result;

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
	
	//DanhSachLop_Them
	public static result insertStudent (String[] infoStudent) throws IOException {
		result rs = null;
		if (dStudent.insertStudent(infoStudent)) {
			rs = new result(true, "Them thanh cong.", "", "", "");
		} else {
			rs = new result(true, "Them that bai.", "", "", "");
		}
		return rs;
	}
}
