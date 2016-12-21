/**
 * Quản lý Rạp chiếu phim RPP
 * Author: Huỳnh Duy Anh Toàn - anhtoan441996@gmail.com
 */

package rcp.entity;

/**
 * @author Toàn
 *
 */
public class ThucAn {
	private String maThucAn;
	private String tenThucAn;
	private String loaiThucAn;
	private int trangThai;
	private String kichCo;
	private double donGia;
	private String tenLoaiThucAn;

	public ThucAn() {
		// do nothing
	}

	public ThucAn(String maThucAn, String tenThucAn, String loaiThucAn, int trangThai){
		setMaThucAn(maThucAn);
		setTenThucAn(tenThucAn);
		setLoaiThucAn(loaiThucAn);
		setTrangThai(trangThai);
	}
	
	public ThucAn(String maThucAn, String tenThucAn, String loaiThucAn){
		setMaThucAn(maThucAn);
		setTenThucAn(tenThucAn);
		setLoaiThucAn(loaiThucAn);
	}
	
	
	public ThucAn(String maThucAn, String tenThucAn, String kichCo, double donGia, String tenLoaiThucAn){
		setMaThucAn(maThucAn);
		setTenThucAn(tenThucAn);
		setKichCo(kichCo);
		setDonGia(donGia);
		setTenLoaiThucAn(tenLoaiThucAn);
	}

	public String getTenLoaiThucAn() {
		return tenLoaiThucAn;
	}

	public void setTenLoaiThucAn(String tenLoaiThucAn) {
		this.tenLoaiThucAn = tenLoaiThucAn;
	}
	
	public double getDonGia() {
		return donGia;
	}

	public void setDonGia(double donGia) {
		this.donGia = donGia;
	}
	
	public String getKichCo() {
		return kichCo;
	}

	public void setKichCo(String kichCo) {
		this.kichCo = kichCo;
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

	public String getLoaiThucAn() {
		return loaiThucAn;
	}

	public void setLoaiThucAn(String loaiThucAn) {
		this.loaiThucAn = loaiThucAn;
	}

	public int getTrangThai() {
		return trangThai;
	}

	public void setTrangThai(int trangThai) {
		this.trangThai = trangThai;
	}


}
