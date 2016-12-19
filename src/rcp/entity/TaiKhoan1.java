/** 
 * Quản lý Rạp chiếu phim RPP 
 * Author: Võ Xuân Vương – vuongvo1809@gmail.com
 */

package rcp.entity;

public class TaiKhoan1 {
	private String tenDangNhap;
	private String maNhanVien;
	private String tenNhanVien;
	private String maQuyen;
	private String tenQuyen;
	private int trangThai;
	
	public TaiKhoan1(){
		
	}
	
	public TaiKhoan1(String tenDangNhap, String maNhanVien, String tenNhanVien, String maQuyen,String tenQuyen, int trangThai){
		setTenDangNhap(tenDangNhap);
		setMaNhanVien(maNhanVien);
		setTenNhanVien(tenNhanVien);
		setMaQuyen(maQuyen);
		setTenQuyen(tenQuyen);
		setTrangThai(trangThai);
	}
	
	public String getTenDangNhap() {
		return tenDangNhap;
	}
	public void setTenDangNhap(String tenDangNhap) {
		this.tenDangNhap = tenDangNhap;
	}
	public String getMaNhanVien() {
		return maNhanVien;
	}
	public void setMaNhanVien(String maNhanVien) {
		this.maNhanVien = maNhanVien;
	}
	public String getTenNhanVien() {
		return tenNhanVien;
	}
	public void setTenNhanVien(String tenNhanVien) {
		this.tenNhanVien = tenNhanVien;
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
	public String getTenQuyen() {
		return tenQuyen;
	}

	public void setTenQuyen(String tenQuyen) {
		this.tenQuyen = tenQuyen;
	}
	
}
