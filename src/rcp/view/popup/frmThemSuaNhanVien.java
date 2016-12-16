/**
 * Quản lý Rạp chiếu phim RPP 
 * Author: Võ Xuân Vương – vuongvo1809@gmail.com
 */
package rcp.view.popup;

import java.util.*;

import org.eclipse.swt.SWT;
import org.eclipse.wb.swt.SWTResourceManager;
import org.eclipse.swt.widgets.*;
import rcp.entity.*;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

public class frmThemSuaNhanVien extends Shell {
	private boolean isInsert = false;
	
	private Text txtMaNhanVien;
	private Text txtHoTen;
	private Text txtDiaChi;
	private Text txtCMND;
	private Text txtEmail;
	private Text txtSDT;
	private DateTime dateNgaySinh;
	private Combo cboTrangThai;
	private Button chkTaoTaiKhoan;
	private Text txtTenDangNhap;
	private Combo cboQuyen;
	private DateTime dateNgayVaoLam;
	private Combo cboChucVu;
	private Button btnNam;
	private Button btnNu;
	private Button btnLuu;
	private Button btnHuy;
	
	/**
	 * Create the shell.
	 * @param display
	 */
	public frmThemSuaNhanVien(Display display, String title, NhanVien nv) {
		super(display, SWT.CLOSE | SWT.MIN | SWT.TITLE);
		setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		setLayout(null);
		
		Composite composite = new Composite(this, SWT.NONE);
		composite.setBounds(0, 484, 720, 54);
		
		btnLuu = new Button(composite, SWT.NONE);
		btnLuu.setBounds(510, 10, 94, 33);
		btnLuu.setText("Lưu");
		
		btnHuy = new Button(composite, SWT.NONE);
		btnHuy.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				close();
			}
		});
		btnHuy.setBounds(610, 10, 94, 33);
		btnHuy.setText("Hủy");
		
		Label lblNewLabel = new Label(this, SWT.NONE);
		lblNewLabel.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		lblNewLabel.setBounds(37, 111, 88, 15);
		lblNewLabel.setText("Mã nhân viên :");
		
		txtMaNhanVien = new Text(this, SWT.BORDER);
		txtMaNhanVien.setBounds(131, 109, 197, 24);
		
		Label lblThmSaNhn = new Label(this, SWT.NONE);
		lblThmSaNhn.setText("Thêm sửa nhân viên");
		lblThmSaNhn.setForeground(SWTResourceManager.getColor(34, 139, 34));
		lblThmSaNhn.setFont(SWTResourceManager.getFont("Segoe UI", 13, SWT.NORMAL));
		lblThmSaNhn.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		lblThmSaNhn.setBounds(118, 21, 197, 24);
		
		Label lblHnh = new Label(this, SWT.NONE);
		lblHnh.setImage(SWTResourceManager.getImage(frmThemSuaNhanVien.class, "/rcp/view/popup/imgNhanVien_64p.png"));
		lblHnh.setForeground(SWTResourceManager.getColor(34, 139, 34));
		lblHnh.setFont(SWTResourceManager.getFont("Segoe UI", 15, SWT.NORMAL));
		lblHnh.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		lblHnh.setBounds(37, 16, 64, 64);
		
		Label lblTnNhnVin = new Label(this, SWT.NONE);
		lblTnNhnVin.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		lblTnNhnVin.setText("Họ tên :");
		lblTnNhnVin.setBounds(37, 158, 70, 15);
		
		txtHoTen = new Text(this, SWT.BORDER);
		txtHoTen.setBounds(131, 155, 197, 24);
		
		Label lblNgySinh = new Label(this, SWT.NONE);
		lblNgySinh.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		lblNgySinh.setText("Ngày sinh :");
		lblNgySinh.setBounds(37, 204, 70, 15);
		
		dateNgaySinh = new DateTime(this, SWT.BORDER);
		dateNgaySinh.setBounds(131, 200, 197, 24);
		
		Label lblaCh = new Label(this, SWT.NONE);
		lblaCh.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		lblaCh.setText("Địa chỉ :");
		lblaCh.setBounds(37, 249, 55, 15);
		
		txtDiaChi = new Text(this, SWT.BORDER);
		txtDiaChi.setBounds(131, 246, 197, 24);
		
		Label lblCmnd = new Label(this, SWT.NONE);
		lblCmnd.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		lblCmnd.setText("CMND :");
		lblCmnd.setBounds(37, 296, 55, 15);
		
		txtCMND = new Text(this, SWT.BORDER);
		txtCMND.setBounds(131, 293, 197, 24);
		
		Label lblTrngThi = new Label(this, SWT.NONE);
		lblTrngThi.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		lblTrngThi.setText("Trạng thái:");
		lblTrngThi.setBounds(37, 343, 64, 15);
		
		btnNam = new Button(this, SWT.RADIO);
		btnNam.setSelection(true);
		btnNam.setText("Nam");
		btnNam.setForeground(SWTResourceManager.getColor(SWT.COLOR_BLACK));
		btnNam.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		btnNam.setBounds(487, 110, 90, 16);
		
		btnNu = new Button(this, SWT.RADIO);
		btnNu.setText("Nữ");
		btnNu.setForeground(SWTResourceManager.getColor(SWT.COLOR_BLACK));
		btnNu.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		btnNu.setBounds(594, 110, 90, 16);
		
		txtEmail = new Text(this, SWT.BORDER);
		txtEmail.setBounds(487, 155, 197, 24);
		
		Label lblEmail = new Label(this, SWT.NONE);
		lblEmail.setText("Email :");
		lblEmail.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		lblEmail.setBounds(383, 158, 55, 15);
		
		Label lblSt = new Label(this, SWT.NONE);
		lblSt.setText("SĐT :");
		lblSt.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		lblSt.setBounds(383, 204, 55, 15);
		
		txtSDT = new Text(this, SWT.BORDER);
		txtSDT.setBounds(487, 200, 197, 24);
		
		Label lblChcV = new Label(this, SWT.NONE);
		lblChcV.setText("Chức vụ :");
		lblChcV.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		lblChcV.setBounds(383, 249, 55, 15);
		
		Label lblNgyVoLm = new Label(this, SWT.NONE);
		lblNgyVoLm.setText("Ngày vào làm :");
		lblNgyVoLm.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		lblNgyVoLm.setBounds(383, 296, 93, 15);
		
		dateNgayVaoLam = new DateTime(this, SWT.BORDER);
		dateNgayVaoLam.setBounds(487, 293, 197, 24);
		
		Label lblGiiTnh = new Label(this, SWT.NONE);
		lblGiiTnh.setText("Giới tính :");
		lblGiiTnh.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		lblGiiTnh.setBounds(383, 111, 55, 15);
		
		chkTaoTaiKhoan = new Button(this, SWT.CHECK);
		chkTaoTaiKhoan.setText("Tạo tài khoản");
		chkTaoTaiKhoan.setSelection(true);
		chkTaoTaiKhoan.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		chkTaoTaiKhoan.setBounds(37, 390, 197, 16);
		
		Label label = new Label(this, SWT.NONE);
		label.setText("Vui lòng nhập đầy đủ thông tin");
		label.setFont(SWTResourceManager.getFont("Segoe UI", 9, SWT.NORMAL));
		label.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		label.setBounds(118, 51, 201, 15);
		
		cboTrangThai = new Combo(this, SWT.NONE);
		cboTrangThai.setBounds(131, 340, 197, 23);
		
		Label lblTnngNhp = new Label(this, SWT.NONE);
		lblTnngNhp.setBounds(37, 425, 88, 15);
		lblTnngNhp.setText("Tên đăng nhập :");
		lblTnngNhp.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		
		txtTenDangNhap = new Text(this, SWT.BORDER);
		txtTenDangNhap.setBounds(131, 422, 197, 24);
		
		Label lblQuyn = new Label(this, SWT.NONE);
		lblQuyn.setBounds(383, 425, 55, 15);
		lblQuyn.setText("Quyền :");
		lblQuyn.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		
		cboChucVu = new Combo(this, SWT.NONE);
		cboChucVu.setBounds(487, 246, 198, 23);
		
		cboQuyen = new Combo(this, SWT.NONE);
		cboQuyen.setBounds(487, 423, 198, 23);
		createContents();
		
		isInsert = nv == null;
	}

	/**
	 * Create contents of the shell.
	 */
	protected void createContents() {
		setText("Thêm sửa nhân viên");
		setSize(723, 566);

	}

	@Override
	protected void checkSubclass() {
		// Disable the check that prevents subclassing of SWT components
	}
	
	public void hienThiGiaoDien() {
		if (isInsert) {
			
		}
		else {
			
		}
	}
	
	@SuppressWarnings("deprecation")
	public NhanVien layNhanVien() {
		return new NhanVien(
			txtMaNhanVien.getText(),
			txtHoTen.getText(),
			new Date(dateNgaySinh.getYear(),dateNgaySinh.getMonth(),dateNgaySinh.getDay()),
			btnNam.getSelection() ? "Nam": "Nữ",
			txtDiaChi.getText(),
			txtCMND.getText(),
			txtEmail.getText(),
			txtSDT.getText(),
			"", //chức vụ để đó
			new Date(dateNgaySinh.getYear(),dateNgaySinh.getMonth(),dateNgaySinh.getDay()),	
			0 //trạng thái để đó	
				);
	}
}
