/**
 * Quản lý Rạp chiếu phim RPP 
 * Author: Võ Xuân Vương – vuongvo1809@gmail.com
 */

package rcp.model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

import rcp.entity.Ve;
import rcp.util.Database;

public class VeModel {

	/**
	 * Lấy tất cả vé
	 * 
	 * @return
	 * @throws SQLException
	 */
	public static ArrayList<Ve> taiTatCa() throws SQLException {
		ResultSet rs = Database.callStored("sp_TraCuuVe", null, null, null, null);

		ArrayList<Ve> arr = new ArrayList<>();
		while (rs.next()) {
			arr.add(new Ve(rs.getString(1), rs.getString(2), rs.getString(3), rs.getDate(4), rs.getString(5),
					rs.getDouble(6), rs.getString(7), rs.getString(8), rs.getInt(9)));
		}

		Database.connect().close();
		return arr;
	}

	/**
	 * Tra cứu vé theo tiêu chí nào đó
	 */
	public static ArrayList<Ve> traCuu(String maVe, String maKhachHang, Date tuNgay, Date denNgay) throws SQLException {
		ResultSet rs = Database.callStored("sp_TraCuuVe", maVe, maKhachHang, tuNgay, denNgay);

		ArrayList<Ve> arr = new ArrayList<>();
		while (rs.next()) {
			arr.add(new Ve(rs.getNString(1), rs.getString(2), rs.getString(3), rs.getDate(4), rs.getString(5),
					rs.getDouble(6), rs.getString(7), rs.getString(8), rs.getInt(9)));
		}

		return arr;
	}

}
