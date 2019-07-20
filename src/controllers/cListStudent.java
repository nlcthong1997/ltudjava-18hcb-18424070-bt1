package controllers;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.filechooser.FileSystemView;

import models.mStudent;
import models.result;

public class cListStudent {
	public static result importCsvListStudent() throws IOException {
		result rs = null;
		
		JFileChooser jfc = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
		jfc.setDialogTitle("Select an image");
		jfc.setAcceptAllFileFilterUsed(false);
		FileNameExtensionFilter filter = new FileNameExtensionFilter("Only CSV", "csv", "txt");
		jfc.addChoosableFileFilter(filter);

		int returnValue = jfc.showOpenDialog(null);
		if (returnValue == JFileChooser.APPROVE_OPTION) {
			File selectedFile = jfc.getSelectedFile();
			String path = jfc.getSelectedFile().getPath();
			// read file csv
			ArrayList<mStudent> listStudent = readStudentCsv(path);
			// write file
			if(writeFile(listStudent)) {
				rs = new result(true, "Import thanh cong.", "", "");
			} else {
				rs = new result(false, "Import that bai.", "", "");
			}
		}
		return rs;
	}

	public static ArrayList<mStudent> readStudentCsv(String path) throws IOException {
		ArrayList<mStudent> listStudent = new ArrayList<mStudent>();
		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader(path));
			String line;
			String arrayLine [];
			while ((line = br.readLine()) != null) {
				arrayLine = line.split("\\,");
				mStudent student = new mStudent(arrayLine[0], arrayLine[1], arrayLine[2], arrayLine[3], arrayLine[4], arrayLine[5]);
        		listStudent.add(student);
			}
		} catch (IOException e) {
			listStudent = null;
			e.printStackTrace();
		}
		br.close();
		return listStudent;
	}
	
	public static boolean writeFile(ArrayList<mStudent> listStudent) throws IOException {
		BufferedWriter bw = null;
		boolean flag;
		try {
	        bw = new BufferedWriter(new FileWriter("data/listStudent.txt", true));
	        int currentLine = countLineFile("data/listStudent.txt");
	        for(mStudent student: listStudent) {
	        	currentLine++;
	        	String dataLine = "\n" + Integer.toString(currentLine) + "," + student.getNienKhoa() + "," + student.getMssv() + "," 
	        					+ student.getHoTen() + "," + student.getGioiTinh() + "," + student.getCmnd();
	        	bw.append(dataLine);
	        }
	        flag = true;
	    } catch (IOException e) {
	    	flag = false;
			e.printStackTrace();
		}
        bw.close();
        return flag;
	}
	
	public static int countLineFile(String path) throws IOException {
		int count = 0;
		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader(path));
			String line;
			while ((line = br.readLine()) != null) {
				count++;
			}
		} catch (IOException e) {
			count = 0;
			e.printStackTrace();
		}
		br.close();
		return count;
	}
}
