package handleData;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import models.mDiem;
import models.mStudent;

public class dStudent {
	public static ArrayList<mStudent> getListStudent() throws IOException {
		ArrayList<mStudent> listStudent = new ArrayList<mStudent>();
		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader("data/listStudent.txt"));
			String line;
			String arrayLine[];
			while ((line = br.readLine()) != null) {
				arrayLine = line.split("\\,");
				mStudent student = new mStudent(arrayLine[0], arrayLine[1], arrayLine[2], arrayLine[3], arrayLine[4],
						arrayLine[5]);
				listStudent.add(student);
			}
		} catch (IOException e) {
			listStudent = null;
			e.printStackTrace();
		}
		br.close();
		return listStudent;
	}
	
	// insert 1 student in file
	// data ["mssv", "ho ten", "gioi tinh", "cmmd", "nienkhoa_lop"]
	public static boolean insertStudent (String[] infoStudent) throws IOException {
		BufferedWriter bw = null;
		boolean flag;
		String path = "data/listStudent.txt";
		try {
			bw = new BufferedWriter(new FileWriter(path, true));
			int currentLine = countLineFile(path);
			String dataLine = "\n" + Integer.toString(currentLine + 1) + "," + infoStudent[4] + "," + infoStudent[0] + ","
						+ infoStudent[1] + "," + infoStudent[2] + "," + infoStudent[3];
			if (currentLine == 0) {
				bw.append(dataLine);
			} else {
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
