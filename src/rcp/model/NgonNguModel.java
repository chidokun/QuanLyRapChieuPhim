package rcp.model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import rcp.entity.NgonNgu;
import rcp.util.Database;

public class NgonNguModel {
	public static ArrayList<NgonNgu> taiTatCa() throws SQLException {
		ResultSet rs = Database.callStored("sp_LayDanhSach_NgonNgu", (Object[]) null);
		
		ArrayList<NgonNgu> arr = new ArrayList<>();
		while (rs.next()) {
			arr.add(new NgonNgu(rs.getString(1),rs.getString(2)));
		}

		return arr;
	}
}
