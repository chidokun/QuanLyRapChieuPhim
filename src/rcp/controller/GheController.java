package rcp.controller;

import java.sql.SQLException;
import java.util.ArrayList;

import rcp.model.GheModel;

public class GheController {
	public static ArrayList<String> layDanhSach(String maSuatChieu) throws SQLException
	{
		return GheModel.layDanhSach(maSuatChieu);
	}
	

}
