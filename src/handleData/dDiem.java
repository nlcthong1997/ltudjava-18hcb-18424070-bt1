package handleData;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import models.mDiem;

public class dDiem {
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
}
