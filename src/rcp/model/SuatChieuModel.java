/**
 * Quản lý Rạp chiếu phim RPP
 * Author: Huỳnh Duy Anh Toàn - anhtoan441996@gmail.com
 */

package rcp.model;

import java.sql.*;
import java.util.Date;
import java.util.*;
import rcp.util.*;
import rcp.entity.*;

/**
 * @author Toàn
 *
 */
public class SuatChieuModel {

	/**
	 * Lấy tất cả suất chiếu
	 * 
	 * @return
	 * @throws SQLException
	 */
	public static ArrayList<SuatChieu> taiTatCa() throws SQLException {
		ResultSet rs = Database.callStored("sp_TraCuuSuatChieu", null, null, null);

		ArrayList<SuatChieu> arr = new ArrayList<>();
		while (rs.next()) {
			arr.add(new SuatChieu(rs.getString(1), rs.getString(2), rs.getString(3), rs.getTimestamp(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getInt(9)));
		}

		Database.connect().close();
		return arr;
	}

	/**
	 * Lấy thông tin một suất chiếu
	 * 
	 * @param maSuatChieu
	 *            Mã Suất chiếu
	 * @return
	 * @throws SQLException
	 */
	public static SuatChieu layThongTin(String maSuatChieu) throws SQLException {
		ResultSet rs = Database.callStored("sp_LayThongTin_SuatChieu", maSuatChieu);

		rs.next();
		SuatChieu s = new SuatChieu(rs.getString(1), rs.getString(2), rs.getTime(3), rs.getDate(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8),rs.getString(9), rs.getInt(10));
		Database.connect().close();
		return s;
	}
	

	/**
	 * Thêm suất chiếu
	 * 
	 * @param sc
	 * @return
	 * @throws SQLException
	 */
	public static boolean them(SuatChieu sc) throws SQLException {
		Connection con = Database.connect();
		try {
			con.setAutoCommit(false);

			if (Database.callStoredUpdate("sp_ThemSuatChieu", sc.getMaSuatChieu(), sc.getThoiGianChieu(), sc.getMaSuatPhim(),
				sc.getMaPhong()) == 0)
				throw new SQLException();
			con.commit();
			return true;
		} catch (Exception e) {
			con.rollback();
			return false;
		} finally {
			con.close();
		}

	}

	/**
	 * Sửa suất chiếu
	 * 
	 * @param sc
	 * @return
	 * @throws SQLException
	 */
	public static boolean sua(SuatChieu sc) throws SQLException {
		Connection con = Database.connect();
		try {
			con.setAutoCommit(false);

			if (Database.callStoredUpdate("sp_SuaSuatChieu", sc.getMaSuatChieu(), sc.getThoiGianChieu(), sc.getMaSuatPhim(),
				sc.getMaPhong(), sc.getTrangThai()) == 0)
				throw new SQLException();
			con.commit();
			return true;
		} catch (Exception e) {
			con.rollback();
			return false;
		} finally {
			con.close();
		}

	}

	/**
	 * Tra cứu suất chiếu theo tiêu chí Tiêu chí nào bỏ qua thì để null
	 * 
	 * @param tenPhim
	 * @param tuNgay
	 * @param denNgay
	 * @return
	 * @throws SQLException
	 */
	public static ArrayList<SuatChieu> traCuu(String tenPhim, Date tuNgay, Date denNgay) throws SQLException {
		ResultSet rs = Database.callStored("sp_TraCuuSuatChieu", tenPhim, tuNgay, denNgay);

		ArrayList<SuatChieu> arr = new ArrayList<>();
		while (rs.next()) {
			arr.add(new SuatChieu(rs.getString(1), rs.getString(2), rs.getString(3), rs.getTimestamp(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getInt(9)));
		}

		return arr;
	}
	/**
	 * Tra cứu tên phim theo ngafy
	 * 
	 * @param ngay
	 * @return
	 * @throws SQLException
	 */
	public static ArrayList<Phim> traCuuPhim_theoNgay(Date ngay) throws SQLException {
		ResultSet rs = Database.callStored("sp_TraCuu_Phim_Ngay", ngay);

		ArrayList<Phim> arr = new ArrayList<>();
		while (rs.next()) {
			Phim p=new Phim();
			p.setMaPhim(rs.getString(1));
			p.setTenPhim(rs.getString(2));
			arr.add(p);
		}

		return arr;
	}
	
	/**
	 * Sinh mã suất chiếu mới
	 * 
	 * @return
	 * @throws SQLException
	 */
	public static String taoMa() throws SQLException {
		CallableStatement st = Database.connect().prepareCall("{call sp_TaoMa_SuatChieu (?)}");
		st.registerOutParameter(1, Types.VARCHAR);

		st.execute();
		return st.getString(1);
	}
	
	/**
	 * Lấy thông tin suất phim từ mã suất chiếu
	 * 
	 * @param maSuatChieu
	 * @return
	 * @throws SQLException
	 */
	public static SuatPhim layThongTin_SuatPhim_TuSuatChieu(String maSuatChieu) throws SQLException {
		ResultSet rs = Database.callStored("sp_LayThongTin_SuatPhim_TuMaSuatChieu", maSuatChieu);
		SuatPhim sp=new SuatPhim(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5));
		return sp;
	}
	
	/**
	 * @param maPhim
	 * @return
	 *  Lấy danh sách suất phim từ mã phim
	 */
	public static ArrayList<SuatPhim> layDanhSachSuatPhim(String maPhim) throws SQLException {
		ResultSet rs = Database.callStored("sp_LayDanhSach_SuatPhim", maPhim);

		ArrayList<SuatPhim> arr = new ArrayList<>();
		while (rs.next()) {
			arr.add(new SuatPhim(rs.getString(1), rs.getString(2),rs.getString(3),rs.getString(4)));
		}

		Database.connect().close();
		return arr;
	}
	
}
