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
		for (mDiem diem : dDiem.getListDiem()) {
			if (diem.getNienKhoa().equals(nienKhoa_maMon[0]) && diem.getMaMon().equals(nienKhoa_maMon[1])) {
				if (Integer.parseInt(diem.getDiemTong()) >= 5) {
					dauTotal++;
				}
				listTotal++;
				System.out.println(nienKhoa_maMon[0]);
				System.out.println(nienKhoa_maMon[1]);
				System.out.println(Integer.parseInt(diem.getDiemTong()));
			}
		}
//		System.out.println(nienKhoa_maMon[0]);
//		System.out.println(nienKhoa_maMon[1]);
//		System.out.println(listTotal);
		System.out.println(dauTotal);
		String dauPercent = Integer.toString((100 * dauTotal) / listTotal);
		String rotPercent = Integer.toString(100 - ((100 * dauTotal) / listTotal));
		String listDiemPercent[] = new String[] {dauPercent, rotPercent};
		return listDiemPercent;
	}
}
