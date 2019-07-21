package handleData;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import models.mUser;

public class dUser {
	public static ArrayList<mUser> getListUser() throws IOException {
		// create list user
		ArrayList<mUser> listUser = new ArrayList<mUser>();
		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader("data/user.txt"));
			String line;
			String arrayLine[];
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

	public static boolean doiMatKhau(String id, String userName, String type, String matKhau) throws IOException {
		BufferedReader br = null;
		BufferedWriter bw = null;
		boolean flag = false;
		ArrayList<String> listUser = new ArrayList<String>();
		try {
			br = new BufferedReader(new FileReader("data/user.txt"));
			String line;
			String lineCompare = id + "," + userName;
			String lineReplace = id + "," + userName + "," + matKhau + "," + type;
			while ((line = br.readLine()) != null) {
				if (line.contains(lineCompare)) {
					line = line.replace(line, lineReplace);
				}
				listUser.add(line);
			}

			bw = new BufferedWriter(new FileWriter("data/user.txt"));
			int i = 0;
			for (String user : listUser) {
				if (i == 0) {
					bw.append(user);
				} else {
					bw.append("\n" + user);
				}
				i++;
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
}
