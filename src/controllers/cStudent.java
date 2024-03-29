




package controllers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

import handleData.dPoint;
import handleData.dStudent;
import handleData.dSchedule;
import models.mPoint;
import models.mStudent;
import models.mSchedule;

public class cStudent {

	public static ArrayList<mPoint> getDiemAllSubjectWithStudent (String userName) throws IOException {
		ArrayList<mPoint> listPoints = new ArrayList<mPoint>();
		ArrayList<String> checkSubjectSame = new ArrayList<String>();
		for (mPoint pointStudent: dPoint.getListDiem()) {
			for (mSchedule schedule : dSchedule.getListTkb()) {
				if (pointStudent.getIdStudent().equals(userName) && pointStudent.getSubjectCode().equals(schedule.getSubjectCode()) && !checkSubjectSame.contains(schedule.getSubjectCode())) {
					checkSubjectSame.add(schedule.getSubjectCode());
					mPoint point = new mPoint(pointStudent.getId(), pointStudent.getClassName(), schedule.getSubjectName() ,pointStudent.getIdStudent(), pointStudent.getNameStudent(), pointStudent.getMidtermPoint(), 
							pointStudent.getEndPoint(), pointStudent.getOrtherPoint(), pointStudent.getTotalPoint());
					listPoints.add(point);
				}
			}
		}
		return listPoints;
	}
	
	public static ArrayList<String> getListSubjectOfStudent (String idStudent) throws IOException {
		String[] listSubjectCode = new String[] {};
		for (mStudent student: dStudent.getListStudent()) {
			if (student.getIdStudent().equals(idStudent)) {
				listSubjectCode = student.getSubjects().split("\\|");
			}
		}
		ArrayList<String> listSubject = new ArrayList<String>();
		for (mSchedule schedule : dSchedule.getListTkb()) {
			System.out.println(schedule.getClassName() + schedule.getSubjectCode());
			for (String subjectCode : listSubjectCode) {
				if ((subjectCode.equals(schedule.getSubjectCode()) || subjectCode.equals(schedule.getClassName() + "-" + schedule.getSubjectCode())) && !listSubject.contains(schedule.getSubjectName())) {
					listSubject.add(schedule.getSubjectName());
					System.out.println(subjectCode);
				}
			}
		}
		return listSubject;
	}
}
