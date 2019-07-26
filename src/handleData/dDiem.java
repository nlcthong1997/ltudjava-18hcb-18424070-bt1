package handleData;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import models.mDiem;

public class dDiem {
	/**
	 * return ArrayList<mDiem>
	 * Format: listDiem[] = { line, line1, ... }
	 * 		   String line = "stt, nienKhoa, maMon, mssv, hoTen, diemGK, diemCK, diemKhac, diemTong"
	 */
	public static ArrayList<mDiem> getListDiem () throws IOException {
		ArrayList<mDiem> listDiem = new ArrayList<mDiem>();
		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader("data/listBangDiem.txt"));
			String line;
			String arrayLine[];
			while ((line = br.readLine()) != null) {
				arrayLine = line.split("\\,");
				mDiem student = new mDiem(arrayLine[0], arrayLine[1], arrayLine[2], arrayLine[3], arrayLine[4],
						arrayLine[5], arrayLine[6], arrayLine[7], arrayLine[8]);
				listDiem.add(student);
			}
		} catch (IOException e) {
			listDiem = null;
			e.printStackTrace();
		}
		br.close();
		return listDiem;
	}
	
	/**
	 * Function: Update Diem for one student
	 * Format of request: inforEdited[] = { nienKhoa-maMon, mssv, diemGK, diemCK, diemKhac, diemTong } 
	 * Format of DB: arrLine[] = { stt, nienKhoa, maMon, mssv, hoTen, diemGK, diemCK, diemKhac, diemTong }
	 */
	public static boolean updateDiem (String[] infoEdited) throws IOException {
		BufferedReader br = null;
		BufferedWriter bw = null;
		boolean flag = false;
		ArrayList<String> listDiem = new ArrayList<String>();
		String nienKhoa_maMon [] = infoEdited[0].split("\\-");
		try {
			br = new BufferedReader(new FileReader("data/listBangDiem.txt"));
			String line;
			while ((line = br.readLine()) != null) {
				String arrLine[] = line.split("\\,");
				if (nienKhoa_maMon[0].equals(arrLine[1]) && nienKhoa_maMon[1].equals(arrLine[2]) && infoEdited[1].equals(arrLine[3])) {
					line = arrLine[0] + "," + arrLine[1] + "," + arrLine[2] + "," + arrLine[3] + "," + arrLine[4] + "," + infoEdited[2] + ","
							+ infoEdited[3] + "," + infoEdited[4] + "," + infoEdited[5];
					flag = true;
				}
				listDiem.add(line);
			}

			bw = new BufferedWriter(new FileWriter("data/listBangDiem.txt"));
			int i = 0;
			for (String diem : listDiem) {
				if (i == 0) {
					bw.append(diem);
				} else {
					bw.append("\n" + diem);
				}
				i++;
			}
			bw.flush();
			bw.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		br.close();
		return flag;
	}
}
