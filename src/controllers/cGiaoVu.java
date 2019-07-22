package controllers;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.filechooser.FileSystemView;

import models.mDiem;
import models.mStudent;
import models.mTkb;
import models.result;

import handleData.dGiaoVu;
import handleData.dStudent;
import handleData.dTkb;

public class cGiaoVu {
	public static result importCsv(String type) throws IOException {
		result rs = null;

		JFileChooser jfc = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
		jfc.setDialogTitle("Select an image");
		jfc.setAcceptAllFileFilterUsed(false);
		FileNameExtensionFilter filter = new FileNameExtensionFilter("Choose file *.csv or *.txt", "csv", "txt");
		jfc.addChoosableFileFilter(filter);
		boolean flag = false;
		int returnValue = jfc.showOpenDialog(null);
		if (returnValue == JFileChooser.APPROVE_OPTION) {
			File selectedFile = jfc.getSelectedFile();
			String path = jfc.getSelectedFile().getPath();
			if (type.equals("dslop")) {
				ArrayList<mStudent> listStudent = dGiaoVu.readStudentCsv(path);
				if (dGiaoVu.writeStudentFile(listStudent, "data/listStudent.txt")) {
					flag = true;
				}
			}
			if (type.equals("tkb")) {
				ArrayList<mTkb> listTkb = dGiaoVu.readTkbCsv(path);
				if (dGiaoVu.writeTkbFile(listTkb, "data/listTkb.txt")) {
					flag = true;
				}
			}
			if (type.equals("bangdiem")) {
				ArrayList<mDiem> listTkb = dGiaoVu.readBangDiemCsv(path);
				if (dGiaoVu.writeBangDiemFile(listTkb, "data/listBangDiem.txt")) {
					flag = true;
				}
			}
			// auto mapping relationship
			ArrayList<mStudent> listS = dStudent.getListStudent();
			ArrayList<mTkb> listT = dTkb.getListTkb();
			ArrayList<mStudent> listSNew = new ArrayList<mStudent>();
			if (listS.size() != 0 && listT.size() != 0) {
				for (mStudent student : listS) {
					String cacMon = "";
					for (mTkb tkb : listT) {
						if (student.getNienKhoa().equals(tkb.getNienKhoa())) {
							System.out.println(tkb.getMaMon());
							System.out.println(tkb.getNienKhoa());
							System.out.println(student.getNienKhoa());
							cacMon += tkb.getMaMon() + "|";
						}
					}
					if (cacMon != "") {
						cacMon = cacMon.substring(0,cacMon.lastIndexOf("|"));	
					}
					mStudent studentNew = new mStudent(student.getStt(), student.getNienKhoa(), cacMon,
							student.getMssv(), student.getHoTen(), student.getGioiTinh(), student.getCmnd());
					listSNew.add(studentNew);
				}
				if (dStudent.writeListStudentNew(listSNew)) {
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

	public static ArrayList<String> getListClass() throws IOException {
		ArrayList<String> listClass = new ArrayList<String>();
		for (mStudent student : dStudent.getListStudent()) {
			if (!listClass.contains(student.getNienKhoa())) {
				listClass.add(student.getNienKhoa());
			}
		}
		Collections.sort(listClass);
		return listClass;
	}
}
