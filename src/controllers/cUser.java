package controllers;

import java.io.IOException;

import models.result;
import handleData.dUser;

public class cUser {
	public static result doiMatKhau(String id, String userName, String type, String matKhau) throws IOException {
		result rs = null;
		if (dUser.doiMatKhau(id, userName, type, matKhau)) {
			rs = new result(true, "Doi mat khau thanh cong.", "", "", "");
		} else {
			rs = new result(true, "Doi mat khau that bai.", "", "", "");
		}
		return rs;
	}
}
