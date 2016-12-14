/**
 * Quản lý Rạp chiếu phim RPP 
 * Author: Võ Xuân Vương – vuongvo1809@gmail.com
 */

package rcp.entity;

import java.util.*;

public class Ve {
	private String maVe;
	private String maSuatChieu;
	private String maGhe;
	private Date ngayBanVe;
	private String maNhanVien;
	private double giaVe;
	private String maKM;
	private String maKhachHang;
	private int diemTichLuy;
	
	public Ve(){
		//nothing
	}
	
	public Ve(String maVe, String maSuatChieu, String maGhe, Date ngayBanVe, String maNhanVien,
			double giaVe, String maKM, String maKhachHang, int diemTichLuy ){
		setMaVe(maVe);
		setMaSuatChieu(maSuatChieu);
		setMaGhe(maGhe);
		setNgayBanVe(ngayBanVe);
		setMaNhanVien(maNhanVien);
		setGiaVe(giaVe);
		setMaKM(maKM);
		setMaKhachHang(maKhachHang);
		setDiemTichLuy(diemTichLuy);
	}
	
	public String getMaVe() {
		return maVe;
	}
	public void setMaVe(String maVe) {
		this.maVe = maVe;
	}
	public String getMaSuatChieu() {
		return maSuatChieu;
	}
	public void setMaSuatChieu(String maSuatChieu) {
		this.maSuatChieu = maSuatChieu;
	}
	public String getMaGhe() {
		return maGhe;
	}
	public void setMaGhe(String maGhe) {
		this.maGhe = maGhe;
	}
	public Date getNgayBanVe() {
		return ngayBanVe;
	}
	public void setNgayBanVe(Date ngayBanVe) {
		this.ngayBanVe = ngayBanVe;
	}
	public String getMaNhanVien() {
		return maNhanVien;
	}
	public void setMaNhanVien(String maNhanVien) {
		this.maNhanVien = maNhanVien;
	}
	public double getGiaVe() {
		return giaVe;
	}
	public void setGiaVe(double giaVe) {
		this.giaVe = giaVe;
	}
	public String getMaKM() {
		return maKM;
	}
	public void setMaKM(String maKM) {
		this.maKM = maKM;
	}
	public String getMaKhachHang() {
		return maKhachHang;
	}
	public void setMaKhachHang(String maKhachHang) {
		this.maKhachHang = maKhachHang;
	}
	public int getDiemTichLuy() {
		return diemTichLuy;
	}
	public void setDiemTichLuy(int diemTichLuy) {
		this.diemTichLuy = diemTichLuy;
	}
	

}
