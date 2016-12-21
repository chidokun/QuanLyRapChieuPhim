package rcp.model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

import rcp.entity.Phim;
import rcp.util.Database;

public class GheModel {
	/**
	 * Tra cứu tên phim theo ngafy
	 * 
	 * @param ngay
	 * @return
	 * @throws SQLException
	 */
	public static ArrayList<String> layDanhSach(String maSuatChieu) throws SQLException {
		ResultSet rs = Database.callStored("sp_LayDanhSachGhe_SuatChieu", maSuatChieu);

		ArrayList<String> arr = new ArrayList<>();
		while (rs.next()) {
			arr.add(rs.getString(1));
		}
		return arr;
	}

}
