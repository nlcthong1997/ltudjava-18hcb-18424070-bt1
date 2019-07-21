package controllers;

import java.io.IOException;

import handleData.dUser;
import models.mUser;
import models.result;

public class cLogin {
	/*
	 * Return ['status', 'message', 'id_user', 'type_user']
	 */
	public static result dangNhap (String taiKhoan, String matKhau) {
		result rs = null;
		try {
			for(mUser user: dUser.getListUser()) {
				if (user.getUsername().equals(taiKhoan) && user.getPassword().equals(matKhau)) {
					rs = new result(true, "success", user.getId(), user.getType(), user.getUsername());
					break;
				} else {
					rs = new result(false, "Tai khoan khong dung", "", "", "");
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
			rs = new result(false, e.getMessage(), "", "", "");
		}
		return rs;
	}
}
