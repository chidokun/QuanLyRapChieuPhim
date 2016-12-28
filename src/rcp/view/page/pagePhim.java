/**
 * Quản lý Rạp chiếu phim RPP
 * Author: Hoàng Hồ
 */

package rcp.view.page;

import java.util.ArrayList;
import java.util.Date;

import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TableViewerColumn;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.DateTime;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.widgets.Text;
import org.eclipse.wb.swt.SWTResourceManager;

import rcp.controller.PhimController;
import rcp.entity.Phim;
import rcp.util.DateF;
import rcp.util.Message;
import rcp.util.Window;
import rcp.view.popup.frmThemSuaPhim;;

public class pagePhim extends Composite {
	private Text txt_TenPhim;
	private Table tablePhim;
	private DateTime dateTime_TuNgay;
	private DateTime dateTime_DenNgay;
	private Button chkBox_TenPhim;
	private Button chkBox_ThoiGian;
	private Button btnTimKiem;
	private Button btnDatLai;
	private Button btnHienTatCa;
	private Button btnThem;
	private Button btnSua;

	/**
	 * Create the composite.
	 * 
	 * @param parent
	 * @param style
	 */
	public pagePhim(Composite parent, int style) {
		super(parent, style);
		setBackground(SWTResourceManager.getColor(SWT.COLOR_WIDGET_BACKGROUND));
		GridLayout gridLayout = new GridLayout(2, false);
		gridLayout.verticalSpacing = 0;
		gridLayout.marginHeight = 0;
		gridLayout.marginWidth = 0;
		setLayout(gridLayout);

		Composite composite = new Composite(this, SWT.NONE);
		GridData gd_composite = new GridData(SWT.FILL, SWT.FILL, false, true, 1, 1);
		gd_composite.heightHint = 385;
		gd_composite.widthHint = 280;
		composite.setLayoutData(gd_composite);
		composite.setBackground(SWTResourceManager.getColor(SWT.COLOR_WIDGET_BACKGROUND));

		Label lblTraCuPhim = new Label(composite, SWT.NONE);
		lblTraCuPhim.setText("Tra cứu");
		lblTraCuPhim.setForeground(SWTResourceManager.getColor(31, 116, 71));
		lblTraCuPhim.setFont(SWTResourceManager.getFont("Segoe UI", 13, SWT.NORMAL));
		lblTraCuPhim.setBackground(SWTResourceManager.getColor(SWT.COLOR_WIDGET_BACKGROUND));
		lblTraCuPhim.setBounds(29, 17, 176, 23);

		chkBox_TenPhim = new Button(composite, SWT.CHECK);
		chkBox_TenPhim.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				if (chkBox_TenPhim.getSelection())
					txt_TenPhim.setEnabled(true);
				else
					txt_TenPhim.setEnabled(false);
			}
		});
		chkBox_TenPhim.setText("Theo tên phim");
		chkBox_TenPhim.setSelection(true);
		chkBox_TenPhim.setBackground(SWTResourceManager.getColor(SWT.COLOR_WIDGET_BACKGROUND));
		chkBox_TenPhim.setBounds(29, 54, 197, 16);

		txt_TenPhim = new Text(composite, SWT.BORDER);
		txt_TenPhim.setBounds(29, 85, 228, 25);

		chkBox_ThoiGian = new Button(composite, SWT.CHECK);

		chkBox_ThoiGian.setText("Theo khoảng thời gian");
		chkBox_ThoiGian.setBackground(SWTResourceManager.getColor(SWT.COLOR_WIDGET_BACKGROUND));
		chkBox_ThoiGian.setBounds(29, 131, 197, 16);
		chkBox_ThoiGian.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				if (chkBox_ThoiGian.getSelection()) {
					dateTime_TuNgay.setEnabled(true);
					dateTime_DenNgay.setEnabled(true);
				} else {
					dateTime_TuNgay.setEnabled(false);
					dateTime_DenNgay.setEnabled(false);
				}
			}
		});

		dateTime_DenNgay = new DateTime(composite, SWT.BORDER | SWT.DROP_DOWN);
		dateTime_DenNgay.setBounds(103, 210, 156, 24);
		dateTime_DenNgay.setEnabled(false);

		dateTime_TuNgay = new DateTime(composite, SWT.BORDER | SWT.DROP_DOWN);
		dateTime_TuNgay.setBounds(103, 166, 156, 24);
		dateTime_TuNgay.setEnabled(false);

		Label lblTNgy = new Label(composite, SWT.NONE);
		lblTNgy.setText("Từ ngày:");
		lblTNgy.setBackground(SWTResourceManager.getColor(SWT.COLOR_WIDGET_BACKGROUND));
		lblTNgy.setBounds(29, 170, 62, 16);

		Label lblnNgy = new Label(composite, SWT.NONE);
		lblnNgy.setText("Đến ngày:");
		lblnNgy.setBackground(SWTResourceManager.getColor(SWT.COLOR_WIDGET_BACKGROUND));
		lblnNgy.setBounds(29, 213, 66, 15);

		btnTimKiem = new Button(composite, SWT.NONE);

		btnTimKiem.setText("Tìm kiếm");
		btnTimKiem.setImage(SWTResourceManager.getImage(pagePhim.class, "/rcp/view/page/zoom_16x16.png"));
		btnTimKiem.setBounds(81, 261, 86, 30);

		btnDatLai = new Button(composite, SWT.NONE);
		btnDatLai.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				datLai();
			}
		});
		btnDatLai.setText("Đặt lại");
		btnDatLai.setImage(SWTResourceManager.getImage(pagePhim.class, "/rcp/view/page/refresh2_16x16.png"));
		btnDatLai.setBounds(171, 261, 86, 30);
		btnTimKiem.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				if(kiemTraHopLe())
				traCuu(chkBox_TenPhim.getSelection() ? txt_TenPhim.getText() : null,
						chkBox_ThoiGian.getSelection() ? DateF.toDate(dateTime_TuNgay.getYear(),
								dateTime_TuNgay.getMonth(), dateTime_TuNgay.getDay()) : null,
						chkBox_ThoiGian.getSelection() ? DateF.toDate(dateTime_DenNgay.getYear(),
								dateTime_DenNgay.getMonth(), dateTime_DenNgay.getDay()) : null);
			}
		});

		Composite composite_1 = new Composite(this, SWT.NONE);
		composite_1.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		GridLayout gl_composite_1 = new GridLayout(3, false);
		gl_composite_1.marginBottom = 15;
		gl_composite_1.marginTop = 10;
		gl_composite_1.marginWidth = 15;
		composite_1.setLayout(gl_composite_1);
		GridData gd_composite_1 = new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1);
		gd_composite_1.widthHint = 398;
		gd_composite_1.heightHint = 371;
		composite_1.setLayoutData(gd_composite_1);

		btnThem = new Button(composite_1, SWT.NONE);
		btnThem.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				Window.open(new frmThemSuaPhim(getDisplay(), true, null));
				datLai();
			}
		});
		GridData gd_btnThem = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
		gd_btnThem.heightHint = 30;
		gd_btnThem.widthHint = 86;
		btnThem.setLayoutData(gd_btnThem);
		btnThem.setText("Thêm");
		btnThem.setImage(SWTResourceManager.getImage(pagePhim.class, "/rcp/view/page/additem_16x16.png"));

		btnSua = new Button(composite_1, SWT.NONE);
		btnSua.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				Window.open(new frmThemSuaPhim(getDisplay(), false, (String) tablePhim.getSelection()[0].getText(0)));
				datLai();
			}
		});
		GridData gd_btnSua = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
		gd_btnSua.heightHint = 30;
		gd_btnSua.widthHint = 86;
		btnSua.setLayoutData(gd_btnSua);
		btnSua.setText("Sửa");
		btnSua.setImage(SWTResourceManager.getImage(pagePhim.class, "/rcp/view/page/edit_16x16.png"));

		btnHienTatCa = new Button(composite_1, SWT.NONE);
		GridData gd_btnHienTatCa = new GridData(SWT.RIGHT, SWT.CENTER, true, false, 1, 1);
		gd_btnHienTatCa.heightHint = 30;
		gd_btnHienTatCa.widthHint = 100;
		btnHienTatCa.setLayoutData(gd_btnHienTatCa);
		btnHienTatCa.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				traCuu(null, null, null);
			}
		});
		btnHienTatCa.setText("Hiện tất cả");
		btnHienTatCa.setImage(SWTResourceManager.getImage(pagePhim.class, "/rcp/view/page/show_16x16.png"));

		TableViewer tableViewer = new TableViewer(composite_1, SWT.BORDER | SWT.FULL_SELECTION);
		tablePhim = tableViewer.getTable();
		tablePhim.setHeaderVisible(true);
		tablePhim.setLinesVisible(true);
		tablePhim.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 3, 1));

		TableViewerColumn tableViewerColumn = new TableViewerColumn(tableViewer, SWT.NONE);
		TableColumn tblclmnStt = tableViewerColumn.getColumn();
		tblclmnStt.setWidth(76);
		tblclmnStt.setText("Mã phim");

		TableViewerColumn tableViewerColumn_1 = new TableViewerColumn(tableViewer, SWT.NONE);
		TableColumn tblclmnTnPhim = tableViewerColumn_1.getColumn();
		tblclmnTnPhim.setWidth(141);
		tblclmnTnPhim.setText("Tên phim");

		TableViewerColumn tableViewerColumn_2 = new TableViewerColumn(tableViewer, SWT.NONE);
		TableColumn tblclmnThiLng = tableViewerColumn_2.getColumn();
		tblclmnThiLng.setWidth(79);
		tblclmnThiLng.setText("Thời lượng");

		TableViewerColumn tableViewerColumn_3 = new TableViewerColumn(tableViewer, SWT.NONE);
		TableColumn tblclmnNhSnXut = tableViewerColumn_3.getColumn();
		tblclmnNhSnXut.setWidth(94);
		tblclmnNhSnXut.setText("Nhà sản xuất");

		TableViewerColumn tableViewerColumn_4 = new TableViewerColumn(tableViewer, SWT.NONE);
		TableColumn tblclmnNmSnXut = tableViewerColumn_4.getColumn();
		tblclmnNmSnXut.setWidth(85);
		tblclmnNmSnXut.setText("Năm sản xuất");

		TableViewerColumn tableViewerColumn_5 = new TableViewerColumn(tableViewer, SWT.NONE);
		TableColumn tblclmnNgnNg = tableViewerColumn_5.getColumn();
		tblclmnNgnNg.setWidth(80);
		tblclmnNgnNg.setText("Ngôn ngữ");

		TableViewerColumn tableViewerColumn_6 = new TableViewerColumn(tableViewer, SWT.NONE);
		TableColumn tblclmnNgyKhiChiu = tableViewerColumn_6.getColumn();
		tblclmnNgyKhiChiu.setWidth(101);
		tblclmnNgyKhiChiu.setText("Ngày khởi chiếu");

		TableViewerColumn tableViewerColumn_8 = new TableViewerColumn(tableViewer, SWT.NONE);
		TableColumn tblclmnNcSnXut = tableViewerColumn_8.getColumn();
		tblclmnNcSnXut.setWidth(93);
		tblclmnNcSnXut.setText("Nước sản xuất");

		TableViewerColumn tableViewerColumn_11 = new TableViewerColumn(tableViewer, SWT.NONE);
		TableColumn tblclmnDoanhThu = tableViewerColumn_11.getColumn();
		tblclmnDoanhThu.setWidth(90);
		tblclmnDoanhThu.setText("Doanh thu");

		TableViewerColumn tableViewerColumn_10 = new TableViewerColumn(tableViewer, SWT.NONE);
		TableColumn tblclmnCcDinVin = tableViewerColumn_10.getColumn();
		tblclmnCcDinVin.setWidth(112);
		tblclmnCcDinVin.setText("Các diễn viên");

		TableColumn tblclmnNewColumn = new TableColumn(tablePhim, SWT.NONE);
		tblclmnNewColumn.setWidth(100);
		tblclmnNewColumn.setText("Trạng thái");

		TableViewerColumn tableViewerColumn_9 = new TableViewerColumn(tableViewer, SWT.NONE);
		TableColumn tblclmnGiiHnTui = tableViewerColumn_9.getColumn();
		tblclmnGiiHnTui.setWidth(80);
		tblclmnGiiHnTui.setText("Giới hạn tuổi");

		TableViewerColumn tableViewerColumn_7 = new TableViewerColumn(tableViewer, SWT.NONE);
		TableColumn tblclmnTmTt = tableViewerColumn_7.getColumn();
		tblclmnTmTt.setWidth(100);
		tblclmnTmTt.setText("Tóm tắt");

		datLai();
	}

	@Override
	protected void checkSubclass() {
		// Disable the check that prevents subclassing of SWT components
	}

	public void traCuu(String tenPhim, Date tuNgay, Date denNgay) {
		try {
			ArrayList<Phim> aPhim = PhimController.traCuu(tenPhim, tuNgay, denNgay);

			tablePhim.removeAll();
			for (Phim p : aPhim) {
				TableItem item = new TableItem(tablePhim, SWT.NONE);
				item.setText(new String[] { p.getMaPhim(), p.getTenPhim(), String.valueOf(p.getThoiLuong()),
						p.getMaNhaSX(), String.valueOf(p.getNamSX()), p.getMaNgonNgu(),
						DateF.toString(p.getNgayKhoiChieu()), p.getMaNuocSX(), String.valueOf(p.getDoanhThu()),
						p.getCacDienVien(), p.getTrangThai() == 1 ? "Công chiếu" : "Không công chiếu",
						String.valueOf(p.getGioiHanTuoi()), p.getTomTat() });
			}
			tablePhim.select(0);
		} catch (Exception e) {

			e.printStackTrace();
		}
	}

	public void datLai() {
		traCuu(null, null, null);
		chkBox_TenPhim.setSelection(true);
		chkBox_ThoiGian.setSelection(false);
		txt_TenPhim.setEnabled(true);
		dateTime_TuNgay.setEnabled(false);
		dateTime_DenNgay.setEnabled(false);
		txt_TenPhim.setText("");
	}
	public boolean kiemTraHopLe(){
		if (chkBox_TenPhim.getSelection() && txt_TenPhim.getText().isEmpty())
		{
			Message.show("Tên phim không được trống", "Lỗi", SWT.OK |SWT.ICON_ERROR, getShell());
			return false;
		}
		
		if (chkBox_ThoiGian.getSelection()
				&& (DateF.toDate(dateTime_TuNgay.getYear(), dateTime_TuNgay.getMonth(), dateTime_TuNgay.getDay())
						.after(DateF.toDate(dateTime_DenNgay.getYear(), dateTime_DenNgay.getMonth(), dateTime_DenNgay.getDay()))))
			{
			Message.show("Từ ngày không được sau Đến ngày", "Lỗi", SWT.OK |SWT.ICON_ERROR, getShell());
			return false;
			}
		return true;
	}
}
