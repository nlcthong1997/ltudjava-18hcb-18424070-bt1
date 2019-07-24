package controllers;

import java.io.IOException;
import java.util.ArrayList;

import handleData.dTkb;
import models.mTkb;

public class cTkbTheoKhoa {
	public static ArrayList<mTkb> getListTkbKhoa (String cLass) throws IOException {
		ArrayList<mTkb> listTkb = new ArrayList<mTkb>();
		for (mTkb tkb : dTkb.getListTkb()) {
			if (tkb.getNienKhoa().equals(cLass)) {
				listTkb.add(tkb);
			}
		}
		return listTkb;
	}
}
