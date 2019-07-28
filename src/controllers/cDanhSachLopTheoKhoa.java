package controllers;

import java.io.IOException;
import java.util.ArrayList;

import handleData.dStudent;
import models.mStudent;
import models.result;

public class cDanhSachLopTheoKhoa {
	//getListStudentWithClass
	public static ArrayList<mStudent> getListStudentFollowClassName(String cLass) throws IOException {
		ArrayList<mStudent> listClass = new ArrayList<mStudent>();
		for (mStudent student: dStudent.getListStudent()) {
			if (student.getClassName().equals(cLass)) {
				listClass.add(student);
			}
		}
		return listClass;
	}
	
	public static result themSinhVienTheoKhoa(String[] info) throws IOException {
		result rs = null;
		if (dStudent.insertStudentInKhoa(info)) {
			rs =  new result(true, "Them thanh cong.", "", "", "");
		} else {
			rs =  new result(false, "Them that bai.", "", "", "");
		}
		return rs;
	}
}