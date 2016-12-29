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
import java.sql.*;
import java.util.Date;
import java.util.*;
import rcp.util.*;
import rcp.entity.*;
/**
 * @author Hoang
 *
 */
public class PhimController {
	/**
	 * Tra cứu phim
	 * 
	 * @param tenPhim, tuNgay, denNgay
	 *            Tên phim, từ ngày, đến ngày
	 * @return
	 * @throws SQLException
	 */
	public static ArrayList<Phim> traCuu(String TenPhim, Date TuNgay, Date DenNgay) throws SQLException{
		return PhimModel.traCuu(TenPhim, TuNgay, DenNgay);
		
	}
	/**
	 * Lấy mã phim tự phát sinh
	 * 
	 * @return
	 * @throws SQLException
	 */
	public static String hienMa() throws SQLException
	{
		return PhimModel.hienMa();
	}
	/**
	 * thêm phim mới
	 * 
	 * @param p, aSuatPhim
	 *            phim, danh sách suất phim
	 * @return
	 * @throws SQLException
	 */
	public static boolean them(Phim p, ArrayList<SuatPhim> aSuatPhim) throws SQLException {
		return PhimModel.them(p, aSuatPhim);
	}
	/**
	 * Cập nhật thông tin phim
	 * 
	 * @param p
	 *            phim
	 * @return
	 * @throws SQLException
	 */
	public static boolean sua(Phim p) throws SQLException {
		return PhimModel.sua(p);
	}
	/**
	 * Lấy thông tin một phim cụ thể
	 * 
	 * @param maPhim
	 *            mã phim
	 * @return
	 * @throws SQLException
	 */
	public static Phim layThongTin(String MaPhim) throws SQLException {
		return PhimModel.layThongTin(MaPhim);
	}
	/**
	 * Tải tất cả phim đang chiếu
	 * 
	 
	 * @return
	 * @throws SQLException
	 */
	public static ArrayList<Phim> taiTatCa_phimdangchieu() throws SQLException {
		return PhimModel.taiTatCa_phimdangchieu();
	}
	/**
	 * Báo cáo doanh thu phim
	 * 
	 * @param tuNgay, denNgay
	 *            từ ngày, đến ngày
	 * @return
	 * @throws SQLException
	 */
	public static ArrayList<BaoCaoPhim> baoCaoPhim(Date tuNgay, Date denNgay) throws SQLException {
		return PhimModel.baoCaoPhim(tuNgay, denNgay);
	}
}
