/** 
 * Quản lý Rạp chiếu phim RPP 
 * Author: Võ Xuân Vương – vuongvo1809@gmail.com
 */

package rcp.view.page;

import java.sql.SQLException;
import java.util.ArrayList;

import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TableViewerColumn;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.wb.swt.SWTResourceManager;

import rcp.controller.QuyenHanController;
import rcp.controller.TaiKhoanController;
import rcp.entity.QuyenHan;
import rcp.entity.TaiKhoan;
import rcp.entity.TaiKhoan1;
import rcp.util.Message;

public class pageTaiKhoan extends Composite {
	private Table gridTaiKhoan;
	private Label lbTenNhanVien;
	private Label lbTenDangNhap;
	private Combo cboQuyen;
	private Button btnLuu;
	private Button btnDatLaiMatKhau;
	private Button btnSua;
	private Group groupTrangThai;
	private Button btnActive;
	private Button btnDeactive;

	/**
	 * Create the composite.
	 * 
	 * @param parent
	 * @param style
	 */
	public pageTaiKhoan(Composite parent, int style) {
		super(parent, style);
		setLayout(new GridLayout(2, false));

		Composite composite = new Composite(this, SWT.NONE);
		GridData gd_composite = new GridData(SWT.FILL, SWT.FILL, false, true, 1, 1);
		gd_composite.widthHint = 280;
		composite.setLayoutData(gd_composite);
		composite.setBackground(SWTResourceManager.getColor(SWT.COLOR_WIDGET_BACKGROUND));

		lbTenNhanVien = new Label(composite, SWT.NONE);
		lbTenNhanVien.setText("<Tên Nhân Viên>");
		lbTenNhanVien.setForeground(SWTResourceManager.getColor(SWT.COLOR_DARK_GREEN));
		lbTenNhanVien.setFont(SWTResourceManager.getFont("Segoe UI", 13, SWT.NORMAL));
		lbTenNhanVien.setBackground(SWTResourceManager.getColor(SWT.COLOR_WIDGET_BACKGROUND));
		lbTenNhanVien.setBounds(64, 30, 187, 23);

		Label lblTnngNhp = new Label(composite, SWT.NONE);
		lblTnngNhp.setText("Tên đăng nhập :");
		lblTnngNhp.setForeground(SWTResourceManager.getColor(SWT.COLOR_BLACK));
		lblTnngNhp.setFont(SWTResourceManager.getFont("Segoe UI", 9, SWT.NORMAL));
		lblTnngNhp.setBackground(SWTResourceManager.getColor(SWT.COLOR_WIDGET_BACKGROUND));
		lblTnngNhp.setBounds(22, 82, 90, 23);

		lbTenDangNhap = new Label(composite, SWT.NONE);
		lbTenDangNhap.setText("<Tên Đăng Nhập>");
		lbTenDangNhap.setForeground(SWTResourceManager.getColor(SWT.COLOR_BLACK));
		lbTenDangNhap.setFont(SWTResourceManager.getFont("Segoe UI", 9, SWT.NORMAL));
		lbTenDangNhap.setBackground(SWTResourceManager.getColor(SWT.COLOR_WIDGET_BACKGROUND));
		lbTenDangNhap.setBounds(145, 82, 112, 23);

		Label lblQuyn = new Label(composite, SWT.NONE);
		lblQuyn.setText("Quyền :");
		lblQuyn.setForeground(SWTResourceManager.getColor(SWT.COLOR_BLACK));
		lblQuyn.setFont(SWTResourceManager.getFont("Segoe UI", 9, SWT.NORMAL));
		lblQuyn.setBackground(SWTResourceManager.getColor(SWT.COLOR_WIDGET_BACKGROUND));
		lblQuyn.setBounds(22, 135, 63, 20);

		cboQuyen = new Combo(composite, SWT.NONE);
		cboQuyen.setEnabled(false);
		cboQuyen.setBounds(91, 132, 166, 23);

		Label lblTrngThi = new Label(composite, SWT.NONE);
		lblTrngThi.setText("Trạng Thái :");
		lblTrngThi.setForeground(SWTResourceManager.getColor(SWT.COLOR_BLACK));
		lblTrngThi.setFont(SWTResourceManager.getFont("Segoe UI", 9, SWT.NORMAL));
		lblTrngThi.setBackground(SWTResourceManager.getColor(SWT.COLOR_WIDGET_BACKGROUND));
		lblTrngThi.setBounds(22, 186, 112, 23);

		btnLuu = new Button(composite, SWT.NONE);
		btnLuu.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				luu();
				hienTatCa();
			}
		});
		btnLuu.setEnabled(false);
		btnLuu.setText("Lưu");
		btnLuu.setImage(SWTResourceManager.getImage(
				"D:\\Document\\PROGRAMING\\PROJECT\\QuanLyHocVien\\Source code\\QuanLyHocVien\\Resources\\zoom_16x16.png"));
		btnLuu.setBounds(10, 282, 120, 30);

		btnDatLaiMatKhau = new Button(composite, SWT.NONE);
		btnDatLaiMatKhau.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				datLaiMatKhau();
			}
		});
		btnDatLaiMatKhau.setEnabled(false);
		btnDatLaiMatKhau.setText(" Đặt lại mật khẩu");
		btnDatLaiMatKhau.setImage(SWTResourceManager.getImage(
				"D:\\Document\\PROGRAMING\\PROJECT\\QuanLyHocVien\\Source code\\QuanLyHocVien\\Resources\\refresh2_16x16.png"));
		btnDatLaiMatKhau.setBounds(137, 282, 120, 30);

		groupTrangThai = new Group(composite, SWT.NONE);
		groupTrangThai.setBounds(32, 215, 219, 30);

		btnActive = new Button(groupTrangThai, SWT.RADIO);
		btnActive.setSelection(true);
		btnActive.setBounds(0, 0, 109, 30);
		btnActive.setText("Active");

		btnDeactive = new Button(groupTrangThai, SWT.RADIO);
		btnDeactive.setBounds(110, 0, 109, 30);
		btnDeactive.setText("Deactive");

		Composite composite_1 = new Composite(this, SWT.NONE);
		GridLayout gl_composite_1 = new GridLayout(1, false);
		gl_composite_1.marginRight = 5;
		gl_composite_1.marginLeft = 5;
		composite_1.setLayout(gl_composite_1);
		composite_1.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));
		composite_1.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));

		btnSua = new Button(composite_1, SWT.NONE);
		btnSua.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				sua();
			}

		});
		GridData gd_btnSua = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
		gd_btnSua.heightHint = 30;
		gd_btnSua.widthHint = 86;
		btnSua.setLayoutData(gd_btnSua);
		btnSua.setText("Sửa");

		TableViewer tableViewer = new TableViewer(composite_1, SWT.BORDER | SWT.FULL_SELECTION);
		gridTaiKhoan = tableViewer.getTable();
		gridTaiKhoan.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				chon();
			}
		});
		gridTaiKhoan.setHeaderVisible(true);
		gridTaiKhoan.setLinesVisible(true);
		gridTaiKhoan.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));

		TableViewerColumn tableViewerColumn = new TableViewerColumn(tableViewer, SWT.NONE);
		TableColumn tblclmnNewColumn = tableViewerColumn.getColumn();
		tblclmnNewColumn.setWidth(50);
		tblclmnNewColumn.setText("STT");

		TableViewerColumn tableViewerColumn_1 = new TableViewerColumn(tableViewer, SWT.NONE);
		TableColumn tblclmnNewColumn_1 = tableViewerColumn_1.getColumn();
		tblclmnNewColumn_1.setWidth(150);
		tblclmnNewColumn_1.setText("Tên đăng nhập");

		TableViewerColumn tableViewerColumn_2 = new TableViewerColumn(tableViewer, SWT.NONE);
		TableColumn tblclmnNewColumn_2 = tableViewerColumn_2.getColumn();
		tblclmnNewColumn_2.setWidth(150);
		tblclmnNewColumn_2.setText("Mã nhân viên");

		TableViewerColumn tableViewerColumn_5 = new TableViewerColumn(tableViewer, SWT.NONE);
		TableColumn tblclmnTnNhnVin = tableViewerColumn_5.getColumn();
		tblclmnTnNhnVin.setWidth(150);
		tblclmnTnNhnVin.setText("Tên nhân viên");

		TableViewerColumn tableViewerColumn_3 = new TableViewerColumn(tableViewer, SWT.NONE);
		TableColumn tblclmnNewColumn_3 = tableViewerColumn_3.getColumn();
		tblclmnNewColumn_3.setWidth(150);
		tblclmnNewColumn_3.setText("Mã quyền");

		TableViewerColumn tableViewerColumn_6 = new TableViewerColumn(tableViewer, SWT.NONE);
		TableColumn tblclmnTnQuyn = tableViewerColumn_6.getColumn();
		tblclmnTnQuyn.setWidth(150);
		tblclmnTnQuyn.setText("Tên quyền");

		TableViewerColumn tableViewerColumn_4 = new TableViewerColumn(tableViewer, SWT.NONE);
		TableColumn tblclmnNewColumn_4 = tableViewerColumn_4.getColumn();
		tblclmnNewColumn_4.setWidth(150);
		tblclmnNewColumn_4.setText("Trạng thái");

		hienThiGiaoDien();

	}

	@Override
	protected void checkSubclass() {
		// Disable the check that prevents subclassing of SWT components
	}
	
	/**
	 * Hàm hiển thị giao diện ban đầu
	 */
	public void hienThiGiaoDien() {
		hienTatCa();
		hienQuyen();
		chon();
	}
	
	/**
	 * Hàm hiện thông tin của tất cả tài khoản
	 */
	public void hienTatCa() {
		try {
			ArrayList<TaiKhoan1> arr = TaiKhoanController.taiTatCaDS();

			gridTaiKhoan.removeAll();
			int stt = 1;
			for (TaiKhoan1 i : arr) {
				// String a=(i.getTrangThai()==1 ? "Active" : "Deactive");
				TableItem item = new TableItem(gridTaiKhoan, SWT.NONE);
				item.setText(
						new String[] { String.valueOf(stt), i.getTenDangNhap(), i.getMaNhanVien(), i.getTenNhanVien(),
								i.getMaQuyen(), i.getTenQuyen(), i.getTrangThai() == 1 ? "Active" : "Deactive" });
				stt++;
			}

			gridTaiKhoan.select(0);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Hàm thực hiện hiện quyền
	 */
	public void hienQuyen() {
		try {
			ArrayList<QuyenHan> arr = QuyenHanController.taiTatCa();

			cboQuyen.removeAll();
			for (QuyenHan i : arr) {
				cboQuyen.add(i.getTenQuyen());
				cboQuyen.setData(i.getTenQuyen(), i.getMaQuyen());
			}

			cboQuyen.select(0);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Hiện thông tin tài khoản cần sửa
	 */
	public void sua() {
		btnLuu.setEnabled(true);
		btnDatLaiMatKhau.setEnabled(true);
		cboQuyen.setEnabled(true);
		try {
			lbTenNhanVien.setText(gridTaiKhoan.getSelection()[0].getText(3));
			lbTenDangNhap.setText(gridTaiKhoan.getSelection()[0].getText(1));
			cboQuyen.setText(gridTaiKhoan.getSelection()[0].getText(5));
			if (gridTaiKhoan.getSelection()[0].getText(6).equals("Active")) {
				btnActive.setSelection(true);
				btnDeactive.setSelection(false);
			} else {
				btnActive.setSelection(false);
				btnDeactive.setSelection(true);
			}

		} catch (Exception e1) {
			e1.printStackTrace();
			Message.show("Nhân viên không hợp lệ", "Lỗi", SWT.OK | SWT.ICON_ERROR, getShell());
		}
	}

	/**
	 * Hàm thực hiện lưu thông tin
	 */
	public void luu() {
		try {
			if (!TaiKhoanController.sua(layTaiKhoan()))
				throw new SQLException();

			Message.show("Lưu thông tin tài khoản thành công", "Thành công", SWT.OK | SWT.ICON_INFORMATION, getShell());
			btnLuu.setEnabled(false);
			btnDatLaiMatKhau.setEnabled(false);

		} catch (Exception e) {
			e.printStackTrace();
			Message.show("Không thể lưu thông tin tài khoản", "Lỗi", SWT.OK | SWT.ICON_ERROR, getShell());
		}
	}

	/**
	 * Chọn một tài khoản trên table
	 */
	public void chon() {

		lbTenNhanVien.setText(gridTaiKhoan.getSelection()[0].getText(3));
		lbTenDangNhap.setText(gridTaiKhoan.getSelection()[0].getText(1));
		cboQuyen.setText(gridTaiKhoan.getSelection()[0].getText(5));
		if (gridTaiKhoan.getSelection()[0].getText(6).equals("Active")) {
			btnActive.setSelection(true);
			btnDeactive.setSelection(false);
		} else {
			btnActive.setSelection(false);
			btnDeactive.setSelection(true);
		}
	}

	/**
	 * Hàm đặt lại mật khẩu
	 */
	public void datLaiMatKhau() {
		try {
			if (!TaiKhoanController.datLaiMatKhau(layTaiKhoan()))
				throw new SQLException();
			Message.show("Đặt lại mật khẩu thành công", "Thành công", SWT.OK | SWT.ICON_INFORMATION, getShell());

		} catch (Exception e) {
			Message.show("Không thể đặt lại mật khẩu", "Lỗi", SWT.OK | SWT.ICON_ERROR, getShell());
		}
	}

	/**
	 * Chuyển các thông tin trên giao diện thành đối tượng tài khoản
	 */
	public TaiKhoan layTaiKhoan() {
		return new TaiKhoan(lbTenDangNhap.getText(), null, null, (String) cboQuyen.getData(cboQuyen.getText()),
				btnActive.getSelection() ? 1 : 0);
	}
}
