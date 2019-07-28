package controllers;

import java.io.IOException;
import java.util.ArrayList;

import handleData.dTkb;
import models.mSchedule;

public class cTkbTheoKhoa {
	public static ArrayList<mSchedule> getListTkbKhoa (String cLass) throws IOException {
		ArrayList<mSchedule> listTkb = new ArrayList<mSchedule>();
		for (mSchedule schedule : dTkb.getListTkb()) {
			if (schedule.getClassName().equals(cLass)) {
				listTkb.add(schedule);
			}
		}
		return listTkb;
	}
}
