/**
 * Quản lý Rạp chiếu phim RPP
 * Author: Nguyễn Tuấn - nguyentuanit96@gmail.com
 */

package rcp.util;

/**
 * @author Tuan
 *
 */
public class MathF {
	/**
	 * Chỉ giữ lại số trong chuỗi float
	 * 
	 * @param floatString
	 * @return
	 */
	public static String removeDot(String floatString) {
		StringBuilder str = new StringBuilder();
		char[] fChar = floatString.toCharArray();

		for (char i : fChar) {
			if (i >= '0' && i <= '9')
				str.append(i);
		}

		return str.toString();
	}

	/**
	 * Định dạng float với 3 chữ số thập phân
	 * 
	 * @param number
	 * @return
	 */
	public static String formatFloat(float number) {
		return String.format("%.3f", number);
	}

	/**
	 * Chuyển ký tự thập phân về nguyên bản
	 * 
	 * @param vnFloat
	 * @return
	 */
	public static float parseFloatVN(String vnFloat) {
		StringBuilder str = new StringBuilder(vnFloat);
		for (int i = 0; i < str.length(); i++)
			if (str.charAt(i) == ',')
				str.setCharAt(i, '.');

		return Float.parseFloat(str.toString());
	}
}
