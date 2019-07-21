package controllers;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.filechooser.FileSystemView;

import models.mDiem;
import models.mStudent;
import models.mTkb;
import models.result;

import handleData.dGiaoVu;

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
		}
		if (flag) {
			rs = new result(true, "Import thanh cong.", "", "", "");
		} else {
			rs = new result(false, "Import that bai.", "", "", "");
		}
		return rs;
	}
}
