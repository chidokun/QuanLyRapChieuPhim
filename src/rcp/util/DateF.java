/**
 * Quản lý Rạp chiếu phim RPP
 * Author: Nguyễn Tuấn - nguyentuanit96@gmail.com
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

	/**
	 * Chuyển chuỗi ngày thành Date
	 * 
	 * @param date
	 * @return
	 * @throws ParseException
	 */
	public static Date toDate(String date) throws ParseException {
		SimpleDateFormat f = new SimpleDateFormat("dd/MM/yyyy");
		return f.parse(date);
	}

	/**
	 * Tạo Date bằng tham số
	 * 
	 * @param year
	 * @param month
	 * @param day
	 * @return
	 */
	public static Date toDate(int year, int month, int day) {
		Calendar cal = Calendar.getInstance();
		cal.set(year, month, day);
		return cal.getTime();
	}

	/**
	 * Tạo Date bằng tham số
	 * 
	 * @param year
	 * @param month
	 * @param day
	 * @param hour
	 * @param minute
	 * @return
	 */
	public static Date toDate(int year, int month, int day, int hour, int minute) {
		Calendar cal = Calendar.getInstance();
		cal.set(year, month, day, hour, minute);
		return cal.getTime();
	}

	/**
	 * Tạo Date bằng tham số
	 * 
	 * @param year
	 * @param month
	 * @param day
	 * @param hour
	 * @param minute
	 * @param second
	 * @return
	 */
	public static Date toDate(int year, int month, int day, int hour, int minute, int second) {
		Calendar cal = Calendar.getInstance();
		cal.set(year, month, day, hour, minute, second);
		return cal.getTime();
	}

	/**
	 * Chuyển Date thành chuỗi dd/MM/yyyy
	 * 
	 * @param date
	 * @return
	 */
	public static String toString(Date date) {
		SimpleDateFormat f = new SimpleDateFormat("dd/MM/yyyy");
		return f.format(date);
	}

	/**
	 * Chuyển Date thành chuỗi dd/MM/yyyy HH:mm:ss
	 * 
	 * @param date
	 * @return
	 */
	public static String toString_full(Date date) {
		SimpleDateFormat f = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		return f.format(date);
	}

	/**
	 * Lấy năm
	 * 
	 * @param date
	 * @return
	 */
	public static int getYear(Date date) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		return cal.get(Calendar.YEAR);
	}

	/**
	 * Lấy tháng
	 * 
	 * @param date
	 * @return
	 */
	public static int getMonth(Date date) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		return cal.get(Calendar.MONTH);
	}

	/**
	 * Lấy ngày
	 * 
	 * @param date
	 * @return
	 */
	public static int getDay(Date date) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		return cal.get(Calendar.DATE);
	}

	/**
	 * Lấy giờ
	 * 
	 * @param date
	 * @return
	 */
	public static int getHour(Date date) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		return cal.get(Calendar.HOUR_OF_DAY);
	}

	/**
	 * Lấy phút
	 * 
	 * @param date
	 * @return
	 */
	public static int getMinute(Date date) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		return cal.get(Calendar.MINUTE);
	}

	/**
	 * Lấy giây
	 * 
	 * @param date
	 * @return
	 */
	public static int getSecond(Date date) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		return cal.get(Calendar.SECOND);
	}
}
