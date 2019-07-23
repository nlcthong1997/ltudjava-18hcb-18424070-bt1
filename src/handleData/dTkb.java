package handleData;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import models.mTkb;

public class dTkb {
	public static ArrayList<mTkb> getListTkb() throws IOException {
		ArrayList<mTkb> listTkb = new ArrayList<mTkb>();
		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader("data/listTkb.txt"));
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
}
