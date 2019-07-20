package handleData;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import models.mUser;

public class dUser {
	public static ArrayList<mUser> getListUser() throws IOException {
		//create list user
		ArrayList<mUser> listUser = new ArrayList<mUser>();
		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader("data/user.txt"));
			String line;
			String arrayLine [];
			while ((line = br.readLine()) != null) {
				arrayLine = line.split("\\,");
//				System.out.println("test: " + arrayLine[0] + " " + arrayLine[1] + " " + arrayLine[2] + " " + arrayLine[3]);
				mUser user = new mUser(arrayLine[0], arrayLine[1], arrayLine[2], arrayLine[3]);
        		listUser.add(user);
			}
		} catch (IOException e) {
			listUser = null;
			e.printStackTrace();
		}
		br.close();
		return listUser;
	}
}
