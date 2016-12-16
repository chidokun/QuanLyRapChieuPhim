/**
 * Quản lý Rạp chiếu phim RPP
 * Author: Hồ Thị Kim Hoàng - hohoang.ag.96@gmail.com
 */

package rcp.entity;

import java.util.*;

public class ChiTietHDThucAn {
	private String maHoaDon;
	private String maThucAnKichCo;
	private int soLuong;
	
	public ChiTietHDThucAn(){
		//nothing
	}
	
	public ChiTietHDThucAn(String maHoaDon, String maThucAnKichCo, int soLuong){
		setMaHoaDon(maHoaDon);
		setMaThucAnKichCo(maThucAnKichCo);
		setSoLuong(soLuong);
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
