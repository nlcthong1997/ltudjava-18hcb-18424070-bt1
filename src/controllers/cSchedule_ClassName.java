package controllers;

import java.io.IOException;
import java.util.ArrayList;

import handleData.dSchedule;
import models.mSchedule;

public class cSchedule_ClassName {
	
	//getListTkbKhoa
	public static ArrayList<mSchedule> getListScheduleFollowClassName (String cLass) throws IOException {
		ArrayList<mSchedule> listTkb = new ArrayList<mSchedule>();
		for (mSchedule schedule : dSchedule.getListTkb()) {
			if (schedule.getClassName().equals(cLass)) {
				listTkb.add(schedule);
			}
		}
		return listTkb;
	}
}
