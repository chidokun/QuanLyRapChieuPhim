package rcp.controller;

import java.sql.SQLException;
import java.util.ArrayList;

import rcp.entity.NgonNgu;
import rcp.entity.NhaSanXuat;
import rcp.model.NgonNguModel;
import rcp.model.NhaSanXuatModel;

public class NhaSanXuatController {
	public static ArrayList<NhaSanXuat> taiTatCa() throws SQLException
	{
		return NhaSanXuatModel.taiTatCa();
	}


}
