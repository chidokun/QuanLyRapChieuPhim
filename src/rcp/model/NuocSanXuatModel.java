package rcp.model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import rcp.entity.NuocSX;
import rcp.util.Database;

public class NuocSanXuatModel {
	public static ArrayList<NuocSX> taiTatCa() throws SQLException {
		ResultSet rs = Database.callStored("sp_LayDanhSach_NuocSX", (Object[]) null);
		
		ArrayList<NuocSX> arr = new ArrayList<>();
		while (rs.next()) {
			arr.add(new NuocSX(rs.getString(1),rs.getString(2)));
		}

		return arr;
	}

}
