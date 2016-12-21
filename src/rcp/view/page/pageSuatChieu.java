/**
 * Quản lý Rạp chiếu phim RPP
 * Author: Huỳnh Duy Anh Toàn - anhtoan441996@gmail.com
 */

package rcp.view.page;

import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Label;
import org.eclipse.wb.swt.SWTResourceManager;

import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.*;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Table;
import org.eclipse.core.commands.ParameterValuesException;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TableViewerColumn;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.wb.swt.ResourceManager;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

import rcp.util.Message;
import rcp.util.Window;
import rcp.view.popup.frmSuatChieu;
import rcp.controller.SuatChieuController;
import rcp.entity.*;
import rcp.util.*;

import java.sql.SQLException;
import java.util.*;

public class pageSuatChieu extends Composite {
	private Text txtTenPhim;
	private Table gridSuatChieu;
	private Button chkTheoTenPhim;
	private Button chkTheoKhoangThoiGian;
	private Button btnDatLai;
	private Button btnTimKiem;
	private DateTime dateTime_DenNgay;
	private DateTime dateTime_TuNgay;

	/**
	 * Create the composite.
	 * 
	 * @param parent
	 * @param style
	 */
	public pageSuatChieu(Composite parent, int style) {
		super(parent, style);
		setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		GridLayout gridLayout = new GridLayout(2, false);
		gridLayout.marginWidth = 0;
		setLayout(gridLayout);

		Composite composite = new Composite(this, SWT.NONE);
		GridData gd_composite = new GridData(SWT.FILL, SWT.FILL, false, true, 1, 1);
		gd_composite.heightHint = 385;
		gd_composite.widthHint = 280;
		composite.setLayoutData(gd_composite);
		composite.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));

		Label lblTraCuPhim = new Label(composite, SWT.NONE);
		lblTraCuPhim.setText("Tra cứu");
		lblTraCuPhim.setForeground(SWTResourceManager.getColor(SWT.COLOR_DARK_GREEN));
		lblTraCuPhim.setFont(SWTResourceManager.getFont("Segoe UI", 13, SWT.NORMAL));
		lblTraCuPhim.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		lblTraCuPhim.setBounds(31, 27, 176, 23);

		chkTheoTenPhim = new Button(composite, SWT.CHECK);
		chkTheoTenPhim.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				txtTenPhim.setEnabled(chkTheoTenPhim.getSelection());
			}
		});
		chkTheoTenPhim.setText("Theo tên phim");
		chkTheoTenPhim.setSelection(true);
		chkTheoTenPhim.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		chkTheoTenPhim.setBounds(31, 64, 197, 16);

		txtTenPhim = new Text(composite, SWT.BORDER);
		txtTenPhim.setBounds(31, 95, 228, 25);

		chkTheoKhoangThoiGian = new Button(composite, SWT.CHECK);
		chkTheoKhoangThoiGian.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				dateTime_TuNgay.setEnabled(chkTheoKhoangThoiGian.getSelection());
				dateTime_DenNgay.setEnabled(chkTheoKhoangThoiGian.getSelection());
			}
		});
		chkTheoKhoangThoiGian.setText("Theo khoảng thời gian");
		chkTheoKhoangThoiGian.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		chkTheoKhoangThoiGian.setBounds(31, 141, 197, 16);

		btnTimKiem = new Button(composite, SWT.NONE);
		btnTimKiem.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				timKiem();
			}
		});
		btnTimKiem.setText("Tìm kiếm");
		btnTimKiem.setImage(ResourceManager.getPluginImage("QuanLyRapChieuPhim", "src/rcp/view/page/zoom_16x16.png"));
		btnTimKiem.setBounds(83, 311, 86, 30);

		btnDatLai = new Button(composite, SWT.NONE);
		btnDatLai.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				datLai();
			}
		});
		btnDatLai.setText("Đặt lại");
		btnDatLai.setImage(ResourceManager.getPluginImage("QuanLyRapChieuPhim", "src/rcp/view/page/refresh2_16x16.png"));
		btnDatLai.setBounds(173, 311, 86, 30);

		dateTime_DenNgay = new DateTime(composite, SWT.BORDER | SWT.DROP_DOWN);
		dateTime_DenNgay.setEnabled(false);
		dateTime_DenNgay.setBounds(103, 214, 156, 24);

		dateTime_TuNgay = new DateTime(composite, SWT.BORDER | SWT.DROP_DOWN);
		dateTime_TuNgay.setEnabled(false);
		dateTime_TuNgay.setBounds(103, 174, 156, 24);

		Label label = new Label(composite, SWT.NONE);
		label.setText("Từ ngày");
		label.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		label.setBounds(31, 180, 62, 16);

		Label label_1 = new Label(composite, SWT.NONE);
		label_1.setText("Đến ngày");
		label_1.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		label_1.setBounds(31, 219, 66, 15);

		Composite composite_1 = new Composite(this, SWT.NONE);
		composite_1.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		GridLayout gl_composite_1 = new GridLayout(3, false);
		gl_composite_1.marginTop = 10;
		gl_composite_1.marginWidth = 15;
		composite_1.setLayout(gl_composite_1);
		GridData gd_composite_1 = new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1);
		gd_composite_1.widthHint = 785;
		gd_composite_1.heightHint = 371;
		composite_1.setLayoutData(gd_composite_1);

		Button btnThem = new Button(composite_1, SWT.NONE);
		btnThem.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				Window.open(new frmSuatChieu(getDisplay(), "Thêm suất chiếu", null));
				hienTatCa();
			}
		});
		GridData gd_btnThem = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
		gd_btnThem.heightHint = 30;
		gd_btnThem.widthHint = 86;
		btnThem.setLayoutData(gd_btnThem);
		btnThem.setText("Thêm");
		btnThem.setImage(ResourceManager.getPluginImage("QuanLyRapChieuPhim", "src/rcp/view/page/additem_16x16.png"));

		Button btnSua = new Button(composite_1, SWT.NONE);
		btnSua.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				try {
					Window.open(new frmSuatChieu(getDisplay(), "Sửa suất chiếu",
							SuatChieuController.layThongTin(gridSuatChieu.getSelection()[0].getText(1))));
					hienTatCa();
				} catch (SQLException e1) {
					e1.printStackTrace();
					Message.show("Suất chiếu không hợp lệ", "Lỗi", SWT.OK | SWT.ICON_ERROR, getShell());
				}
			}
		});
		GridData gd_btnSua = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
		gd_btnSua.heightHint = 30;
		gd_btnSua.widthHint = 86;
		btnSua.setLayoutData(gd_btnSua);
		btnSua.setText("Sửa");
		btnSua.setImage(ResourceManager.getPluginImage("QuanLyRapChieuPhim", "src/rcp/view/page/edit_16x16.png"));

		Button btnHienTatCa = new Button(composite_1, SWT.NONE);
		GridData gd_btnHienTatCa = new GridData(SWT.RIGHT, SWT.CENTER, true, false, 1, 1);
		gd_btnHienTatCa.heightHint = 30;
		gd_btnHienTatCa.widthHint = 100;
		btnHienTatCa.setLayoutData(gd_btnHienTatCa);
		btnHienTatCa.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				hienTatCa();
			}
		});
		btnHienTatCa.setText("Hiện tất cả");
		btnHienTatCa.setImage(ResourceManager.getPluginImage("QuanLyRapChieuPhim", "src/rcp/view/page/show_16x16.png"));

		TableViewer tableViewer = new TableViewer(composite_1, SWT.BORDER | SWT.FULL_SELECTION);
		tableViewer.setColumnProperties(new String[] { "Mã suất chiếu", "Mã phim", "Tên phim", "Giờ", "Định dạng",
				"Hình Thức", "Ngôn ngữ", "Phòng", "Trạng thái" });
		gridSuatChieu = tableViewer.getTable();
		gridSuatChieu.setFont(SWTResourceManager.getFont("Segoe UI", 9, SWT.NORMAL));
		gridSuatChieu.setHeaderVisible(true);
		gridSuatChieu.setLinesVisible(true);
		gridSuatChieu.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 3, 1));

		TableViewerColumn tableViewerColumn = new TableViewerColumn(tableViewer, SWT.NONE);
		TableColumn tblclmnStt = tableViewerColumn.getColumn();
		tblclmnStt.setWidth(40);
		tblclmnStt.setText("STT");

		TableViewerColumn tableViewerColumn_1 = new TableViewerColumn(tableViewer, SWT.NONE);
		TableColumn tblclmnMSutChiu = tableViewerColumn_1.getColumn();
		tblclmnMSutChiu.setWidth(95);
		tblclmnMSutChiu.setText("Mã suất chiếu");

		TableViewerColumn tableViewerColumn_2 = new TableViewerColumn(tableViewer, SWT.NONE);
		TableColumn tblclmnMPhim = tableViewerColumn_2.getColumn();
		tblclmnMPhim.setWidth(100);
		tblclmnMPhim.setText("Mã phim");

		TableViewerColumn tableViewerColumn_3 = new TableViewerColumn(tableViewer, SWT.NONE);
		TableColumn tblclmnTnPhim = tableViewerColumn_3.getColumn();
		tblclmnTnPhim.setWidth(250);
		tblclmnTnPhim.setText("Tên phim");

		TableViewerColumn tableViewerColumn_4 = new TableViewerColumn(tableViewer, SWT.NONE);
		TableColumn tblclmnGi = tableViewerColumn_4.getColumn();
		tblclmnGi.setWidth(146);
		tblclmnGi.setText("Giờ");

		TableViewerColumn tableViewerColumn_5 = new TableViewerColumn(tableViewer, SWT.NONE);
		TableColumn tblclmnnhDng = tableViewerColumn_5.getColumn();
		tblclmnnhDng.setWidth(85);
		tblclmnnhDng.setText("Định dạng");

		TableViewerColumn tableViewerColumn_6 = new TableViewerColumn(tableViewer, SWT.NONE);
		TableColumn tblclmnHnhThc = tableViewerColumn_6.getColumn();
		tblclmnHnhThc.setWidth(100);
		tblclmnHnhThc.setText("Hình thức");

		TableViewerColumn tableViewerColumn_7 = new TableViewerColumn(tableViewer, SWT.NONE);
		TableColumn tblclmnNgnNg = tableViewerColumn_7.getColumn();
		tblclmnNgnNg.setWidth(80);
		tblclmnNgnNg.setText("Ngôn ngữ");

		TableViewerColumn tableViewerColumn_8 = new TableViewerColumn(tableViewer, SWT.NONE);
		TableColumn tblclmnPhng = tableViewerColumn_8.getColumn();
		tblclmnPhng.setWidth(78);
		tblclmnPhng.setText("Phòng");

		TableViewerColumn tableViewerColumn_9 = new TableViewerColumn(tableViewer, SWT.NONE);
		TableColumn tblclmnTrngThi = tableViewerColumn_9.getColumn();
		tblclmnTrngThi.setWidth(73);
		tblclmnTrngThi.setText("Trạng thái");
		new Label(composite_1, SWT.NONE);
		new Label(composite_1, SWT.NONE);
		new Label(composite_1, SWT.NONE);
		
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
		hienTatCa();
		datLai();
	}

	/**
	 * Đặt lại điều kiện tìm kiếm
	 */
	public void datLai() {
		chkTheoTenPhim.setSelection(true);
		txtTenPhim.setText("");
		txtTenPhim.setEnabled(chkTheoTenPhim.getSelection());

		chkTheoKhoangThoiGian.setSelection(false);
		dateTime_TuNgay.setEnabled(chkTheoKhoangThoiGian.getSelection());
		dateTime_TuNgay.setData(this.getData());
		dateTime_DenNgay.setEnabled(chkTheoKhoangThoiGian.getSelection());
		dateTime_DenNgay.setData(System.currentTimeMillis());

	}

	/**
	 * Hiện tất cả suất chiếu
	 */
	public void hienTatCa() {
		try {
			ArrayList<SuatChieu> arr = SuatChieuController.taiTatCa();

			gridSuatChieu.removeAll();
			int stt = 1;
			for (SuatChieu i : arr) {
				TableItem item = new TableItem(gridSuatChieu, SWT.NONE);
				item.setText(new String[] { String.valueOf(stt), i.getMaSuatChieu(), i.getMaPhim(),i.getTenPhim(), DateF.toString_full(i.getThoiGianChieu()),
						i.getDinhDang(),i.getHinhThuc(), i.getNgonNgu(), i.getPhong(),String.valueOf((i.getTrangThai())) });
				stt++;
			}

			gridSuatChieu.select(0);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Tìm kiếm suất chiếu
	 */
	public void timKiem() {
		try {
			kiemTraHopLe();
			ArrayList<SuatChieu> arr = SuatChieuController.traCuu(
					chkTheoTenPhim.getSelection() ? txtTenPhim.getText() : null,
					chkTheoKhoangThoiGian.getSelection() ?  DateF.toDate(dateTime_TuNgay.getYear(), dateTime_TuNgay.getMonth(), dateTime_TuNgay.getDay()) : null,
					chkTheoKhoangThoiGian.getSelection() ?  DateF.toDate(dateTime_DenNgay.getYear(), dateTime_DenNgay.getMonth(), dateTime_DenNgay.getDay()) : null);

			gridSuatChieu.removeAll();
			int stt = 1;
			for (SuatChieu i : arr) {
				TableItem item = new TableItem(gridSuatChieu, SWT.NONE);
				item.setText(new String[] { String.valueOf(stt), i.getMaSuatChieu(), i.getMaPhim(),i.getTenPhim(), i.getThoiGianChieu().toString(),
						i.getDinhDang(),i.getHinhThuc(), i.getNgonNgu(), i.getPhong(),String.valueOf((i.getTrangThai())) });
				stt++;
			}

			gridSuatChieu.select(0);
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
		if (chkTheoTenPhim.getSelection() && txtTenPhim.getText().isEmpty())
			throw new ParameterValuesException("Tên phim không được trống", null);

	}
}
