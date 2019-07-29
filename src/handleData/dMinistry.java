package handleData;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import models.mPoint;
import models.mStudent;
import models.mSchedule;

public class dMinistry {
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
				mStudent student = new mStudent(arrayLine[0], arrayLine[1], "", arrayLine[2], arrayLine[3],
						arrayLine[4], arrayLine[5]);
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
				String dataLine = Integer.toString(currentLine) + "," + student.getClassName() + ","
						+ student.getSubjects() + "," + student.getIdStudent() + "," + student.getNameStudent() + ","
						+ student.getSex() + "," + student.getIdentityCard();
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
	public static ArrayList<mSchedule> readTkbCsv(String path) throws IOException {
		ArrayList<mSchedule> listTkb = new ArrayList<mSchedule>();
		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader(path));
			String line;
			String arrayLine[];
			while ((line = br.readLine()) != null) {
				arrayLine = line.split("\\,");
				mSchedule tkb = new mSchedule(arrayLine[0], arrayLine[1], arrayLine[2], arrayLine[3], arrayLine[4]);
				listTkb.add(tkb);
			}
		} catch (IOException e) {
			listTkb = null;
			e.printStackTrace();
		}
		br.close();
		return listTkb;
	}

	public static boolean writeTkbFile(ArrayList<mSchedule> listSchedules, String path) throws IOException {
		BufferedWriter bw = null;
		boolean flag;
		try {
			bw = new BufferedWriter(new FileWriter(path, true));
			int currentLine = countLineFile(path);
			for (mSchedule schedule : listSchedules) {
				currentLine++;
				String dataLine = Integer.toString(currentLine) + "," + schedule.getClassName() + "," + schedule.getSubjectCode() + ","
						+ schedule.getSubjectName() + "," + schedule.getClassRoom();
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
	public static ArrayList<mPoint> readBangDiemCsv(String path) throws IOException {
		ArrayList<mPoint> listBangDiem = new ArrayList<mPoint>();
		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader(path));
			String line;
			String arrayLine[];
			while ((line = br.readLine()) != null) {
				arrayLine = line.split("\\,");
				mPoint diem = new mPoint(arrayLine[0], arrayLine[1], arrayLine[2], arrayLine[3], arrayLine[4],
						arrayLine[5], arrayLine[6], arrayLine[7], arrayLine[8]);
				listBangDiem.add(diem);
			}
		} catch (IOException e) {
			listBangDiem = null;
			e.printStackTrace();
		}
		br.close();
		return listBangDiem;
	}

	public static boolean writeBangDiemFile(ArrayList<mPoint> listPoints, String path) throws IOException {
		BufferedWriter bw = null;
		boolean flag;
		try {
			bw = new BufferedWriter(new FileWriter(path, true));
			int currentLine = countLineFile(path);
			for (mPoint point : listPoints) {
				currentLine++;
				String dataLine = Integer.toString(currentLine) + "," + point.getClassName() + "," + point.getSubjectCode() + ","
						+ point.getIdStudent() + "," + point.getNameStudent() + "," + point.getMidtermPoint() + "," + point.getEndPoint()+ ","
						+ point.getOrtherPoint() + "," + point.getTotalPoint();
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
