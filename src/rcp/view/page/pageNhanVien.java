/**
 * Quản lý Rạp chiếu phim RPP
 * Author: Nguyễn Tuấn - nguyentuanit96@gmail.com
 */

package rcp.view.page;

import java.sql.SQLException;
import java.util.ArrayList;

import org.eclipse.core.commands.ParameterValuesException;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.widgets.Text;
import org.eclipse.wb.swt.SWTResourceManager;

import rcp.controller.*;
import rcp.entity.*;
import rcp.util.*;
import rcp.view.popup.*;

public class pageNhanVien extends Composite {
	private Text txtTenNhanVien;
	private Text txtCMND;
	private Table gridNhanVien;
	private Button chkTenNhanVien;
	private Button chkChucVu;
	private Combo cboChucVu;
	private Button chkCMND;
	private Button btnTimKiem;
	private Button btnDatLai;

	/**
	 * Create the composite.
	 * 
	 * @param parent
	 * @param style
	 */
	public pageNhanVien(Composite parent, int style) {
		super(parent, style);
		GridLayout gridLayout = new GridLayout(2, false);
		gridLayout.marginWidth = 0;
		gridLayout.marginHeight = 0;
		setLayout(gridLayout);

		Composite searchPan = new Composite(this, SWT.NONE);
		GridData gd_searchPan = new GridData(SWT.FILL, SWT.FILL, false, true, 1, 1);
		gd_searchPan.widthHint = 280;
		searchPan.setLayoutData(gd_searchPan);
		searchPan.setBackground(SWTResourceManager.getColor(240, 240, 240));

		Label lblNewLabel = new Label(searchPan, SWT.NONE);
		lblNewLabel.setForeground(SWTResourceManager.getColor(31, 116, 71));
		lblNewLabel.setBackground(SWTResourceManager.getColor(240, 240, 240));
		lblNewLabel.setFont(SWTResourceManager.getFont("Segoe UI", 13, SWT.NORMAL));
		lblNewLabel.setBounds(29, 17, 176, 23);
		lblNewLabel.setText("Tra cứu nhân viên");

		chkTenNhanVien = new Button(searchPan, SWT.CHECK);
		chkTenNhanVien.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				txtTenNhanVien.setEnabled(chkTenNhanVien.getSelection());
			}
		});
		chkTenNhanVien.setSelection(true);
		chkTenNhanVien.setBounds(29, 54, 197, 16);
		chkTenNhanVien.setBackground(SWTResourceManager.getColor(240, 240, 240));
		chkTenNhanVien.setText("Theo tên nhân viên");

		txtTenNhanVien = new Text(searchPan, SWT.BORDER);
		txtTenNhanVien.setBounds(29, 85, 228, 25);

		chkChucVu = new Button(searchPan, SWT.CHECK);
		chkChucVu.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				cboChucVu.setEnabled(chkChucVu.getSelection());
			}
		});
		chkChucVu.setText("Theo chức vụ");
		chkChucVu.setBackground(SWTResourceManager.getColor(240, 240, 240));
		chkChucVu.setBounds(29, 131, 197, 16);

		cboChucVu = new Combo(searchPan, SWT.NONE);
		cboChucVu.setEnabled(false);
		cboChucVu.setBounds(29, 164, 228, 23);

		chkCMND = new Button(searchPan, SWT.CHECK);
		chkCMND.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				txtCMND.setEnabled(chkCMND.getSelection());
			}
		});
		chkCMND.setText("Theo CMND");
		chkCMND.setBackground(SWTResourceManager.getColor(240, 240, 240));
		chkCMND.setBounds(29, 212, 197, 16);

		txtCMND = new Text(searchPan, SWT.BORDER);
		txtCMND.setEnabled(false);
		txtCMND.setBounds(29, 246, 228, 25);

		btnTimKiem = new Button(searchPan, SWT.NONE);
		btnTimKiem.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				timKiem();
			}
		});
		btnTimKiem.setImage(SWTResourceManager.getImage(pageNhanVien.class, "/rcp/view/page/zoom_16x16.png"));
		btnTimKiem.setBounds(81, 301, 86, 30);
		btnTimKiem.setText("Tìm kiếm");

		btnDatLai = new Button(searchPan, SWT.NONE);
		btnDatLai.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				datLai();
			}
		});
		btnDatLai.setImage(SWTResourceManager.getImage(pageNhanVien.class, "/rcp/view/page/refresh2_16x16.png"));
		btnDatLai.setText("Đặt lại");
		btnDatLai.setBounds(171, 301, 86, 30);

		Composite composite_2 = new Composite(this, SWT.NONE);
		GridLayout gl_composite_2 = new GridLayout(3, false);
		gl_composite_2.marginBottom = 15;
		gl_composite_2.marginTop = 10;
		gl_composite_2.marginWidth = 15;
		composite_2.setLayout(gl_composite_2);
		GridData gd_composite_2 = new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1);
		gd_composite_2.heightHint = 369;
		gd_composite_2.widthHint = 398;
		composite_2.setLayoutData(gd_composite_2);
		composite_2.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));

		Button btnThem = new Button(composite_2, SWT.NONE);
		btnThem.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				Window.open(new frmThemSuaNhanVien(getDisplay(), "Thêm nhân viên", null));
				hienTatCa();
			}
		});
		btnThem.setImage(SWTResourceManager.getImage(pageNhanVien.class, "/rcp/view/page/additem_16x16.png"));
		GridData gd_btnThem = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
		gd_btnThem.widthHint = 86;
		gd_btnThem.heightHint = 30;
		btnThem.setLayoutData(gd_btnThem);
		btnThem.setText("Thêm");

		Button btnSua = new Button(composite_2, SWT.NONE);
		btnSua.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				try {
					Window.open(new frmThemSuaNhanVien(getDisplay(), "Sửa nhân viên",
							NhanVienController.layThongTin(gridNhanVien.getSelection()[0].getText(1))));
					hienTatCa();
				} catch (SQLException e1) {
					e1.printStackTrace();
					Message.show("Nhân viên không hợp lệ", "Lỗi", SWT.OK | SWT.ICON_ERROR, getShell());
				}
			}
		});
		btnSua.setImage(SWTResourceManager.getImage(pageNhanVien.class, "/rcp/view/page/edit_16x16.png"));
		GridData gd_btnSua = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
		gd_btnSua.widthHint = 86;
		gd_btnSua.heightHint = 30;
		btnSua.setLayoutData(gd_btnSua);
		btnSua.setText("Sửa");

		Button btnHienTatCa = new Button(composite_2, SWT.NONE);
		btnHienTatCa.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				hienTatCa();
			}
		});
		btnHienTatCa.setImage(SWTResourceManager.getImage(pageNhanVien.class, "/rcp/view/page/show_16x16.png"));
		GridData gd_btnHienTatCa = new GridData(SWT.RIGHT, SWT.CENTER, true, false, 1, 1);
		gd_btnHienTatCa.widthHint = 100;
		gd_btnHienTatCa.heightHint = 30;
		btnHienTatCa.setLayoutData(gd_btnHienTatCa);
		btnHienTatCa.setText("Hiện tất cả");

		TableViewer tableViewer = new TableViewer(composite_2, SWT.BORDER | SWT.FULL_SELECTION);
		tableViewer.setColumnProperties(new String[] { "Mã nhân viên", "Tên nhân viên", "Ngày sinh", "Giới tính",
				"Địa chỉ", "CMND", "Email", "SĐT", "Chức vụ", "Ngày vào làm", "Trạng thái" });
		gridNhanVien = tableViewer.getTable();
		gridNhanVien.setFont(SWTResourceManager.getFont("Segoe UI", 9, SWT.NORMAL));
		gridNhanVien.setLinesVisible(true);
		gridNhanVien.setHeaderVisible(true);
		gridNhanVien.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 3, 1));

		TableColumn tblclmnStt = new TableColumn(gridNhanVien, SWT.NONE);
		tblclmnStt.setWidth(37);
		tblclmnStt.setText("STT");

		TableColumn tblclmnMNhnVin = new TableColumn(gridNhanVien, SWT.NONE);
		tblclmnMNhnVin.setWidth(91);
		tblclmnMNhnVin.setText("Mã nhân viên");

		TableColumn tblclmnHVTn_1 = new TableColumn(gridNhanVien, SWT.NONE);
		tblclmnHVTn_1.setWidth(167);
		tblclmnHVTn_1.setText("Họ và tên");

		TableColumn tblclmnHVTn = new TableColumn(gridNhanVien, SWT.NONE);
		tblclmnHVTn.setWidth(100);
		tblclmnHVTn.setText("Ngày sinh");

		TableColumn tblclmnGiiTnh = new TableColumn(gridNhanVien, SWT.NONE);
		tblclmnGiiTnh.setWidth(69);
		tblclmnGiiTnh.setText("Giới tính");

		TableColumn tblclmnaCh = new TableColumn(gridNhanVien, SWT.NONE);
		tblclmnaCh.setWidth(167);
		tblclmnaCh.setText("Địa chỉ");

		TableColumn tblclmnCmnd = new TableColumn(gridNhanVien, SWT.NONE);
		tblclmnCmnd.setWidth(100);
		tblclmnCmnd.setText("CMND");

		TableColumn tblclmnEmail = new TableColumn(gridNhanVien, SWT.NONE);
		tblclmnEmail.setWidth(100);
		tblclmnEmail.setText("Email");

		TableColumn tblclmnSt = new TableColumn(gridNhanVien, SWT.NONE);
		tblclmnSt.setWidth(100);
		tblclmnSt.setText("SĐT");

		TableColumn tblclmnChcV = new TableColumn(gridNhanVien, SWT.NONE);
		tblclmnChcV.setWidth(100);
		tblclmnChcV.setText("Chức vụ");

		TableColumn tblclmnNgyVoLm = new TableColumn(gridNhanVien, SWT.NONE);
		tblclmnNgyVoLm.setWidth(100);
		tblclmnNgyVoLm.setText("Ngày vào làm");

		TableColumn tblclmnTrngThi = new TableColumn(gridNhanVien, SWT.NONE);
		tblclmnTrngThi.setWidth(100);
		tblclmnTrngThi.setText("Trạng thái");

		hienThiGiaoDien();
	}

	@Override
	protected void checkSubclass() {
		// Disable the check that prevents subclassing of SWT components
	}

	/**
	 * Hiển thị giao diện ban đầu
	 */
	public void hienThiGiaoDien() {
		hienChucVu();
		hienTatCa();
		datLai();
	}

	/**
	 * Đặt lại điều kiện tìm kiếm
	 */
	public void datLai() {
		chkTenNhanVien.setSelection(true);
		txtTenNhanVien.setText("");
		txtTenNhanVien.setEnabled(chkTenNhanVien.getSelection());

		chkChucVu.setSelection(false);
		cboChucVu.select(0);
		cboChucVu.setEnabled(chkChucVu.getSelection());

		chkCMND.setSelection(false);
		txtCMND.setText("");
		txtCMND.setEnabled(chkCMND.getSelection());
	}

	/**
	 * Hiển thị chức vụ lên comboBox
	 */
	public void hienChucVu() {
		try {
			ArrayList<ChucVu> arr = ChucVuController.taiTatCa();

			cboChucVu.removeAll();
			for (ChucVu i : arr) {
				cboChucVu.add(i.getTenChucVu());
				cboChucVu.setData(i.getTenChucVu(), i.getMaChucVu());
			}

			cboChucVu.select(0);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Hiện tất cả nhân viên
	 */
	public void hienTatCa() {
		try {
			ArrayList<NhanVien> arr = NhanVienController.taiTatCa();

			gridNhanVien.removeAll();
			int stt = 1;
			for (NhanVien i : arr) {
				TableItem item = new TableItem(gridNhanVien, SWT.NONE);
				item.setText(new String[] { String.valueOf(stt), i.getMaNhanVien(), i.getTenNhanVien(),
						i.getNgaySinh().toString(), i.getGioiTinh(), i.getDiaChi(), i.getCMND(), i.getEmail(),
						i.getSDT(), i.getMaChucVu(), i.getNgayVaoLam().toString(),
						String.valueOf((i.getTrangThai())) });
				stt++;
			}

			gridNhanVien.select(0);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Tìm kiếm nhân viên
	 */
	public void timKiem() {
		try {
			kiemTraHopLe();
			ArrayList<NhanVien> arr = NhanVienController.traCuu(
					chkTenNhanVien.getSelection() ? txtTenNhanVien.getText() : null,
					chkChucVu.getSelection() ? (String) cboChucVu.getData(cboChucVu.getText()) : null,
					chkCMND.getSelection() ? txtCMND.getText() : null);

			gridNhanVien.removeAll();
			int stt = 1;
			for (NhanVien i : arr) {
				TableItem item = new TableItem(gridNhanVien, SWT.NONE);
				item.setText(new String[] { String.valueOf(stt), i.getMaNhanVien(), i.getTenNhanVien(),
						i.getNgaySinh().toString(), i.getGioiTinh(), i.getDiaChi(), i.getCMND(), i.getEmail(),
						i.getSDT(), i.getMaChucVu(), i.getNgayVaoLam().toString(),
						i.getTrangThai() == 1 ? "Đang làm" : "Nghỉ việc" });
				stt++;
			}

			gridNhanVien.select(0);
		} catch (ParameterValuesException e) {
			Message.show(e.getMessage(), "Cảnh báo", SWT.ICON_WARNING | SWT.OK, getShell());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Kiểm tra các điều kiện nhập có đầy đủ
	 * 
	 * @throws ParameterValuesException
	 */
	public void kiemTraHopLe() throws ParameterValuesException {
		if (chkTenNhanVien.getSelection() && txtTenNhanVien.getText().isEmpty())
			throw new ParameterValuesException("Tên nhân viên không được trống", null);
		if (chkCMND.getSelection() && txtCMND.getText().isEmpty())
			throw new ParameterValuesException("CMND không được trống", null);
	}
}
