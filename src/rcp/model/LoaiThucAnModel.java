/**
 * Quản lý Rạp chiếu phim RPP
 * Author: Huỳnh Duy Anh Toàn - anhtoan441996@gmail.com
 */

package rcp.model;

import java.sql.*;
import java.util.ArrayList;

import rcp.entity.*;
import rcp.util.*;

/**
 * @author Toàn
 *
 */
public class LoaiThucAnModel {

	public static ArrayList<LoaiThucAn> taiTatCa() throws SQLException {
		ResultSet rs = Database.callStored("sp_LayDanhSach_LoaiThucAn", (Object[]) null);
		
		ArrayList<LoaiThucAn> arr = new ArrayList<>();
		while (rs.next()) {
			arr.add(new LoaiThucAn(rs.getString(1),rs.getString(2)));
		}

		return arr;
	}

}
