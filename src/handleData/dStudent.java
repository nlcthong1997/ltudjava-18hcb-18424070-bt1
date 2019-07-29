package handleData;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

import models.mPoint;
import models.mStudent;
import models.mSchedule;

public class dStudent {
	/**
	 * Function: getListStudent 
	 * return ArrayList<mStudent> listStudent[ line, line1, ... ]
	 * 		  String line = "stt, nienKhoa, cacMon, mssv, hoTen, gioiTinh, cmnd"
	 */
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
	
	/**
	 * Function: writeListStudentNew (write file student)
	 * Format request: ArrayList<mStudent> listStudent[ line, line1, ... ]
	 * 		  		   String line = "stt, nienKhoa, cacMon, mssv, hoTen, gioiTinh, cmnd"
	 * return boolean true/false
	 */
	public static boolean writeListStudentNew(ArrayList<mStudent> listStudent) throws IOException {
		BufferedWriter bw = null;
		boolean flag;
		String path = "data/listStudent.txt";
		try {
			bw = new BufferedWriter(new FileWriter(path));
			int currentLine = countLineFile(path);
			for (mStudent student : listStudent) {
				String dataLine = student.getId() + "," + student.getClassName() + "," + student.getSubjects() + ","
						+ student.getIdStudent() + "," + student.getNameStudent() + "," + student.getSex() + ","
						+ student.getIdentityCard();
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

	/**
	 *Function: UpdateStudent (update cacMon for student when student learn class same nienKhoa)
	 *Format request: infoStudent[] = { "mssv", "ho ten", "gioi tinh", "cmmd", "nienkhoa_maMon" }
	 *return boolean true/false
	 */
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

				// check same mssv
				if (arrLine[3].equals(infoStudent[0])) {
					
					//check conditions and check maMon(new) already exists in cacMon of student ?
					// nienkhoa=nienkhoa, hoten=hoten, gioitinh=gioitinh, cmnd=cmnd, maMon ko co trong cacMon
					// format cacMon ex; CNPM|MMT|...
					if (arrLine[1].equals(nienKhoa) && arrLine[4].toLowerCase().equals(infoStudent[1].toLowerCase())
							&& arrLine[5].toLowerCase().equals(infoStudent[2].toLowerCase())
							&& arrLine[6].equals(infoStudent[3]) && !check) {

						line = arrLine[0] + "," + arrLine[1] + "," + arrLine[2] + "|" + nienKhoa_maMon[1] + ","
								+ arrLine[3] + "," + arrLine[4] + "," + arrLine[5] + "," + arrLine[6];
					}
					// if student already exists in listStudent
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
				flag = true;
			} else {
				// if student donn't exists in listStudent
				bw = new BufferedWriter(new FileWriter("data/listStudent.txt", true));
				int currentLine = countLineFile("data/listStudent.txt");
				String dataLine = Integer.toString(currentLine + 1) + "," + nienKhoa_maMon[0] + "," + nienKhoa_maMon[1]
						+ "," + infoStudent[0] + "," + infoStudent[1] + "," + infoStudent[2] + "," + infoStudent[3];
				if (currentLine == 0) {
					bw.append(dataLine);
				} else {
					bw.append("\n" + dataLine);
				}
				flag = true;
			}
			bw.flush();
			bw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		br.close();
		return flag;
	}

	/**
	 *Function: insertStudent (update cacMon for student when student learn class differ nienKhoa)
	 *Format request: infoStudent[] = { "mssv", "hoTen", "gioi tinh", "cmmd", "nienkhoa_maMon" }
	 *return boolean true/false
	 */
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
				// check same mssv
				if (arrLine[3].equals(infoStudent[0])) {
					
					// check conditions and check maMon(new) already exists in cacMon of student ?
					// hoten=hoten, gioitinh=gioitinh, cmnd=cmnd, maMon ko co trong cacMon
					// format cacMon ex: MMT|18-CNPM|18-DLCM
					if (arrLine[4].toLowerCase().equals(infoStudent[1].toLowerCase())
							&& arrLine[5].toLowerCase().equals(infoStudent[2].toLowerCase())
							&& arrLine[6].equals(infoStudent[3]) && !check) {

						line = arrLine[0] + "," + arrLine[1] + "," + arrLine[2] + "|" + infoStudent[4] + ","
								+ arrLine[3] + "," + arrLine[4] + "," + arrLine[5] + "," + arrLine[6];
					}
					// if student already exists in listStudent
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
				flag = true;
			} else {
				// if student don't exists in listStudent
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
				flag = true;
			}
			bw.flush();
			bw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		br.close();
		return flag;
	}

	/**
	 * Function: deleteStudent (feature update cacMon of student in listStudent)
	 * Format request: infoStudent[] = {"mssv", "hoTen", "gioiTinh", "cmmd", "nienkhoa_maMon"}
	 * Format arrLine[] = { stt, nienKhoa, cacMon, mssv, hoTen, gioiTinh, cmnd }
	 */
	public static boolean deleteStudentOfClassSubject(String[] infoStudent) throws IOException {
		BufferedReader br = null;
		BufferedWriter bw = null;
		boolean flag = false;
		ArrayList<String> listStudent = new ArrayList<String>();

		// [nienKhoa, maMon]
		String nienKhoa_maMon[] = infoStudent[4].split("\\-");
		try {
			br = new BufferedReader(new FileReader("data/listStudent.txt"));
			String line;
			String arrLine[];
			while ((line = br.readLine()) != null) {
				arrLine = line.split("\\,");

				// Check mssv, hoten, cmnd, giotinh cua DB vs req
				if (arrLine[3].equals(infoStudent[0]) && arrLine[4].equals(infoStudent[1])
						&& arrLine[6].equals(infoStudent[3]) && arrLine[5].equals(infoStudent[2])) {

					// handle after find student need delete

					// lay ra tung mon duoi DB luu vao mang
					String arrayCacMon[] = arrLine[2].split("\\|");

					// Kiem tra xem req.maMon thuoc loai cua student cung Khoa (18) hay khac khoa
					// (18-CNPM)
					boolean check_cungKhoa = Arrays.stream(arrayCacMon).anyMatch(nienKhoa_maMon[1]::equals);
					boolean check_khacKhoa = Arrays.stream(arrayCacMon).anyMatch(infoStudent[4]::equals);

					String cacMonNew = "";

					// Duyet qua cac mon duoi DB neu mon nao khac voi mon duoc yeu cau xoa (req.maMon) thi giu lai
					for (String mon : arrayCacMon) {
						if (check_cungKhoa) {
							if (!mon.equals(nienKhoa_maMon[1])) {
								cacMonNew += mon + "|";
							}
						} else {
							if (!mon.equals(infoStudent[4])) {
								cacMonNew += mon + "|";
							}
						}
					}

					// Neu truong hop student chi co 1 mon thi for se ko chay
					// Nen ta kiem tra neu chi co 1 mon thi ta se luu rong
					String soLuongMon[] = cacMonNew.split("\\|");
					if (soLuongMon.length == 1) {
						line = arrLine[0] + "," + arrLine[1] + "," + "" + "," + arrLine[3] + "," + arrLine[4] + ","
								+ arrLine[5] + "," + arrLine[6];
					} else {
						cacMonNew = cacMonNew.substring(0, cacMonNew.lastIndexOf("|"));
						line = arrLine[0] + "," + arrLine[1] + "," + cacMonNew + "," + arrLine[3] + "," + arrLine[4]
								+ "," + arrLine[5] + "," + arrLine[6];
					}
				}
				listStudent.add(line);
			}
			// write file
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
			flag = true;
			bw.flush();
			bw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		br.close();
		return flag;
	}
	
	/**
	 * Format request: info[] = { hoTen, mssv, cmnd, gioiTinh, nienKhoa };
	 */
	public static boolean insertStudentInClassName (String[] info) throws IOException {
		BufferedWriter bw = null;
		boolean flag = false;
		try { 
			bw = new BufferedWriter(new FileWriter("data/listStudent.txt", true));
			int currentLine = countLineFile("data/listStudent.txt");
			String dataLine = Integer.toString(currentLine + 1) + "," + info[4] + "," + "," + info[1] + "," + info[0] + "," + info[3] + "," + info[2];
			if (currentLine == 1) {
				bw.append(dataLine);
			} else {
				bw.append("\n" + dataLine);
			}
			flag = true;
		} catch (IOException e) {
			e.printStackTrace();
		}
		bw.close();
		return flag;
	}
	
	/**
	 * Function: countLineFile (path file)
	 * return total line of file
	 */
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
