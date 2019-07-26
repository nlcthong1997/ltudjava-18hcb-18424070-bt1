package controllers;

import java.io.IOException;
import java.util.ArrayList;

import handleData.dDiem;
import models.mDiem;
import models.result;

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
	
	public static ArrayList<mDiem> getListDiemDau(String cLass) throws IOException {
		ArrayList<mDiem> listDiem = new ArrayList<mDiem>();
		String nienKhoa_maMon[] = cLass.split("\\-");
		for (mDiem diem : dDiem.getListDiem()) {
			if (diem.getNienKhoa().equals(nienKhoa_maMon[0]) && diem.getMaMon().equals(nienKhoa_maMon[1]) && (Integer.parseInt(diem.getDiemTong()) >= 5)) {
				listDiem.add(diem);
			}
		}
		return listDiem;
	}
	
	public static ArrayList<mDiem> getListDiemRot(String cLass) throws IOException {
		ArrayList<mDiem> listDiem = new ArrayList<mDiem>();
		String nienKhoa_maMon[] = cLass.split("\\-");
		for (mDiem diem : dDiem.getListDiem()) {
			if (diem.getNienKhoa().equals(nienKhoa_maMon[0]) && diem.getMaMon().equals(nienKhoa_maMon[1]) && (Integer.parseInt(diem.getDiemTong()) < 5)) {
				listDiem.add(diem);
			}
		}
		return listDiem;
	}
	
	public static String[] getDiemPercent (String cLass) throws IOException {
		String nienKhoa_maMon[] = cLass.split("\\-");
		int listTotal = 0;
		int dauTotal = 0;
		String dauPercent = "0";
		String rotPercent = "0";
		for (mDiem diem : dDiem.getListDiem()) {
			if (diem.getNienKhoa().equals(nienKhoa_maMon[0]) && diem.getMaMon().equals(nienKhoa_maMon[1])) {
				if (Integer.parseInt(diem.getDiemTong()) >= 5) {
					dauTotal++;
				}
				listTotal++;
			}
		}
		if (listTotal != 0) {
			dauPercent = Integer.toString((100 * dauTotal) / listTotal);
			rotPercent = Integer.toString(100 - ((100 * dauTotal) / listTotal));
		}
		String listDiemPercent[] = {dauPercent, rotPercent};
		return listDiemPercent;
	}
	
	/*
	 * Function: Edit Diem for one student
	 * Format of request: inforEdited[] = { nienKhoa-maMon, mssv, diemGK, diemCK, diemKhac, diemTong } 
	 */
	public static result chinhSuaDiem (String[] infoEdited) throws IOException {
		result rs = null;
		if (dDiem.updateDiem(infoEdited)) {
			rs = new result(true, "Chinh sua diem thanh cong", "", "", "");
		} else {
			rs = new result(true, "Chinh sua diem that bai", "", "", "");
		}
		return rs;
	}
}
