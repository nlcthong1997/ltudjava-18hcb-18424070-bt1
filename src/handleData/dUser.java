package handleData;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FilterInputStream;
import java.io.IOException;
import java.util.ArrayList;
import models.mUser;

public class dUser {
	public static ArrayList<mUser> getListUser() throws IOException {
		//create list user
		ArrayList<mUser> listUser = new ArrayList<mUser>();
		
		FileInputStream file = null;
        FilterInputStream filter = null;
        try {
            file = new FileInputStream(new File("data/user.txt"));
            filter = new BufferedInputStream(file);
            //comment: "\n" => 10, "|" => 124, " " => 32 
            int k = 0;
            String line = "";
            String arrayLine [];
            while ((k = filter.read()) != -1) {
            	if (k != 10) {
            		line += (char)k;
            	} else {
            		arrayLine = line.split("\\|");
            		mUser user = new mUser(arrayLine[0], arrayLine[1], arrayLine[2], arrayLine[3]);
            		listUser.add(user);
            		line = "";
            	}
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        file.close();
        filter.close();
		return listUser;

	}
}
