package com.hard.helpers;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class DateHelper {
	public static String getCurrentTime() {
		Calendar calendar = Calendar.getInstance();
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm:ss");
		return simpleDateFormat.format(calendar.getTime());
	}
	
	public static String getCurrentYear() {
		Calendar calendar = Calendar.getInstance();
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("y");
		return simpleDateFormat.format(calendar.getTime());
	}
}