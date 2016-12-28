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
public class ChucVuModel {

	/**
	 * Lấy danh sách chức vụ
	 * 
	 * @return
	 * @throws SQLException
	 */
	public static ArrayList<ChucVu> taiTatCa() throws SQLException {
		ResultSet rs = Database.callStored("sp_LayDanhSach_ChucVu", (Object[]) null);

		ArrayList<ChucVu> arr = new ArrayList<>();
		while (rs.next()) {
			arr.add(new ChucVu(rs.getString(1), rs.getString(2), rs.getDouble(3)));
		}

		return arr;
	}
	
	

}
