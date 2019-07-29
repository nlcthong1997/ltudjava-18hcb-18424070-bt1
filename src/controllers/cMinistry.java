package controllers;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.filechooser.FileSystemView;

import models.mPoint;
import models.mStudent;
import models.mSchedule;
import models.result;

import handleData.dMinistry;
import handleData.dStudent;
import handleData.dSchedule;

public class cMinistry {
	public static result importCsv(String type) throws IOException {
		result rs = null;
		// handle file
		JFileChooser jfc = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
		if (type.equals("dslop")) {
			jfc.setDialogTitle("Import danh sach lop");
		}
		if (type.equals("tkb")) {
			jfc.setDialogTitle("Import thoi khoa bieu");
		}
		if (type.equals("bangdiem")) {
			jfc.setDialogTitle("Import bang diem");
		}
		jfc.setAcceptAllFileFilterUsed(false);
		FileNameExtensionFilter filter = new FileNameExtensionFilter("Choose file *.csv or *.txt", "csv", "txt");
		jfc.addChoosableFileFilter(filter);
		boolean flag = false;
		int returnValue = jfc.showOpenDialog(null);
		if (returnValue == JFileChooser.APPROVE_OPTION) {
			File selectedFile = jfc.getSelectedFile();
			String path = jfc.getSelectedFile().getPath();
		// end handle file
			if (type.equals("dslop")) {
				ArrayList<mStudent> listStudents = dMinistry.readStudentCsv(path);
				if (dMinistry.writeStudentFile(listStudents, "data/listStudent.txt")) {
					flag = true;
				}
			}
			if (type.equals("tkb")) {
				ArrayList<mSchedule> listSchedules = dMinistry.readTkbCsv(path);
				if (dMinistry.writeTkbFile(listSchedules, "data/listTkb.txt")) {
					flag = true;
				}
			}
			if (type.equals("bangdiem")) {
				ArrayList<mPoint> listPoints = dMinistry.readBangDiemCsv(path);
				if (dMinistry.writeBangDiemFile(listPoints, "data/listBangDiem.txt")) {
					flag = true;
				}
			}
			// auto mapping relationship
			ArrayList<mStudent> listStudents = dStudent.getListStudent();
			ArrayList<mSchedule> listSchedules = dSchedule.getListTkb();
			ArrayList<mStudent> listStudentNew = new ArrayList<mStudent>();
			if (listStudents.size() != 0 && listSchedules.size() != 0) {
				for (mStudent student : listStudents) {
					String subjects = "";
					for (mSchedule schedule : listSchedules) {
						if (student.getClassName().equals(schedule.getClassName())) {
							subjects += schedule.getSubjectCode() + "|";
						}
					}
					if (subjects != "") {
						subjects = subjects.substring(0, subjects.lastIndexOf("|"));
					}
					mStudent studentNew = new mStudent(student.getId(), student.getClassName(), subjects,
							student.getIdStudent(), student.getNameStudent(), student.getSex(), student.getIdentityCard());
					listStudentNew.add(studentNew);
				}
				if (dStudent.writeListStudentNew(listStudentNew)) {
					flag = true;
				} else {
					flag = false;
				}
			}
		}
		if (flag) {
			rs = new result(true, "Import thanh cong.", "", "", "");
		} else {
			rs = new result(false, "Import that bai.", "", "", "");
		}
		return rs;
	}

	//getListClassWithSubjects
	public static ArrayList<String> getListClassFollowSubjects() throws IOException {
		ArrayList<String> listClass = new ArrayList<String>();
		for (mStudent student : dStudent.getListStudent()) {
			for (mSchedule schedule : dSchedule.getListTkb()) {
				if (student.getClassName().equals(schedule.getClassName())) {
					String classSchedule = student.getClassName() + "-" + schedule.getSubjectCode();
					if (!listClass.contains(classSchedule)) {
						listClass.add(classSchedule);
					}
				}
			}
		}
		Collections.sort(listClass);
		return listClass;
	}
	
	//getListClass
	public static ArrayList<String> getListClassName () throws IOException {
		ArrayList<String> listclass = new ArrayList<String>();
		for (mStudent student : dStudent.getListStudent()) {
			if (!listclass.contains(student.getClassName())) {
				listclass.add(student.getClassName());
			}
		}
		Collections.sort(listclass);
		return listclass;
	}
}
