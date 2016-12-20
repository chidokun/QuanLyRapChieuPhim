/**
 * Quản lý Rạp chiếu phim RPP
 * Author: Nguyễn Tuấn - nguyentuanit96@gmail.com
 */

package rcp.entity;

import java.util.Date;

public class BaoCaoKhachHang {
	private String maKhachHang;
	private String hoTen;
	private Date ngayDangKy;
	private String loaiKhachHang;
	private double doanhThu;
	
	public BaoCaoKhachHang(){
		//nothing
	}
	
	public BaoCaoKhachHang(String maKhachHang, String hoTen, Date ngayDangKy, String loaiKhachHang, double doanhThu){
		setMaKhachHang(maKhachHang);
		setHoTen(hoTen);
		setNgayDangKy(ngayDangKy);
		setLoaiKhachHang(loaiKhachHang);
		setDoanhThu(doanhThu);
	}

	public String getMaKhachHang() {
		return maKhachHang;
	}

	public void setMaKhachHang(String maKhachHang) {
		this.maKhachHang = maKhachHang;
	}

	public String getHoTen() {
		return hoTen;
	}

	public void setHoTen(String hoTen) {
		this.hoTen = hoTen;
	}

	public Date getNgayDangKy() {
		return ngayDangKy;
	}

	public void setNgayDangKy(Date ngayDangKy) {
		this.ngayDangKy = ngayDangKy;
	}

	public String getLoaiKhachHang() {
		return loaiKhachHang;
	}

	public void setLoaiKhachHang(String loaiKhachHang) {
		this.loaiKhachHang = loaiKhachHang;
	}

	public double getDoanhThu() {
		return doanhThu;
	}

	public void setDoanhThu(double doanhThu) {
		this.doanhThu = doanhThu;
	}

	
}
