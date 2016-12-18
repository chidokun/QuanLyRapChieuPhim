/**
 * Quản lý Rạp chiếu phim RPP
 * Author: Nguyễn Tuấn - nguyentuanit96@gmail.com
 */

package rcp.model;

import java.sql.*;
import java.util.*;
import rcp.util.*;
import rcp.entity.*;

/**
 * @author Tuan
 *
 */
public class NhanVienModel {

	/**
	 * Lấy tất cả nhân viên
	 * 
	 * @return
	 * @throws SQLException
	 */
	public static ArrayList<NhanVien> taiTatCa() throws SQLException {
		ResultSet rs = Database.callStored("sp_TraCuuNhanVien", null, null, null);

		ArrayList<NhanVien> arr = new ArrayList<>();
		while (rs.next()) {
			arr.add(new NhanVien(rs.getString(1), rs.getString(2), rs.getDate(3), rs.getString(4), rs.getString(5),
					rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getDate(10), rs.getInt(11)));
		}

		Database.connect().close();
		return arr;
	}

	/**
	 * Lấy thông tin một nhân viên
	 * 
	 * @param maNhanVien
	 *            Mã nhân viên
	 * @return
	 * @throws SQLException
	 */
	public static NhanVien layThongTin(String maNhanVien) throws SQLException {
		ResultSet rs = Database.callStored("sp_LayThongTin_NhanVien", maNhanVien);

		rs.next();
		NhanVien n = new NhanVien(rs.getString(1), rs.getString(2), rs.getDate(3), rs.getString(4), rs.getString(5),
				rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getDate(10), rs.getInt(11));
		Database.connect().close();
		return n;
	}

	/**
	 * Thêm một nhân viên mà không có tài khoản
	 * 
	 * @param nv
	 * @return
	 * @throws SQLException
	 */
	public static boolean them(NhanVien nv) throws SQLException {
		if (Database.callStoredUpdate("sp_ThemNhanVien", nv.getMaNhanVien(), nv.getTenNhanVien(), nv.getNgaySinh(),
				nv.getGioiTinh(), nv.getDiaChi(), nv.getCMND(), nv.getEmail(), nv.getSDT(), nv.getMaChucVu(),
				nv.getNgayVaoLam()) > 0) {
			Database.connect().close();
			return true;
		} else
			throw new SQLException("Không thể thêm nhân viên " + nv.getTenNhanVien());
	}

	/**
	 * Thêm một nhân viên kèm tài khoản
	 * 
	 * @param nv
	 * @param tk
	 * @return
	 * @throws SQLException
	 */
	public static boolean them(NhanVien nv, TaiKhoan tk) throws SQLException {
		Connection con = Database.connect();
		try {
			con.setAutoCommit(false);
			Database.callStoredUpdate("sp_ThemNhanVien", nv.getMaNhanVien(), nv.getTenNhanVien(), nv.getNgaySinh(),
					nv.getGioiTinh(), nv.getDiaChi(), nv.getCMND(), nv.getEmail(), nv.getSDT(), nv.getMaChucVu(),
					nv.getNgayVaoLam());

			Database.callStoredUpdate("sp_ThemTaiKhoan", tk.getTenDangNhap(), tk.getMaNhanVien(), tk.getMaQuyen());
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
	 * Sửa một nhân viên mà lựa chọn xóa tài khoản hoặc không
	 * 
	 * @param nv
	 * @param xoaTaiKhoan
	 * @return
	 * @throws SQLException
	 */
	public static boolean sua(NhanVien nv, boolean xoaTaiKhoan) throws SQLException {
		Connection con = Database.connect();
		try {
			con.setAutoCommit(false);

			if (Database.callStoredUpdate("sp_SuaNhanVien", nv.getMaNhanVien(), nv.getTenNhanVien(), nv.getNgaySinh(),
					nv.getGioiTinh(), nv.getDiaChi(), nv.getCMND(), nv.getEmail(), nv.getSDT(), nv.getMaChucVu(),
					nv.getNgayVaoLam(), nv.getTrangThai()) == 0)
				throw new SQLException();

			if (xoaTaiKhoan && !TaiKhoanModel.xoa(TaiKhoanModel.layThongTinTuMaNhanVien(nv.getMaNhanVien())))
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
	 * Sửa một nhân viên và thêm hoặc sửa tài khoản
	 * 
	 * @param nv
	 * @param tk
	 * @param themTaiKhoan
	 * @return
	 * @throws SQLException
	 */
	public static boolean sua(NhanVien nv, TaiKhoan tk, boolean themTaiKhoan) throws SQLException {
		Connection con = Database.connect();
		try {
			con.setAutoCommit(false);

			if (Database.callStoredUpdate("sp_SuaNhanVien", nv.getMaNhanVien(), nv.getTenNhanVien(), nv.getNgaySinh(),
					nv.getGioiTinh(), nv.getDiaChi(), nv.getCMND(), nv.getEmail(), nv.getSDT(), nv.getMaChucVu(),
					nv.getNgayVaoLam(), nv.getTrangThai()) == 0)
				throw new SQLException();

			if (themTaiKhoan) {
				if (!TaiKhoanModel.them(tk))
					throw new SQLException();
			} else {
				if (!TaiKhoanModel.sua(tk))
					throw new SQLException();
			}
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
	 * Tra cứu nhân viên theo tiêu chí Tiêu chí nào bỏ qua thì để null
	 * 
	 * @param tenNhanVien
	 * @param maChucVu
	 * @param CMND
	 * @return
	 * @throws SQLException
	 */
	public static ArrayList<NhanVien> traCuu(String tenNhanVien, String maChucVu, String CMND) throws SQLException {
		ResultSet rs = Database.callStored("sp_TraCuuNhanVien", tenNhanVien, maChucVu, CMND);

		ArrayList<NhanVien> arr = new ArrayList<>();
		while (rs.next()) {
			arr.add(new NhanVien(rs.getString(1), rs.getString(2), rs.getDate(3), rs.getString(4), rs.getString(5),
					rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getDate(10), rs.getInt(11)));
		}

		return arr;
	}

	/**
	 * Sinh mã nhân viên mới
	 * 
	 * @return
	 * @throws SQLException
	 */
	public static String taoMa() throws SQLException {
		CallableStatement st = Database.connect().prepareCall("{call sp_TaoMa_NhanVien (?)}");
		st.registerOutParameter(1, Types.VARCHAR);

		st.execute();
		return st.getString(1);
	}

	/**
	 * Kiểm tra nhân viên này có tài khoản hay chưa
	 * 
	 * @param maNhanVien
	 * @return
	 * @throws SQLException
	 */
	public static boolean coTaiKhoan(String maNhanVien) throws SQLException {
		ResultSet rs = Database.callStored("sp_KiemTra_CoTaiKhoan", maNhanVien);

		rs.next();
		return Boolean.parseBoolean(rs.getString(1));
	}
}
