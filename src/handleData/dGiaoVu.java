package handleData;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import models.mDiem;
import models.mStudent;
import models.mTkb;

public class dGiaoVu {
	// Import Student
	public static ArrayList<mStudent> readStudentCsv(String path) throws IOException {
		ArrayList<mStudent> listStudent = new ArrayList<mStudent>();
		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader(path));
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

	public static boolean writeStudentFile(ArrayList<mStudent> listStudent, String path) throws IOException {
		BufferedWriter bw = null;
		boolean flag;
		try {
			bw = new BufferedWriter(new FileWriter(path, true));
			int currentLine = countLineFile(path);
			for (mStudent student : listStudent) {
				currentLine++;
				String dataLine = Integer.toString(currentLine) + "," + student.getNienKhoa() + "," + student.getMssv()
						+ "," + student.getHoTen() + "," + student.getGioiTinh() + "," + student.getCmnd();
				if (currentLine == 1) {
					bw.append(dataLine);
				} else {
					bw.append("\n" + dataLine);
				}
			}
			flag = true;
		} catch (IOException e) {
			flag = false;
			e.printStackTrace();
		}
		bw.close();
		return flag;
	}

	// Import TKB
	public static ArrayList<mTkb> readTkbCsv(String path) throws IOException {
		ArrayList<mTkb> listTkb = new ArrayList<mTkb>();
		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader(path));
			String line;
			String arrayLine[];
			while ((line = br.readLine()) != null) {
				arrayLine = line.split("\\,");
				mTkb tkb = new mTkb(arrayLine[0], arrayLine[1], arrayLine[2], arrayLine[3], arrayLine[4]);
				listTkb.add(tkb);
			}
		} catch (IOException e) {
			listTkb = null;
			e.printStackTrace();
		}
		br.close();
		return listTkb;
	}

	public static boolean writeTkbFile(ArrayList<mTkb> listTkb, String path) throws IOException {
		BufferedWriter bw = null;
		boolean flag;
		try {
			bw = new BufferedWriter(new FileWriter(path, true));
			int currentLine = countLineFile(path);
			for (mTkb tkb : listTkb) {
				currentLine++;
				String dataLine = Integer.toString(currentLine) + "," + tkb.getNienKhoa() + "," + tkb.getMaMon() + ","
						+ tkb.getTenMon() + "," + tkb.getPhongHoc();
				if (currentLine == 1) {
					bw.append(dataLine);
				} else {
					bw.append("\n" + dataLine);
				}
			}
			flag = true;
		} catch (IOException e) {
			flag = false;
			e.printStackTrace();
		}
		bw.close();
		return flag;
	}

	// Import Diem
	public static ArrayList<mDiem> readBangDiemCsv(String path) throws IOException {
		ArrayList<mDiem> listBangDiem = new ArrayList<mDiem>();
		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader(path));
			String line;
			String arrayLine[];
			while ((line = br.readLine()) != null) {
				arrayLine = line.split("\\,");
				mDiem diem = new mDiem(arrayLine[0], arrayLine[1], arrayLine[2], arrayLine[3], arrayLine[4],
						arrayLine[5], arrayLine[6]);
				listBangDiem.add(diem);
			}
		} catch (IOException e) {
			listBangDiem = null;
			e.printStackTrace();
		}
		br.close();
		return listBangDiem;
	}

	public static boolean writeBangDiemFile(ArrayList<mDiem> listBangDiem, String path) throws IOException {
		BufferedWriter bw = null;
		boolean flag;
		try {
			bw = new BufferedWriter(new FileWriter(path, true));
			int currentLine = countLineFile(path);
			for (mDiem diem : listBangDiem) {
				currentLine++;
				String dataLine = Integer.toString(currentLine) + "," + diem.getNienKhoa() + "," + diem.getMaMon() + ","
						+ diem.getMssv() + "," + diem.getHoTen() + "," + diem.getGioiTinh() + "," + diem.getCmnd();
				if (currentLine == 1) {
					bw.append(dataLine);
				} else {
					bw.append("\n" + dataLine);
				}
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
