/**
 * Quản lý Rạp chiếu phim RPP
 * Author: Hồ Thị Kim Hoàng - hohoang.ag.96@gmail.com
 */
package rcp.model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import rcp.entity.NhaSanXuat;
import rcp.util.Database;
/**
 * @author Hoang
 *
 */
public class NhaSanXuatModel {
	/**
	 * Tải tất cả nhà sản xuất
	 * 
	 * @return
	 * @throws SQLException
	 */
	public static ArrayList<NhaSanXuat> taiTatCa() throws SQLException {
		ResultSet rs = Database.callStored("sp_LayDanhSach_NhaSX", (Object[]) null);
		
		ArrayList<NhaSanXuat> arr = new ArrayList<>();
		while (rs.next()) {
			arr.add(new NhaSanXuat(rs.getString(1),rs.getString(2)));
		}

		return arr;
	}

}
