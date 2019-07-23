package handleData;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

import models.mDiem;
import models.mStudent;
import models.mTkb;

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
						arrayLine[5], arrayLine[6]);
				listStudent.add(student);
			}
		} catch (IOException e) {
			listStudent = null;
			e.printStackTrace();
		}
		br.close();
		return listStudent;
	}

	public static boolean writeListStudentNew(ArrayList<mStudent> listStudent) throws IOException {
		BufferedWriter bw = null;
		boolean flag;
		String path = "data/listStudent.txt";
		try {
			bw = new BufferedWriter(new FileWriter(path));
			int currentLine = countLineFile(path);
			for (mStudent student : listStudent) {
				String dataLine = student.getStt() + "," + student.getNienKhoa() + "," + student.getCacMon() + ","
						+ student.getMssv() + "," + student.getHoTen() + "," + student.getGioiTinh() + ","
						+ student.getCmnd();
				if (currentLine == 0) {
					bw.append(dataLine);
				} else {
					bw.append("\n" + dataLine);
				}
				currentLine++;
			}
			flag = true;
		} catch (IOException e) {
			flag = false;
			e.printStackTrace();
		}
		bw.close();
		return flag;
	}

	// insert|Update student (cung nien khoa) in file
	// infoStudent ["mssv", "ho ten", "gioi tinh", "cmmd", "nienkhoa_maMon"]
	public static boolean UpdateStudent(String[] infoStudent, String nienKhoa) throws IOException {
		BufferedReader br = null;
		BufferedWriter bw = null;
		boolean flag = false;
		ArrayList<String> listStudent = new ArrayList<String>();
		try {
			br = new BufferedReader(new FileReader("data/listStudent.txt"));
			String line;
			String arrLine[];
			boolean exists = false;
			String nienKhoa_maMon[] = infoStudent[4].split("\\-");
			while ((line = br.readLine()) != null) {
				arrLine = line.split("\\,");

				String arrayCacMon[] = arrLine[2].split("\\|");

				boolean check = Arrays.stream(arrayCacMon).anyMatch(nienKhoa_maMon[1]::equals);

				// mssv=mssv
				if (arrLine[3].equals(infoStudent[0])) {
					// nienkhoa=nienkhoa, hoten=hoten, gioitinh=gioitinh, cmnd=cmnd, maMon ko co
					// trong cacMon
					if (arrLine[1].equals(nienKhoa) && arrLine[4].toLowerCase().equals(infoStudent[1].toLowerCase())
							&& arrLine[5].toLowerCase().equals(infoStudent[2].toLowerCase())
							&& arrLine[6].equals(infoStudent[3]) && !check) {

						line = arrLine[0] + "," + arrLine[1] + "," + arrLine[2] + "|" + nienKhoa_maMon[1] + ","
								+ arrLine[3] + "," + arrLine[4] + "," + arrLine[5] + "," + arrLine[6];
					}
					// neu student duoc them chua co trong ds student
					exists = true;
				}
				listStudent.add(line);
			}

			if (exists) {
				bw = new BufferedWriter(new FileWriter("data/listStudent.txt"));
				int i = 0;
				for (String student : listStudent) {
					if (i == 0) {
						bw.append(student);
					} else {
						bw.append("\n" + student);
					}
					i++;
				}
			} else {
				bw = new BufferedWriter(new FileWriter("data/listStudent.txt", true));
				int currentLine = countLineFile("data/listStudent.txt");
				String dataLine = Integer.toString(currentLine + 1) + "," + nienKhoa_maMon[0] + "," + nienKhoa_maMon[1]
						+ "," + infoStudent[0] + "," + infoStudent[1] + "," + infoStudent[2] + "," + infoStudent[3];
				if (currentLine == 0) {
					bw.append(dataLine);
				} else {
					bw.append("\n" + dataLine);
				}
			}
			bw.flush();
			bw.close();
			flag = true;
		} catch (IOException e) {
			e.printStackTrace();
		}
		br.close();
		return flag;
	}

	// insert|Update student (khac nien khoa) in file
	// data ["mssv", "ho ten", "gioi tinh", "cmmd", "nienkhoa_lop"]
	public static boolean insertStudent(String[] infoStudent) throws IOException {
		BufferedReader br = null;
		BufferedWriter bw = null;
		boolean flag = false;
		ArrayList<String> listStudent = new ArrayList<String>();
		try {
			br = new BufferedReader(new FileReader("data/listStudent.txt"));
			String line;
			String arrLine[];
			boolean exists = false;
			while ((line = br.readLine()) != null) {
				arrLine = line.split("\\,");

				String arrayCacMon[] = arrLine[2].split("\\|");

				boolean check = Arrays.stream(arrayCacMon).anyMatch(infoStudent[4]::equals);

				// mssv=mssv
				if (arrLine[3].equals(infoStudent[0])) {
					// hoten=hoten, gioitinh=gioitinh, cmnd=cmnd, maMon ko co
					// trong cacMon
					if (arrLine[4].toLowerCase().equals(infoStudent[1].toLowerCase())
							&& arrLine[5].toLowerCase().equals(infoStudent[2].toLowerCase())
							&& arrLine[6].equals(infoStudent[3]) && !check) {

						line = arrLine[0] + "," + arrLine[1] + "," + arrLine[2] + "|" + infoStudent[4] + ","
								+ arrLine[3] + "," + arrLine[4] + "," + arrLine[5] + "," + arrLine[6];
					}
					// neu student duoc them chua co trong ds student
					exists = true;
				}
				listStudent.add(line);
			}

			if (exists) {
				bw = new BufferedWriter(new FileWriter("data/listStudent.txt"));
				int i = 0;
				for (String student : listStudent) {
					if (i == 0) {
						bw.append(student);
					} else {
						bw.append("\n" + student);
					}
					i++;
				}
			} else {
				bw = new BufferedWriter(new FileWriter("data/listStudent.txt", true));
				int currentLine = countLineFile("data/listStudent.txt");
				String dataLine = Integer.toString(currentLine + 1) + "," + infoStudent[0].substring(0, 2) + ","
						+ infoStudent[4] + "," + infoStudent[0] + "," + infoStudent[1] + "," + infoStudent[2] + ","
						+ infoStudent[3];
				if (currentLine == 0) {
					bw.append(dataLine);
				} else {
					bw.append("\n" + dataLine);
				}
			}
			bw.flush();
			bw.close();
			flag = true;
		} catch (IOException e) {
			e.printStackTrace();
		}
		br.close();
		return flag;
	}

	// ["mssv", "ho ten", "gioi tinh", "cmmd", "nienkhoa_lop"]
	public static boolean deleteStudent(String[] infoStudent) throws IOException {
		BufferedReader br = null;
		BufferedWriter bw = null;
		boolean flag = false;
		ArrayList<String> listStudent = new ArrayList<String>();
		String nienKhoa_maMon[] = infoStudent[4].split("\\-");
		try {
			br = new BufferedReader(new FileReader("data/listStudent.txt"));
			String line;
			String arrLine[];
			while ((line = br.readLine()) != null) {
				arrLine = line.split("\\,");
				// 7,17,18-CNPM,1722222,Nguyen Thi B,Nu,123456789
				
				// mssv, hoten, cmnd, giotinh
				if (arrLine[3].equals(infoStudent[0]) && arrLine[4].equals(infoStudent[1])
						&& arrLine[6].equals(infoStudent[3]) && arrLine[5].equals(infoStudent[3])) {

					String arrayCacMon[] = arrLine[2].split("\\|");
					boolean check_cungKhoa = Arrays.stream(arrayCacMon).anyMatch(infoStudent[4]::equals);
					boolean check_khacKhoa = Arrays.stream(arrayCacMon).anyMatch(nienKhoa_maMon[1]::equals);
					System.out.println(check_cungKhoa);
					System.out.println(check_khacKhoa);
					System.out.println(infoStudent[4]);
					System.out.println(nienKhoa_maMon[1]);
					String cacMonNew = "";
					for (String mon : arrayCacMon) {
						if (check_cungKhoa) {
							if (mon != infoStudent[4]) {
								cacMonNew += mon + "|";
							}
						} else {
							if (mon != nienKhoa_maMon[1]) {
								cacMonNew += mon + "|";
							}
						}
					}

					if (cacMonNew.length() == 1) {
						line = arrLine[0] + "," + arrLine[1] + "," + "" + "," + arrLine[3] + "," + arrLine[4] + ","
								+ arrLine[5] + "," + arrLine[6];
					} else if (cacMonNew.length() > 1) {
						cacMonNew = cacMonNew.substring(0, cacMonNew.lastIndexOf("|"));
						line = arrLine[0] + "," + arrLine[1] + "," + cacMonNew + "," + arrLine[3] + "," + arrLine[4]
								+ "," + arrLine[5] + "," + arrLine[6];
					}
				}
				System.out.println(line);
				listStudent.add(line);

				bw = new BufferedWriter(new FileWriter("data/listStudent.txt"));
				int i = 0;
				for (String student : listStudent) {
					if (i == 0) {
						bw.append(student);
					} else {
						bw.append("\n" + student);
					}
					i++;
				}
			}
			bw.flush();
			bw.close();
			flag = true;
		} catch (IOException e) {
			e.printStackTrace();
		}
		br.close();
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
