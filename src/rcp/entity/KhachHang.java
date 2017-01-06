/**
 * Quản lý Rạp chiếu phim RPP
 * Author: Nguyễn Tuấn - nguyentuanit96@gmail.com
 */

package rcp.entity;

import java.util.*;

/**
 * @author Tuan
 *
 */
public class KhachHang {
	private String maKhachHang;
	private String gioiTinh;
	private String hoTen;
	private String cMND;
	private Date ngaySinh;
	private String email;
	private String sDT;
	private String maLoaiKH;
	private Date ngayDangKy;
	private int diemTichLuy;

	public KhachHang() {
		// do nothing
	}

	public KhachHang(String maKhachHang, String hoTen, String gioiTinh, String cMND, Date ngaySinh, String email,
			String sDT, String maLoaiKH, Date ngayDangKy) {
		setMaKhachHang(maKhachHang);
		setHoTen(hoTen);
		setGioiTinh(gioiTinh);
		setCMND(cMND);
		setNgaySinh(ngaySinh);
		setEmail(email);
		setSDT(sDT);
		setMaLoaiKH(maLoaiKH);
		setNgayDangKy(ngayDangKy);
	}

	public String getMaKhachHang() {
		return maKhachHang;
	}

	public void setMaKhachHang(String maKhachHang) {
		this.maKhachHang = maKhachHang;
	}

	public String getGioiTinh() {
		return gioiTinh;
	}

	public void setGioiTinh(String gioiTinh) {
		this.gioiTinh = gioiTinh;
	}

	public String getHoTen() {
		return hoTen;
	}

	public void setHoTen(String hoTen) {
		this.hoTen = hoTen;
	}

	public String getCMND() {
		return cMND;
	}

	public void setCMND(String cMND) {
		this.cMND = cMND;
	}

	public Date getNgaySinh() {
		return ngaySinh;
	}

	public void setNgaySinh(Date ngaySinh) {
		this.ngaySinh = ngaySinh;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSDT() {
		return sDT;
	}

	public void setSDT(String sDT) {
		this.sDT = sDT;
	}

	public String getMaLoaiKH() {
		return maLoaiKH;
	}

	public void setMaLoaiKH(String maLoaiKH) {
		this.maLoaiKH = maLoaiKH;
	}

	public Date getNgayDangKy() {
		return ngayDangKy;
	}

	public void setNgayDangKy(Date ngayDangKy) {
		this.ngayDangKy = ngayDangKy;
	}

	public int getDiemTichLuy() {
		return diemTichLuy;
	}

	public void setDiemTichLuy(int diemTichLuy) {
		this.diemTichLuy = diemTichLuy;
	}

}
