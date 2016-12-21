/**
 * Quản lý Rạp chiếu phim RPP
 * Author: Huỳnh Duy Anh Toàn - anhtoan441996@gmail.com
 */

package rcp.entity;

/**
 * @author Toàn
 *
 */
public class HinhThuc {
	private String	 maHinhThuc;
	private String	 tenHinhThuc;
	


	public HinhThuc() {
		// do nothing
	}

	public HinhThuc(String maHinhThuc,String tenHinhThuc){
		setMaHinhThuc(maHinhThuc);
		setTenHinhThuc(tenHinhThuc);

	}

	public String getMaHinhThuc() {
		return maHinhThuc;
	}

	public void setMaHinhThuc(String maHinhThuc) {
		this.maHinhThuc = maHinhThuc;
	}

	public String getTenHinhThuc() {
		return tenHinhThuc;
	}

	public void setTenHinhThuc(String tenHinhThuc) {
		this.tenHinhThuc = tenHinhThuc;
	}
	


}
