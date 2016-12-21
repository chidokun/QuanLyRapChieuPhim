/**
 * Quản lý Rạp chiếu phim RPP 
 * Author: Võ Xuân Vương – vuongvo1809@gmail.com
 */

package rcp.entity;

public class TichLuy {
	private String maKhachHang;
	private int nam;
	private int tongDiemTichLuy;
	
	public TichLuy(){
		//nothing
	}
	
	public TichLuy(String maKhachHang, int nam, int tongDiemTichLuy){
		setMaKhachHang(maKhachHang);
		setNam(nam);
		setTongDiemTichLuy(tongDiemTichLuy);
	}
	
	public String getMaKhachHang() {
		return maKhachHang;
	}
	public void setMaKhachHang(String maKhachHang) {
		this.maKhachHang = maKhachHang;
	}
	public int getNam() {
		return nam;
	}
	public void setNam(int nam) {
		this.nam = nam;
	}
	public int getTongDiemTichLuy() {
		return tongDiemTichLuy;
	}
	public void setTongDiemTichLuy(int tongDiemTichLuy) {
		this.tongDiemTichLuy = tongDiemTichLuy;
	}
}
