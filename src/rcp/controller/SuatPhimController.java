package rcp.controller;

import java.sql.SQLException;
import java.util.ArrayList;

import rcp.entity.SuatPhim;
import rcp.model.SuatPhimModel;

public class SuatPhimController {
	public static ArrayList<SuatPhim> taiDanhSach(String maPhim) throws SQLException{
		return SuatPhimModel.taiDanhSach(maPhim);
		
	}
	public static boolean them(SuatPhim sp) throws SQLException
	{
		return SuatPhimModel.them(sp);
	}
	public static boolean xoa(String maSP) throws SQLException
	{
		return SuatPhimModel.xoa(maSP);
	}


}
