/**
 * Quản lý Rạp chiếu phim RPP
 * Author: Hồ Thị Kim Hoàng - hohoang.ag.96@gmail.com
 */

package rcp.entity;

import java.util.*;

public class HoaDonThucAn {
	private String maHoaDon;
	private Date ngayHoaDon;
	private double tongTien;
	private String maNhanVien;
	
	public HoaDonThucAn(){
		//nothing
	}
	
	public HoaDonThucAn(String maHoaDon, Date ngayHoaDon, double tongTien, String maNhanVien){
		setMaHoaDon(maHoaDon);
		setNgayHoaDon(ngayHoaDon);
		setTongTien(tongTien);
		setMaNhanVien(maNhanVien);
	}
	
	public String getMaHoaDon() {
		return maHoaDon;
	}
	public void setMaHoaDon(String maHoaDon) {
		this.maHoaDon = maHoaDon;
	}
	public Date getNgayHoaDon() {
		return ngayHoaDon;
	}
	public void setNgayHoaDon(Date ngayHoaDon) {
		this.ngayHoaDon = ngayHoaDon;
	}
	public double getTongTien() {
		return tongTien;
	}
	public void setTongTien(double tongTien) {
		this.tongTien = tongTien;
	}
	public String getMaNhanVien() {
		return maNhanVien;
	}
	public void setMaNhanVien(String maNhanVien) {
		this.maNhanVien = maNhanVien;
	}

}
