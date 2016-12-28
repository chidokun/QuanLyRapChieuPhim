/**
 * Quản lý Rạp chiếu phim RPP
 * Author: Nguyễn Tuấn - nguyentuanit96@gmail.com
 */

package rcp.controller;

import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import java.util.ArrayList;

import rcp.entity.TaiKhoan;
import rcp.entity.TaiKhoan1;
import rcp.model.TaiKhoanModel;
import rcp.util.MD5;

/**
 * @author Tuan
 *
 */
public class TaiKhoanController {

	/**
	 * Lấy danh sách tài khoản
	 * 
	 * @return
	 * @throws SQLException
	 */
	public static ArrayList<TaiKhoan> taiTatCa() throws SQLException {
		return TaiKhoanModel.taiTatCa();
	}

	/**
	 * Lấy tài khoản từ mã nhân viên
	 * 
	 * @param maNhanVien
	 * @return
	 * @throws SQLException
	 */
	public static TaiKhoan layThongTinTuMaNhanVien(String maNhanVien) throws SQLException {
		return TaiKhoanModel.layThongTinTuMaNhanVien(maNhanVien);
	}

	/**
	 * Thêm một tài khoản
	 * 
	 * @param tk
	 * @return
	 * @throws SQLException
	 */
	public static boolean them(TaiKhoan tk) throws SQLException {
		return TaiKhoanModel.them(tk);
	}

	/**
	 * Sửa một tài khoản
	 * 
	 * @param tk
	 * @return
	 * @throws SQLException
	 */
	public static boolean sua(TaiKhoan tk) throws SQLException {
		return TaiKhoanModel.sua(tk);
	}

	/**
	 * Xóa một tài khoản
	 * 
	 * @param tk
	 * @return
	 * @throws SQLException
	 */
	public static boolean xoa(TaiKhoan tk) throws SQLException {
		return TaiKhoanModel.xoa(tk);
	}

	/**
	 * Lấy danh sách tài khoản trên table
	 * 
	 * @return
	 * @throws SQLException
	 */
	public static ArrayList<TaiKhoan1> taiTatCaDS() throws SQLException {
		return TaiKhoanModel.taiTatCaDS();
	}

	/**
	 * Đặt lại mật khẩu một tài khoản
	 */
	public static boolean datLaiMatKhau(TaiKhoan tk) throws SQLException {
		return TaiKhoanModel.datLaiMatKhau(tk);
	}

	/**
	 * Kiểm tra tên đăng nhập và mật khẩu có hợp lệ
	 * 
	 * @param tenDangNhap
	 * @param matKhau
	 *            Mật khẩu dạng chưa mã hóa
	 * @return
	 * @throws SQLException
	 */
	public static boolean dangNhap(String tenDangNhap, String matKhau) {
		try {
			String pass = TaiKhoanModel.layMatKhau(tenDangNhap);

			if (!MD5.equals(matKhau, pass))
				throw new Exception();

			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	/**
	 * Lấy mã nhân viên từ tên đăng nhập
	 * 
	 * @param tenDangNhap
	 * @return
	 * @throws SQLException
	 */
	public static String layMaNhanVien(String tenDangNhap) throws SQLException {
		return TaiKhoanModel.layMaNhanVien(tenDangNhap);
	}

	/**
	 * Đổi mật khẩu
	 * 
	 * @param tenDangNhap
	 *            Tài khoản cần đổi
	 * @param matKhauCu
	 *            Bắt buộc phải khớp, cần kiểm tra lỗi không khớp bên ngoài hàm
	 *            này
	 * @param matKhauMoi
	 * @throws SQLException
	 * @throws NoSuchAlgorithmException
	 */
	public static void doiMatKhau(String tenDangNhap, String matKhauCu, String matKhauMoi)
			throws SQLException, NoSuchAlgorithmException {
		TaiKhoanModel.doiMatKhau(tenDangNhap, matKhauCu, matKhauMoi);
	}
	
	/**
	 * Lấy mã quyền từ tên đăng nhập
	 * 
	 * @param tenDangNhap
	 * @return
	 * @throws SQLException
	 */
	public static String layMaQuyen(String tenDangNhap) throws SQLException {
		return TaiKhoanModel.layMaQuyen(tenDangNhap);
	}
}
