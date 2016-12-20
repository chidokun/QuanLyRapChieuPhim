/**
 * Quản lý Rạp chiếu phim RPP
 * Author: Nguyễn Tuấn - nguyentuanit96@gmail.com
 */

package rcp.model;

import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import rcp.entity.*;
import rcp.util.*;

/**
 * @author Tuan
 *
 */
public class PhimModel {

	public static ArrayList<BaoCaoPhim> baoCaoPhim(Date tuNgay, Date denNgay) throws SQLException {
		ResultSet rs = Database.callStored("sp_BaoCao_DoanhThuPhim", tuNgay, denNgay);
		
		ArrayList<BaoCaoPhim> arr = new ArrayList<>();
		while (rs.next()) {
			arr.add(new BaoCaoPhim(rs.getString(1),rs.getString(2),rs.getDouble(3)));
		}

		return arr;
	}
}
