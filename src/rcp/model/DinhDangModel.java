/**
 * Quản lý Rạp chiếu phim RPP
 * Author: Hồ Thị Kim Hoàng - hohoang.ag.96@gmail.com
 */
package rcp.model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import rcp.entity.DinhDang;
import rcp.util.Database;
/**
 * @author Hoang
 *
 */
public class DinhDangModel {
	/**
	 * Tải tất cả định dạng
	 * 
	 * @return
	 * @throws SQLException
	 */
	public static ArrayList<DinhDang> taiTatCa() throws SQLException {
		ResultSet rs = Database.callStored("sp_LayDanhSach_DinhDang", (Object[]) null);
		
		ArrayList<DinhDang> arr = new ArrayList<>();
		while (rs.next()) {
			arr.add(new DinhDang(rs.getString(1),rs.getString(2),rs.getDouble(3)));
		}

		return arr;
	}
}
