/**
 * Quản lý Rạp chiếu phim RPP
 * Author: Nguyễn Tuấn - nguyentuanit96@gmail.com
 */

package rcp.model;

import java.sql.*;
import java.util.ArrayList;

import rcp.entity.*;
import rcp.util.*;

/**
 * @author Tuan
 *
 */
public class QuyenHanModel {

	public static ArrayList<QuyenHan> taiTatCa() throws SQLException {
		ResultSet rs = Database.callStored("sp_LayDanhSach_Quyen", (Object[]) null);

		ArrayList<QuyenHan> arr = new ArrayList<>();
		while (rs.next()) {
			arr.add(new QuyenHan(rs.getString(1), rs.getString(2), rs.getBoolean(3), rs.getBoolean(4), rs.getBoolean(5),
					rs.getBoolean(6), rs.getBoolean(7), rs.getBoolean(8), rs.getBoolean(9), rs.getBoolean(10),
					rs.getBoolean(11), rs.getBoolean(12), rs.getBoolean(13), rs.getBoolean(14), rs.getBoolean(15)));
		}

		return arr;
	}

}
