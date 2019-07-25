package controllers;

import java.io.IOException;
import java.util.ArrayList;

import handleData.dDiem;
import models.mDiem;

public class cDiem {
	public static ArrayList<mDiem> getListDiemWithSubjects(String cLass) throws IOException {
		ArrayList<mDiem> listDiem = new ArrayList<mDiem>();
		String nienKhoa_maMon[] = cLass.split("\\-");
		for (mDiem diem : dDiem.getListDiem()) {
			if (diem.getNienKhoa().equals(nienKhoa_maMon[0]) && diem.getMaMon().equals(nienKhoa_maMon[1])) {
				listDiem.add(diem);
			}
		}
		return listDiem;
	}
}
