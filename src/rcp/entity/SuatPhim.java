/**
 * Quản lý Rạp chiếu phim RPP
 * Author: Huỳnh Duy Anh Toàn - anhtoan441996@gmail.com
 */

package rcp.entity;

/**
 * @author Toàn
 *
 */
public class SuatPhim {
	private String	 maSuatPhim;
	private String 	 maPhim;
	private String	 maDinhDang;
	private String	 maHinhThuc;
	private String 	 maNgonNgu;

	public SuatPhim() {
		// do nothing
	}

	public SuatPhim(String maSuatPhim,String maPhim, String maDinhDang, String maHinhThuc, String maNgonNgu){
		setMaSuatPhim(maSuatPhim);
		setMaPhim(maPhim);
		setMaDinhDang(maDinhDang);
		setMaHinhThuc(maHinhThuc);
		setMaNgonNgu(maNgonNgu);
	}
	
	public SuatPhim(String maSuatPhim, String maDinhDang, String maHinhThuc, String maNgonNgu){
		setMaSuatPhim(maSuatPhim);
		setMaDinhDang(maDinhDang);
		setMaHinhThuc(maHinhThuc);
		setMaNgonNgu(maNgonNgu);
	}

	public String getMaSuatPhim() {
		return maSuatPhim;
	}

	public void setMaSuatPhim(String maSuatPhim) {
		this.maSuatPhim = maSuatPhim;
	}

	public String getMaPhim() {
		return maPhim;
	}

	public void setMaPhim(String maPhim) {
		this.maPhim = maPhim;
	}

	public String getMaDinhDang() {
		return maDinhDang;
	}

	public void setMaDinhDang(String maDinhDang) {
		this.maDinhDang = maDinhDang;
	}

	public String getMaHinhThuc() {
		return maHinhThuc;
	}

	public void setMaHinhThuc(String maHinhThuc) {
		this.maHinhThuc = maHinhThuc;
	}

	public String getMaNgonNgu() {
		return maNgonNgu;
	}

	public void setMaNgonNgu(String maNgonNgu) {
		this.maNgonNgu = maNgonNgu;
	}


}
