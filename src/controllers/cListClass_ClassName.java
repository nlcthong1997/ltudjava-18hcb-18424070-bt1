package controllers;

import java.io.IOException;
import java.util.ArrayList;

import handleData.dStudent;
import models.mStudent;
import models.result;

public class cListClass_ClassName {
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
	
	//themSinhVienTheoKhoa
	public static result addStudentFollowClassName(String[] info) throws IOException {
		result rs = null;
		if (dStudent.insertStudentInClassName(info)) {
			rs =  new result(true, "Them thanh cong.", "", "", "");
		} else {
			rs =  new result(false, "Them that bai.", "", "", "");
		}
		return rs;
	}
}