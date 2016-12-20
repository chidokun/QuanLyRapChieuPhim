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
public class SuatChieu {
	private String	 maSuatChieu;
	private String	 maPhim;
	private String	 tenPhim;
	private Date	 thoiGianChieu;
	private String	 dinhDang;
	private String	 hinhThuc;
	private String	 ngonNgu;
	private String	 phong;
	private int 	 trangThai;
	private String	 maSuatPhim;
	private String	 maPhong;
	private Date	 gioChieu;
	private Date	 ngayChieu;

	public SuatChieu() {
		// do nothing
	}

	public SuatChieu(String maSuatChieu,String maPhim, String tenPhim, Date thoiGianChieu, String dinhDang, String hinhThuc, String ngonNgu, String phong, int trangThai){
		setMaSuatChieu(maSuatChieu);
		setMaPhim(maPhim);
		setTenPhim(tenPhim);		
		setThoiGianChieu(thoiGianChieu);
		setDinhDang(dinhDang);
		setHinhThuc(hinhThuc);
		setNgonNgu(ngonNgu);
		setPhong(phong);
		setTrangThai(trangThai);
		setMaSuatPhim(maSuatPhim);
	}

	public SuatChieu(String maSuatChieu,String tenPhim, Date gioChieu, Date ngayChieu,String maSuatPhim, String dinhDang, String hinhThuc, String ngonNgu, String phong, int trangThai){
		setMaSuatChieu(maSuatChieu);
		setTenPhim(tenPhim);		
		setGioChieu(gioChieu);
		setNgayChieu(ngayChieu);
		setDinhDang(dinhDang);
		setHinhThuc(hinhThuc);
		setNgonNgu(ngonNgu);
		setPhong(phong);
		setTrangThai(trangThai);
		setMaSuatPhim(maSuatPhim);
	}
	
	
	public SuatChieu(String maSuatChieu,Date thoiGianChieu, String maSuatPhim, String maPhong, int trangThai){
		setMaSuatChieu(maSuatChieu);		
		setThoiGianChieu(thoiGianChieu);
		setMaSuatPhim(maSuatPhim);
		setMaPhong(maPhong);
		setTrangThai(trangThai);
	}
	
	public SuatChieu(String maSuatChieu,Date thoiGianChieu, String maSuatPhim, String maPhong){
		setMaSuatChieu(maSuatChieu);		
		setThoiGianChieu(thoiGianChieu);
		setMaSuatPhim(maSuatPhim);
		setMaPhong(maPhong);
	}
	
	
	public String getMaSuatChieu() {
		return maSuatChieu;
	}

	public void setMaSuatChieu(String maSuatChieu) {
		this.maSuatChieu = maSuatChieu;
	}
	
	public Date getGioChieu() {
		return gioChieu;
	}

	public void setGioChieu(Date gioChieu) {
		this.gioChieu = gioChieu;
	}
	
	public Date getNgayChieu() {
		return ngayChieu;
	}

	public void setNgayChieu(Date ngayChieu) {
		this.ngayChieu = ngayChieu;
	}
	
	
	public String getMaPhong() {
		return maPhong;
	}

	public void setMaPhong(String maPhong) {
		this.maPhong = maPhong;
	}
	
	public String getMaSuatPhim() {
		return maSuatPhim;
	}

	public void setMaSuatPhim(String maSuatPhim) {
		this.maSuatPhim = maSuatPhim;
	}
	
	public String getNgonNgu() {
		return ngonNgu;
	}

	public void setNgonNgu(String ngonNgu) {
		this.ngonNgu = ngonNgu;
	}
	
	public String getMaPhim() {
		return maPhim;
	}

	public void setMaPhim(String maPhim) {
		this.maPhim = maPhim;
	}
	
	public String getDinhDang() {
		return dinhDang;
	}

	public void setDinhDang(String dinhDang) {
		this.dinhDang = dinhDang;
	}
	
	public String getHinhThuc() {
		return hinhThuc;
	}

	public void setHinhThuc(String hinhThuc) {
		this.hinhThuc = hinhThuc;
	}
	

	public Date getThoiGianChieu() {
		return thoiGianChieu;
	}

	public void setThoiGianChieu(Date thoiGianChieu) {
		this.thoiGianChieu = thoiGianChieu;
	}

	public String getTenPhim() {
		return tenPhim;
	}

	public void setTenPhim(String tenPhim) {
		this.tenPhim = tenPhim;
	}

	public String getPhong() {
		return phong;
	}

	public void setPhong(String phong) {
		this.phong = phong;
	}

	public int getTrangThai() {
		return trangThai;
	}

	public void setTrangThai(int trangThai) {
		this.trangThai = trangThai;
	}


}
