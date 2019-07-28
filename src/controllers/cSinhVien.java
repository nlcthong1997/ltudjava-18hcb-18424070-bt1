package controllers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

import handleData.dDiem;
import handleData.dStudent;
import handleData.dTkb;
import models.mDiem;
import models.mStudent;
import models.mTkb;

public class cSinhVien {

	public static ArrayList<mDiem> getDiemAllSubjectWithStudent (String userName) throws IOException {
		ArrayList<mDiem> listDiem = new ArrayList<mDiem>();
		ArrayList<String> check = new ArrayList<String>();
		for (mDiem diemSV: dDiem.getListDiem()) {
			for (mTkb tkb : dTkb.getListTkb()) {
				if (diemSV.getMssv().equals(userName) && diemSV.getMaMon().equals(tkb.getMaMon()) && !check.contains(tkb.getMaMon())) {
					check.add(tkb.getMaMon());
					mDiem diem = new mDiem(diemSV.getStt(), diemSV.getNienKhoa(), tkb.getTenMon() ,diemSV.getMssv(), diemSV.getHoTen(), diemSV.getDiemGk(), 
							diemSV.getDiemCk(), diemSV.getDiemKhac(), diemSV.getDiemTong());
					listDiem.add(diem);
				}
			}
		}
		return listDiem;
	}
	
	public static ArrayList<String> getListSubjectOfStudent (String idStudent) throws IOException {
		String[] listIdSubject = new String[] {};
		for (mStudent student: dStudent.getListStudent()) {
			if (student.getMssv().equals(idStudent)) {
				listIdSubject = student.getCacMon().split("\\|");
			}
		}
		ArrayList<String> listSubject = new ArrayList<String>();
		for (mTkb tkb : dTkb.getListTkb()) {
			for (String idSubject : listIdSubject) {
				if (idSubject.equals(tkb.getMaMon()) && !listSubject.contains(tkb.getTenMon())) {
					listSubject.add(tkb.getTenMon());
				}
			}
		}
		return listSubject;
	}
}
