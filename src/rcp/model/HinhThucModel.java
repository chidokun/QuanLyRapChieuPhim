/**
 * Quản lý Rạp chiếu phim RPP
 * Author: Hồ Thị Kim Hoàng - hohoang.ag.96@gmail.com
 */
package rcp.model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import rcp.entity.HinhThuc;
import rcp.util.Database;
/**
 * @author Hoang
 *
 */
public class HinhThucModel {
	/**
	 * Tải tất cả hình thức
	 * 
	 * @return
	 * @throws SQLException
	 */
	public static ArrayList<HinhThuc> taiTatCa() throws SQLException {
		ResultSet rs = Database.callStored("sp_LayDanhSach_HinhThuc", (Object[]) null);
		
		ArrayList<HinhThuc> arr = new ArrayList<>();
		while (rs.next()) {
			arr.add(new HinhThuc(rs.getString(1),rs.getString(2)));
		}

		return arr;
	}

}
