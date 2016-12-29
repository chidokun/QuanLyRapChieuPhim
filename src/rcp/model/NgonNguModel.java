/**
 * Quản lý Rạp chiếu phim RPP
 * Author: Hồ Thị Kim Hoàng - hohoang.ag.96@gmail.com
 */
package rcp.model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import rcp.entity.NgonNgu;
import rcp.util.Database;
/**
 * @author Hoang
 *
 */
public class NgonNguModel {
	/**
	 * Tải tất cả ngôn ngữ
	 * 
	 * @return
	 * @throws SQLException
	 */
	public static ArrayList<NgonNgu> taiTatCa() throws SQLException {
		ResultSet rs = Database.callStored("sp_LayDanhSach_NgonNgu", (Object[]) null);
		
		ArrayList<NgonNgu> arr = new ArrayList<>();
		while (rs.next()) {
			arr.add(new NgonNgu(rs.getString(1),rs.getString(2)));
		}

		return arr;
	}
}
