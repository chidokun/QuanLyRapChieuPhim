/**
 * Quản lý Rạp chiếu phim RPP 
 * Author: Võ Xuân Vương – vuongvo1809@gmail.com
 */
package rcp.view.page;

import java.sql.SQLException;
import java.util.ArrayList;

import org.eclipse.core.commands.ParameterValuesException;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TableViewerColumn;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.widgets.Text;
import org.eclipse.wb.swt.SWTResourceManager;

import rcp.controller.KhachHangController;
import rcp.entity.KhachHang;
import rcp.util.DateF;
import rcp.util.Message;
import rcp.util.Window;
import rcp.view.popup.frmThemSuaKhachHang;

public class pageKhachHang extends Composite {
	private Text txtTenKhachHang;
	private Text txtCMND;
	private Button chkTenKhachHang;
	private Button chkCMND;
	private Button btnDatLai;
	private Button btnTimKiem;
	private Table gridKhachHang;

	/**
	 * Create the composite.
	 * 
	 * @param parent
	 * @param style
	 */
	public pageKhachHang(Composite parent, int style) {
		super(parent, style);
		GridLayout gridLayout = new GridLayout(2, false);
		gridLayout.marginWidth = 0;
		gridLayout.marginHeight = 0;
		setLayout(gridLayout);

		Composite composite = new Composite(this, SWT.NONE);
		composite.setLayout(null);
		GridData gd_composite = new GridData(SWT.FILL, SWT.FILL, false, true, 1, 1);
		gd_composite.widthHint = 280;
		composite.setLayoutData(gd_composite);
		composite.setBackground(SWTResourceManager.getColor(SWT.COLOR_WIDGET_BACKGROUND));
		composite.setForeground(SWTResourceManager.getColor(SWT.COLOR_WHITE));

		Label lblTraCuuKH = new Label(composite, SWT.NONE);
		lblTraCuuKH.setText("Tra cứu khách hàng");
		lblTraCuuKH.setForeground(SWTResourceManager.getColor(31, 116, 71));
		lblTraCuuKH.setFont(SWTResourceManager.getFont("Segoe UI", 13, SWT.NORMAL));
		lblTraCuuKH.setBackground(SWTResourceManager.getColor(SWT.COLOR_WIDGET_BACKGROUND));
		lblTraCuuKH.setBounds(29, 17, 176, 23);

		chkTenKhachHang = new Button(composite, SWT.CHECK);
		chkTenKhachHang.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				txtTenKhachHang.setEnabled(chkTenKhachHang.getSelection());
			}
		});
		chkTenKhachHang.setText("Theo tên khách hàng");
		chkTenKhachHang.setSelection(true);
		chkTenKhachHang.setBackground(SWTResourceManager.getColor(SWT.COLOR_WIDGET_BACKGROUND));
		chkTenKhachHang.setBounds(29, 54, 197, 16);

		txtTenKhachHang = new Text(composite, SWT.BORDER);
		txtTenKhachHang.setBounds(29, 85, 228, 25);

		chkCMND = new Button(composite, SWT.CHECK);
		chkCMND.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				txtCMND.setEnabled(chkCMND.getSelection());
			}
		});
		chkCMND.setText("Theo CMND");
		chkCMND.setBackground(SWTResourceManager.getColor(SWT.COLOR_WIDGET_BACKGROUND));
		chkCMND.setBounds(29, 131, 197, 16);

		btnTimKiem = new Button(composite, SWT.NONE);
		btnTimKiem.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				timKiem();
			}
		});
		btnTimKiem.setText("Tìm kiếm");
		btnTimKiem.setImage(SWTResourceManager.getImage(pageKhachHang.class, "/rcp/view/page/zoom_16x16.png"));
		btnTimKiem.setBounds(81, 217, 86, 30);

		btnDatLai = new Button(composite, SWT.NONE);
		btnDatLai.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				datLai();
			}
		});
		btnDatLai.setText("Đặt lại");
		btnDatLai.setImage(SWTResourceManager.getImage(pageKhachHang.class, "/rcp/view/page/refresh2_16x16.png"));
		btnDatLai.setBounds(171, 217, 86, 30);

		txtCMND = new Text(composite, SWT.BORDER);
		txtCMND.setEnabled(false);
		txtCMND.setBounds(29, 164, 228, 25);

		Composite composite_1 = new Composite(this, SWT.NONE);
		GridLayout gl_composite_1 = new GridLayout(3, false);
		gl_composite_1.marginBottom = 15;
		gl_composite_1.marginWidth = 15;
		gl_composite_1.horizontalSpacing = 4;
		gl_composite_1.marginTop = 10;
		composite_1.setLayout(gl_composite_1);
		composite_1.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));
		composite_1.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));

		Button btnThem = new Button(composite_1, SWT.NONE);
		btnThem.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				Window.open(new frmThemSuaKhachHang(getDisplay(), "Thêm khách hàng", null));
				hienTatCa();
			}
		});
		GridData gd_btnThem = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
		gd_btnThem.widthHint = 86;
		gd_btnThem.heightHint = 30;
		btnThem.setLayoutData(gd_btnThem);
		btnThem.setText("Thêm");
		btnThem.setImage(SWTResourceManager.getImage(pageKhachHang.class, "/rcp/view/page/additem_16x16.png"));

		Button btnSua = new Button(composite_1, SWT.NONE);
		btnSua.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				try {
					Window.open(new frmThemSuaKhachHang(getDisplay(), "Sửa khách hàng",
							KhachHangController.layThongTin(gridKhachHang.getSelection()[0].getText(1))));
					hienTatCa();
				} catch (SQLException e1) {
					e1.printStackTrace();
					Message.show("Nhân viên không hợp lệ", "Lỗi", SWT.OK | SWT.ICON_ERROR, getShell());
				}
			}
		});
		GridData gd_btnSua = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
		gd_btnSua.heightHint = 30;
		gd_btnSua.widthHint = 86;
		btnSua.setLayoutData(gd_btnSua);
		btnSua.setText("Sửa");
		btnSua.setImage(SWTResourceManager.getImage(pageKhachHang.class, "/rcp/view/page/edit_16x16.png"));

		Button btnHienTatCa = new Button(composite_1, SWT.NONE);
		btnHienTatCa.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				hienTatCa();
			}
		});
		GridData gd_btnHienTatCa = new GridData(SWT.RIGHT, SWT.CENTER, true, false, 1, 1);
		gd_btnHienTatCa.heightHint = 30;
		gd_btnHienTatCa.widthHint = 100;
		btnHienTatCa.setLayoutData(gd_btnHienTatCa);
		btnHienTatCa.setText("Hiện tất cả");
		btnHienTatCa.setImage(SWTResourceManager.getImage(pageKhachHang.class, "/rcp/view/page/show_16x16.png"));

		TableViewer tableViewer = new TableViewer(composite_1, SWT.BORDER | SWT.FULL_SELECTION);
		gridKhachHang = tableViewer.getTable();
		gridKhachHang.setLinesVisible(true);
		gridKhachHang.setHeaderVisible(true);
		GridData gd_gridKhachHang = new GridData(SWT.FILL, SWT.FILL, true, true, 3, 1);
		gd_gridKhachHang.minimumWidth = 5;
		gd_gridKhachHang.minimumHeight = 5;
		gridKhachHang.setLayoutData(gd_gridKhachHang);

		TableViewerColumn tableViewerColumn = new TableViewerColumn(tableViewer, SWT.NONE);
		TableColumn tblclmnFff = tableViewerColumn.getColumn();
		tblclmnFff.setWidth(50);
		tblclmnFff.setText("STT");

		TableViewerColumn tableViewerColumn_1 = new TableViewerColumn(tableViewer, SWT.NONE);
		TableColumn tblclmnHhhh = tableViewerColumn_1.getColumn();
		tblclmnHhhh.setWidth(100);
		tblclmnHhhh.setText("Mã khách hàng");

		TableViewerColumn tableViewerColumn_2 = new TableViewerColumn(tableViewer, SWT.NONE);
		TableColumn tblclmnNewColumn = tableViewerColumn_2.getColumn();
		tblclmnNewColumn.setWidth(150);
		tblclmnNewColumn.setText("Họ tên");

		TableViewerColumn tableViewerColumn_3 = new TableViewerColumn(tableViewer, SWT.NONE);
		TableColumn tblclmnNewColumn_1 = tableViewerColumn_3.getColumn();
		tblclmnNewColumn_1.setWidth(100);
		tblclmnNewColumn_1.setText("Giới tính");

		TableViewerColumn tableViewerColumn_4 = new TableViewerColumn(tableViewer, SWT.NONE);
		TableColumn tblclmnNewColumn_2 = tableViewerColumn_4.getColumn();
		tblclmnNewColumn_2.setWidth(100);
		tblclmnNewColumn_2.setText("CMND");

		TableViewerColumn tableViewerColumn_5 = new TableViewerColumn(tableViewer, SWT.NONE);
		TableColumn tblclmnCmnd = tableViewerColumn_5.getColumn();
		tblclmnCmnd.setWidth(100);
		tblclmnCmnd.setText("Ngày sinh");

		TableViewerColumn tableViewerColumn_6 = new TableViewerColumn(tableViewer, SWT.NONE);
		TableColumn tblclmnNewColumn_3 = tableViewerColumn_6.getColumn();
		tblclmnNewColumn_3.setWidth(150);
		tblclmnNewColumn_3.setText("Email");

		TableViewerColumn tableViewerColumn_7 = new TableViewerColumn(tableViewer, SWT.NONE);
		TableColumn tblclmnNewColumn_4 = tableViewerColumn_7.getColumn();
		tblclmnNewColumn_4.setWidth(100);
		tblclmnNewColumn_4.setText("SĐT");

		TableViewerColumn tableViewerColumn_8 = new TableViewerColumn(tableViewer, SWT.NONE);
		TableColumn tblclmnNewColumn_5 = tableViewerColumn_8.getColumn();
		tblclmnNewColumn_5.setWidth(100);
		tblclmnNewColumn_5.setText("Loại khách hàng");

		TableViewerColumn tableViewerColumn_9 = new TableViewerColumn(tableViewer, SWT.NONE);
		TableColumn tblclmnNewColumn_6 = tableViewerColumn_9.getColumn();
		tblclmnNewColumn_6.setWidth(100);
		tblclmnNewColumn_6.setText("Ngày đăng ký");

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
		datLai();
	}

	/**
	 * Hàm đặt lại điều kiện tìm kiếm
	 */
	public void datLai() {
		chkTenKhachHang.setSelection(true);
		txtTenKhachHang.setText("");
		txtTenKhachHang.setEnabled(chkTenKhachHang.getSelection());

		chkCMND.setSelection(false);
		txtCMND.setText("");
		txtCMND.setEnabled(chkCMND.getSelection());

	}

	/**
	 * Hàm hiện thông tin của tất cả khách hàng
	 */
	public void hienTatCa() {
		try {
			ArrayList<KhachHang> arr = KhachHangController.taiTatCa();

			gridKhachHang.removeAll();
			int stt = 1;
			for (KhachHang i : arr) {
				TableItem item = new TableItem(gridKhachHang, SWT.NONE);
				item.setText(new String[] { String.valueOf(stt), i.getMaKhachHang(), i.getHoTen(), i.getGioiTinh(),
						i.getCMND(), DateF.toString(i.getNgaySinh()), i.getEmail(), i.getSDT(), i.getMaLoaiKH(),
						DateF.toString(i.getNgayDangKy()) });
				stt++;
			}

			gridKhachHang.select(0);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Hàm tìm kiếm khách hàng
	 */
	public void timKiem() {
		try {
			kiemTraHopLe();
			ArrayList<KhachHang> arr = KhachHangController.traCuu(
					chkTenKhachHang.getSelection() ? txtTenKhachHang.getText() : null,
					chkCMND.getSelection() ? txtCMND.getText() : null);

			gridKhachHang.removeAll();
			int stt = 1;
			for (KhachHang i : arr) {
				TableItem item = new TableItem(gridKhachHang, SWT.NONE);
				item.setText(new String[] { String.valueOf(stt), i.getMaKhachHang(), i.getHoTen(), i.getGioiTinh(),
						i.getCMND(), DateF.toString(i.getNgaySinh()), i.getEmail(), i.getSDT(), i.getMaLoaiKH(),
						DateF.toString(i.getNgayDangKy()) });
				stt++;
			}

			gridKhachHang.select(0);
		} catch (ParameterValuesException e) {
			Message.show(e.getMessage(), "Cảnh báo", SWT.ICON_WARNING | SWT.OK, getShell());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Kiểm tra các trường trong điều kiện có nhập đầy đủ hay không
	 */
	public void kiemTraHopLe() throws ParameterValuesException {
		if (chkTenKhachHang.getSelection() && txtTenKhachHang.getText().isEmpty())
			throw new ParameterValuesException("Tên khách hàng không được trống", null);
		if (chkCMND.getSelection() && txtCMND.getText().isEmpty())
			throw new ParameterValuesException("CMND không được trống", null);
	}
}
