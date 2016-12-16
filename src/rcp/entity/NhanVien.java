/**
 * Quản lý Rạp chiếu phim RPP
 * Author: Nguyễn Tuấn - nguyentuanit96@gmail.com
 */

package rcp.entity;

import java.util.*;

public class NhanVien {
	private String maNhanVien;
	private String tenNhanVien;
	private Date ngaySinh;
	private String gioiTinh;
	private String diaChi;
	private String CMND;
	private String email;
	private String SDT;
	private String maChucVu;
	private Date ngayVaoLam;
	private int trangThai;

	public NhanVien() {
		// do nothing
	}

	public NhanVien(String maNhanVien, String tenNhanVien, Date ngaySinh, String gioiTinh, String diaChi, String CMND,
			String email, String SDT, String maChucVu, Date ngayVaoLam, int trangThai) {
		setMaNhanVien(maNhanVien);
		setTenNhanVien(tenNhanVien);
		setNgaySinh(ngaySinh);
		setGioiTinh(gioiTinh);
		setDiaChi(diaChi);
		setCMND(CMND);
		setEmail(email);
		setSDT(SDT);
		setMaChucVu(maChucVu);
		setNgayVaoLam(ngayVaoLam);
		setTrangThai(trangThai);
	}

	public String getMaNhanVien() {
		return maNhanVien;
	}

	public void setMaNhanVien(String maNhanVien) {
		this.maNhanVien = maNhanVien;
	}

	public String getTenNhanVien() {
		return tenNhanVien;
	}

	public void setTenNhanVien(String tenNhanVien) {
		this.tenNhanVien = tenNhanVien;
	}

	public Date getNgaySinh() {
		return ngaySinh;
	}

	public void setNgaySinh(Date ngaySinh) {
		this.ngaySinh = ngaySinh;
	}

	public String getGioiTinh() {
		return gioiTinh;
	}

	public void setGioiTinh(String gioiTinh) {
		this.gioiTinh = gioiTinh;
	}

	public String getDiaChi() {
		return diaChi;
	}

	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}

	public String getCMND() {
		return CMND;
	}

	public void setCMND(String cMND) {
		CMND = cMND;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSDT() {
		return SDT;
	}

	public void setSDT(String sDT) {
		SDT = sDT;
	}

	public String getMaChucVu() {
		return maChucVu;
	}

	public void setMaChucVu(String maChucVu) {
		this.maChucVu = maChucVu;
	}

	public Date getNgayVaoLam() {
		return ngayVaoLam;
	}

	public void setNgayVaoLam(Date ngayVaoLam) {
		this.ngayVaoLam = ngayVaoLam;
	}

	public int getTrangThai() {
		return trangThai;
	}

	public void setTrangThai(int trangThai) {
		this.trangThai = trangThai;
	}

}
