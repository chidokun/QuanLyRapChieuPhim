/**
 * Quản lý Rạp chiếu phim RPP
 * Author: Nguyễn Tuấn - nguyentuanit96@gmail.com
 */

package rcp.util;

import java.math.*;
import java.security.*;

public class MD5 {

	/**
	 * Mã hóa một chuỗi ký tự
	 * 
	 * @param input
	 * @return
	 * @throws NoSuchAlgorithmException
	 */
	public static String encrypt(String input) throws NoSuchAlgorithmException {
		MessageDigest md = MessageDigest.getInstance("MD5");
		byte[] messageDigest = md.digest(input.getBytes());
		BigInteger number = new BigInteger(1, messageDigest);
		String hashtext = number.toString(16);
		while (hashtext.length() < 32) {
			hashtext = "0" + hashtext;
		}
		return hashtext;
	}

	/**
	 * So sánh một chuỗi gốc và mã hóa của nó
	 * 
	 * @param input
	 *            Chuỗi gốc
	 * @param md5
	 *            Mã hóa của nó
	 * @return
	 * @throws NoSuchAlgorithmException
	 */
	public static boolean equals(String input, String md5) throws NoSuchAlgorithmException {
		return encrypt(input).equals(md5);
	}
}
