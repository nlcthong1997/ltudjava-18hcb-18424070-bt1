package controllers;

import java.io.IOException;
import java.util.ArrayList;

import handleData.dPoint;
import models.mPoint;
import models.result;

public class cDiem {
	//getListDiemWithSubjects
	public static ArrayList<mPoint> getListPointWithSubjects(String cLass) throws IOException {
		ArrayList<mPoint> listPoints = new ArrayList<mPoint>();
		String className_subjectCode[] = cLass.split("\\-");
		for (mPoint point : dPoint.getListDiem()) {
			if (point.getClassName().equals(className_subjectCode[0]) && point.getSubjectCode().equals(className_subjectCode[1])) {
				listPoints.add(point);
			}
		}
		return listPoints;
	}
	
	//getListDiemDau
	public static ArrayList<mPoint> getListPassPoint(String cLass) throws IOException {
		ArrayList<mPoint> listPoints = new ArrayList<mPoint>();
		String className_subjectCode[] = cLass.split("\\-");
		for (mPoint point : dPoint.getListDiem()) {
			if (point.getClassName().equals(className_subjectCode[0]) && point.getSubjectCode().equals(className_subjectCode[1]) && (Integer.parseInt(point.getTotalPoint()) >= 5)) {
				listPoints.add(point);
			}
		}
		return listPoints;
	}
	
	//getListDiemRot
	public static ArrayList<mPoint> getListFallPoint(String cLass) throws IOException {
		ArrayList<mPoint> listPoints = new ArrayList<mPoint>();
		String className_subjectCode[] = cLass.split("\\-");
		for (mPoint point : dPoint.getListDiem()) {
			if (point.getClassName().equals(className_subjectCode[0]) && point.getSubjectCode().equals(className_subjectCode[1]) && (Integer.parseInt(point.getTotalPoint()) < 5)) {
				listPoints.add(point);
			}
		}
		return listPoints;
	}
	
	//getDiemPercent
	public static String[] getPointPercent (String cLass) throws IOException {
		String className_subjectCode[] = cLass.split("\\-");
		int listTotal = 0;
		int passTotal = 0;
		String passPercent = "0";
		String fallPercent = "0";
		for (mPoint point : dPoint.getListDiem()) {
			if (point.getClassName().equals(className_subjectCode[0]) && point.getSubjectCode().equals(className_subjectCode[1])) {
				if (Integer.parseInt(point.getTotalPoint()) >= 5) {
					passTotal++;
				}
				listTotal++;
			}
		}
		if (listTotal != 0) {
			passPercent = Integer.toString((100 * passTotal) / listTotal);
			fallPercent = Integer.toString(100 - ((100 * passTotal) / listTotal));
		}
		String listPointPercent[] = {passPercent, fallPercent};
		return listPointPercent;
	}
	
	/*
	 * Function: Edit Diem for one student
	 * Format of request: inforEdited[] = { nienKhoa-maMon, mssv, diemGK, diemCK, diemKhac, diemTong } 
	 */
	//chinhSuaDiem
	public static result editPointStudent (String[] infoEdited) throws IOException {
		result rs = null;
		if (dPoint.updateDiem(infoEdited)) {
			rs = new result(true, "Chinh sua diem thanh cong", "", "", "");
		} else {
			rs = new result(true, "Chinh sua diem that bai", "", "", "");
		}
		return rs;
	}
}
