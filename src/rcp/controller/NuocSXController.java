package rcp.controller;

import java.sql.SQLException;
import java.util.ArrayList;

import rcp.entity.NgonNgu;
import rcp.entity.NuocSX;
import rcp.model.NgonNguModel;
import rcp.model.NuocSanXuatModel;

public class NuocSXController {
	public static ArrayList<NuocSX> taiTatCa() throws SQLException
	{
		return NuocSanXuatModel.taiTatCa();
	}


}
