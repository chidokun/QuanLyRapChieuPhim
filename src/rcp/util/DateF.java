/**
 * 
 */
package rcp.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @author Tuan
 *
 */
public class DateF {
	public static Date toDate(String date) throws ParseException {
		SimpleDateFormat f = new SimpleDateFormat("dd/MM/yyyy");
		return f.parse(date);
	}
	
	
	public static Date toDate(int year, int month, int day) {
		Calendar cal = Calendar.getInstance();
		cal.set(year, month, day);
		return cal.getTime();
	}
	
	public static Date toDate(int year, int month, int day, int hour, int minute) {
		Calendar cal = Calendar.getInstance();
		cal.set(year, month, day, hour, minute);
		return cal.getTime();
	}
	
	public static Date toDate(int year, int month, int day, int hour, int minute,int second) {
		Calendar cal = Calendar.getInstance();
		cal.set(year, month, day, hour, minute,second);
		return cal.getTime();
	}
	
	public static String toString(Date date) {
		SimpleDateFormat f = new SimpleDateFormat("dd/MM/yyyy");
		return f.format(date);
	}
	
	public static String toString_full(Date date) {
		SimpleDateFormat f = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		return f.format(date);
	}
	
	public static int getYear(Date date) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		return cal.get(Calendar.YEAR);
	}
	
	public static int getMonth(Date date) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		return cal.get(Calendar.MONTH);
	}
	
	public static int getDay(Date date) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		return cal.get(Calendar.DATE);
	}
	
	public static int getHour(Date date) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		return cal.get(Calendar.HOUR);
	}
	
	public static int getMinute(Date date) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		return cal.get(Calendar.MINUTE);
	}

	public static int getSecond(Date date) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		return cal.get(Calendar.SECOND);
	}
}
