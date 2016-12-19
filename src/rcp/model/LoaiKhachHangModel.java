/**
 * Quản lý Rạp chiếu phim RPP 
 * Author: Võ Xuân Vương – vuongvo1809@gmail.com
 */

package rcp.model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import rcp.entity.LoaiKhachHang;
import rcp.util.Database;

/**
 * @author Vuong
 *
 */
public class LoaiKhachHangModel {

	/**
	 * Lấy danh sách loại khách hàng
	 * 
	 * @return
	 * @throws SQLException
	 */
	public static ArrayList<LoaiKhachHang> taiTatCa() throws SQLException {
		ResultSet rs = Database.callStored("sp_LayDanhSach_LoaiKH", (Object[]) null);

		ArrayList<LoaiKhachHang> arr = new ArrayList<>();
		while (rs.next()) {
			arr.add(new LoaiKhachHang(rs.getString(1), rs.getString(2)));
		}

		return arr;
	}
}
