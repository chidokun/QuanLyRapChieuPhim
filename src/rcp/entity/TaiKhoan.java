/**
 * Quản lý Rạp chiếu phim RPP
 * Author: Hồ Thị Kim Hoàng - hohoang.ag.96@gmail.com
 */

package rcp.entity;

public class TaiKhoan {
	private String tenDangNhap;
	private String matKhau;
	private String maNhanVien;
	private String maQuyen;
	private int trangThai;
	
	public TaiKhoan(){
		//nothing
	}
	
	public TaiKhoan(String tenDangNhap, String matKhau, 
			String maNhanVien, String maQuyen, int trangThai){
		setTenDangNhap(tenDangNhap);
		setMatKhau(matKhau);
		setMaNhanVien(maNhanVien);
		setMaQuyen(maQuyen);
		setTrangThai(trangThai);
	}
	
	public String getTenDangNhap() {
		return tenDangNhap;
	}
	public void setTenDangNhap(String tenDangNhap) {
		this.tenDangNhap = tenDangNhap;
	}
	public String getMatKhau() {
		return matKhau;
	}
	public void setMatKhau(String matKhau) {
		this.matKhau = matKhau;
	}
	public String getMaNhanVien() {
		return maNhanVien;
	}
	public void setMaNhanVien(String maNhanVien) {
		this.maNhanVien = maNhanVien;
	}
	public String getMaQuyen() {
		return maQuyen;
	}
	public void setMaQuyen(String maQuyen) {
		this.maQuyen = maQuyen;
	}
	public int getTrangThai() {
		return trangThai;
	}
	public void setTrangThai(int trangThai) {
		this.trangThai = trangThai;
	}
	

}
