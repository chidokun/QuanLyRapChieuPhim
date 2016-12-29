/**
 * Quản lý Rạp chiếu phim RPP
 * Author: Hồ Thị Kim Hoàng - hohoang.ag.96@gmail.com
 */
package rcp.model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import rcp.entity.NuocSX;
import rcp.util.Database;
/**
 * @author Hoang
 *
 */
public class NuocSanXuatModel {
	/**
	 * Tải tất cả nước sản xuất
	 * 
	 * @return
	 * @throws SQLException
	 */
	public static ArrayList<NuocSX> taiTatCa() throws SQLException {
		ResultSet rs = Database.callStored("sp_LayDanhSach_NuocSX", (Object[]) null);
		
		ArrayList<NuocSX> arr = new ArrayList<>();
		while (rs.next()) {
			arr.add(new NuocSX(rs.getString(1),rs.getString(2)));
		}

		return arr;
	}

}
