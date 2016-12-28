/**
 * Quản lý Rạp chiếu phim RPP
 * Author: Hồ Thị Kim Hoàng - hohoang.ag.96@gmail.com
 */
package rcp.controller;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

import rcp.entity.BaoCaoPhim;
import rcp.entity.Phim;
import rcp.entity.SuatPhim;
import rcp.model.PhimModel;
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
