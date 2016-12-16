/**
 * Quản lý Rạp chiếu phim RPP
 * Author: Nguyễn Tuấn - nguyentuanit96@gmail.com
 */

package rcp.model;

import java.sql.*;
import java.util.*;
import rcp.util.*;
import rcp.entity.*;

/**
 * @author Tuan
 *
 */
public class NhanVienModel {

	public static ArrayList<NhanVien> taiTatCa() throws SQLException {
		ResultSet rs = Database.callStored("sp_LayDanhSach_NhanVien", (Object[]) null);

		ArrayList<NhanVien> arr = new ArrayList<>();
		while (rs.next()) {
			arr.add(new NhanVien(rs.getString(1), rs.getString(2), rs.getDate(3), rs.getString(4), rs.getString(5),
					rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getDate(10), rs.getInt(11)));
		}

		return arr;
	}
	
	public static NhanVien layThongTin(String maNhanVien) throws SQLException {
		ResultSet rs = Database.callStored("sp_LayThongTin_NhanVien", maNhanVien);
		
		return new NhanVien(rs.getString(1), rs.getString(2), rs.getDate(3), rs.getString(4), rs.getString(5),
				rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getDate(10), rs.getInt(11));
	}
	
	public static boolean them(NhanVien nv) {
		
		return false;
	}
	
	public static boolean sua(NhanVien nv) {
		
		return false;
	}
	
	public static String taoMa() {
		return null;
	}

}
