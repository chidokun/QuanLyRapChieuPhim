/**
 * Quản lý Rạp chiếu phim RPP
 * Author: Hồ Thị Kim Hoàng - hohoang.ag.96@gmail.com
 */
package rcp.controller;
import java.sql.*;
import java.util.Date;
import java.util.*;
import rcp.entity.*;
import rcp.model.*;
import rcp.util.Database;
public class PhimController {
	public static ArrayList<Phim> traCuu(String TenPhim, Date TuNgay, Date DenNgay) throws SQLException{
		return PhimModel.traCuu(TenPhim, TuNgay, DenNgay);
		
	}
	public static String hienMa() throws SQLException
	{
		return PhimModel.hienMa();
	}
	public static boolean them(Phim p, ArrayList<SuatPhim> aSuatPhim) throws SQLException {
		return PhimModel.them(p, aSuatPhim);
	}
	public static boolean sua(Phim p) throws SQLException {
		return PhimModel.sua(p);
	}
	public static Phim layThongTin(String MaPhim) throws SQLException {
		return PhimModel.layThongTin(MaPhim);
	}
	public static ArrayList<Phim> taiTatCa_phimdangchieu() throws SQLException {
		return PhimModel.taiTatCa_phimdangchieu();
	}
	public static ArrayList<BaoCaoPhim> baoCaoPhim(Date tuNgay, Date denNgay) throws SQLException {
		return PhimModel.baoCaoPhim(tuNgay, denNgay);
	}
}
