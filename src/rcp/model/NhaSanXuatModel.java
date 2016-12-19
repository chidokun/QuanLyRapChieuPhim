package rcp.model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import rcp.entity.NhaSanXuat;
import rcp.util.Database;

public class NhaSanXuatModel {
	public static ArrayList<NhaSanXuat> taiTatCa() throws SQLException {
		ResultSet rs = Database.callStored("sp_LayDanhSach_NhaSX", (Object[]) null);
		
		ArrayList<NhaSanXuat> arr = new ArrayList<>();
		while (rs.next()) {
			arr.add(new NhaSanXuat(rs.getString(1),rs.getString(2)));
		}

		return arr;
	}

}
