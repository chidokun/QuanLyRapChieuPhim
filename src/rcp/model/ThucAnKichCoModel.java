package rcp.model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


import rcp.entity.ThucAnKichCo;
import rcp.util.Database;

public class ThucAnKichCoModel {
	public static ArrayList<ThucAnKichCo> traCuu(int maLoaiThucAn) throws SQLException {
		ResultSet rs = Database.callStored("sp_TraCuuThucAnKichCo", maLoaiThucAn);

		ArrayList<ThucAnKichCo> arr = new ArrayList<>();
		while (rs.next()) {
			arr.add(new ThucAnKichCo(rs.getString(1), rs.getString(2),rs.getDouble(4), rs.getString(3)));
		}

		return arr;
	}

}
