package handleData;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import models.mSchedule;

public class dSchedule {
	/**
	 * Function: getListTkb 
	 * return ArrayList<mTkb> listTkb[ line, line1, ... ]
	 * 		  String line = "stt, nienKhoa, maMon, tenMon, phong"
	 */
	public static ArrayList<mSchedule> getListTkb() throws IOException {
		ArrayList<mSchedule> listTkb = new ArrayList<mSchedule>();
		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader("data/listTkb.txt"));
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
}
