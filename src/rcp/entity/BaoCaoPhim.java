/**
 * Quản lý Rạp chiếu phim RPP
 * Author: Nguyễn Tuấn - nguyentuanit96@gmail.com
 */

package rcp.entity;

public class BaoCaoPhim {
	private String maPhim;
	private String tenPhim;
	private double doanhThu;
	
	public BaoCaoPhim(){
		//nothing
	}
	
	public BaoCaoPhim(String maPhim, String tenPhim, double doanhThu){
		setMaPhim(maPhim);
		setTenPhim(tenPhim);
		setDoanhThu(doanhThu);
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

	public double getDoanhThu() {
		return doanhThu;
	}

	public void setDoanhThu(double doanhThu) {
		this.doanhThu = doanhThu;
	}
}
