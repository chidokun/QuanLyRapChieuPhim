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
public class KhuyenMaiModel {

	/**
	 * Lấy danh sách khuyến mãi
	 * @return
	 * @throws SQLException
	 */
	public static ArrayList<KhuyenMai> taiTatCa() throws SQLException {
		ResultSet rs = Database.callStored("sp_LayDanhSach_KhuyenMai", (Object[]) null);

		ArrayList<KhuyenMai> arr = new ArrayList<>();
		while (rs.next()) {
			arr.add(new KhuyenMai(rs.getString(1), rs.getString(2), rs.getString(3)));
		}
		
		return arr;
	}

}
