/**
 * Quản lý Rạp chiếu phim RPP
 * Author: Huỳnh Duy Anh Toàn - anhtoan441996@gmail.com
 */

package rcp.entity;

import java.util.*;

/**
 * @author Toàn
 *
 */
public class Phim {
	private String	 maPhim;
	private String	 tenPhim ;
	private int	 	 thoiLuong;
	private String	 maNhaSX;
	private int 	 namSX;
	private String	 maNgonNgu;
	private Date ngayKhoiChieu ;
	private String	 tomTat;
	private String	 maNuocSX;
	private int 	 gioiHanTuoi;
	private double	 doanhThu;
	private String	 cacDienVien;
	private int 	 trangThai;


	public Phim() {
		// do nothing
	}

	public Phim(String maPhim,String tenPhim, int thoiLuong, String maNhaSX, int namSX,String maNgonNgu,Date ngayKhoiChieu
			,String	 tomTat,String maNuocSX,int gioiHanTuoi,double doanhThu,String cacDienVien,int trangThai){
		setMaPhim(maPhim);
		setTenPhim(tenPhim);
		setThoiLuong(thoiLuong);
		setMaNhaSX(maNhaSX);
		setNamSX(namSX);
		setMaNgonNgu(maNgonNgu);
		setNgayKhoiChieu(ngayKhoiChieu);
		setTomTat(tomTat);
		setMaNuocSX(maNuocSX);
		setGioiHanTuoi(gioiHanTuoi);
		setDoanhThu(doanhThu);
		setCacDienVien(cacDienVien);
		setTrangThai(trangThai);
	}
	
	public String getMaPhim() {
		return maPhim;
	}

	public void setMaPhim(String maPhim) {
		this.maPhim = maPhim;
	}
	
	public String getTenPhim() {
		return tenPhim;
	}

	public void setTenPhim(String tenPhim) {
		this.tenPhim = tenPhim;
	}	

	
	public int getThoiLuong() {
		return thoiLuong;
	}

	public void setThoiLuong(int thoiLuong) {
		this.thoiLuong = thoiLuong;
	}	

	public String getMaNhaSX() {
		return maNhaSX;
	}

	public void setMaNhaSX(String maNhaSX) {
		this.maNhaSX = maNhaSX;
	}
	
	public int getNamSX() {
		return namSX;
	}

	public void setNamSX(int namSX) {
		this.namSX = namSX;
	}
	
	public String getMaNgonNgu() {
		return maNgonNgu;
	}

	public void setMaNgonNgu(String maNgonNgu) {
		this.maNgonNgu = maNgonNgu;
	}


	public Date getNgayKhoiChieu() {
		return ngayKhoiChieu;
	}

	public void setNgayKhoiChieu(Date ngayKhoiChieu) {
		this.ngayKhoiChieu = ngayKhoiChieu;
	}

	public String getTomTat() {
		return tomTat;
	}

	public void setTomTat(String tomTat) {
		this.tomTat = tomTat;
	}
	
	public String getMaNuocSX() {
		return maNuocSX;
	}

	public void setMaNuocSX(String maNuocSX) {
		this.maNuocSX = maNuocSX;
	}
	
	
	public int getGioiHanTuoi() {
		return gioiHanTuoi;
	}

	public void setGioiHanTuoi(int gioiHanTuoi) {
		this.gioiHanTuoi = gioiHanTuoi;
	}
	
	public double getDoanhThu() {
		return doanhThu;
	}

	public void setDoanhThu(double doanhThu) {
		this.doanhThu = doanhThu;
	}
	
	public String getCacDienVien() {
		return cacDienVien;
	}

	public void setCacDienVien(String cacDienVien) {
		this.cacDienVien = cacDienVien;
	}

	
	public int getTrangThai() {
		return trangThai;
	}

	public void setTrangThai(int trangThai) {
		this.trangThai = trangThai;
	}

	


}
