package rcp.model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import rcp.entity.DinhDang;
import rcp.util.Database;

public class DinhDangModel {
	public static ArrayList<DinhDang> taiTatCa() throws SQLException {
		ResultSet rs = Database.callStored("sp_LayDanhSach_DinhDang", (Object[]) null);
		
		ArrayList<DinhDang> arr = new ArrayList<>();
		while (rs.next()) {
			arr.add(new DinhDang(rs.getString(1),rs.getString(2),rs.getDouble(3)));
		}

		return arr;
	}
}
