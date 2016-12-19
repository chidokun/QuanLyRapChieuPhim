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
public class QuyDinhModel {

	/**
	 * Lấy danh sách quy định
	 * 
	 * @return
	 * @throws SQLException
	 */
	public static ArrayList<QuyDinh> taiTatCa() throws SQLException {
		ResultSet rs = Database.callStored("sp_LayDanhSach_QuyDinh", (Object[]) null);

		ArrayList<QuyDinh> arr = new ArrayList<>();
		while (rs.next()) {
			arr.add(new QuyDinh(rs.getString(1), rs.getString(2), rs.getFloat(3), rs.getString(4)));
		}

		Database.connect().close();
		return arr;
	}

	/**
	 * Thay đổi quy định
	 * 
	 * @param qd
	 * @return
	 * @throws SQLException
	 */
	public static boolean sua(QuyDinh qd) throws SQLException {
		return Database.callStoredUpdate("sp_ThayDoiQuyDinh", qd.getMaQD(), qd.getGiaTri()) > 0;
	}

}
