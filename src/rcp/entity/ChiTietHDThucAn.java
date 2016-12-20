/**
 * Quản lý Rạp chiếu phim RPP
 * Author: Hồ Thị Kim Hoàng - hohoang.ag.96@gmail.com
 */

package rcp.entity;

import java.util.*;

public class ChiTietHDThucAn {
	private String maHoaDon;
	private String maThucAnKichCo;
	private String maThucAn;
	private String tenThucAn;
	private String kichCo;
	private Double donGia;
	private int soLuong;
	
	
	public ChiTietHDThucAn(){
		//nothing
	}
	
	public ChiTietHDThucAn(String maHoaDon, String maThucAnKichCo, int soLuong){
		setMaHoaDon(maHoaDon);
		setMaThucAnKichCo(maThucAnKichCo);
		setSoLuong(soLuong);
	}
	
	public ChiTietHDThucAn(String maThucAn, String tenThucAn,String kichCo,double donGia, int soLuong){
		setMaThucAn(maThucAn);
		setTenThucAn(tenThucAn);
		setKichCo(kichCo);
		setDonGia(donGia);
		setSoLuong(soLuong);
	}
	
	public String getMaThucAn() {
		return maThucAn;
	}

	public void setMaThucAn(String maThucAn) {
		this.maThucAn = maThucAn;
	}
	
	
	
	public String getTenThucAn() {
		return tenThucAn;
	}

	public void setTenThucAn(String tenThucAn) {
		this.tenThucAn = tenThucAn;
	}
	
	
	public String getKichCo() {
		return kichCo;
	}

	public void setKichCo(String kichCo) {
		this.kichCo = kichCo;
	}
	
	public double getDonGia() {
		return donGia;
	}

	public void setDonGia(double donGia) {
		this.donGia = donGia;
	}
	
	public String getMaHoaDon() {
		return maHoaDon;
	}

	public void setMaHoaDon(String maHoaDon) {
		this.maHoaDon = maHoaDon;
	}

	public String getMaThucAnKichCo() {
		return maThucAnKichCo;
	}

	public void setMaThucAnKichCo(String maThucAnKichCo) {
		this.maThucAnKichCo = maThucAnKichCo;
	}

	public int getSoLuong() {
		return soLuong;
	}

	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}
}
