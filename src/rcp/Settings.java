/**
 * Quản lý Rạp chiếu phim RPP
 * Author: Nguyễn Tuấn - nguyentuanit96@gmail.com
 */

package rcp;

import java.util.*;

/**
 * @author Tuan
 *
 */
public class Settings {
	private static Hashtable<String, Object> settings = new Hashtable<>();
	
	
	/**
	 * Nạp cài đặt
	 */
	public static void load() {
		
	}
	
	public static Object get(String entry) {
		return settings.get(entry);
	}
	
	public static void set(String entry, Object value) {
		settings.replace(entry, value);
	}
	
	public static void save() {
		
	}
}
