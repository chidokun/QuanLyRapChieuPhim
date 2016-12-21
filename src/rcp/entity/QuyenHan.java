/**
 * Quản lý Rạp chiếu phim RPP
 * Author: Hồ Thị Kim Hoàng - hohoang.ag.96@gmail.com
 */

package rcp.entity;

public class QuyenHan {
	private String maQuyen;
	private String tenQuyen;
	private boolean quanLyPhim;
	private boolean quanLySuatChieu;
	private boolean traCuuSuatChieu;
	private boolean banVe;
	private boolean traCuuVe;
	private boolean quanLyKhachHang;
	private boolean quanLyNhanVien;
	private boolean quanLyThucAn;
	private boolean traCuuThucAn;
	private boolean banThucAn;
	private boolean thayDoiQuyDinh;
	private boolean thongKeBaoCao;
	private boolean saoLuuPhucHoi;
	
	public QuyenHan(){
		//nothing
	}
	
	public QuyenHan(String maQuyen, String tenQuyen, boolean quanLyPhim, boolean quanLySuatChieu, boolean traCuuSuatChieu,
			boolean banVe, boolean traCuuVe, boolean quanLyKhachHang, boolean quanLyNhanVien,boolean quanLyThucAn, 
			boolean traCuuThucAn, boolean banThucAn, boolean thayDoiQuyDinh, boolean thongKeBaoCao, boolean saoLuuPhucHoi){
		setMaQuyen(maQuyen);
		setTenQuyen(tenQuyen);
		setQuanLyPhim(quanLyPhim);
		setQuanLySuatChieu(quanLySuatChieu);
		setTraCuuSuatChieu(traCuuSuatChieu);
		setBanVe(banVe);
		setTraCuuVe(traCuuVe);
		setQuanLyKhachHang(quanLyKhachHang);
		setQuanLyNhanVien(quanLyNhanVien);
		setQuanLyThucAn(quanLyThucAn);
		setTraCuuThucAn(traCuuThucAn);
		setBanThucAn(banThucAn);
		setThayDoiQuyDinh(thayDoiQuyDinh);
		setThongKeBaoCao(thongKeBaoCao);
		setSaoLuuPhucHoi(saoLuuPhucHoi);
	}
	
	public String getMaQuyen() {
		return maQuyen;
	}
	public void setMaQuyen(String maQuyen) {
		this.maQuyen = maQuyen;
	}
	public String getTenQuyen() {
		return tenQuyen;
	}
	public void setTenQuyen(String tenQuyen) {
		this.tenQuyen = tenQuyen;
	}
	public boolean isQuanLyPhim() {
		return quanLyPhim;
	}
	public void setQuanLyPhim(boolean quanLyPhim) {
		this.quanLyPhim = quanLyPhim;
	}
	public boolean isQuanLySuatChieu() {
		return quanLySuatChieu;
	}
	public void setQuanLySuatChieu(boolean quanLySuatChieu) {
		this.quanLySuatChieu = quanLySuatChieu;
	}
	public boolean isTraCuuSuatChieu() {
		return traCuuSuatChieu;
	}
	public void setTraCuuSuatChieu(boolean traCuuSuatChieu) {
		this.traCuuSuatChieu = traCuuSuatChieu;
	}
	public boolean isBanVe() {
		return banVe;
	}
	public void setBanVe(boolean banVe) {
		this.banVe = banVe;
	}
	public boolean isTraCuuVe() {
		return traCuuVe;
	}
	public void setTraCuuVe(boolean traCuuVe) {
		this.traCuuVe = traCuuVe;
	}
	public boolean isQuanLyKhachHang() {
		return quanLyKhachHang;
	}
	public void setQuanLyKhachHang(boolean quanLyKhachHang) {
		this.quanLyKhachHang = quanLyKhachHang;
	}
	public boolean isQuanLyNhanVien() {
		return quanLyNhanVien;
	}
	public void setQuanLyNhanVien(boolean quanLyNhanVien) {
		this.quanLyNhanVien = quanLyNhanVien;
	}
	public boolean isQuanLyThucAn() {
		return quanLyThucAn;
	}
	public void setQuanLyThucAn(boolean quanLyThucAn) {
		this.quanLyThucAn = quanLyThucAn;
	}
	public boolean isTraCuuThucAn() {
		return traCuuThucAn;
	}
	public void setTraCuuThucAn(boolean traCuuThucAn) {
		this.traCuuThucAn = traCuuThucAn;
	}
	public boolean isBanThucAn() {
		return banThucAn;
	}
	public void setBanThucAn(boolean banThucAn) {
		this.banThucAn = banThucAn;
	}
	public boolean isThayDoiQuyDinh() {
		return thayDoiQuyDinh;
	}
	public void setThayDoiQuyDinh(boolean thayDoiQuyDinh) {
		this.thayDoiQuyDinh = thayDoiQuyDinh;
	}
	public boolean isThongKeBaoCao() {
		return thongKeBaoCao;
	}
	public void setThongKeBaoCao(boolean thongKeBaoCao) {
		this.thongKeBaoCao = thongKeBaoCao;
	}
	public boolean isSaoLuuPhucHoi() {
		return saoLuuPhucHoi;
	}
	public void setSaoLuuPhucHoi(boolean saoLuuPhucHoi) {
		this.saoLuuPhucHoi = saoLuuPhucHoi;
	}

}
